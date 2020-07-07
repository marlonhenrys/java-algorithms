
public class Ex7 {

	public static int contaVetor(int[] vet) {
		return contaVetor(vet, 0, 0);
	}

	private static int contaVetor(int[] vet, int pos, int cont) {
		if (pos < vet.length) {
			if (vet[pos] < 0)
				cont++;
			return contaVetor(vet, pos + 1, cont);
		}
		return cont;
	}

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -1, -2 };
		System.out.println(contaVetor(vetor));
	}

}