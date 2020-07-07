package empresa;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		Cliente cliente = null;
		Funcionario funcionario = null;
		float credito, salario;

		while (funcionario == null || cliente == null) {

			try {

				if (cliente == null) {
					System.out.println("Digite um valor de LIMITE DE CRÉDITO para o cliente José Maria:");
					credito = ler.nextFloat();
					cliente = new Cliente(
							new PessoaFisica("José Maria", "endereco", "telefone", "cep", "cidade", "uf", "cpf"),
							credito);
				}

				if (funcionario == null) {
					System.out.println("\nDigite um valor de SALÁRIO para o funcionário João Batista:");
					salario = ler.nextFloat();
					funcionario = new Funcionario("João Batista", "endereco", "telefone", "cep", "cidade", "uf", "cpf",
							"cargo", salario);
				}

			} catch (ExcecaoValorNegativo e) {

				System.out.println("\n" + e.getMessage() + "\n");
			}
		}

		ler.close();
		System.out.println("\nCliente: " + cliente.getEntidade().getNome() + "; Limite de crédito: R$"
				+ cliente.getLimiteDeCredito());
		System.out.println("\nFuncionário: " + funcionario.getNome() + "; Salário: R$" + funcionario.getSalario());
	}
}
