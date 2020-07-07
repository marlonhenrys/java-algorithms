
public class order {

	public static void BBSortClassico(int[] vetor) {
		int i, j, temp;
		for (i = 0; i < vetor.length - 1; i++)
			for (j = 0; j < vetor.length - 1; j++)
				if (vetor[j] > vetor[j + 1]) {
					temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
	}

	public static void BBSortAdap1(int[] vetor) {
		int i, temp;
		boolean HouveTroca = true;
		while (HouveTroca) {
			HouveTroca = false;
			for (i = 0; i < vetor.length - 1; i++)
				if (vetor[i] > vetor[i + 1]) {
					temp = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = temp;
					HouveTroca = true;
				}
		}
	}

	public static void BBSortAdap2(int[] vetor) {
		int i, j, temp, cont;
		cont = vetor.length - 1;
		for (i = 0; i < vetor.length - 1; i++) {
			for (j = 0; j < cont; j++)
				if (vetor[j] > vetor[j + 1]) {
					temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
			cont--;
		}
	}

	public static void Selecao(int[] vetor) {
		int i, j, min, aux;
		for (i = 0; i < vetor.length - 1; i++) {
			// Procura o menor elemento a partir
			// da i-ésima posição do vetor. min = i
			// pois consideraremos no início que o
			// i-ésimo elemento é o menor do subvetor
			min = i;
			for (j = i + 1; j < vetor.length; j++)
				if (vetor[j] < vetor[min])
					min = j;
			// Troca o menor elemento de posição com
			// o elemento da posição i
			aux = vetor[min];
			vetor[min] = vetor[i];
			vetor[i] = aux;
		}
	}

	public static void Insercao(int[] vetor) {
		int i, j, v;
		for (i = 1; i < vetor.length; i++) {
			v = vetor[i];
			j = i;
			while ((j > 0) && (vetor[j - 1] > v)) {
				vetor[j] = vetor[j - 1];
				j--;
			}
			vetor[j] = v;
		}
	}

	public static void quickSort(int[] vetor) {
		quickSort(vetor, 0, vetor.length - 1);
	}

	public static void quickSort(int v[], int esquerda, int direita) {

		int esq = esquerda;
		int dir = direita;
		int pivo = v[(esq + dir) / 2];
		int troca;
		while (esq <= dir) {
			while (v[esq] < pivo) {
				esq = esq + 1;
			}
			while (v[dir] > pivo) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = v[esq];
				v[esq] = v[dir];
				v[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if (dir > esquerda)
			quickSort(v, esquerda, dir);
		if (esq < direita)
			quickSort(v, esq, direita);

	}
}
