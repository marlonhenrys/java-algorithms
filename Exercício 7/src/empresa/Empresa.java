package empresa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empresa extends PessoaJuridica {

	private List<Cliente> clientes;
	private List<Funcionario> funcionarios;

	public Empresa(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cnpj) {
		super(nome, endereco, telefone, cep, cidade, uf, cnpj);
		clientes = new ArrayList<Cliente>();
		funcionarios = new ArrayList<Funcionario>();
	}

	public void add(Cliente cliente) {
		if (!(clientes.contains(cliente))) {
			for (Cliente c : clientes) {
				if (cliente.compareTo(c) == 1) {
					clientes.add(clientes.indexOf(c), cliente);
					break;
				}
			}
			clientes.add(cliente);
		}
	}

	public void add(Funcionario funcionario) {
		if (!(funcionarios.contains(funcionario))) {
			for (Funcionario f : funcionarios) {
				if (f.compareTo(funcionario) == 1) {
					funcionarios.add(funcionarios.indexOf(f), funcionario);
					break;
				}
			}
			funcionarios.add(funcionario);
		}
	}

	public void removeCliente(String documento) {
		clientes.removeIf(cliente -> cliente.getEntidade().getDocumento().equals(documento));
	}

	public void removeFuncionario(String documento) {
		funcionarios.removeIf(funcionario -> funcionario.getDocumento().equals(documento));
	}

	public void ordenarPorSalario() {
		ComparadorSalario comparador = new ComparadorSalario();
		Collections.sort(funcionarios, comparador);
	}

	public void listarFuncionarios() {
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
}
