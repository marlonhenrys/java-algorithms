package estruturas;

public class Pessoa {
	private String nome;
	private String cpf;
	private int idade;
	private String sexo;

	public Pessoa() {
		nome = "Maria";
		cpf = "12345678910";
		idade = 30;
		sexo = "Feminino";
	}

	public Pessoa(String nome, String cpf, int idade, String sexo) {
		setNome(nome);
		setCPF(cpf);
		setIdade(idade);
		setSexo(sexo);
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		if (cpf.length() >= 11)
			this.cpf = cpf;
		else
			this.cpf = "000.000.000-00";
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if (idade > 0 && idade < 150)
			this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		if (sexo == "Feminino" || sexo == "Masculino" || sexo == "Outro")
			this.sexo = sexo;
		else
			this.sexo = "Inválido";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean eMaior() {
		return (getIdade() >= 18);
	}

}
