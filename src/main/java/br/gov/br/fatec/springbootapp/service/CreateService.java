package br.gov.br.fatec.springbootapp.service;

import java.util.List;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.entity.Morador;

public interface CreateService {

    public Morador criarMoradorInApartamento(String cpf, String nome, String telefone, String email, String senha, String unidade, Integer garagem);
    
    public Morador criarMorador(String cpf, String nome, String telefone, String email, String senha);

    public Apartamento criarApartamento(String unidade, Integer garagem);
    
    public List<Morador> buscarTodosMoradores();

    public List<Apartamento> buscarTodosApartamentos();

    public Morador buscarMoradorPorId(Long id);

    public Morador buscarMoradorPorNome(String nome);

    public Apartamento buscarApartamentoPorUnidade(String unidade);

    public Morador deletarMorador(String cpf);

    public Morador updateMoradorTelefone(String cpf, String telefone);

}