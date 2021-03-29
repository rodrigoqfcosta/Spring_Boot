package br.gov.br.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
        morador.setNome("Usuario Teste");
        morador.setTelefone("(12)91234-5678");
        morador.setSenha("pass123");
        moradorRep.save(morador);
        assertNotNull(morador.getId());
    }

    @Test
    void testInsercaoApartamento() {
        Apartamento apartamento = new Apartamento();
        apartamento.setUnidade("B99");
        apartamento.setGaragem(999);
        apartamentoRep.save(apartamento);
        assertNotNull(apartamento.getId());
    }

    @Test
    void testMoradorInApartamento() {
        Morador morador = moradorRep.findById(1L).get();
        assertEquals("A01", morador.getApartamentos().iterator().next().getUnidade());
    }

    @Test
    void testApartamentoInMorador() {
        Apartamento apartamento = apartamentoRep.findById(1L).get();
        assertEquals("User Test", apartamento.getMoradores().iterator().next().getNome());
    }
}
