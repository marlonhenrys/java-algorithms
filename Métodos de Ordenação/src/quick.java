import java.util.Random;

public class quick {
	public static int[] criaVetor(int opcao) {

		int limite = 10;

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

		int vetor[] = criaVetor(3);

		for (int i = 0; i < vetor.length; i++)
			System.out.println(vetor[i]);

		System.out.println("\n\n\n");

		order.quickSort(vetor);

		for (int i = 0; i < vetor.length; i++)
			System.out.println(vetor[i]);

	}

}
