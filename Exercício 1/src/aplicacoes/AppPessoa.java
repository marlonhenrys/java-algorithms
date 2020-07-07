package aplicacoes;

import javax.swing.JOptionPane;

import estruturas.Pessoa;

public class AppPessoa {

	public static void main(String[] args) {

		int opcao, idade, sexoOpcao;
		String nome, cpf, sexo;
		Pessoa pessoa = new Pessoa();

		do {

			opcao = Integer.parseInt(JOptionPane
					.showInputDialog("MENU:\n\n0 - SAIR\n1 - Cadastrar Pessoa\n2 - Imprimir dados\n\nOpção:"));

			switch (opcao) {

			case 0:
				JOptionPane.showMessageDialog(null, "Programa Encerrado!");
				break;

			case 1:
				nome = JOptionPane.showInputDialog("Informe o nome:");
				cpf = JOptionPane.showInputDialog("Informe o CPF:");
				idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade:"));
				sexoOpcao = Integer.parseInt(JOptionPane.showInputDialog(
						"SEXO\n\nInforme o número correspondente:\n\n1- Feminino\n2 - Masculino\n3 - Outro\n\nOpção:"));
				if (sexoOpcao == 1)
					sexo = "Feminino";
				else if (sexoOpcao == 2)
					sexo = "Masculino";
				else if (sexoOpcao == 3)
					sexo = "Outro";
				else
					sexo = "null";

				pessoa = new Pessoa(nome, cpf, idade, sexo);
				break;

			case 2:
				JOptionPane.showMessageDialog(null, "Nome: " + pessoa.getNome() + "\nCPF: " + pessoa.getCPF()
						+ "\nIdade: " + pessoa.getIdade() + "\nSexo: " + pessoa.getSexo());
				if (pessoa.eMaior())
					JOptionPane.showMessageDialog(null, "É maior de idade!");
				else
					JOptionPane.showMessageDialog(null, "Não é maior de idade!");

				break;
			}

		} while (opcao != 0);

	}

}
