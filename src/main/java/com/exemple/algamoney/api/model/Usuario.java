package com.exemple.algamoney.api.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects; 

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private Long codigo;

    private String nome;

    private String email;

    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)  // = toda vez que buscar usuarios ja busca as permissoes dele
    @JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "codigo_usuario"),
    inverseJoinColumns = @JoinColumn(name = "codigo_permissao"))
    private List<Permissao> permissoes;

    public Long getId() {
        return codigo;
    }

    public void setId(Long id) {
        this.codigo = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<Permissao> permissoes) {
        this.permissoes = permissoes;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }



}
