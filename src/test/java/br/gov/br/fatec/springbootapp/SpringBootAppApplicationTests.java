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
    void testInsercao() {
        Morador morador = new Morador();
        morador.setNome("Usuario Teste");
        morador.setTelefone("(12)91234-5678");
        morador.setSenha("pass123");
        moradorRep.save(morador);
        assertNotNull(morador.getId());

        Apartamento ap = new Apartamento();
        ap.setUnidade("A13");
        ap.setGaragem(42);
        apartamentoRep.save(ap);
        assertNotNull(ap.getId());
    }

    @Test
    void testMoradorInApartamento() {
        Apartamento apartamento = apartamentoRep.findById(2L).get();
        assertEquals(2, apartamento.getMoradores().iterator().next().getId());

        Morador morador = moradorRep.findById(2L).get();
        assertEquals("B13", morador.getApartamentos().iterator().next().getUnidade());

    }
}
