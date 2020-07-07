
import java.io.*;

import javax.swing.JOptionPane;

public class Arquivo {

	String nomeArquivo;

	Arquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	Arquivo() {
		this.nomeArquivo = "";
	}

	public void salvarRegistro(Registro r) throws IOException {
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "rw");
		file.seek(file.length());
		file.writeInt(r.getByteArray().length);
		file.write(r.getByteArray());
		file.close();
	}

	public void listarArquivo() throws IOException {
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "r");
		Aluno aluno = new Aluno();
		int posAtual = 0;
		String lista = "";

		while (posAtual < file.length()) {

			int size = file.readInt();
			byte b[] = new byte[size];
			file.read(b);
			aluno.setByteArray(b);
			lista += "Aluno: " + aluno.nome + "\nCódigo: " + aluno.codigo + "\n\n";
			posAtual = posAtual + size + 4;

		}

		file.close();
		JOptionPane.showMessageDialog(null, lista);
	}

	public void pesquisaSequencial(String nome) throws IOException {
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "r");
		Aluno aluno = new Aluno();
		int posAtual = 0;

		while (posAtual < file.length()) {

			int size = file.readInt();
			byte b[] = new byte[size];
			file.read(b);
			aluno.setByteArray(b);
			if (aluno.nome.contains(nome))
				JOptionPane.showMessageDialog(null, "Aluno: " + aluno.nome + "\nCódigo: " + aluno.codigo);
			posAtual = posAtual + size + 4;
		}

		file.close();
	}

	public void pesquisaBinaria(int codigo) throws IOException {
		RandomAccessFile file = new RandomAccessFile(nomeArquivo, "rw");
		file.seek(0);

		int tam_registro = 4 + 4 + Aluno.TAM_NOME;
		int inicio = 0;
		int fim = (int) file.length() - tam_registro;
		boolean achou = false;

		while (!achou && inicio <= fim) {

			int meio = (inicio + fim) / 2;
			if (meio % tam_registro != 0)
				meio = meio + meio % tam_registro;

			file.seek(meio);

			int size = file.readInt();
			byte b[] = new byte[size];
			file.read(b);

			Aluno a = new Aluno();
			a.setByteArray(b);

			if (a.codigo == codigo) {
				achou = true;
				JOptionPane.showMessageDialog(null, "Aluno: " + a.nome + "\nCódigo: " + a.codigo);

			} else if (a.codigo > codigo) {
				fim = meio - tam_registro;

			} else if (a.codigo < codigo) {
				inicio = meio + tam_registro;
			}
		}

		file.close();

		if (!achou)
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
	}
}
