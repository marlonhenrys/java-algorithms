
public class L4Ex3 {

	public static int fibonacciRec(int pos) {
		int termo;
		if (pos < 2)
			return pos;

		termo = fibonacciRec(pos - 1) + fibonacciRec(pos - 2);

		//System.out.println(termo); // Com ou sem impressão.

		return termo;

	}

	public static void fibonacciIte(long pos) {

		long ant = 0, num = 0;

		for (int i = 1; i <= pos; i++) {

			if (i == 1) {
				num = 1;
				ant = 0;
			} else {
				num = num + ant;
				ant = num - ant;
			}
			System.out.println(num); // Com ou sem impressão.
		}
	}

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();

//		System.out.println("Iterativa: ");
//		stopWatch.start();
//		fibonacciIte(92);
//		stopWatch.stop();
//		System.out.println("Tempo em nanosegundos:" + stopWatch.getTime() + "\n");

		System.out.println("Recursiva: ");
		stopWatch.start();
		System.out.println(fibonacciRec(46));
		stopWatch.stop();
		System.out.println("Tempo em nanosegundos:" + stopWatch.getTime());

	}
}
