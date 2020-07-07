package Sorteio;

public class CDicionario {
	private CCelulaDicionario primeira, ultima;
	private int qtde;

	public CDicionario() {
		primeira = new CCelulaDicionario();
		ultima = primeira;
	}

	public boolean vazio() {
		return primeira == ultima;
	}

	public void adicionar(long chave, Object valor) {

		boolean achou = false;

		if (primeira != ultima) {
			CCelulaDicionario aux = primeira.prox;
			while (aux.prox != null && !achou) {
				achou = aux.key == chave;
				aux = aux.prox;
			}
		}

		if (primeira == ultima || !achou) {
			ultima.prox = new CCelulaDicionario(chave, valor, null);
			ultima = ultima.prox;
			qtde++;
		}
	}

	public Object retornaValor(long chave) {

		if (primeira != ultima) {
			CCelulaDicionario aux = primeira.prox;
			boolean achou = false;
			while (aux != null && !achou) {
				achou = aux.key == chave;
				if (!achou)
					aux = aux.prox;
			}

			if (achou) {
				return aux.value;
			}
		}
		return null;
	}

	public int quantidade() {
		return qtde;
	}

	public void Limpar() {
		ultima = primeira;
		primeira.prox = null;
		qtde = 0;
	}

	public boolean remove(long key) {
		if (primeira != ultima) {
			CCelulaDicionario aux = primeira;
			boolean achou = false;
			while (aux.prox != null && !achou) {
				achou = aux.prox.key == key;
				if (!achou)
					aux = aux.prox;
			}
			if (achou) {
				aux.prox = aux.prox.prox;
				if (aux.prox == null)
					ultima = aux;
				qtde--;
				return true;
			}
		}
		return false;
	}

	public Object retornaIndice(int posicao) {
		if (primeira != ultima && posicao <= qtde) {
			CCelulaDicionario aux = new CCelulaDicionario();
			aux = primeira;
			for (int i = 1; i <= posicao; i++)
				aux = aux.prox;

			return aux.value;
		}
		return null;
	}

	public void insereFim(long key, Object valorItem) {
		ultima.prox = new CCelulaDicionario(key, valorItem);
		ultima = ultima.prox;
		qtde++;
	}

	public void insereComeco(long key, Object valorItem) {
		primeira.prox = new CCelulaDicionario(key, valorItem, primeira.prox);
		if (primeira.prox.prox == null)
			ultima = primeira.prox;
		qtde++;
	}

	public Object removeRetornaFim() {
		if (primeira != ultima) {
			CCelulaDicionario aux = primeira;
			while (aux.prox != ultima)
				aux = aux.prox;
			CCelulaDicionario aux2 = aux.prox;
			ultima = aux;
			ultima.prox = null;
			qtde--;
			return aux2.value;
		}
		return null;
	}

	public Object removeRetornaComeco() {
		if (primeira != ultima) {
			primeira = primeira.prox;
			qtde--;
			return primeira.value;
		}
		return null;
	}
}
