package veiculos;

public class Caminhao extends Carro {

	private int carga;

	public Caminhao(int velocidade, double preco, String cor, int carga) {
		super(velocidade, preco, cor);
		this.carga = carga;
	}

	public double getPrecoVenda() {
		return this.carga > 2000 ? (super.getPrecoVenda() * 0.9) : (super.getPrecoVenda() * 0.8);
	}

	public int getCarga() {
		return this.carga;
	}
}
