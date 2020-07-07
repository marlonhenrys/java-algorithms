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
					System.out.println("Digite um valor de LIMITE DE CR�DITO para o cliente Jos� Maria:");
					credito = ler.nextFloat();
					cliente = new Cliente(
							new PessoaFisica("Jos� Maria", "endereco", "telefone", "cep", "cidade", "uf", "cpf"),
							credito);
				}

				if (funcionario == null) {
					System.out.println("\nDigite um valor de SAL�RIO para o funcion�rio Jo�o Batista:");
					salario = ler.nextFloat();
					funcionario = new Funcionario("Jo�o Batista", "endereco", "telefone", "cep", "cidade", "uf", "cpf",
							"cargo", salario);
				}

			} catch (ExcecaoValorNegativo e) {

				System.out.println("\n" + e.getMessage() + "\n");
			}
		}

		ler.close();
		System.out.println("\nCliente: " + cliente.getEntidade().getNome() + "; Limite de cr�dito: R$"
				+ cliente.getLimiteDeCredito());
		System.out.println("\nFuncion�rio: " + funcionario.getNome() + "; Sal�rio: R$" + funcionario.getSalario());
	}
}
