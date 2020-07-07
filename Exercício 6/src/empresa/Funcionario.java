package empresa;

public class Funcionario extends PessoaFisica {

	private String cargo;
	private float salario;

	public Funcionario(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cpf,
			String cargo, float salario) throws ExcecaoValorNegativo {
		super(nome, endereco, telefone, cep, cidade, uf, cpf);
		this.cargo = cargo;
		setSalario(salario);
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) throws ExcecaoValorNegativo {
		if (salario >= 0)
			this.salario = salario;
		else
			throw new ExcecaoValorNegativo("O SALÁRIO não pode ser um valor negativo.");
	}

}
