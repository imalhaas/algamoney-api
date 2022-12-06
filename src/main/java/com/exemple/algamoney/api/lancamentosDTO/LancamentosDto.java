package com.exemple.algamoney.api.lancamentosDTO;

import com.exemple.algamoney.api.model.Categoria;
import com.exemple.algamoney.api.model.Lancamento;
import com.exemple.algamoney.api.model.Pessoa;
import com.exemple.algamoney.api.model.TipoLancamento;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDate;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Lancamento.class)
public class LancamentosDto {

        public static volatile SingularAttribute<Lancamento, Long> codigo;
        public static volatile SingularAttribute<Lancamento, String> observacao;
        public static volatile SingularAttribute<Lancamento, TipoLancamento> tipo;
        public static volatile SingularAttribute<Lancamento, LocalDate> dataPagamento;
        public static volatile SingularAttribute<Lancamento, Pessoa> pessoa;
        public static volatile SingularAttribute<Lancamento, LocalDate> dataVencimento;
        public static volatile SingularAttribute<Lancamento, Categoria> categoria;
        public static volatile SingularAttribute<Lancamento, BigDecimal> valor;
        public static volatile SingularAttribute<Lancamento, String> descricao;

    }
