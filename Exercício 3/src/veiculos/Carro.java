package veiculos;

public class Carro {

	private int velocidade;
	private double preco;
	private String cor;

	public Carro(int velocidade, double preco, String cor) {
		this.velocidade = velocidade;
		this.preco = preco;
		this.cor = cor;
	}

	public double getPrecoVenda() {
		return preco;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public String getCor() {
		return cor;
	}
}
