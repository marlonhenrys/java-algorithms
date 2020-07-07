package lista3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex3B {

	static Scanner ler = new Scanner(System.in);
	static ArrayList<Integer> mochila = new ArrayList<Integer>();

	public static void run() {
		int[][] itens = new int[][] { { 1, 1 }, { 2, 6 }, { 5, 18 }, { 6, 22 }, { 7, 28 } };
		System.out.print("Informe a capacidade da mochila: ");
		int capacidade = ler.nextInt();
		ler.nextLine();
		System.out.print("\nItens:\n");
		for (int i = 0; i < itens.length; i++)
			System.out.print("\n# Peso: " + itens[i][0] + " - Valor: " + itens[i][1]);

		int ocupado = 0;
		while (ocupado < capacidade) {
			int item = numItens((capacidade - ocupado), itens);
			if (!mochila.contains(item)) {
				mochila.add(item);
				ocupado += itens[item][0];
			} else
				break;
		}

		imprime(mochila, itens);
	}

	public static int numItens(int capacidade, int[][] itens) {

		int melhor = 0;

		for (int i = 0; i < itens.length; i++) {
			if (itens[i][0] < capacidade && !mochila.contains(i))
				if (itens[melhor][1] < itens[i][1])
					melhor = i;
		}

		return melhor;

	}

	private static void imprime(ArrayList<Integer> mochila, int[][] itens) {
		int pesoTotal = 0, valorTotal = 0;
		System.out.println("\n\nItens a serem levados:\n");
		for (Integer indice : mochila) {
			System.out.println("Peso: " + itens[indice][0] + " - Valor: " + itens[indice][1]);
			pesoTotal += itens[indice][0];
			valorTotal += itens[indice][1];
		}

		System.out.println("\n\nPeso Total: " + pesoTotal + "\n\nValor Total: " + valorTotal);
	}
}
