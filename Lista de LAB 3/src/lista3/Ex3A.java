package lista3;

import java.util.Scanner;

public class Ex3A {

	static Scanner ler = new Scanner(System.in);

	public static void run() {
		int[][] itens = new int[][] { { 1, 1 }, { 2, 6 }, { 5, 18 }, { 6, 22 }, { 7, 28 } };
		System.out.print("Informe a capacidade da mochila: ");
		int capacidade = ler.nextInt();
		ler.nextLine();
		System.out.print("\nItens:\n");
		for (int i = 0; i < itens.length; i++)
			System.out.print("\n# Peso: " + itens[i][0] + " - Valor: " + itens[i][1]);

		System.out.println("\n\nValor máximo a ser levado: " + numItens(capacidade, itens));
	}

	public static int numItens(int capacidade, int[][] itens) {
		int[][] C = new int[itens.length][capacidade + 1];

		for (int i = 0; i < itens.length; i++)
			C[i][0] = 0;

		for (int i = 1; i <= capacidade; i++)
			C[0][i] = itens[0][1];

		for (int i = 1; i < itens.length; i++) {

			for (int j = 1; j <= capacidade; j++) {

				if (j - itens[i][0] >= 0)
					C[i][j] = max(C[i - 1][j], itens[i][1] + C[i - 1][j - itens[i][0]]);

				else
					C[i][j] = C[i - 1][j];
			}
		}

		return C[itens.length - 1][capacidade];
	}

	private static int max(int x, int y) {
		return x > y ? x : y;
	}

}
