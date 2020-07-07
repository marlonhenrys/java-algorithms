
public class Ex3 {

	public static void main(String[] args) {

		int n = 5, temp = 0, cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0;
		cont1++;
		for (int i = 1; i <= 2; i++, cont1++) {
			cont2++;
			for (int j = i; j <= n; j++, cont2++) {
				cont3++;
				for (int k = i; k <= j; k++, cont3++) {
					cont4++;
					temp = temp + i + j + k;
				}
			}
		}

		System.out.println("for 1: " + cont1);
		System.out.println("for 2: " + cont2);
		System.out.println("for 3: " + cont3);
		System.out.println("temp: " + cont4);

	}
}
