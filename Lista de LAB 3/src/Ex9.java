import java.util.Scanner;

public class Ex9 {

	public static void main(String args[]) {

		Scanner ler = new Scanner(System.in);
		System.out.print("Digite a quantidade de termos da primeira sequência: ");
		int[] m = new int[ler.nextInt()];
		ler.nextLine();
		System.out.print("\nDigite a quantidade de termos segunda sequência: ");
		int[] n = new int[ler.nextInt()];

		for (int i = 0; i < m.length; i++) {
			System.out.print("\nDigite o termo " + (i + 1) + " da 1ª sequência: ");
			m[i] = ler.nextInt();
			ler.nextLine();
		}

		for (int i = 0; i < n.length; i++) {
			System.out.print("\nDigite o termo " + (i + 1) + " da 2ª sequência: ");
			n[i] = ler.nextInt();
			ler.nextLine();
		}

		int[] max = new int[m.length + n.length];
		int aux = 0;
		int aux2 = 0;

		for (int i = 0; i < max.length; i++) {

			if (aux == m.length) {
				max[i] = n[aux2];
				aux2++;
			} else if (aux2 == n.length) {
				max[i] = m[aux];
				aux++;

			} else {
				if (m[aux] < n[aux2]) {
					max[i] = m[aux];
					aux++;
				} else {
					max[i] = n[aux2];
					aux2++;
				}
			}
		}

		System.out.println("\nDigite o elemento a ser pesquisado: ");
		System.out.println(max[ler.nextInt() - 1]);
		ler.close();
	}
}