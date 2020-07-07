package lista3;

import java.util.ArrayList;

public class JogoDaVelha {
	private char vencedor = ' ';
	private char IA;
	private char TECLADO;
	private char[][] tabuleiro = new char[3][3];
	private char A1 = tabuleiro[0][0] = ' ', A2 = tabuleiro[0][1] = ' ', A3 = tabuleiro[0][2] = ' ';
	private char B1 = tabuleiro[1][0] = ' ', B2 = tabuleiro[1][1] = ' ', B3 = tabuleiro[1][2] = ' ';
	private char C1 = tabuleiro[2][0] = ' ', C2 = tabuleiro[2][1] = ' ', C3 = tabuleiro[2][2] = ' ';

	public JogoDaVelha(char[][] campo, char ia, char teclado) {

		A1 = tabuleiro[0][0] = campo[0][0];
		A2 = tabuleiro[0][1] = campo[0][1];
		A3 = tabuleiro[0][2] = campo[0][2];
		B1 = tabuleiro[1][0] = campo[1][0];
		B2 = tabuleiro[1][1] = campo[1][1];
		B3 = tabuleiro[1][2] = campo[1][2];
		C1 = tabuleiro[2][0] = campo[2][0];
		C2 = tabuleiro[2][1] = campo[2][1];
		C3 = tabuleiro[2][2] = campo[2][2];

		this.IA = ia;
		this.TECLADO = teclado;
	}

	public JogoDaVelha(char ia, char teclado) {
		this.IA = ia;
		this.TECLADO = teclado;
	}

	public void jogar(int linha, int coluna) {
		char jogador = vezJogador();
		if (!acabouEspaco()) {
			tabuleiro[linha][coluna] = jogador;
			atualizar();
			checarVitoria(jogador);
		}
	}

	public char getIA() {
		return this.IA;
	}

	public char getTeclado() {
		return this.TECLADO;
	}

	public char[][] getJogo() {
		return tabuleiro;
	}

	public ArrayList<Jogada> jogadasPossiveis() {
		ArrayList<Jogada> jogadas = new ArrayList<Jogada>();
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				if (tabuleiro[l][c] == ' ')
					jogadas.add(new Jogada(l, c));
			}
		}
		return jogadas;
	}

	public boolean fimDoJogo() {
		return (acabouEspaco() || vencedor != ' ');
	}

	public char vezJogador() {
		int contX = 0, contO = 0;
		for (int l = 0; l < 3; l++) {
			for (int c = 0; c < 3; c++) {
				if (tabuleiro[l][c] == 'X')
					contX++;
				else if (tabuleiro[l][c] == 'O')
					contO++;
			}
		}
		if (contO < contX)
			return 'O';
		else
			return 'X';
	}

	public int status() {
		if (fimDoJogo()) {
			if (vencedor == IA)
				return 10;
			if (vencedor == TECLADO)
				return -10;

			return 0;
		}
		return -1;
	}

	public void resultado() {
		if (fimDoJogo()) {
			if (vencedor == TECLADO)
				System.out.println("\n\n\n# Parabéns! Você Ganhou!");
			else if (vencedor == IA)
				System.out.println("\n\n\n# Game Over! Você Perdeu!");
			else
				System.out.println("\n\n\n# Fim de Jogo! Deu Velha!");
		}
	}

	public boolean posicaoValida(char linha, int c) {
		int l;

		if (linha == 'A' || linha == 'a')
			l = 0;
		else if (linha == 'B' || linha == 'b')
			l = 1;
		else if (linha == 'C' || linha == 'c')
			l = 2;
		else
			return false;

		if (tabuleiro[l][(c - 1)] == ' ')
			return true;

		return false;
	}

	public int toLinha(char linha) {
		int l = -1;

		if (linha == 'A' || linha == 'a')
			l = 0;
		else if (linha == 'B' || linha == 'b')
			l = 1;
		else if (linha == 'C' || linha == 'c')
			l = 2;

		return l;
	}

	private boolean acabouEspaco() {
		return ((A1 != ' ') && (A2 != ' ') && (A3 != ' ') && (B1 != ' ') && (B2 != ' ') && (B3 != ' ') && (C1 != ' ')
				&& (C2 != ' ') && (C3 != ' '));
	}

	private void checarVitoria(char jogador) {
		if ((A1 == jogador && A1 == A2 && A2 == A3) || (A1 == jogador && A1 == B1 && B1 == C1)
				|| (A1 == jogador && A1 == B2 && B2 == C3) || (B1 == jogador && B1 == B2 && B2 == B3)
				|| (C1 == jogador && C1 == C2 && C2 == C3) || (A3 == jogador && A3 == B3 && B3 == C3)
				|| (A2 == jogador && A2 == B2 && B2 == C2) || (C1 == jogador && C1 == B2 && B2 == A3)) {

			vencedor = jogador;
		}
	}

	private void atualizar() {
		A1 = tabuleiro[0][0];
		A2 = tabuleiro[0][1];
		A3 = tabuleiro[0][2];
		B1 = tabuleiro[1][0];
		B2 = tabuleiro[1][1];
		B3 = tabuleiro[1][2];
		C1 = tabuleiro[2][0];
		C2 = tabuleiro[2][1];
		C3 = tabuleiro[2][2];
	}

	public void imprimir() {
		System.out.println("        1 | 2 | 3 \n" + "       --- --- --- " + "\n\n" + " A |    " + A1 + " | " + A2
				+ " | " + A3 + "\n" + "---    --- --- --- " + "\n" + " B |    " + B1 + " | " + B2 + " | " + B3 + "\n"
				+ "---    --- --- --- " + "\n" + " C |    " + C1 + " | " + C2 + " | " + C3);
	}
}
