package orderdata;

import java.util.Random;

import ordenação.Ordenador;
import ordenação.Ordenavel;

public class Aplicacao {

	public static void main(String[] args) {

		Random gerador = new Random();
		Ordenavel[] lista = new Ordenavel[3];

		System.out.println("Criando lista...\n");
		for (int i = 0; i < 3; i++)
			lista[i] = new Data(gerador.nextInt(31), gerador.nextInt(12), gerador.nextInt(2000));

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
