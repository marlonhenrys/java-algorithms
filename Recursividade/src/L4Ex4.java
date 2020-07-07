
public class L4Ex4 {

	public static void multIterat(long A, long B) {
		long soma = 0;
		while (B > 0) {
			soma = soma + A;
			System.out.println(soma); // Com ou sem impressão.
			B--;
		}

	}

	public static long multRecurs(long A, long B) {
		long soma;
		if (B == 0)
			return 0;
		soma = A + multRecurs(A, B - 1);
		System.out.println(soma); // Com ou sem impressão.
		return soma;
	}

	public static void main(String[] args) {

		StopWatch stopWatch = new StopWatch();

		System.out.println("Iterativa: ");
		stopWatch.start();
		multIterat(3, 715827881);
		stopWatch.stop();
		System.out.println("Tempo em nanosegundos:" + stopWatch.getTime() + "\n");

		System.out.println("Recursiva: ");
		stopWatch.start();
		multRecurs(3, 715827881);
		stopWatch.stop();
		System.out.println("Tempo em nanosegundos:" + stopWatch.getTime());

	}

}
