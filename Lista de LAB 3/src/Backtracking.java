import java.util.ArrayList;

public class Backtracking {

	public static ArrayList<Integer> novo = new ArrayList<Integer>();

	public static void main(String args[]) {
		int[] vet = { 15, 2, 4, 9, 1, 1 };
		int soma = 10;
		for (int i = 0; i < vet.length; i++) {
			if (procuraSoma(vet, i, 0, soma)) {
				while (novo.size() != 0)
					System.out.println(novo.remove(0));
			}
		}
	}

	public static boolean procuraSoma(int[] vet, int i, int soma, int valor) {
		soma = soma + vet[i];
		if (soma == valor) {
			novo.add(vet[i]);
			return true;
		} else if (soma > valor) {
			if (i + 1 < vet.length)
				return procuraSoma(vet, i + 1, soma - vet[i], valor);
			else {

				novo.clear();
				return false;

			}
		} else {
			if (i + 1 < vet.length) {
				novo.add(vet[i]);
				return procuraSoma(vet, i + 1, soma, valor);
			} else {
				novo.clear();
				return false;
			}
		}

	}
}
