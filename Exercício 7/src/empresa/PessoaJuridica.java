package empresa;

public class PessoaJuridica extends Pessoa {

	private String cnpj;

	public PessoaJuridica(String nome, String endereco, String telefone, String cep, String cidade, String uf,
			String cnpj) {
		super(nome, endereco, telefone, cep, cidade, uf);
		this.cnpj = cnpj;
	}

	public PessoaJuridica(String nome, String cnpj) {
		super(nome);
		this.cnpj = cnpj;
	}

	public String getDocumento() {
		return cnpj;
	}

	public void setDocumento(String cnpj) {
		this.cnpj = cnpj;
	}
}
