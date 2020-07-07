import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Aplicacao {

	public static void inserir(Arquivo arquivo, Aluno aluno) throws IOException {

		aluno.nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
		aluno.codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do aluno:"));

		arquivo.salvarRegistro(aluno);
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

	}

	public static void main(String[] args) {
		try {
			Arquivo arquivo = new Arquivo("Alunos");
			Aluno aluno = new Aluno();
			int opcao;

			do {

				opcao = Integer.parseInt(JOptionPane.showInputDialog(
						"MENU:\n\n1 - Cadastrar aluno\n2 - Listar alunos\n3 - Pesquisar aluno por nome\n4 - Pesquisar aluno por código\n0 - SAIR\n\nOpção:"));

				switch (opcao) {

				case 0:
					JOptionPane.showMessageDialog(null, "Programa encerrado!");
					break;

				case 1:
					inserir(arquivo, aluno);
					break;

				case 2:
					arquivo.listarArquivo();
					break;

				case 3:
					String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
					arquivo.pesquisaSequencial(nome);
					break;

				case 4:
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do aluno:"));
					arquivo.pesquisaBinaria(codigo);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Opção inválida!");
				}

			} while (opcao != 0);
		} catch (FileNotFoundException e) {
			System.out.println("O Arquivo informado não existe.\n" + e.toString());
		} catch (IOException e) {
			System.out.println("O seguinte erro de I/O ocorreu:\n" + e.toString());
		} catch (Exception e) {
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}
	}
}
