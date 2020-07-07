package Exerc�cios;

public class CArvBin {

	private CNo raiz;

	public CArvBin() {
		raiz = null;
	}

	// Chama o m�todo recursivo para inser��o de valores na ABP
	public void adicionar(int valor) {
		raiz = adicionarRecursivo(raiz, valor);
	}

	// M�todo recursivo de inser��o de valores na ABP
	private CNo adicionarRecursivo(CNo no, int valor) {
		if (no == null)
			return new CNo(valor);

		if (valor < no.item)
			no.esq = adicionarRecursivo(no.esq, valor);
		else if (valor > no.item)
			no.dir = adicionarRecursivo(no.dir, valor);
		return no;
	}

	public void imprimir(int Ordem) {
		// Ordem = 1 => EmOrdem
		// Ordem = 2 => PreOrdem
		// Ordem = 1 => PosOrdem
		switch (Ordem) {
		case 1:
			System.out.println("\n\nImpressao em ordem");
			emOrdem(raiz);
			break;
		case 2:
			System.out.println("\n\nImpressao pre ordem");
			preOrdem(raiz);
			break;
		case 3:
			System.out.println("\n\nImpressao pos ordem");
			posOrdem(raiz);
			break;
		default:
			System.out.println("Opcao invalida!!!\n\n");
			break;
		}
	}

	private void emOrdem(CNo no) {
		// percorre em ordem crescente
		if (no != null) {
			emOrdem(no.esq);
			System.out.println("Chave = " + no.item);
			emOrdem(no.dir);
		}
	}

	private void preOrdem(CNo no) {
		// percorre previlegiando a raiz sobre
		// seus descendentes
		if (no != null) {
			System.out.println("Chave = " + no.item);
			preOrdem(no.esq);
			preOrdem(no.dir);
		}
	}

	private void posOrdem(CNo no) {
		// percorre previlegiando os descendentes
		// sobre a raiz
		if (no != null) {
			posOrdem(no.esq);
			posOrdem(no.dir);
			System.out.println("Chave = " + no.item);
		}
	}

	// M�todo recursivo de busca em ABP
	private boolean contem(CNo no, int valor) {
		if (no == null)
			return false;
		if (valor == no.item)
			return true;
		return valor < no.item ? contem(no.esq, valor) : contem(no.dir, valor);
	}

	// Chama o m�todo recursivo "contem"
	public boolean contem(int valor) {
		return contem(raiz, valor);
	}

	// M�todo iterativo de busca em ABP
	public CNo achar(int id) {
		CNo no = raiz;
		while (no != null) {
			if (no.item == id)
				return no;
			else if (no.item > id)
				no = no.esq;
			else
				no = no.dir;
		}
		return null;
	}

	//
	public void delete(int valor) {
		raiz = deleteRecursivo(raiz, valor);
	}

	// M�todo recursivo de exclus�o de n�s
	private CNo deleteRecursivo(CNo no, int valor) {
		if (no == null)
			return null;

		if (valor == no.item) {
			if (no.esq == null && no.dir == null)
				return null;

			if (no.dir == null)
				return no.esq;

			if (no.esq == null)
				return no.dir;

			int menorValor = menorValor(no.dir);
			no.item = menorValor;
			no.dir = deleteRecursivo(no.dir, menorValor);
			return no;
		}

		if (valor < no.item) {
			no.esq = deleteRecursivo(no.esq, valor);
			return no;
		}
		no.dir = deleteRecursivo(no.dir, valor);
		return no;
	}

	// Retorna o menor valor em uma sub�rvore
	private int menorValor(CNo no) {
		return no.esq == null ? no.item : menorValor(no.esq);
	}

	private int maiorValor(CNo no) {
		return no.dir == null ? no.item : maiorValor(no.dir);
	}

	public Object subMenorValor(int chave) {
		CNo no = achar(chave);
		int valor = menorValor(no);
		return valor;
	}

	public Object subMaiorValor(int chave) {
		CNo no = achar(chave);
		int valor = maiorValor(no);
		return valor;
	}

	public int profundidade(int valor) {
		return profundidade(raiz, valor, 1);
	}

