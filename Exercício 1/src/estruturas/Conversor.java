package estruturas;

public class Conversor {

	public double converterPesParaMetros(double valor) {

		valor = valor / 3.281;

		return valor;
	}

	public double converterPesParaPolegadas(double valor) {

		valor = valor * 12;

		return valor;
	}

	public double converterPesParaCentimetros(double valor) {
		
		valor = valor * 30.48;
		
		return valor;
	}

	public double converterPolegadasParaMetros(double valor) {
		
		valor = valor / 39.37;

		return valor;
	}

	public double converterPolegadasParaPes(double valor) {

		valor = valor / 12;
		
		return valor;
	}

	public double converterPolegadasParaCentimetros(double valor) {
		
		valor = valor * 2.54;

		return valor;
	}

	public double converterMetrosParaPes(double valor) {
		
		valor = valor * 3.281;

		return valor;
	}

	public double converterMetrosParaPolegadas(double valor) {
		
		valor = valor * 39.37;

		return valor;
	}

	public double converterMetrosParaCentimetros(double valor) {
		
		valor = valor * 100;

		return valor;
	}

	public double converterCentimetrosParaPes(double valor) {
		
		valor = valor / 30.48;

		return valor;
	}

	public double converterCentimetrosParaPolegadas(double valor) {
		
		valor = valor / 2.54;

		return valor;
	}

	public double converterCentimetrosParaMetros(double valor) {
		
		valor = valor / 100;

		return valor;
	}

}
