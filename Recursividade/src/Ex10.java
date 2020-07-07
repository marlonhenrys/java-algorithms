
public class Ex10 {

	public static int mdc(int x, int y) {
		int num = x < y ? x : y;
		return mdc(x, y, num);
	}

	private static int mdc(int x, int y, int num) {

		if (x % num == 0 && y % num == 0)
			return num;
		return mdc(x, y, num - 1);
	}

	public static void main(String[] args) {
		System.out.println(mdc(60, 45));

	}
}
