package lista3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex4 {

	static Scanner ler = new Scanner(System.in);

	public static void run() {

		ArrayList<Integer> lousa = new ArrayList<Integer>();
		int n, d = 0;

		System.out.print("Informe a quantidade de termos (N): ");
		n = ler.nextInt();
		ler.nextLine();

		for (int i = 0; i < n; i++) {
			System.out.print("\nInsira um dígito (0 - 9): ");
			lousa.add(ler.nextInt());
			ler.nextLine();
		}

		System.out.print("\n\nInforme a quantidade de termos a serem apagados (D): ");
		d = ler.nextInt();
		ler.nextLine();

		while (!fim(lousa, (n - d))) {
			lousa.remove(melhorOpcao(lousa));
		}

		imprime(lousa);
	}

	private static boolean fim(ArrayList<Integer> solucao, int qtde) {
		return solucao.size() == qtde;
	}

	private static void imprime(ArrayList<Integer> solucao) {
		System.out.print("\n\nResultado: ");
		for (int termo : solucao)
			System.out.print(termo);
	}

	private static int melhorOpcao(ArrayList<Integer> lousa) {
		int menor = 10, pos = 0;
		for (int i = 0; i < lousa.size(); i++) {
			if (lousa.get(i) < menor) {
				menor = lousa.get(i);
				pos = i;
			}
		}
		return pos;
	}

}
