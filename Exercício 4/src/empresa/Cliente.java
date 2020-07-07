package empresa;

public class Cliente {
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

}
