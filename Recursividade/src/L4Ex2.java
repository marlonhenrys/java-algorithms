
public class L4Ex2 {

	public static void fatorialIte(long num) {
		long fat = 1;
		for (int i = 1; i <= num; i++) {
			fat = fat * i;
			//System.out.println(fat); // Com ou sem impressão.
		}
	}

	public static long fatorialRec(long num) {
		long fat;
		if (num == 0)
			return 1;
		fat = num * fatorialRec(num - 1);
		//System.out.println(fat); // Com ou sem impressão.
		return fat;
	}

	public static void main(String[] args) {
		StopWatch stopWatch = new StopWatch();

		System.out.println("Iterativa: ");
		stopWatch.start();
		fatorialIte(20);
		stopWatch.stop();
		System.out.println("Tempo em nanosegundos:" + stopWatch.getTime() + "\n");

		System.out.println("Recursiva: ");
		stopWatch.start();
		fatorialRec(20);
		stopWatch.stop();
		System.out.println("Tempo em nanosegundos:" + stopWatch.getTime());
	}

}