	private int profundidade(CNo no, int valor, int cont) {
		if (no == null)
			return 0;
		if (valor == no.item)
			return cont;
		cont++;
		return valor < no.item ? profundidade(no.esq, valor, cont) : profundidade(no.dir, valor, cont);
	}

	public int altura(int valor) {
		CNo no = achar(valor);
		return altura(no);
	}

	private int altura(CNo no) {

		int esq = 0, dir = 0;

		if (no != null) {
			dir = dir + altura(no.dir);
			esq = esq + altura(no.esq);
		} else
			return 0;

		if (dir > esq)
			return dir + 1;
		else
			return esq + 1;
	}

	public void info() {
		info(raiz, raiz);
	}

	private void info(CNo no, CNo pai) {

		if (no != null) {

			int filhos = 0;

			System.out.println("\nValor: " + no.item);
			System.out.println("Altura: " + altura(no));
			System.out.println("Profundidade: " + profundidade(no.item));
			if (no != pai)
				System.out.println("Pai: " + pai.item);
			else
				System.out.println("Pai: N�o tem.");

			if (no.esq != null)
				filhos++;
			if (no.dir != null)
				filhos++;

			System.out.println("Quantidade de filhos: " + filhos);

			if (no.dir != null)
				System.out.println("Filho a direita: " + no.dir.item);
			else
				System.out.println("Filho a direita: N�o tem.");
			if (no.esq != null)
				System.out.println("Filho a esquerda: " + no.esq.item);
			else
				System.out.println("Filho a esquerda: N�o tem.");
			if (no.dir == null && no.esq == null)
				System.out.println("N� folha.");
			else if (no == pai)
				System.out.println("N� raiz.");
			else if (no.dir != null || no.esq != null)
				System.out.println("N� intermed�rio.");

			info(no.dir, no);
			info(no.esq, no);
		}

	}

	public void imprimeDecresc() {
		imprimeDecresc(raiz);
	}

	private void imprimeDecresc(CNo no) {
		if (no != null) {
			imprimeDecresc(no.dir);
			System.out.println("Chave = " + no.item);
			imprimeDecresc(no.esq);
		}
	}

	public void folhas() {
		folhas(raiz);
	}

	private void folhas(CNo no) {
		if (no != null) {
			folhas(no.esq);
			if (no.dir == null && no.esq == null)
				System.out.println("Folha: " + no.item);
			folhas(no.dir);
		}
	}

	// public int descendentes(int valor) {
	// CNo no = achar(valor);
	// return descendentes(no);
	// }
	//
	// private int descendentes(CNo no) {
	// int cont = 0;
	// if (no != null) {
	// descendentes(no.esq);
	// return cont+1;
	// descendentes(no.dir);
	// return cont+1;
	// }
	// return cont;
	// }

	public void maior(int valor) {
		maior(raiz, valor);
	}

	private void maior(CNo no, int valor) {
		if (no != null) {
			maior(no.esq, valor);
			if (no.item > valor)
				System.out.println("Chave = " + no.item);
			maior(no.dir, valor);
		}
	}

	public void menor(int valor) {
		menor(raiz, valor);
	}

	private void menor(CNo no, int valor) {
		if (no != null) {
			menor(no.esq, valor);
			if (no.item < valor)
				System.out.println("Chave = " + no.item);
			menor(no.dir, valor);
		}
	}

	public CNo localizaPai(int chave) {
		CNo atual = raiz;
		CNo pai = null;
		while (atual.item != chave) {
			if (chave < atual.item) {
				pai = atual;
				atual = atual.esq;
			} else {
				pai = atual;
				atual = atual.dir;
			}
			if (atual == null)
				return null;
		}
		return pai;
	}

	public int fatorBalanceamento(CNo atual) {

		int fatorbalanceamento = 0;

		if ((atual.esq != null) && (atual.dir != null)) {
			fatorbalanceamento = altura(atual.esq) - altura(atual.dir);

		} else if ((atual.esq == null) && (atual.dir != null)) {
			fatorbalanceamento = -1 - altura(atual.dir);

		} else if ((atual.esq != null) && (atual.dir == null)) {
			fatorbalanceamento = altura(atual.esq) + 1;
		}

		return fatorbalanceamento;
	}

