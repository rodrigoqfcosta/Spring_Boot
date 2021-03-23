package br.gov.br.fatec.springbootapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "apartamentos")
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ap_id")
    private Long id;
    
    @Column(name = "ap_unidade")
    private String unidade;

    @Column(name = "ap_garagem")
    private Integer garagem;


    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUnidade() {
        return this.unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Integer getGaragem() {
        return this.garagem;
    }
    public void setGaragem(Integer garagem) {
        this.garagem = garagem;
    }
}