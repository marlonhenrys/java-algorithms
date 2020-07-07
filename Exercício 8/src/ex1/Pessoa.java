package ex1;

public class Pessoa {
	private String nome;
	private String sexo;
	private int idade;
	private String estadoCivil;

	public Pessoa(String nome, String sexo, int idade, String estadoCivil) {
		super();
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.estadoCivil = estadoCivil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String toString() {
		return "Nome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo + "\nEstado Civil: " + estadoCivil;
	}

}
