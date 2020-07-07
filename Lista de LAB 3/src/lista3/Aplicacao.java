package lista3;

import java.util.Scanner;

public class Aplicacao {

	static Scanner ler = new Scanner(System.in);

	public static void main(String[] args) {
		int opcao = 0;

		do {
			System.out
					.print("\n---------- LISTA DE EXERCÍCIOS 3 ---------\n\nSelecione o algoritmo que deseja executar: "
							+ "\n\n10 - Ordenação\n20 - Jogo da Velha"
							+ "\n30 - Mochila Dinâmica\n31 - Mochila Gulosa\n40 - Apagando e Ganhando"
							+ "\n50 - N Rainhas\n60 - Subsequências Iguais\n70 - Lista de Tarefas\n80 - Fibonacci Dinâmico"
							+ "\n81 - Problema do Troco\n\n0 - SAIR\n\nOpção: ");
			opcao = ler.nextInt();
			ler.nextLine();

			switch (opcao) {
			case 10:
				clear();
				Ex1.run();
				pause();
				break;
			case 20:
				clear();
				Ex2.run();
				pause();
				break;
			case 30:
				clear();
				Ex3A.run();
				pause();
				break;
			case 31:
				clear();
				Ex3B.run();
				pause();
				break;
			case 40:
				clear();
				Ex4.run();
				pause();
				break;
			case 50:
				clear();
				Ex5.run();
				pause();
				break;
			case 60:
				clear();
				Ex6.run();
				pause();
				break;
			case 70:
				clear();
				Ex7.run();
				pause();
				break;
			case 80:
				clear();
				Ex8A.run();
				pause();
				break;
			case 81:
				clear();
				Ex8B.run();
				pause();
				break;
			case 0:
				clear();
				System.out.println("Programa Encerrado...");
				break;
			default:
				clear();
				System.out.println("Opção Inválida!");
				pause();
			}

		} while (opcao != 0);

	}

	public static void clear() {
		for (int i = 0; i < 50; i++)
			System.out.println("");
	}

	public static void pause() {
		System.out.println("\n\n\nPressione ENTER para continuar...");
		ler.nextLine();
		for (int i = 0; i < 50; i++)
			System.out.println("");
	}

}
