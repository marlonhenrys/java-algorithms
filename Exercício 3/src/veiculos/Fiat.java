package veiculos;

public class Fiat extends Carro {

	private int descontoDeFabrica;

	public Fiat(int velocidade, double preco, String cor, int descontoDeFabrica) {
		super(velocidade, preco, cor);
		this.descontoDeFabrica = descontoDeFabrica;
	}

	public double getPrecoVenda() {
		return (super.getPrecoVenda() - this.descontoDeFabrica);
	}

	public int getDescontoDeFabrica() {
		return this.descontoDeFabrica;
	}
}
