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

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.br.fatec.springbootapp.controller.View;


@Entity
@Table(name = "moradores")
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mor_id")
    private Long id;

    @JsonView(View.Morador.class)
    @Column(name = "mor_cpf")
    private String cpf;

    @JsonView({View.Morador.class, View.Apartamento.class})
    @Column(name = "mor_nome")
    private String nome;

    @JsonView({View.Morador.class, View.Apartamento.class})
    @Column(name = "mor_telefone")
    private String telefone;

    @JsonView({View.Morador.class, View.Apartamento.class})
    @Column(name = "mor_email")
    private String email;

    @JsonView({View.Morador.class, View.Apartamento.class})
    @Column(name = "mor_perfil")
    private String perfil;

    @Column(name = "mor_senha")
    private String senha;

    @JsonView(View.Morador.class)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "moradores")
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

    public String getPerfil() {
        return this.perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
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