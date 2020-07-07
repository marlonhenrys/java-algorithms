package orderpessoa;

import ordena��o.Ordenavel;

/* - A classe Pessoa deve ser abstrata, pois ela � necess�ria apenas para armazenar os dados pessoais.
   - � necess�rio sempre instanciar uma Pessoa F�sica ou Pessoa Jur�dica, mas nunca uma "Pessoa".
   - � necess�rio que hajam m�todos abstratos para acessar os atributos espec�ficos de Pessoa F�sica e Pessoa Jur�dica.
   - Uma pessoa deve sempre possuir um n�mero de identifica��o (CPF ou CNPJ), portanto, deve ser uma pessoa F�sica ou Jur�dica. */

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
