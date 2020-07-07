import java.util.Random;

public class Ex7 {

	public static void main(String[] args) {

		double[] desviosInsertion = new double[10];
		double[] desviosSelection = new double[10];

		System.out.println("\n---------------- INSERTION ------------------------\n");

		for (int j = 10; j <= 100; j += 10) {

			double media = 0;
			long soma = 0;
			double[] tempos = new double[10];

			System.out.println("\n---- " + (j * 2000) + " termos ----\n");

			for (int i = 0; i < 10; i++) {

				int[] vetor = new int[(j * 2000)];
				criaVetor(vetor, vetor.length);
				StopWatch clock = new StopWatch();
				clock.start();
				insertion(vetor);
				clock.stop();
//			imprimeVetor(vetor, vetor.length);
				System.out.println(clock.getTime());
				soma += clock.getTime();
				tempos[i] = clock.getTime();
//			imprimeVetor(vetor, vetor.length);
			}

			media = soma / 10;
			soma = 0;

			for (int i = 0; i < tempos.length; i++)
				tempos[i] = Math.pow((tempos[i] - media), 2);

			for (int i = 0; i < tempos.length; i++)
				soma += tempos[i];

			System.out.println("\nMédia: " + (long) media);
			desviosInsertion[(j / 10) - 1] = Math.sqrt((soma / 10));
			System.out.println("\nDesvio Padrão: " + (long) Math.sqrt((soma / 10)));
			
//			System.out.println((long) media);
//			desviosInsertion[(j / 10) - 1] = Math.sqrt((soma / 10));
		}

		System.out.println("\nDesvios:\n");
		for (int i = 0; i < 10; i++)
			System.out.println((long) desviosInsertion[i]);

		System.out.println("\n\n---------------- SELECTION ------------------------\n");

		for (int j = 10; j <= 100; j += 10) {

			double media = 0;
			long soma = 0;
			double[] tempos = new double[10];

			System.out.println("\n---- " + (j * 2000) + " termos ----\n");
			for (int i = 0; i < 10; i++) {
				int[] vetor = new int[(j * 2000)];
				criaVetor(vetor, vetor.length);
				StopWatch clock = new StopWatch();
				clock.start();
				selection(vetor);
				clock.stop();
//			imprimeVetor(vetor, vetor.length);
				System.out.println(clock.getTime());
				soma += clock.getTime();
				tempos[i] = clock.getTime();
//			imprimeVetor(vetor, vetor.length);
			}

			media = soma / 10;
			soma = 0;

			for (int i = 0; i < tempos.length; i++)
				tempos[i] = Math.pow((tempos[i] - media), 2);

			for (int i = 0; i < tempos.length; i++)
				soma += tempos[i];

			System.out.println("\nMédia: " + (long) media);
			desviosSelection[(j / 10) - 1] = Math.sqrt((soma / 10));
			System.out.println("\nDesvio Padrão: " + (long) Math.sqrt((soma / 10)));
			
//			System.out.println((long) media);
//			desviosSelection[(j / 10) - 1] = Math.sqrt((soma / 10));
		}

		System.out.println("\nDesvios:\n");
		for (int i = 0; i < 10; i++)
			System.out.println((long) desviosSelection[i]);
	}

	public static void criaVetor(int[] vet, int tam) {
		Random gerador = new Random();
		for (int i = 0; i < tam; i++)
			vet[i] = gerador.nextInt(1000);
	}

	public static void imprimeVetor(int[] vet, int tam) {
		for (int i = 0; i < tam; i++)
			System.out.println(vet[i]);
		System.out.println("\n\n");
	}

	public static void insertion(int[] vetor) {
		int j, key, i;

		for (j = 1; j < vetor.length; j++) {
			key = vetor[j];
			for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
				vetor[i + 1] = vetor[i];
			}
			vetor[i + 1] = key;
		}
	}

	public static void selection(int[] array) {
		for (int fixo = 0; fixo < array.length - 1; fixo++) {
			int menor = fixo;

			for (int i = menor + 1; i < array.length; i++) {
				if (array[i] < array[menor]) {
					menor = i;
				}
			}
			if (menor != fixo) {
				int t = array[fixo];
				array[fixo] = array[menor];
				array[menor] = t;
			}
		}
	}
}
