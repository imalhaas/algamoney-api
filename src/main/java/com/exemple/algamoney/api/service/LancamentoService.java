package com.exemple.algamoney.api.service;

import com.exemple.algamoney.api.model.Lancamento;
import com.exemple.algamoney.api.model.Pessoa;
import com.exemple.algamoney.api.rerpository.LancamentoRepository;
import com.exemple.algamoney.api.rerpository.PessoaRepository;
import com.exemple.algamoney.api.service.exception.PessoaInexistenteOuInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = pessoaRepository.findOne(lancamento.getPessoa().getCodigo());
        if (pessoa == null || pessoa.isInativo()) {
            throw new PessoaInexistenteOuInativaException();
        }

        return lancamentoRepository.save(lancamento);
    }

}