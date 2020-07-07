
public class verificaVetor {

	public static boolean verifica(int[] vetor, int n, int valor) {

		if (n - 1 >= 0) {

			if (vetor[n - 1] == valor)
				return true;
			else
				return verifica(vetor, n - 1, valor);
		}

		return false;
	}

	public static boolean verificaString(String s, char c) {
		return verificaString(s, c, 0);
	}

	private static boolean verificaString(String s, char c, int pos) {

		if (pos < s.length()) {

			if (s.charAt(pos) == c)
				return true;
			else
				return verificaString(s, c, pos + 1);
		}
		return false;
	}

	public static boolean palindromo(String s) {
		return palindromo(s, 0, s.length() - 1);
	}

	public static boolean palindromo(String s, int posInicial, int posFinal) {

		if (posInicial != posFinal && posFinal > posInicial) {

			if (s.charAt(posInicial) == s.charAt(posFinal))
				return palindromo(s, posInicial + 1, posFinal - 1);
			else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		String s = "aaab";

		if (palindromo(s))
			System.out.println("é");
		else
			System.out.println("Não é");
	}
}