package br.gov.br.fatec.springbootapp.service;

import java.util.List;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.entity.Morador;

public interface SegurancaService {

    public Morador criarMorador(String cpf, String nome, String telefone, String email, String senha, String unidade, Integer garagem);
    
    public List<Morador> buscarTodosMoradores();

    public List<Apartamento> buscarTodosApartamentos();

}
