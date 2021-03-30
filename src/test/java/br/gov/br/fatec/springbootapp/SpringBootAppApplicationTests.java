package br.gov.br.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.br.fatec.springbootapp.entity.Apartamento;
import br.gov.br.fatec.springbootapp.repository.ApartamentoRepository;
import br.gov.br.fatec.springbootapp.entity.Morador;
import br.gov.br.fatec.springbootapp.repository.MoradorRepository;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private MoradorRepository moradorRep;

    @Autowired
    private ApartamentoRepository apartamentoRep;

	@Test
	void contextLoads() {
    }
    
    @Test
    void testInsercaoMorador() {
        Morador morador = new Morador();
        morador.setNome("User Teste");
        morador.setTelefone("(12)91234-5678");
        morador.setSenha("pass123");
        moradorRep.save(morador);
        assertNotNull(morador.getId());
    }

    @Test
    void testInsercaoApartamento() {
        Apartamento apartamento = new Apartamento();
        apartamento.setUnidade("A99");
        apartamento.setGaragem(1);
        apartamentoRep.save(apartamento);
        assertNotNull(apartamento.getId());
    }

    @Test
    void testMoradorInApartamento() {
        Apartamento apartamento = new Apartamento();
        apartamento.setUnidade("A99");
        apartamento.setGaragem(99);
        apartamentoRep.save(apartamento);
        Morador morador = new Morador();
        morador.setNome("User Teste");
        morador.setTelefone("(12)91234-5678");
        morador.setSenha("pass123");
        morador.setApartamentos(new HashSet<Apartamento>());
        morador.getApartamentos().add(apartamento);
        moradorRep.save(morador);
        assertNotNull(morador.getApartamentos().iterator().next().getId());
    }

    @Test
    void testBuscaMoradorNomeContains() {
        List<Morador> morador = moradorRep.findByNomeContainsIgnoreCase("G");
        assertFalse(morador.isEmpty());
    }

    @Test
    void testBuscaMoradorNome() {
        Morador morador = moradorRep.findByNome("Rodrigo Querino");
        assertNotNull(morador);
    }

    @Test
    void testBuscaMoradorNomeSenha() {
        Morador morador = moradorRep.findByNomeAndSenha("Rodrigo Querino", "pass123");
        assertNotNull(morador);
    }

    @Test
    void testApartamentoUnidade() {
        Apartamento ap = apartamentoRep.findByUnidade("B13");
        assertNotNull(ap);
    }

    @Test
    void testBuscaMoradorApartamento() {
        List<Morador> morador = moradorRep.findByApartamentoUnidade("B13");
        assertNotNull(morador);
    }
}
