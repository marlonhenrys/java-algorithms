
public class Ex6 {

	public static int somaVetor(int[] vet) {
		return somaVetor(vet, 0, 0);
	}

	private static int somaVetor(int[] vet, int pos, int soma) {
		if (pos < vet.length) {
			return somaVetor(vet, pos + 1, soma + vet[pos]);
		}
		return soma;
	}

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(somaVetor(vetor));
	}

}