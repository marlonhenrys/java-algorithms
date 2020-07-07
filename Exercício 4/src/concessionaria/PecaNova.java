package concessionaria;

public class PecaNova extends Peca {

	public PecaNova(float preco, int garantia, String nome) {
		super(preco, garantia, nome);
	}

	@Override
	public float getPreco() {
		return super.getPreco() * 1.2F;
	}

	@Override
	public int getGarantia() {
		return super.getGarantia() + 3;
	}
}
