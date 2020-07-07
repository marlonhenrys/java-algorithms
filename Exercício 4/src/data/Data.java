package data;


import java.util.Calendar;

public class Data {
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

	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
	
	@Override
	public boolean equals(Object obj) {
		Data date = (Data) obj;
		
		return date.dia == this.dia && date.mes == this.mes && date.ano == this.ano;
	}
}
