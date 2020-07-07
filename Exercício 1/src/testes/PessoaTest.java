package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import estruturas.Pessoa;

public class PessoaTest {

	@Test
	public void testNome() {
		Pessoa p = new Pessoa();
		p.setNome("maria");
		assertEquals("erro: nome", "maria", p.getNome());
	}

	@Test
	public void testCPF() {
		Pessoa p = new Pessoa();
		p.setCPF("10020030040");
		assertEquals("erro: cpf", "10020030040", p.getCPF());
	}

	@Test
	public void testIdade() {
		Pessoa p = new Pessoa();
		p.setIdade(35);
		assertEquals("erro: idade", 35, p.getIdade());
	}

	@Test
	public void testSexo() {
		Pessoa p = new Pessoa();
		p.setSexo("Feminino");
		assertEquals("erro: sexo", "Feminino", p.getSexo());
	}

	@Test
	public void testMaioridade() {
		Pessoa p = new Pessoa();
		p.setIdade(18);
		assertTrue("erro: maioridade", p.eMaior());
	}

}
