package br.gov.br.fatec.springbootapp.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "moradores")
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mor_id")
    private Long id;
    
    @Column(name = "mor_nome")
    private String nome;

    @Column(name = "mor_telefone")
    private String telefone;

    @Column(name = "mor_senha")
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "morador")
    private Set<Apartamento> apartamento;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return this.senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Apartamento> getApartamentos() {
        return this.apartamento;
    }
    public void setApartamentos(Set<Apartamento> apartamento) {
        this.apartamento = apartamento;
    }
}