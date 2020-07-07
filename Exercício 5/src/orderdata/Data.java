package orderdata;

import java.util.Calendar;

import ordenação.Ordenavel;

public class Data implements Ordenavel {
	private int dia;
	private int mes;
	private int ano;

	public Data(int dia, int mes, int ano) {
		setMes(mes);
		setDia(dia);
		this.ano = ano;

	}

	public Data() {
		Calendar c = Calendar.getInstance();
		c.setTime(c.getTime());

		dia = c.get(Calendar.DATE);
		mes = c.get(Calendar.MONTH) + 1;
		ano = c.get(Calendar.YEAR);
	}

	private void setDia(int dia) {
		if (dia >= 1 && dia <= diasNoMes())
			this.dia = dia;
		else
			this.dia = 1;
	}

	private void setMes(int mes) {
		if (mes >= 1 && mes <= 12)
			this.mes = mes;
		else
			this.mes = 1;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public void adicionaDias(int dias) {
		for (int i = 0; i < dias; i++) {
			proximoDia();
		}
	}

	public int diasNoMes() {
		if (getMes() == 2) {
			if (eAnoBisexto())
				return 29;
			else
				return 28;
		} else if (getMes() == 1 || getMes() == 3 || getMes() == 5 || getMes() == 7 || getMes() == 8 || getMes() == 10
				|| getMes() == 12) {
			return 31;
		} else
			return 30;
	}

	public String diaDaSemana(int dia, int mes, int ano) {

		Calendar c = Calendar.getInstance();
		c.set(ano, mes - 1, dia);
		switch (c.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			return "Domingo";
		case 2:
			return "Segunda-feira";
		case 3:
			return "Terça-feira";
		case 4:
			return "Quarta-feira";
		case 5:
			return "Quinta-feira";
		case 6:
			return "Sexta-feira";
		case 7:
			return "Sábado";
		default:
			return "Inválido";
		}
	}

	public boolean eAnoBisexto() {
		if (getAno() % 4 == 0) {

			if (getAno() % 100 == 0)
				return getAno() % 400 == 0;
			else
				return true;

		} else
			return false;
	}

	public void proximoDia() {
		dia++;
		if (getDia() > diasNoMes()) {
			mes++;
			dia = 1;
			if (getMes() > 12) {
				ano++;
				mes = 1;
			}
		}
	}

	public String porExtenso() {

		String extenso;

		switch (mes) {
		case 1:
			extenso = " de Janeiro de ";
			break;
		case 2:
			extenso = " de Fevereiro de ";
			break;
		case 3:
			extenso = " de Março de ";
			break;
		case 4:
			extenso = " de Abril de ";
			break;
		case 5:
			extenso = " de Maio de ";
			break;
		case 6:
			extenso = " de Junho de ";
			break;
		case 7:
			extenso = " de Julho de ";
			break;
		case 8:
			extenso = " de Agosto de ";
			break;
		case 9:
			extenso = " de Setembro de ";
			break;
		case 10:
			extenso = " de Outubro de ";
			break;
		case 11:
			extenso = " de Novembro de ";
			break;
		case 12:
			extenso = " de Dezembro de ";
			break;
		default:
			extenso = " de ERRO de ";
		}
		return dia + extenso + ano;
	}

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}

	@Override
	public boolean equals(Object obj) {
		Data date = (Data) obj;

		return date.dia == this.dia && date.mes == this.mes && date.ano == this.ano;
	}

	@Override
	public boolean menorQue(Ordenavel o) {
		Data aux = (Data) o;
		return this.ano < aux.ano || (this.ano == aux.ano && this.mes < aux.mes)
				|| (this.ano == aux.ano && this.mes == aux.mes && this.dia < aux.dia);
	}
}
