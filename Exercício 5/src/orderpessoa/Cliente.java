package orderpessoa;

import ordenação.Ordenavel;

public class Cliente implements Ordenavel {
	private Pessoa entidade;
	private float limiteDeCredito;

	public Cliente(Pessoa entidade, float limiteDeCredito) {
		this.entidade = entidade;
		this.limiteDeCredito = limiteDeCredito;
	}

	public float getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(float limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}

	public Pessoa getEntidade() {
		return entidade;
	}

	public void setEntidade(Pessoa entidade) {
		this.entidade = entidade;
	}

	@Override
	public boolean menorQue(Ordenavel o) {
		Cliente aux = (Cliente) o;
		return this.entidade.menorQue(aux.entidade);
	}

	@Override
	public String toString() {
		return this.entidade.getNome() + " - " + this.entidade.getCpf();
	}

}
