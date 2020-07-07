import java.lang.Long;
import java.util.ArrayList;

public class Eratostenes {

	private static final long longLimit = (long) Math.pow(2, 20) - 1;

	public static void verifica(int num) {
		if (checar(num))
			System.out.printf("\n" + num + " é primo!");
		else
			System.out.printf("\n" + num + " é composto!");
	}

	private static boolean checar(int num) {

		ArrayList<Long> longPrimes = new ArrayList<Long>();

		long longNumber = 5;
		int intNext = 0;
		double doubleSquareRoot = 0.0;

		longPrimes.add(new Long(2));
		longPrimes.add(new Long(3));
		
		if (longPrimes.contains(new Long(num)))
			return true;

		do {

			intNext = 0;
			doubleSquareRoot = Math.sqrt(longNumber);

			while ((double) longPrimes.get(++intNext) < doubleSquareRoot && (longNumber % longPrimes.get(intNext)) != 0);

			if ((double) longPrimes.get(intNext) > doubleSquareRoot) {
				longPrimes.add(new Long(longNumber));

				if (longNumber == num)
					return true;
				else if (longNumber > num)
					return false;
			}

			longNumber += ((longNumber % 3 == 2) ? 2 : 4);

		} while (longNumber < longLimit);

		return false;
	}
}
