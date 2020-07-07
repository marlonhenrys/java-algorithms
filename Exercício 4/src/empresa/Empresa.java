package empresa;

import java.util.Set;
import java.util.TreeSet;

public class Empresa extends PessoaJuridica {

	private Set<Cliente> clientes;
	private Set<Funcionario> funcionarios;

	public Empresa(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cnpj) {
		super(nome, endereco, telefone, cep, cidade, uf, cnpj);
		clientes = new TreeSet<Cliente>();
		funcionarios = new TreeSet<Funcionario>();
	}

	public void add(Cliente cliente) {
		clientes.add(cliente);
	}

	public void add(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	public void removeCliente(String documento) {
		clientes.removeIf(cliente -> cliente.getEntidade().getDocumento().equals(documento));
	}

	public void removeFuncionario(String documento) {
		funcionarios.removeIf(funcionario -> funcionario.getDocumento().equals(documento));
	}
}
