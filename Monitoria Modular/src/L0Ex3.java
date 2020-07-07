public class L0Ex3 {

	public static void main(String[] args) {
		int sinal = 1, x = 8, num = 1, cont = 0;

		double sinMath = Math.sin(x);
		double sinFunc = 0;
		double formatM = sinMath * 10000;
		double formatF = 0;

		while ((int) formatM != (int) formatF) {

			sinFunc += (Math.pow(x, num) / fatorial(num)) * sinal;
			sinal *= -1;
			num += 2;
			cont++;
			formatF = sinFunc * 10000;

			System.out.println("sinMath = " + formatM + " | sinFun = " + formatF);
		}

		System.out.println("\n[Resultado] sen(" + x + "): sinMath = " + sinMath + " | sinFun = " + sinFunc
				+ " | Iterações = " + cont);
	}

	public static double fatorial(int num) {
		double fatorial = 1;

		for (int i = 1; i <= num; i++)
			fatorial *= i;

		return fatorial;
	}
}
