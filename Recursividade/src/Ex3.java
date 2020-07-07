public class Ex3 {

	public static int fibonacci(int pos) {
		if (pos == 1 || pos == 2)
			return 1;
		else
			return fibonacci(pos - 1) + fibonacci(pos - 2);
	}

	public static void main(String[] args) {
		System.out.println("Termo: " + fibonacci(47));

	}
}