	protected void balanceia(CNo atual) {
		CNo aux;
		CNo aux2;
		if ((atual != null) && (atual.dir != null) && (atual.dir.dir != null) && (fatorBalanceamento(atual) == -2)
				&& (fatorBalanceamento(atual.dir) == -1) && (fatorBalanceamento(atual.dir.dir) == -1)) {
			if (localizaPai(atual.item).dir == atual) {
				localizaPai(atual.item).dir = atual.dir;
			} else {
				localizaPai(atual.item).esq = atual.dir;
			}
			;
			aux = atual;
			atual = atual.dir;
			aux.dir = atual.esq;
			atual.esq = aux;
		} else if ((atual != null) && (atual.esq != null) && (atual.esq.esq != null) && (fatorBalanceamento(atual) == 2)
				&& (fatorBalanceamento(atual.esq) == 1) && (fatorBalanceamento(atual.esq.esq) == 1)) {
			if (localizaPai(atual.item).dir == atual) {
				localizaPai(atual.item).dir = atual.esq;
			} else {
				localizaPai(atual.item).esq = atual.esq;
			}
			;
			aux = atual;
			atual = atual.esq;
			aux.esq = atual.dir;
			atual.dir = aux;
		} else if ((atual != null) && (atual.esq != null) && (atual.esq.dir != null) && (fatorBalanceamento(atual) == 2)
				&& (fatorBalanceamento(atual.esq) == -1) && (fatorBalanceamento(atual.esq.dir) == 1)) {
			if (localizaPai(atual.item).dir == atual) {
				localizaPai(atual.item).dir = atual.esq.dir;
			} else {
				localizaPai(atual.item).esq = atual.esq.dir;
			}
			;
			aux = atual;
			aux2 = atual.esq;
			atual = atual.esq.dir;
			aux2.dir = atual.esq;
			aux.esq = atual.dir;
			atual.dir = aux;
			atual.esq = aux2;
		} else if ((atual != null) && (atual.dir != null) && (atual.dir.esq != null)
				&& (fatorBalanceamento(atual) == -2) && (fatorBalanceamento(atual.dir) == 1)
				&& (fatorBalanceamento(atual.dir.esq) == -1)) {
			if (localizaPai(atual.item).dir == atual) {
				localizaPai(atual.item).dir = atual.dir.esq;
			} else {
				localizaPai(atual.item).esq = atual.dir.esq;
			}
			;
			aux = atual;
			aux2 = atual.dir;
			atual = atual.dir.esq;
			aux.dir.esq = atual.dir;
			aux.dir = atual.esq;
			atual.dir = aux;
			atual.esq = aux2;
		}
	}

	public void inserirAVL(int valor) {
		CNo no = new CNo(valor);
		inserirAVL(raiz, no);
	}

	private void inserirAVL(CNo aComparar, CNo aInserir) {

		if (aComparar == null) {
			raiz = aInserir;

		} else {

			if (aInserir.item < aComparar.item) {

				if (aComparar.esq == null) {
					aComparar.esq = aInserir;
					localizaPai(aComparar.item);
					fatorBalanceamento(aComparar);

				} else {
					inserirAVL(aComparar.esq, aInserir);
				}

			} else if (aInserir.item > aComparar.item) {

				if (aComparar.dir == null) {
					aComparar.dir = aInserir;
					localizaPai(aComparar.item);
					fatorBalanceamento(aComparar);

				} else {
					inserirAVL(aComparar.dir, aInserir);
				}

			} else {
				System.out.println("Este n� j� existe!");
			}
		}
	}

	// public CNo duplaRotacaoEsquerdaDireita(CNo inicial) {
	// inicial.esq = rotacaoEsquerda(inicial.esq);
	// return rotacaoDireita(inicial);
	// }
	//
	// public CNo duplaRotacaoDireitaEsquerda(CNo inicial) {
	// inicial.dir = rotacaoDireita(inicial.dir);
	// return rotacaoEsquerda(inicial);
	// }

}
