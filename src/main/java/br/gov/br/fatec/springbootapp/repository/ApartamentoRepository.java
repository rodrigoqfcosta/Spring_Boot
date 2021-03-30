package br.gov.br.fatec.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.br.fatec.springbootapp.entity.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{

    public Apartamento findByUnidade(String unidade);

    public Apartamento findByGaragem(Integer garagem);

}