
public class Ex4 {

	public static void ImpVetRec(int[] vet) {
		ImpVetRec(vet, 0);
	}

	private static void ImpVetRec(int[] vet, int pos) {
		if (pos < vet.length) {
			System.out.print(vet[pos] + "|");
			ImpVetRec(vet, pos + 1);
		}
	}

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ImpVetRec(vetor);
	}

}