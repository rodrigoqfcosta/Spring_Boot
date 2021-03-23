package br.gov.br.fatec.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.br.fatec.springbootapp.entity.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long>{

}