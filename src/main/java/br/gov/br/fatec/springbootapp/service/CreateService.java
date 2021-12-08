package br.gov.br.fatec.springbootapp.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.entity.Morador;

public interface CreateService extends UserDetailsService {

    public Morador criarMoradorInApartamento(String cpf, String nome, String telefone, String email, String perfil, String senha, String unidade, Integer garagem);
    
    public Morador criarMorador(String cpf, String nome, String telefone, String email, String perfil, String senha);

    public Apartamento criarApartamento(String unidade, Integer garagem);
    
    public List<Morador> buscarTodosMoradores();

    public List<Apartamento> buscarTodosApartamentos();

    public Morador buscarMoradorPorId(Long id);

    public Morador buscarMoradorPorEmail(String email);

    public Morador buscarMoradorPorNome(String nome);

    public Apartamento buscarApartamentoPorUnidade(String unidade);

    public String deletarMorador(String cpf);

    public Morador updateMoradorTelefone(String cpf, String telefone);

}
