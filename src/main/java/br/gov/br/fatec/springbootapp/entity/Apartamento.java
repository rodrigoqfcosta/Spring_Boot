package br.gov.br.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "moradores_in_apartamentos", 
        joinColumns = { @JoinColumn(name = "ap_id")},
        inverseJoinColumns = { @JoinColumn(name = "mor_id")})
    private Set<Morador> moradores;

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
    public Set<Morador> getMoradores() {
        return this.moradores;
    }
    public void setMoradores(Set<Morador> moradores) {
        this.moradores = moradores;
    }
}