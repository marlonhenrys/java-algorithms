public class Ex2 {

	public static int fatIterativo(int num) {
		int fat = 1;
		if (num == 0)
			fat = 1;
		while (num > 0) {
			fat = fat * num;
			num--;
		}
		return fat;
	}

	public static int fatRecursivo(int num) {
		if (num == 0)
			return 1;
		else
			return num * fatRecursivo(num - 1);
	}

	public static void main(String[] args) {
		System.out.println("Recursiva = " + fatRecursivo(16));
		System.out.println("Iterativa = " + fatIterativo(16));
	}
}
