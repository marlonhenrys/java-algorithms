package orderpessoa;

import ordenação.Ordenavel;

/* - A classe Pessoa deve ser abstrata, pois ela é necessária apenas para armazenar os dados pessoais.
   - É necessário sempre instanciar uma Pessoa Física ou Pessoa Jurídica, mas nunca uma "Pessoa".
   - É necessário que hajam métodos abstratos para acessar os atributos específicos de Pessoa Física e Pessoa Jurídica.
   - Uma pessoa deve sempre possuir um número de identificação (CPF ou CNPJ), portanto, deve ser uma pessoa Física ou Jurídica. */

public abstract class Pessoa implements Ordenavel {
	private String nome, endereco, telefone, cep, cidade, uf;

	public Pessoa(String nome, String endereco, String telefone, String cep, String cidade, String uf) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Pessoa(String nome) {
		this.nome = nome;
		this.endereco = "nada";
		this.telefone = "nada";
		this.cep = "nada";
		this.cidade = "nada";
		this.uf = "nada";
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract String getCpf();

	public abstract String getCnpj();

	@Override
	public boolean menorQue(Ordenavel o) {
		Pessoa aux = (Pessoa) o;
		return this.nome.compareToIgnoreCase(aux.nome) <= -1;
	}

}
