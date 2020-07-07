package lista3;

import java.util.Scanner;

public class Ex6 {

	static Scanner ler = new Scanner(System.in);

	public static void run() {
		System.out.print("\nInforme a primeira palavra: ");
		String palavraX = " " + ler.nextLine();
		char[] x = new char[palavraX.length()];

		System.out.print("\nInforme a segunda palavra: ");
		String palavraY = " " + ler.nextLine();
		char[] y = new char[palavraY.length()];

		for (int i = 0; i < palavraX.length(); i++)
			x[i] = palavraX.charAt(i);

		for (int i = 0; i < palavraY.length(); i++)
			y[i] = palavraY.charAt(i);

		char[][] b = new char[x.length][y.length];

		System.out.print("\n\nTamanho da maior subsequência: " + subSequencia(x, y, b));
		System.out.print("\n\nMaior subsequência: ");
		imprimeSequencia(b, x, (x.length - 1), (y.length - 1));
		System.out.println("\n\nMatriz de Resultados:\n");
		imprimeMatriz(b, x, y);
	}

	public static int subSequencia(char[] x, char[] y, char[][] b) {

		int m = x.length;
		int n = y.length;
		int[][] c = new int[m][n];
		for (int i = 0; i < m; i++) {
			c[i][0] = 0;
			b[i][0] = '0';
		}
		for (int j = 0; j < n; j++) {
			c[0][j] = 0;
			b[0][j] = '0';
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (x[i] == y[j]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = '\\';
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = '^';

				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = '<';
				}
			}
		}
		return c[m - 1][n - 1];
	}

	public static void imprimeSequencia(char[][] b, char[] x, int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (b[i][j] == '\\') {
			imprimeSequencia(b, x, i - 1, j - 1);
			System.out.print(" " + x[i]);
		} else if (b[i][j] == '^') {
			imprimeSequencia(b, x, i - 1, j);
		} else if (b[i][j] == '<')
			imprimeSequencia(b, x, i, j - 1);
	}

	public static void imprimeMatriz(char[][] b, char[] x, char[] y) {
		System.out.print("      ");
		for (int i = 1; i < y.length; i++)
			System.out.print("   " + y[i]);
		System.out.println("");
		for (int i = 0; i < x.length; i++) {
			System.out.print("\n");
			System.out.print(x[i] + " ");
			for (int j = 0; j < y.length; j++) {
				if (i == 0 && j == 0)
					System.out.print("");

				System.out.print("   " + b[i][j]);
			}
		}
	}
}
