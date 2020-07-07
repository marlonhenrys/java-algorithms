package lista3;

public class Ex1 {

	public static int[] merge(int vetorA[], int vetorB[]) {

		int vetorC[] = new int[vetorA.length + vetorB.length], a = 0, b = 0, c = 0;

		while (a < vetorA.length || b < vetorB.length) {
			if (vetorA.length == 1 && vetorB.length == 1) {

				if (vetorA[a] > vetorB[b]) {
					vetorC[c] = vetorB[b];
					vetorC[c + 1] = vetorA[a];

				} else {
					vetorC[c] = vetorA[a];
					vetorC[c + 1] = vetorB[b];
				}

				a = vetorA.length;
				b = vetorB.length;

			} else if (a == vetorA.length) {
				for (int i = b; i < vetorB.length; i++) {
					if (c < vetorC.length)
						vetorC[c] = vetorB[i];
					c++;
					b++;
				}
			} else if (b == vetorB.length) {
				for (int i = a; i < vetorA.length; i++) {
					if (c < vetorC.length)
						vetorC[c] = vetorA[i];
					c++;
					a++;
				}
			} else if (vetorA[a] > vetorB[b]) {
				vetorC[c] = vetorB[b];
				if (b < vetorB.length)
					b++;

			} else {
				vetorC[c] = vetorA[a];
				if (a < vetorA.length)
					a++;
			}
			c++;
		}
		return vetorC;
	}

	public static int[] mergeSort(int[] vetor) {

		if (vetor.length > 1) {
			int limite = vetor.length / 2, vetorEsq[] = new int[vetor.length / 2],
					vetorDir[] = new int[vetor.length - vetorEsq.length];

			for (int i = 0; i < limite; i++) {
				vetorEsq[i] = vetor[i];
			}
			for (int i = limite; i < vetor.length; i++) {
				vetorDir[i - limite] = vetor[i];
			}

			vetorEsq = mergeSort(vetorEsq);
			vetorDir = mergeSort(vetorDir);
			return merge(vetorEsq, vetorDir);

		} else
			return vetor;
	}

	public static void run() {
		int vetor[] = { 0, 9, -1, -5, 4, 3, 8, -2, -7, 1 };

		System.out.println("Vetor Original:");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}

		vetor = mergeSort(vetor);

		System.out.println("\nVetor Ordenado:");
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}

	}
}
