import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class BuscaConteudoWEB {

	public static ArrayList<String> conteudoWEB(String enderecoWEB, String enderecoProxy, int portaProxy) {

		ArrayList<String> lista = new ArrayList<String>();

		if (enderecoProxy != null && enderecoProxy != "") {
			System.setProperty("http.proxyHost", enderecoProxy);
			System.setProperty("http.proxyPort", portaProxy + "");
		}

		try {
			URL endereco = new URL(enderecoWEB);

			HttpURLConnection connection = (HttpURLConnection) endereco.openConnection();

			connection.connect();

			BufferedReader conteudo = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String linha = "";
			linha = conteudo.readLine();

			while (null != linha) {
				lista.add(linha);
				linha = conteudo.readLine();
			}

			conteudo.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	public static ArrayList<String> separaPalavras(String linha) {

		linha = linha.replace("<", " ").replace(">", " ").replace(":", " ").replace("\"", " ").replace("/", " ")
				.replace(".", " ").replace("=", " ").replace(";", " ").replace(",", " ").replace(")", " ")
				.replace("(", " ").replace("#", " ").replace("{", " ").replace("}", " ").replace("?", " ")
				.replace("]", " ").replace("!", " ").replace("\\", " ").replace("'", " ").replace("[", " ")
				.replaceAll("_", " ");

		StringTokenizer token = new StringTokenizer(linha, " ");
		ArrayList<String> chaves = new ArrayList<String>();

		while (token.hasMoreTokens())
			chaves.add(token.nextToken());

		return chaves;
	}

	public static void criarArquivo(String url, String enderecoProxy, int portaProxy) {

		ArrayList<String> chaves = new ArrayList<String>();
		ArrayList<String> address = new ArrayList<String>();
		ArrayList<String> retorno = new ArrayList<String>();
		String chave;

		ArrayList<String> pagina = conteudoWEB(url, enderecoProxy, portaProxy);

		for (int i = 0; i < pagina.size(); i++) {
			retorno = separaPalavras(pagina.get(i));

			for (int j = 0; j < retorno.size(); j++) {
				chave = retorno.get(j);

				if (chaves.contains(chave)) {

					for (int a = 0; a < chaves.size(); a++) {

						if (chaves.get(a).equals(chave)) {

							String aux = address.get(a);
							aux += " <" + (i + 1) + "," + (j + 1) + ">";
							address.remove(a);
							address.add(a, aux);
						}
					}

				} else {
					chaves.add(chave);
					address.add("<" + (i + 1) + "," + (j + 1) + ">");
				}
			}
		}

		try {
			FileOutputStream arqSaida = new FileOutputStream("ArquivoInvertido.txt");
			PrintStream saida = new PrintStream(arqSaida);

			for (int k = 0; k < chaves.size(); k++) {
				saida.println(chaves.get(k) + " " + address.get(k));
			}

			saida.flush();
			saida.close();
			arqSaida.close();

			JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!");

		} catch (Exception e) {
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}

	}

	@SuppressWarnings("deprecation")
	public static void pesquisarTermo() {

		String termo = JOptionPane.showInputDialog("Informe o termo a ser pesquisado:");
		String print = "";
		boolean achou = false;

		try {
			FileInputStream arqEntrada = new FileInputStream("ArquivoInvertido.txt");
			DataInputStream entrada = new DataInputStream(arqEntrada);

			while (entrada.available() != 0) {

				String linha = entrada.readLine();
				if (linha.substring(0, termo.length()).equalsIgnoreCase(termo)) {
					print += linha + "\n\n";
					achou = true;
				}
			}

			if (!achou)
				JOptionPane.showMessageDialog(null, "Termo não encontrado!");
			else
				JOptionPane.showMessageDialog(null, print);

			entrada.close();
			arqEntrada.close();

		} catch (FileNotFoundException e) {
			System.out.println("O Arquivo não existe.\n" + e.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String enderecoProxy = null;
		int portaProxy = 0;

		String url;
		int opcao;

		do {

			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"MENU: Arquivo Invertido\n\n1 - Criar arquivo padrão\n2 - Criar arquivo com uma URL\n3 - Pesquisar termo\n0 - SAIR\n\nOpção:"));

			switch (opcao) {

			case 0:
				JOptionPane.showMessageDialog(null, "Programa encerrado!");
				break;

			case 1:
				url = "http://machado.mec.gov.br/";
				criarArquivo(url, enderecoProxy, portaProxy);
				break;

			case 2:
				url = JOptionPane.showInputDialog("Informe a URL:");
				criarArquivo(url, enderecoProxy, portaProxy);
				break;

			case 3:
				pesquisarTermo();
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}

		} while (opcao != 0);
	}
}