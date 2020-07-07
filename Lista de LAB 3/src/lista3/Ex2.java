package lista3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2 {

	public static Scanner ler = new Scanner(System.in);
	public static Jogada jogadaIA;

	public static void run() {
		int opcao = 0;
		do {
			executar();
			System.out.print("\n\nPressione 1 para SAIR ou 2 para JOGAR NOVAMENTE.\n\nOpção: ");
			opcao = ler.nextInt();
			limpa();
		} while (opcao != 1);
		System.out.println("Jogo Encerrado!");
	}

	public static void executar() {
		JogoDaVelha jogo;
		char linha;
		int coluna, inicio;

		do {

			System.out.println("\n              JOGO DA VELHA" + "\n-----------------------------------------\n\n"
					+ "Insira as coordenadas onde deseja jogar.\nDigite as LINHAS e COLUNAS separadamente.\n\n"
					+ "LINHAS : A | B | C\n" + "COLUNAS: 1 | 2 | 3\n\n-----------------------------------------\n\n");

			System.out.print("Quem irá começar? \n\n1 - Eu\n2 - Computador\n\nOpção: ");
			inicio = ler.nextInt();
			ler.nextLine();
			limpa();
		} while (inicio != 1 && inicio != 2);

		if (inicio == 1) {
			jogo = new JogoDaVelha('O', 'X');

		} else {
			jogo = new JogoDaVelha('X', 'O');
			jogarIA(jogo);
		}

		while (!jogo.fimDoJogo()) {

			do {
				limpa();
				jogo.imprimir();
				System.out.print("\n\nInforme a LINHA: ");
				linha = ler.nextLine().charAt(0);
				System.out.print("Informe a COLUNA: ");
				coluna = ler.nextInt();
				ler.nextLine();
				limpa();

			} while (!(jogo.posicaoValida(linha, coluna)));

			jogo.jogar(jogo.toLinha(linha), (coluna - 1));
			jogarIA(jogo);

			jogo.imprimir();
		}
		jogo.resultado();
	}

	public static void jogarIA(JogoDaVelha jogoOriginal) {
		melhorJogada(jogoOriginal);
		jogoOriginal.jogar(jogadaIA.getLinha(), jogadaIA.getColuna());

	}

	private static int melhorJogada(JogoDaVelha jogoAtual) {
		if (!(jogoAtual.fimDoJogo())) {

			ArrayList<Jogada> jogadas = jogoAtual.jogadasPossiveis();
			ArrayList<Integer> pontos = new ArrayList<Integer>();
			ArrayList<Jogada> movimentos = new ArrayList<Jogada>();

			for (Jogada jogada : jogadas) {

				JogoDaVelha novoJogo = new JogoDaVelha(jogoAtual.getJogo(), jogoAtual.getIA(), jogoAtual.getTeclado());
				novoJogo.jogar(jogada.getLinha(), jogada.getColuna());
				pontos.add(melhorJogada(novoJogo));
				movimentos.add(jogada);
			}

			int melhorJogada;

			if (jogoAtual.vezJogador() == jogoAtual.getIA())
				melhorJogada = getMax(pontos);
			else
				melhorJogada = getMin(pontos);

			jogadaIA = movimentos.get(melhorJogada);
			return pontos.get(melhorJogada);

		} else
			return jogoAtual.status();
	}

	public static int getMax(ArrayList<Integer> pontos) {
		int maior = 0, zero = 0;

		if (pontos.size() > 0) {
			for (int i = (pontos.size() - 1); i >= 0; i--) {
				int ponto = pontos.get(i);
				if (ponto > maior)
					return i;
				if (ponto == 0)
					zero = i;
			}
		}
		return zero;
	}

	public static int getMin(ArrayList<Integer> pontos) {
		int menor = 0, zero = 0;

		if (pontos.size() > 0) {
			for (int i = (pontos.size() - 1); i >= 0; i--) {
				int ponto = pontos.get(i);
				if (ponto < menor)
					return i;
				if (ponto == 0)
					zero = i;
			}
		}
		return zero;
	}

	public static void limpa() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}
}