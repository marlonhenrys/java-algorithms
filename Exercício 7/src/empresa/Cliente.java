package empresa;

public class Cliente implements Ordenavel, Comparable<Cliente> {
	private Pessoa entidade;
	private float limiteDeCredito;

	public Cliente(Pessoa entidade, float limiteDeCredito) throws ExcecaoValorNegativo {
		this.entidade = entidade;
		setLimiteDeCredito(limiteDeCredito);
	}

	public float getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(float limiteDeCredito) throws ExcecaoValorNegativo {
		if (limiteDeCredito >= 0)
			this.limiteDeCredito = limiteDeCredito;
		else
			throw new ExcecaoValorNegativo("O LIMITE DE CRÉDITO não pode ser um valor negativo.");
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
		return this.entidade.getNome() + " - " + this.entidade.getDocumento();
	}

	@Override
	public int compareTo(Cliente cliente) {
		return this.getEntidade().getNome().compareTo(cliente.getEntidade().getNome());
	}

	@Override
	public boolean equals(Object o) {
		return this.getEntidade().getDocumento().equals(((Cliente) o).getEntidade().getDocumento());
	}

}
