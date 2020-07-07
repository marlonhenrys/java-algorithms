package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import estruturas.Conversor;

public class ConversorTest {

	@Test
	public void testConverterPesParaMetros() {
		Conversor c = new Conversor();
		assertEquals("p�s para metros", 0.3048, c.converterPesParaMetros(1), 0.001);
	}

	@Test
	public void testConverterPesParaPolegadas() {
		Conversor c = new Conversor();
		assertEquals("p�s para polegadas", 12, c.converterPesParaPolegadas(1), 0.001);
	}

	@Test
	public void testConverterPesParaCentimetros() {
		Conversor c = new Conversor();
		assertEquals("p�s para cent�metros", 30.48, c.converterPesParaCentimetros(1), 0.001);
	}

	@Test
	public void testConverterPolegadasParaMetros() {
		Conversor c = new Conversor();
		assertEquals("polegadas para metros", 0.0254, c.converterPolegadasParaMetros(1), 0.001);
	}

	@Test
	public void testConverterPolegadasParaPes() {
		Conversor c = new Conversor();
		assertEquals("polegadas para p�s", 0.0833333, c.converterPolegadasParaPes(1), 0.001);
	}

	@Test
	public void testConverterPolegadasParaCentimetros() {
		Conversor c = new Conversor();
		assertEquals("polegadas para cent�metros", 2.54, c.converterPolegadasParaCentimetros(1), 0.001);
	}

	@Test
	public void testConverterMetrosParaPes() {
		Conversor c = new Conversor();
		assertEquals("metros para pes", 3.28084, c.converterMetrosParaPes(1), 0.001);
	}

	@Test
	public void testConverterMetrosParaPolegadas() {
		Conversor c = new Conversor();
		assertEquals("metros para polegadas", 39.3701, c.converterMetrosParaPolegadas(1), 0.001);
	}

	@Test
	public void testConverterMetrosParaCentimetros() {
		Conversor c = new Conversor();
		assertEquals("metros para cent�metros", 100, c.converterMetrosParaCentimetros(1), 0.001);
	}

	@Test
	public void testConverterCentimetrosParaPes() {
		Conversor c = new Conversor();
		assertEquals("cent�metros para p�s", 0.0328084, c.converterCentimetrosParaPes(1), 0.001);
	}

	@Test
	public void testConverterCentimetrosParaPolegadas() {
		Conversor c = new Conversor();
		assertEquals("cent�metros para polegadas", 0.393701, c.converterCentimetrosParaPolegadas(1), 0.001);
	}

	@Test
	public void testConverterCentimetrosParaMetros() {
		Conversor c = new Conversor();
		assertEquals("cent�metros para metros", 0.01, c.converterCentimetrosParaMetros(1), 0.001);
	}

}
