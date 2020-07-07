
public class Ex8 {

	public static int contaVetor(int[] vet, int num) {
		return contaVetor(vet, 0, 0, num);
	}

	private static int contaVetor(int[] vet, int pos, int cont, int num) {
		if (pos < vet.length) {
			if (vet[pos] == num)
				cont++;
			return contaVetor(vet, pos + 1, cont, num);
		}
		return cont;
	}

	public static int contaVetorC(int[] vet, int num) {
		int cont = 0;
		for (int i = 0; i < vet.length; i++) {
			if (vet[i] == num)
				cont++;
		}
		return cont;

	}

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 2, 2, 3 };
		System.out.println(contaVetor(vetor, 2));
		System.out.println(contaVetorC(vetor, 3));
	}

}