package manipulacaoObjetos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SalvarComo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		System.out.print("Informe o nome do arquivo a ser copiado: ");
		String nomeArquivo = Teclado.readLine();

		try {

			FileInputStream arqEntrada = new FileInputStream(nomeArquivo);
			ObjectInputStream entrada = new ObjectInputStream(arqEntrada);

			try {

				System.out.print("Salvar como: ");
				String nomeCopia = Teclado.readLine();

				FileOutputStream arqSaida = new FileOutputStream(nomeCopia);
				ObjectOutputStream saida = new ObjectOutputStream(arqSaida);

				while (arqEntrada.available() != 0) {

					Empresa empr = (Empresa) entrada.readObject();

					int codigo = empr.getId();
					String nomeEmpresa = empr.getNome();

					Empresa e = new Empresa(codigo, nomeEmpresa);
					saida.writeObject(e);

				}

				saida.flush();
				entrada.close();
				arqEntrada.close();
				saida.close();
				arqSaida.close();
				
				System.out.println("\nBackup realizado com sucesso!");

			} catch (Exception e) {
				System.out.println("O seguinte erro ocorreu: " + e.toString());
			}

		} catch (FileNotFoundException e) {
			System.out.println("O Arquivo informado não existe.\n" + e.toString());
		}
	}
}