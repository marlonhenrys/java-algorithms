package pilha;

import data.Data;
import data.ExcecaoDataInvalida;

public class Aplicacao {

	public static void main(String[] args) {
		Pilha<Data> datas = new Pilha<Data>();
		try {
			datas.empilha(new Data(2, 3, 2000));
			datas.empilha(new Data(7, 4, 2020));
			datas.empilha(new Data(9, 6, 2010));
			datas.empilha(new Data(15, 8, 2011));
		} catch (ExcecaoDataInvalida e) {
			e.printStackTrace();
		}
		datas.imprime();

		System.out.println("\n\n");

		Pilha<Integer> inteiros = new Pilha<Integer>();
		try {
			inteiros.empilha(150);
			inteiros.empilha(100);
			inteiros.empilha(45);
			inteiros.empilha(536);
		} catch (Exception e) {
			e.printStackTrace();
		}
		inteiros.imprime();
	}

}
