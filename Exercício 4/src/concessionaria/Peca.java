package concessionaria;

public class Peca extends Oferta {
	private int garantia;
	private String nome;

	public Peca(float preco, int garantia, String nome) {
		super(preco);
		this.garantia = garantia;
		this.nome = nome;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
