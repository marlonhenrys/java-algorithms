package empresa;

public class ExcecaoValorNegativo extends Exception {
	private static final long serialVersionUID = 8748452270393773432L;

	public ExcecaoValorNegativo(String msg) {
		super(msg);
	}
}
