package lista3;

import java.util.Scanner;

public class Ex5 {

	public static Scanner ler = new Scanner(System.in);
	public static char[][] tabuleiro;
	public static int n = 0;

	public static void run() {
		System.out.print("Defina um valor de N para um tabuleiro (N x N): ");
		int n = ler.nextInt();
		criaTabuleiro(n);
		for (int r = 1; r <= n; r++)
			addRainha(r);
	}

	public static void addRainha(int rainha) {
		for (int i = 1; i <= n; i++) {
			if (posicaoValida(new int[] { rainha - 1, i - 1 })) {
				tabuleiro[rainha - 1][i - 1] = '#';
				if (rainha == n)
					imprimeTabuleiro();
				else {
					addRainha(rainha + 1);
					tabuleiro[rainha - 1][i - 1] = ' ';
				}
			}
		}
	}

	public static void criaTabuleiro(int tamanho) {
		tabuleiro = new char[tamanho][tamanho];
		n = tamanho;
		for (int l = 0; l < n; l++) {
			for (int c = 0; c < n; c++) {
				tabuleiro[l][c] = ' ';
			}
		}
	}

	public static void imprimeTabuleiro() {
		System.out.println();
		String posicoes = "";
		for (int l = 0; l < n; l++) {
			for (int c = 0; c < n; c++) {
				System.out.print("[" + tabuleiro[l][c] + "]");
				if (tabuleiro[l][c] != ' ')
					posicoes += "\nLinha: " + (l + 1) + " - Coluna: " + (c + 1);
			}
			System.out.println();
		}
		System.out.println(posicoes);
	}

	public static boolean posicaoValida(int[] endRainha) {

		if (tabuleiro[endRainha[0]][endRainha[1]] != ' ')
			return false;

		// verifica linha

		for (int c = 0; c < n; c++) {
			if ((tabuleiro[endRainha[0]][c] != ' ') && (c != endRainha[1]))
				return false;
		}

		// verifica coluna

		for (int l = 0; l < n; l++) {
			if ((tabuleiro[l][endRainha[1]] != ' ') && (l != endRainha[0]))
				return false;
		}

		// --------- verifica diagonais ----------

		int l, c;

		// superior esquerda

		l = endRainha[0] - 1;
		c = endRainha[1] - 1;

		while (l >= 0 && c >= 0) {
			if (tabuleiro[l][c] != ' ')
				return false;
			l--;
			c--;
		}

		// superior direita

		l = endRainha[0] - 1;
		c = endRainha[1] + 1;

		while (l >= 0 && c < n) {
			if (tabuleiro[l][c] != ' ')
				return false;
			l--;
			c++;
		}

		// inferior esquerda

		l = endRainha[0] + 1;
		c = endRainha[1] - 1;

		while (l < n && c >= 0) {
			if (tabuleiro[l][c] != ' ')
				return false;
			l++;
			c--;
		}

		// inferior direita

		l = endRainha[0] + 1;
		c = endRainha[1] + 1;

		while (l < n && c < n) {
			if (tabuleiro[l][c] != ' ')
				return false;
			l++;
			c++;
		}
		return true;
	}
}
