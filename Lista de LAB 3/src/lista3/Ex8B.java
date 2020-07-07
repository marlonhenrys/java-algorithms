package lista3;

import java.util.Scanner;

public class Ex8B {

	static Scanner ler = new Scanner(System.in);

	public static void run() {
		int[] moedas = new int[] { 2, 3, 6 };
		System.out.print("Informe o valor do troco: ");
		int valor = ler.nextInt();
		ler.nextLine();
		System.out.print("\nMoedas:\t");
		for (int i = 0; i < moedas.length; i++)
			System.out.print("\t" + moedas[i]);

		System.out.println("\n\nQuantidade mínima de moedas: " + numMoedasOTIMIZADO(valor, moedas));
	}

	public static int numMoedas(int valor, int[] moedas) {

		int[][] C = new int[moedas.length][valor + 1];

		for (int i = 0; i < moedas.length; i++)
			C[i][0] = 0;

		for (int i = 1; i <= valor; i++)
			C[0][i] = i;

		for (int i = 1; i < moedas.length; i++) {

			for (int j = 1; j <= valor; j++) {

				if (j - moedas[i] >= 0)
					C[i][j] = min(C[i - 1][j], 1 + C[i][j - moedas[i]]);
				else
					C[i][j] = C[i - 1][j];
			}
		}

		return C[moedas.length - 1][valor];
	}

	public static int numMoedasOTIMIZADO(int valor, int[] moedas) {

		int numMoedas;

		int[][] C = new int[moedas.length][valor + 1];

		for (int i = 0; i < moedas.length; i++) {

			for (int j = 0; j <= valor; j++) {

				int k = j - moedas[i];

				if (k >= 0) {

					numMoedas = C[i][k] + 1;
					if (i > 0 && C[i - 1][j] < numMoedas)
						numMoedas = C[i - 1][j];

				} else
					numMoedas = i == 0 ? 0 : C[i - 1][j];

				C[i][j] = numMoedas;
			}
		}

		return C[moedas.length - 1][valor];
	}

	private static int min(int x, int y) {
		return x < y ? x : y;
	}
}
