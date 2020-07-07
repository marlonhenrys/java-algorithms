
public class Ex5 {

	public static void ImpVetRec(int[] vet) {
		ImpVetRec(vet, vet.length - 1);
	}

	private static void ImpVetRec(int[] vet, int pos) {
		if (pos >= 0) {
			System.out.print(vet[pos] + "|");
			ImpVetRec(vet, pos - 1);
		}
	}

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		ImpVetRec(vetor);
	}

}