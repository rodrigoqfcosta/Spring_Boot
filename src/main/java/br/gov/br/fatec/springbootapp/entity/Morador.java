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

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "moradores")
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mor_id")
    private Long id;
    
    @Column(name = "mor_cpf")
    private String cpf;

    @Column(name = "mor_nome")
    private String nome;

    @Column(name = "mor_telefone")
    private String telefone;

    @Column(name = "mor_email")
    private String email;

    @Column(name = "mor_senha")
    private String senha;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "moradores")
    @JsonIgnore
    private Set<Apartamento> apartamentos;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Apartamento> getApartamentos() {
        return this.apartamentos;
    }
    public void setApartamentos(Set<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }
}