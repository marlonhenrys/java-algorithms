
public class Ex11 {

	public static boolean palindromo(int[] vet) {
		int cont = vet.length / 2;
		int pos = 0;
		boolean teste = false;
		return palindromo(vet, 0, vet.length - 1, cont, pos, teste);
	}

	private static boolean palindromo(int[] vet, int posIn, int posOut, int cont, int pos, boolean teste) {
		if (pos < cont) {
			if (vet[posIn] == vet[posOut]) {
				teste = true;
				return palindromo(vet, posIn + 1, posOut - 1, cont, pos + 1, teste);
			} else
				teste = false;
		}
		return teste;
	}

	public static void main(String[] args) {
		int vetor[] = { 1, 2, 5, 6, 2, 1 };
		if (palindromo(vetor))
			System.out.println("Palíndromo!");
		else
			System.out.println("Não palíndromo!");
	}

}