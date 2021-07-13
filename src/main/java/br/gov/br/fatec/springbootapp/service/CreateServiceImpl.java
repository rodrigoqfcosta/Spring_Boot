package br.gov.br.fatec.springbootapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.entity.Morador;
import br.gov.br.fatec.springbootapp.repository.ApartamentoRepository;
import br.gov.br.fatec.springbootapp.repository.MoradorRepository;

@Service("createService")
public class CreateServiceImpl implements CreateService {

    @Autowired
    private ApartamentoRepository apartamentoRep;

    @Autowired
    private MoradorRepository moradorRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @PreAuthorize("isAuthenticated()")
    public Morador criarMoradorInApartamento(String cpf, String nome, String telefone, String email, String perfil, String senha, String unidade, Integer garagem) {
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
        morador.setSenha(passwordEncoder.encode(senha));
        morador.setApartamentos(new HashSet<Apartamento>());
        morador.getApartamentos().add(ap);
        moradorRep.save(morador);
        return morador;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Morador criarMorador(String cpf, String nome, String telefone, String email, String perfil, String senha) {
        Morador morador = moradorRep.findByCpf(cpf);
        if(morador == null) {
            morador = new Morador();
            morador.setCpf(cpf);
            morador.setNome(nome);
            morador.setTelefone(telefone);
            morador.setEmail(email);
            morador.setPerfil(perfil);
            morador.setSenha(passwordEncoder.encode(senha));
            moradorRep.save(morador);
        }
        return morador;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Apartamento criarApartamento(String unidade, Integer garagem) {
        Apartamento ap = apartamentoRep.findByUnidade(unidade);
        if(ap == null) {
            ap = new Apartamento();
            ap.setUnidade(unidade);
            ap.setGaragem(garagem);
            apartamentoRep.save(ap);
        }
        return ap;
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Morador buscarMoradorPorId(Long id) {
        Optional<Morador> moradorOp = moradorRep.findById(id);
        if(moradorOp.isPresent()) {
            return moradorOp.get();
        }
        throw new RuntimeException("Morador não encontrado!");
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Morador buscarMoradorPorNome(String nome) {
        Morador morador = moradorRep.findByNome(nome);
        if(morador != null) {
            return morador;
        }
        throw new RuntimeException("Morador não encontrado!");
    }

    
    @Override
    @PreAuthorize("isAuthenticated()")
    public Apartamento buscarApartamentoPorUnidade(String unidade) {
        Apartamento ap = apartamentoRep.findByUnidade(unidade);
        if(ap != null) {
            return ap;
        }
        throw new RuntimeException("Apartamento não encontrado!");
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Morador> buscarTodosMoradores() {
        return moradorRep.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Apartamento> buscarTodosApartamentos() {
        return apartamentoRep.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public String deletarMorador(String cpf) {
        Morador morador = moradorRep.findByCpf(cpf);
        moradorRep.delete(morador);
        return "Usuario deletado";
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Morador updateMoradorTelefone(String cpf, String telefone) {
        Morador morador = moradorRep.findByCpf(cpf);
        morador.setTelefone(telefone);
        moradorRep.save(morador);
        return morador;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Morador morador = moradorRep.findByNome(username);
        if(morador == null) {
            throw new UsernameNotFoundException("Usuario " + username + "não encontrado!!!");
        }
        return User.builder().username(username).password(morador.getSenha())
            .authorities(morador.getPerfil()).build();
    }
}
