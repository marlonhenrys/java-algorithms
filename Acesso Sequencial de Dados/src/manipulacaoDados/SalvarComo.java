package manipulacaoDados;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class SalvarComo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		System.out.print("Informe o nome do arquivo a ser copiado: ");
		String nomeArquivo = Teclado.readLine();

		try {

			FileInputStream arqEntrada = new FileInputStream(nomeArquivo);
			DataInputStream entrada = new DataInputStream(arqEntrada);

			try {

				System.out.print("Salvar como: ");
				String nomeCopia = Teclado.readLine();

				FileOutputStream arqSaida = new FileOutputStream(nomeCopia);
				PrintStream saida = new PrintStream(arqSaida);

				while (entrada.available() != 0) {

					String linha = entrada.readLine();
					StringTokenizer listaPalavras = new StringTokenizer(linha);

					String codigoLinha = listaPalavras.nextToken();
					String nomeLinha = listaPalavras.nextToken();

					String novalinha = codigoLinha + " " + nomeLinha;
					saida.println(novalinha);

				}

				saida.flush();
				entrada.close();
				arqEntrada.close();
				saida.close();
				arqSaida.close();

				System.out.println("\nBackup realizado com sucesso!");

			} catch (Exception e) {
				System.out.println("\nO seguinte erro ocorreu: " + e.toString());
			}
		} catch (FileNotFoundException e) {
			System.out.println("\nO Arquivo informado não existe.\n" + e.toString());
		}
	}
}
