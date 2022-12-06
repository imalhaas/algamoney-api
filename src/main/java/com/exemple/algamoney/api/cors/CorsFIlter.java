package com.exemple.algamoney.api.cors;


import com.exemple.algamoney.api.config.property.AlgamoneyApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFIlter implements Filter {

    @Autowired
    private AlgamoneyApiProperty algamoneyApiProperty;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;


        response.setHeader("Access-Control-Allow-Origin", algamoneyApiProperty.getOriginPermitida());// é preciso mandar esses dois fora do Options pq ele tem que mandar sempre nas requisiçoes
        response.setHeader("Access-Control-Allow-Credentials", "true");


        if ("OPTIONS".equals(request.getMethod()) &&  algamoneyApiProperty.equals(request.getHeader("origin"))){
            response.setHeader("access-control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
            response.setHeader("access-control-Allow-headers", "authorization, content-Type, Accept");
            response.setHeader("access-control-Allow-Max-Age", "3600");


            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
