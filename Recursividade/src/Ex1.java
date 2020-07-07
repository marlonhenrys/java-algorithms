public class Ex1 {

	public static int powRecursiva(int base, int expoente) {
		if (expoente == 0)
			return 1;
		else
			return base * powIterativa(base, expoente - 1);
	}

	public static int powIterativa(int base, int expoente) {
		int result = 1;
		if (expoente == 0)
			result = 1;
		while (expoente > 0) {
			result = result * base;
			expoente--;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("Recursiva = " + powRecursiva(2, 3));
		System.out.println("Iterativa = " + powIterativa(2, 4));
	}
}
