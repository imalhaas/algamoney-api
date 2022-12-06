package com.exemple.algamoney.api.rerpository.lancamento;

import com.exemple.algamoney.api.model.Lancamento;
import com.exemple.algamoney.api.rerpository.filter.LancamentoFilter;
import com.exemple.algamoney.api.rerpository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
    public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
}
