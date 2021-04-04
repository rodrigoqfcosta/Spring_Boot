package br.gov.br.fatec.springbootapp.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.entity.Morador;
import br.gov.br.fatec.springbootapp.repository.ApartamentoRepository;
import br.gov.br.fatec.springbootapp.repository.MoradorRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private ApartamentoRepository apartamentoRep;

    @Autowired
    private MoradorRepository moradorRep;

    @Override
    @Transactional
    public Morador criarMorador(String cpf, String nome, String telefone, String email, String senha, String unidade, Integer garagem) {
        Apartamento ap = apartamentoRep.findByUnidade(unidade);
        if(ap == null) {
            ap = new Apartamento();
            ap.setUnidade(unidade);
            ap.setGaragem(garagem);
            apartamentoRep.save(ap);
        }
        Morador morador = new Morador();
        morador.setCpf(cpf);
        morador.setNome(nome);
        morador.setTelefone(telefone);
        morador.setEmail(email);
        morador.setSenha(senha);
        morador.setApartamentos(new HashSet<Apartamento>());
        morador.getApartamentos().add(ap);
        moradorRep.save(morador);
        return morador;
        
    }
    
}