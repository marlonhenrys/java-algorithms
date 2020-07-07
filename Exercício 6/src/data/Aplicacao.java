package data;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {

		Data date = null;
		int dia, mes, ano;
		Scanner ler = new Scanner(System.in);

		while (date == null) {

			try {

				System.out.println("Informe uma data:\n\nDia: ");
				dia = ler.nextInt();
				System.out.println("M�s: ");
				mes = ler.nextInt();
				System.out.println("Ano: ");
				ano = ler.nextInt();
				date = new Data(dia, mes, ano);

			} catch (ExcecaoDataInvalida e) {

				System.out.println("\n" + e.getMessage() + "\n");
			}
		}

		ler.close();
		System.out.println("\nData: " + date);
	}
}
