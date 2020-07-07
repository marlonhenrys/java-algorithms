package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturas.Data;

public class DataTest {

	@Test
	public void testDataIntIntInt() {
		Data d = new Data(0, 3, 2011);
		assertEquals("erro: criação", 1, d.getDia());
	}

	@Test
	public void testAdicionaDias() {
		Data d = new Data(5, 9, 2020);
		d.adicionaDias(31);
		assertEquals("erro: adicionar dias", 6, d.getDia());
	}

	@Test
	public void testDiasNoMes() {
		Data d = new Data(10, 2, 2020);
		assertEquals("erro: dias no mês", 29, d.diasNoMes());
	}

	@Test
	public void testDiaDaSemana() {
		Data d = new Data();
		assertEquals("erro: dia da semana", "Quarta-feira", d.diaDaSemana(d.getDia(), d.getMes(), d.getAno()));
	}

	@Test
	public void testEAnoBisexto() {
		Data d = new Data(15, 5, 2016);
		assertTrue("erro: ano bisexto", d.eAnoBisexto());
	}

	@Test
	public void testProximoDia() {
		Data d = new Data(31, 7, 2018);
		d.proximoDia();
		assertEquals("erro: proximo dia", 1, d.getDia());
	}

}
