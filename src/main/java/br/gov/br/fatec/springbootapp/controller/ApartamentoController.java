package br.gov.br.fatec.springbootapp.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.entity.Morador;
import br.gov.br.fatec.springbootapp.service.CreateService;

@RestController
@RequestMapping(value = "/apartamentos")
@CrossOrigin
public class ApartamentoController {
    
    @Autowired
    private CreateService createService;

    @GetMapping
    @JsonView(View.Apartamento.class)
    public List<Apartamento> buscarTodos() {
        return createService.buscarTodosApartamentos();
    }
    
    @JsonView(View.Apartamento.class)
    @GetMapping(value = "/unidade")
    public Apartamento buscaApartamentoPorUnidade(@PathParam("unidade") String unidade) {
        return createService.buscarApartamentoPorUnidade(unidade);
    }

    @PostMapping(value = "/cadastro")
    public Morador cadastroMorador(@RequestBody Morador morador) {
        return createService.criarMorador(morador.getCpf(), morador.getNome(), morador.getTelefone(), morador.getEmail(), morador.getSenha());
    }
}
