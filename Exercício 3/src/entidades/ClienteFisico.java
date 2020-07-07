package entidades;

public class ClienteFisico extends PessoaFisica {
	private float limiteDeCredito;

	public ClienteFisico(String nome, String endereco, String telefone, String cep, String cidade, String uf,
			String cpf, float limiteDeCredito) {
		super(nome, endereco, telefone, cep, cidade, uf, cpf);
		this.limiteDeCredito = limiteDeCredito;
	}

	public float getLimiteDeCredito() {
		return limiteDeCredito;
	}

	public void setLimiteDeCredito(float limiteDeCredito) {
		this.limiteDeCredito = limiteDeCredito;
	}
}
