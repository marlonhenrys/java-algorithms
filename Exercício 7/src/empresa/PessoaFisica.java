package empresa;

public class PessoaFisica extends Pessoa {

	private String cpf;

	public PessoaFisica(String nome, String endereco, String telefone, String cep, String cidade, String uf,
			String cpf) {
		super(nome, endereco, telefone, cep, cidade, uf);
		this.cpf = cpf;
	}

	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	@Override
	public String getDocumento() {
		return cpf;
	}

	public void setDocumento(String cpf) {
		this.cpf = cpf;
	}
}