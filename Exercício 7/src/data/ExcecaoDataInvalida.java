package data;

public class ExcecaoDataInvalida extends Exception {
	private static final long serialVersionUID = -2458225420979583187L;

	public ExcecaoDataInvalida(String msg) {
		super("DATA INVÁLIDA: " + msg);
	}
}
