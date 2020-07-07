package empresa;

public class Aplicacao {

	public static void main(String[] args) {

		Empresa empresa = new Empresa("nome", "endereco", "telefone", "cep", "cidade", "uf", "cnpj");

		try {
			empresa.add(new Funcionario("a", "endereco", "telefone", "cep", "cidade", "uf", "111", "cargo", 750));
			empresa.add(new Funcionario("b", "endereco", "telefone", "cep", "cidade", "uf", "222", "cargo", 200));
			empresa.add(new Funcionario("c", "endereco", "telefone", "cep", "cidade", "uf", "333", "cargo", 450));
			empresa.add(new Funcionario("d", "endereco", "telefone", "cep", "cidade", "uf", "444", "cargo", 800));
			empresa.add(new Funcionario("b", "endereco", "telefone", "cep", "cidade", "uf", "222", "cargo", 200));

		} catch (ExcecaoValorNegativo e) {
			e.printStackTrace();
		}

		empresa.listarFuncionarios();
		System.out.println("\nOrdenando...\n");
		empresa.ordenarPorSalario();
		empresa.listarFuncionarios();
	}

}