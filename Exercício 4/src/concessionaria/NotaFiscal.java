package concessionaria;

import java.util.ArrayList;

public class NotaFiscal {
	private ArrayList<Item> conteudo;

	public String getItens() {
		String itens = "";

		for (int i = 0; i < conteudo.size(); i++) {
			itens = itens + conteudo.get(i) + "\n";
		}

		return itens;
	}

	public void addItem(Item item) {
		conteudo.add(item);
	}
}
