package com.imd0409.vacinacaobovino.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.repository.PessoaRepository;
import com.imd0409.vacinacaobovino.service.PessoaService;
import com.imd0409.vacinacaobovino.rest.dto.PessoaDTO;

@Component
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> getListaPessoa() {
        return pessoaRepository.findAll();
    }

    @Override
    public PessoaDTO salvarPessoa(Pessoa pessoa) {// nova inscricao
        var pessoaSalvo = this.pessoaRepository.save(pessoa);

        return pessoaSalvo.obterPessoaDTO();
    }
/*
    @Override
    public Pessoa salvarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    } */

    @Override
    public void apagarPessoa(Integer id) {
        pessoaRepository.deleteById(id);
    }

    @Override
    public void editarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);

    }

    @Override
    public Optional<Pessoa> getPessoaById(Integer id) {
        return pessoaRepository.findById(id);
    }
}