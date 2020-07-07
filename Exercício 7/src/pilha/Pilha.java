package pilha;

public class Pilha<E> {
	private Celula<E> topo = null;
	private int qtde;

	public boolean vazia() {
		return topo == null;
	}

	public void empilha(E valorItem) {
		topo = new Celula<E>(valorItem, topo);
		qtde++;
	}

	public E desempilha() {
		E item = null;
		if (topo != null) {
			item = topo.item;
			topo = topo.prox;
			qtde--;
		}
		return item;
	}

	public boolean contem(E valorItem) {
		boolean achou = false;
		Celula<E> aux = topo;
		while (aux != null && !achou) {
			achou = aux.item.equals(valorItem);
			aux = aux.prox;
		}
		return achou;
	}

	public Object peek() {
		return (topo != null) ? topo.item : null;
	}

	public int quantidade() {
		return qtde;
	}

	public void imprime() {
		Pilha<E> aux = new Pilha<E>();
		int tamanho = this.quantidade();
		for (int i = 0; i < tamanho; i++) {
			System.out.println(this.peek());
			aux.empilha(this.desempilha());
		}
		for (int i = 0; i < tamanho; i++)
			this.empilha(aux.desempilha());
	}
}