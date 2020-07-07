package entidades;

import java.util.ArrayList;

public class Empresa extends PessoaJuridica {

	private ArrayList clientes;
	private ArrayList<Funcionario> funcionarios;

	public Empresa(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cnpj) {
		super(nome, endereco, telefone, cep, cidade, uf, cnpj);
		clientes = new ArrayList();
		funcionarios = new ArrayList<Funcionario>();
	}

	public void addClienteFisico(ClienteFisico cliente) {
		clientes.add(cliente);
	}

	public void addClienteJuridico(ClienteJuridico cliente) {
		clientes.add(cliente);
	}

	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	public ArrayList getClientes() {
		return clientes;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}
}
