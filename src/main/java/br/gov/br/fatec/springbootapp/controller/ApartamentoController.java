package br.gov.br.fatec.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.service.SegurancaService;

@RestController
@RequestMapping(value="/apartamentos")
@CrossOrigin
public class ApartamentoController {
    
    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Apartamento> buscarTodos() {
        return segurancaService.buscarTodosApartamentos();
    }
}
