package br.gov.br.fatec.springbootapp.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @JsonView(View.Morador.class)
    @GetMapping
    public List<Morador> buscarTodos() {
        return createService.buscarTodosMoradores();
    }

    @JsonView(View.Morador.class)
    @GetMapping(value = "/id/{id}")
    public Morador buscarPorId(@PathVariable("id") Long id) {
        return createService.buscarMoradorPorId(id);
    }

    @JsonView(View.Morador.class)
    @GetMapping(value = "/nome/{nome}")
    public Morador buscarPorNome(@PathVariable("nome") String nome) {
        return createService.buscarMoradorPorNome(nome);
    }

    @JsonView(View.Morador.class)
    @DeleteMapping(value = "/delete")
    public Morador deletarMorador(@RequestBody Morador morador) {
        return createService.deletarMorador(morador.getCpf());
    }

    @JsonView(View.Morador.class)
    @PutMapping(value = "/update")
    public Morador updateTelefone(@RequestBody Morador morador) {
        return createService.updateMoradorTelefone(morador.getCpf(), morador.getTelefone());
    }
}
