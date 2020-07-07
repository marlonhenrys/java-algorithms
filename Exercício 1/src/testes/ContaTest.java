package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import estruturas.Conta;

public class ContaTest {

	@Test
	public void testeNovaConta() {
		Conta c = new Conta();
		assertEquals("erro ao criar conta", 0.0F, c.getSaldo(), 0.001);
	}

	@Test
	public void testNumeroConta() {
		Conta c = new Conta();
		assertEquals("numero da conta incorreto", 4, c.getNumeroConta());
	}

	@Test
	public void testDepositar() {
		Conta c = new Conta();
		c.depositar(150);
		assertEquals("erro ao depositar", 150, c.getSaldo(), 0.001);
	}

	@Test
	public void testSacar() {
		Conta c = new Conta(200);
		c.sacar(150);
		assertEquals("erro ao sacar", 50, c.getSaldo(), 0.001);
	}

}
