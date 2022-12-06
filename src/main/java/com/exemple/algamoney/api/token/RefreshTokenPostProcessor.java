package com.exemple.algamoney.api.token;

import com.exemple.algamoney.api.config.property.AlgamoneyApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class RefreshTokenPostProcessor implements ResponseBodyAdvice<OAuth2AccessToken> {

    @Autowired
    private AlgamoneyApiProperty algamoneyApiProperty;


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return returnType.getMethod().getName().equals("postAccessToken");
    }

    @Override
    public OAuth2AccessToken beforeBodyWrite(OAuth2AccessToken body, MethodParameter returnType, MediaType selectedContentType,
                                             Class<? extends HttpMessageConverter<?>> selectedConvertedType, ServerHttpRequest request,
                                             ServerHttpResponse response) {

        HttpServletRequest req =((ServletServerHttpRequest) request).getServletRequest();
        HttpServletResponse resp = ((ServletServerHttpResponse)response).getServletResponse();

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) body;

        String refreshToken = body.getRefreshToken().getValue();
        adicionarRefreshTokenCookie(refreshToken, req, resp);
        removerRefreshTokenDoBody(token);

        return body;
        // aqui que vai ser a regra que precisa quando o metodo SUPPORTS retornar true
    }

    private void removerRefreshTokenDoBody(DefaultOAuth2AccessToken token) {
        token.setRefreshToken(null); // vai tirar refresh token do body
    }

    private void adicionarRefreshTokenCookie(String refreshToken, HttpServletRequest req, HttpServletResponse resp) {
        Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
        refreshTokenCookie.setHttpOnly(true); //propiedades para esse cookie... "so quero que ele seja acessivel em http"
        refreshTokenCookie.setSecure(algamoneyApiProperty.getSeguranca().isEnableHttps());
        refreshTokenCookie.setPath(req.getContextPath() + "/Oauth/token"); // para qual caminho esse cookie deve ser enviado
        refreshTokenCookie.setMaxAge(2592000); // em quanto tempo esse cookie vai expirar em dias? 30 dias
        resp.addCookie(refreshTokenCookie); // adicionar o cookie na resposta
    }
}
