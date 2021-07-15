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
import br.gov.br.fatec.springbootapp.service.CreateService;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

    @Autowired
    private MoradorRepository moradorRep;

    @Autowired
    private ApartamentoRepository apartamentoRep;

    @Autowired
    private CreateService creService;

	@Test
	void contextLoads() {
    }
    
    @Test
    void testInsercaoMorador() {
        Morador morador = new Morador();
        morador.setCpf("1234567890x");
        morador.setNome("Teste Unitario");
        morador.setTelefone("(12)91234-5678");
        morador.setEmail("testUnitario@test.com");
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
        morador.setCpf("1234567890x");
        morador.setNome("Teste Unitario");
        morador.setTelefone("(12)91234-5678");
        morador.setEmail("testUnitario@test.com");
        morador.setSenha("pass123");
        morador.setApartamentos(new HashSet<Apartamento>());
        morador.getApartamentos().add(apartamento);
        moradorRep.save(morador);
        assertNotNull(morador.getApartamentos().iterator().next().getId());
    }

    @Test
    void testBuscaMoradorNomeContains() {
        List<Morador> morador = moradorRep.findByNomeContainsIgnoreCase("S");
        assertFalse(morador.isEmpty());
    }

    @Test
    void testBuscaMoradorNome() {
        Morador morador = moradorRep.findByNome("USER Teste");
        assertNotNull(morador);
    }

    @Test
    void testBuscaMoradorNomeQuery() {
        Morador morador = moradorRep.buscaPorNome("admin");
        assertNotNull(morador);
    }

    @Test
    void testBuscaMoradorCpf() {
        Morador morador = moradorRep.findByCpf("12345678900");
        assertNotNull(morador);
    }

    @Test
    void testBuscaMoradorNomeCpf() {
        Morador morador = moradorRep.findByNomeAndCpf("USER Teste", "98765432100");
        assertNotNull(morador);
    }

    @Test
    void testBuscaMoradorCpfSenha() {
        Morador morador = moradorRep.findByCpfAndSenha("98765432100", "$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C");
        assertNotNull(morador);
    }

    @Test
    void testBuscaMoradorUnidade() {
        List<Morador> morador = moradorRep.findByApartamentosUnidade("A00");
        assertFalse(morador.isEmpty());
    }

    @Test
    void testBuscaMoradorUnidadeQuery() {
        List<Morador> morador = moradorRep.buscaMoradorUnidade("A00");
        assertFalse(morador.isEmpty());
    }

    @Test
    void testBuscaApartamentoCpf() {
        List<Apartamento> ap = apartamentoRep.findByMoradoresCpf("12345678900");
        assertFalse(ap.isEmpty());
    }

    @Test
    void testSeviceCriarMorador() {
        Morador morador = creService.criarMorador("12345678909", "Test", "(12)91234-5678)", "test@test.com", "ROLE_ADMIN", "pass123");
        assertNotNull(morador);
    }

}
