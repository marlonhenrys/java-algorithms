import java.util.Random;

public class Testes {

	public static int[] criaVetor(int opcao) {

		int limite = 100000;

		int i, max = limite, vetor[] = new int[limite];
		Random num = new Random();

		switch (opcao) {

		case 1:
			for (i = 0; i < limite; i++)
				vetor[i] = i + 1;
			break;

		case 2:
			for (i = 0; i < limite; i++) {
				vetor[i] = max;
				max--;
			}
			break;

		case 3:
			for (i = 0; i < limite; i++)
				vetor[i] = num.nextInt(limite);
			break;
		}

		return vetor;
	}

	public static void main(String[] args) {

		int vetorA[], vetorB[], vetorC[];

		vetorA = criaVetor(1);
		vetorB = criaVetor(2);
		vetorC = criaVetor(3);

		StopWatch relogio = new StopWatch();

		System.out.println("RELAT�RIO:");

		// BubbleSort Cl�ssico

		relogio.start();
		order.BBSortClassico(vetorA);
		relogio.stop();

		System.out.println("\n[BubbleSort | Cl�ssico - Vetor A] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.BBSortClassico(vetorB);
		relogio.stop();

		System.out.println("\n[BubbleSort | Cl�ssico- Vetor B] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.BBSortClassico(vetorC);
		relogio.stop();

		System.out.println("\n[BubbleSort | Cl�ssico - Vetor C] Tempo em microssegundos: " + relogio.getTime() / 1000);

		// BubbleSort Adaptado 1

		vetorA = criaVetor(1);
		vetorB = criaVetor(2);
		vetorC = criaVetor(3);

		relogio.start();
		order.BBSortAdap1(vetorA);
		relogio.stop();

		System.out.println(
				"\n\n[BubbleSort | Adaptado 1 - Vetor A] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.BBSortAdap1(vetorB);
		relogio.stop();

		System.out
				.println("\n[BubbleSort | Adaptado 1 - Vetor B] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.BBSortAdap1(vetorC);
		relogio.stop();

		System.out
				.println("\n[BubbleSort | Adaptado 1 - Vetor C] Tempo em microssegundos: " + relogio.getTime() / 1000);

		// BubbleSort Adaptado 2

		vetorA = criaVetor(1);
		vetorB = criaVetor(2);
		vetorC = criaVetor(3);

		relogio.start();
		order.BBSortAdap2(vetorA);
		relogio.stop();

		System.out.println(
				"\n\n[BubbleSort | Adaptado 2 - Vetor A] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.BBSortAdap2(vetorB);
		relogio.stop();

		System.out
				.println("\n[BubbleSort | Adaptado 2 - Vetor B] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.BBSortAdap2(vetorC);
		relogio.stop();

		System.out
				.println("\n[BubbleSort | Adaptado 2 - Vetor C] Tempo em microssegundos: " + relogio.getTime() / 1000);

		// Inser��o

		vetorA = criaVetor(1);
		vetorB = criaVetor(2);
		vetorC = criaVetor(3);

		relogio.start();
		order.Insercao(vetorA);
		relogio.stop();

		System.out.println("\n\n[Inser��o - Vetor A] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.Insercao(vetorB);
		relogio.stop();

		System.out.println("\n[Inser��o - Vetor B] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.Insercao(vetorC);
		relogio.stop();

		System.out.println("\n[Inser��o - Vetor C] Tempo em microssegundos: " + relogio.getTime() / 1000);

		// Sele��o

		vetorA = criaVetor(1);
		vetorB = criaVetor(2);
		vetorC = criaVetor(3);

		relogio.start();
		order.Selecao(vetorA);
		relogio.stop();

		System.out.println("\n\n[Sele��o - Vetor A] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.Selecao(vetorB);
		relogio.stop();

		System.out.println("\n[Sele��o - Vetor B] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.Selecao(vetorC);
		relogio.stop();

		System.out.println("\n[Sele��o - Vetor C] Tempo em microssegundos: " + relogio.getTime() / 1000);

		// QuickSort

		vetorA = criaVetor(1);
		vetorB = criaVetor(2);
		vetorC = criaVetor(3);

		relogio.start();
		order.quickSort(vetorA);
		relogio.stop();

		System.out.println("\n\n[QuickSort - Vetor A] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.quickSort(vetorB);
		relogio.stop();

		System.out.println("\n[QuickSort - Vetor B] Tempo em microssegundos: " + relogio.getTime() / 1000);

		relogio.start();
		order.quickSort(vetorC);
		relogio.stop();

		System.out.println("\n[QuickSort - Vetor C] Tempo em microssegundos: " + relogio.getTime() / 1000);

	}

}
