package br.gov.br.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.br.fatec.springbootapp.entity.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long>{

    public List<Morador> findByNomeContainsIgnoreCase(String nome);

    public Morador findByNome(String nome);

    @Query("select m from Morador m where m.nome = ?1")
    public Morador buscaPorNome(String nome);

    public Morador findByCpf(String cpf);

    public Morador findByNomeAndCpf(String nome, String cpf);

    public Morador findByCpfAndSenha(String cpf, String senha);

    public List<Morador> findByApartamentosUnidade(String unidade);

    @Query("select m from Morador m inner join m.apartamentos a where a.unidade = ?1")
    public List<Morador> buscaMoradorUnidade(String unidade);

}