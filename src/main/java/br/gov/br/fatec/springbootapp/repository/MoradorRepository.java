package br.gov.br.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.br.fatec.springbootapp.entity.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long>{

    public List<Morador> findByNomeContainsIgnoreCase(String nome);

    public Morador findByNome(String nome);

    public Morador findByCpf(String cpf);

    public Morador findByNomeAndSenha(String nome, String senha);

    public List<Morador> findByApartamentosUnidade(String unidade);

}