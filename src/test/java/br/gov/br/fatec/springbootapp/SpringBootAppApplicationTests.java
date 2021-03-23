package br.gov.br.fatec.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.gov.br.fatec.springbootapp.entity.Morador;
import br.gov.br.fatec.springbootapp.repository.MoradorRepository;

@SpringBootTest
class SpringBootAppApplicationTests {

    @Autowired
    private MoradorRepository moradorRep;

	@Test
	void contextLoads() {
	}

    @Test
    void testaInsercao() {
        Morador morador = new Morador();
        morador.setNome("Usuario Teste");
        morador.setTelefone("(12)91234-5678");
        morador.setSenha("pass123");
        moradorRep.save(morador);
        assertNotNull(morador.getId());
    }
}
