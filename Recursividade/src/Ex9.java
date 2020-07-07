
public class Ex9 {

	public static int achaVetor(int[] vet, int num) {
		return achaVetor(vet, 0, num);
	}

	private static int achaVetor(int[] vet, int pos, int num) {
		if (pos < vet.length) {
			if (vet[pos] == num)
				return pos;
			return achaVetor(vet, pos + 1, num);
		}
		return -1;
	}

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 2, 2, 3 };
		System.out.println(achaVetor(vetor, 11));
	}
}