package br.gov.br.fatec.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.br.fatec.springbootapp.entity.Morador;
import br.gov.br.fatec.springbootapp.service.SegurancaService;

@RestController
@RequestMapping(value="/morador")
@CrossOrigin
public class MoradorController {

    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Morador> buscarTodos() {
        return segurancaService.buscarTodosMoradores();
    }
        
}
