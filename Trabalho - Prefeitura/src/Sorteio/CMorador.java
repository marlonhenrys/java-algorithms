package Sorteio;

public class CMorador {

	public long CPF;
	public String Nome;
	public int qtdeDepend;
	public double RendaFamiliar;
	public String Telefone;
	public String Cidade;
	public String Estado;
	public String CEP;
	public String Complemento;
	public String Endereco;
	public int NumeroRua;
	public String Bairro;

	public CMorador() {

	}

	public CMorador(long cPF, String nome, int qtdeDep, double rendaFamiliar, String telefone, String cidade, String estado,
			String cEP, String complemento, String endereco, int numeroRua, String bairro) {
		CPF = cPF;
		Nome = nome;
		qtdeDepend = qtdeDep;
		RendaFamiliar = rendaFamiliar;
		Telefone = telefone;
		Cidade = cidade;
		Estado = estado;
		CEP = cEP;
		Complemento = complemento;
		Endereco = endereco;
		NumeroRua = numeroRua;
		Bairro = bairro;
	}
}
