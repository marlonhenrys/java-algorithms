package pilha;

public class Celula<E> {
	public E item;
	public Celula<E> prox;

	public Celula(E valorItem, Celula<E> proxCelula) {
		item = valorItem;
		prox = proxCelula;
	}

	public Celula(E valorItem) {
		item = valorItem;
		prox = null;
	}

	public Celula() {
		item = null;
		prox = null;
	}
}