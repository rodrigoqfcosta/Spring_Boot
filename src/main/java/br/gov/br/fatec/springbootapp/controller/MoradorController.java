package br.gov.br.fatec.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/{id}")
    public Morador buscarPorId(@PathVariable("id") Long id) {
        return createService.buscarMoradorPorId(id);
    }

    @GetMapping(value = "/nome")
    public Morador buscarPorNome(@RequestParam(value = "nome") String nome) {
        return createService.buscarMoradorPorNome(nome);
    }

    @PostMapping
    public Morador cadastraMorador(@RequestBody Morador morador) {
        return createService.criarMorador(morador.getCpf(), morador.getNome(), morador.getTelefone(), morador.getEmail(), morador.getSenha());
    }
        
}
