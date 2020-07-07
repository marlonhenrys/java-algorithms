
import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		System.out.print("Digite a quantidade de termos da sequência: ");
		int tam = ler.nextInt();
		ler.nextLine();
		int[] vetor = new int[tam];
		for (int i = 0; i < tam; i++) {
			System.out.print("Digite o termo " + (i + 1) + " da sequência: ");
			vetor[i] = ler.nextInt();
			ler.nextLine();
		}

		int[] intervalo = new int[2];
		int pos = 0;
		int max_ate_agora = 0;
		int max_ate_aqui = 0;

		for (int i = 0; i < vetor.length; i++) {
			max_ate_aqui = max_ate_aqui + vetor[i];

			if (max_ate_aqui < 0) {
				max_ate_aqui = 0;
				pos = 0;
			}

			if (max_ate_agora < max_ate_aqui) {
				max_ate_agora = max_ate_aqui;
				intervalo[pos] = i;
				pos = pos == 0 ? 1 : pos;
			}
		}

		System.out.print("\nA sequência máxima é:\t");

		for (int i = intervalo[0]; i <= intervalo[1]; i++)
			System.out.print(vetor[i] + "\t");

		System.out.println("\n\nSoma = " + max_ate_agora);

		ler.close();
	}
}