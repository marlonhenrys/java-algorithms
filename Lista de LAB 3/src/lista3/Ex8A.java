package lista3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex8A {

	static ArrayList<Integer> cache = new ArrayList<Integer>();
	static Scanner ler = new Scanner(System.in);
	static int[] memo = new int[0];

	// 0, 1, 1, 2, 3, 5, 8

	public static void run() {
		cache.add(0);
		cache.add(1);
		do {
			System.out.print("\n\n\nInforme o índice do termo: ");
			System.out.println("\nTermo: " + memoria(ler.nextInt()));
			ler.nextLine();
		} while (true);
	}

	public static int memoria(int n) {

		if (cache.size() < (n + 1)) {
			for (int i = cache.size(); i <= n; i++)
				cache.add(memoria(i - 1) + memoria(i - 2));
		}
		return cache.get(n);
	}
}
