package entidades;

public class ClienteJuridico extends PessoaFisica {
	private float limiteDeCredito;

	public ClienteJuridico(String nome, String endereco, String telefone, String cep, String cidade, String uf,
			String cnpj, float limiteDeCredito) {
		super(nome, endereco, telefone, cep, cidade, uf, cnpj);
		this.limiteDeCredito = limiteDeCredito;
	}

	public float getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(float limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
}
