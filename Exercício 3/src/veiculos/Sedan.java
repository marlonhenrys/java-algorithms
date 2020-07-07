package veiculos;

public class Sedan extends Carro {

	int comprimento;

	public Sedan(int velocidade, double preco, String cor, int comprimento) {
		super(velocidade, preco, cor);
		this.comprimento = comprimento;
	}

	public double getPrecoVenda() {
		return this.comprimento > 6 ? (super.getPrecoVenda() * 0.95) : (super.getPrecoVenda() * 0.9);
	}
	
	public int getComprimento() {
		return this.comprimento;
	}
}
