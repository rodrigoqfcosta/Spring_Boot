package br.gov.br.fatec.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.br.fatec.springbootapp.entity.Morador;
import br.gov.br.fatec.springbootapp.service.CreateService;

@RestController
@RequestMapping(value="/moradores")
@CrossOrigin
public class MoradorController {

    @Autowired
    private CreateService createService;

    @GetMapping
    public List<Morador> buscarTodos() {
        return createService.buscarTodosMoradores();
    }
        
}
