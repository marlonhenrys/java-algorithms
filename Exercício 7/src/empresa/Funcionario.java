package empresa;

public class Funcionario extends PessoaFisica implements Comparable<Funcionario> {

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
			throw new ExcecaoValorNegativo("O SAL�RIO n�o pode ser um valor negativo.");
	}

	@Override
	public String toString() {
		return this.getNome() + " - " + this.getDocumento() + " - " + this.getSalario();
	}

	@Override
	public int compareTo(Funcionario funcionario) {
		return this.getNome().compareTo(funcionario.getNome());
	}

	@Override
	public boolean equals(Object o) {
		return this.getDocumento().equals(((Funcionario) o).getDocumento());
	}
}
