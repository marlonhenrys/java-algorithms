package Sorteio;


public class CCelulaDicionario {
	public Object value;
	long key;
	public CCelulaDicionario prox;

	public CCelulaDicionario() {
		key = 0;
		value = null;
		prox = null;
	}

	public CCelulaDicionario(long chave, Object valor) {
		key = chave;
		value = valor;
		prox = null;
	}

	public CCelulaDicionario(long chave, Object valor, CCelulaDicionario proxima) {
		key = chave;
		value = valor;
		prox = proxima;
	}
}
