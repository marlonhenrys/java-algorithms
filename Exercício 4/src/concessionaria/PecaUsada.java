package concessionaria;

public class PecaUsada extends Peca {

	public PecaUsada(float preco, int garantia, String nome) {
		super(preco, garantia, nome);
	}

	@Override
	public float getPreco() {
		return super.getPreco() * 0.8F;
	}

	@Override
	public int getGarantia() {
		return super.getGarantia() / 2;
	}
}
