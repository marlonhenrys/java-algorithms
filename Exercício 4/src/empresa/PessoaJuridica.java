package empresa;

public class PessoaJuridica extends Pessoa {

	private String cnpj;

	public PessoaJuridica(String nome, String endereco, String telefone, String cep, String cidade, String uf,
			String cnpj) {
		super(nome, endereco, telefone, cep, cidade, uf);
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String getDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDocumento(String documento) {
		// TODO Auto-generated method stub
		
	}

}
