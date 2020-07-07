package concessionaria;

public class Item {
	private int qtde;
	private Oferta elemento;

	public Item(Oferta elemento, int qtde) {
		this.setElemento(elemento);
		this.qtde = qtde;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Oferta getElemento() {
		return elemento;
	}

	public void setElemento(Oferta elemento) {
		this.elemento = elemento;
	}

}
