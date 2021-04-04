package br.gov.br.fatec.springbootapp.service;

import br.gov.br.fatec.springbootapp.entity.Morador;

public interface SegurancaService {

    public Morador criarMorador(String cpf, String nome, String telefone, String email, String senha, String unidade, Integer garagem);
    
}
