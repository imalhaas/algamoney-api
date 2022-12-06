package com.exemple.algamoney.api.lancamentosDTO;

import com.exemple.algamoney.api.model.Endereco;
import com.exemple.algamoney.api.model.Pessoa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public class PessoaDto {

        public static volatile SingularAttribute<Pessoa, Long> codigo;
        public static volatile SingularAttribute<Pessoa, Boolean> ativo;
        public static volatile SingularAttribute<Pessoa, Endereco> endereco;
        public static volatile SingularAttribute<Pessoa, String> nome;

    }
