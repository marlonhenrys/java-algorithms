package orderpessoa;

import ordenação.Ordenador;
import ordenação.Ordenavel;

public class Aplicacao {

	public static void main(String[] args) {

		Ordenavel[] lista = new Ordenavel[3];

		System.out.println("Criando lista...\n");
		lista[0] = new Cliente(new PessoaFisica("marlon", "10020030040"), 150.95F);
		lista[1] = new Cliente(new PessoaFisica("gabriel", "10120130141"), 150.95F);
		lista[2] = new Cliente(new PessoaFisica("lucas", "10220230242"), 150.95F);

		for (int i = 0; i < lista.length; i++)
			System.out.println(lista[i]);

		System.out.println("\n\nOrdenando em ordem crescente...\n");
		lista = Ordenador.crescente(lista);

		for (int i = 0; i < lista.length; i++)
			System.out.println(lista[i]);

		System.out.println("\n\nOrdenando em ordem decrescente...\n");
		lista = Ordenador.decrescente(lista);

		for (int i = 0; i < lista.length; i++)
			System.out.println(lista[i]);

	}

}
