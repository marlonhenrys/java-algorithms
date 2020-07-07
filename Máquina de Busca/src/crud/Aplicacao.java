package crud;

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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Aplicacao {

	private static Scanner console = new Scanner(System.in);
	private static Arquivo<Pagina> arqPaginas;

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

	public static ArrayList<String> indexarPaginas() throws Exception {
		Object[] obj = arqPaginas.listar();
		ArrayList<String> paginas = new ArrayList<String>();

		for (int i = 0; i < obj.length; i++) {
			Pagina p = (Pagina) obj[i];
			paginas.add(p.url + ";" + p.id);
		}
		return paginas;
	}

	public static ArrayList<String> separaPalavras(String linha) {

		linha = linha.toLowerCase().replace("<", " ").replace(">", " ").replace(":", " ").replace("\"", " ")
				.replace("/", " ").replace(".", " ").replace("=", " ").replace(";", " ").replace(",", " ")
				.replace(")", " ").replace("(", " ").replace("#", " ").replace("{", " ").replace("}", " ")
				.replace("?", " ").replace("]", " ").replace("!", " ").replace("\\", " ").replace("'", " ")
				.replace("[", " ").replace("_", " ").replace("|", " ").replace("+", " ").replace("&", " ")
				.replace("^", " ").replace("@", " ").replace("	", " ").replace("*", " ").replace("\t", " ");

		StringTokenizer token = new StringTokenizer(linha, " ");
		ArrayList<String> chaves = new ArrayList<String>();

		while (token.hasMoreTokens())
			chaves.add(token.nextToken());

		return chaves;
	}

	public static void criarArquivo(String enderecoProxy, int portaProxy) throws Exception {

		ArrayList<String> chaves = new ArrayList<String>();
		ArrayList<String> address = new ArrayList<String>();
		ArrayList<String> retorno = new ArrayList<String>();
		ArrayList<String> paginas = indexarPaginas();

		String chave;
		System.out.println("\nCriando arquivo invertido... Isso pode demorar um pouco.");

		for (int p = 0; p < paginas.size(); p++) {

			String pag = paginas.get(p);
			int flag = pag.indexOf(";");

			String url = pag.substring(0, flag);

			ArrayList<String> pagina = conteudoWEB(url, enderecoProxy, portaProxy);

			for (int i = 0; i < pagina.size(); i++) {
				retorno = separaPalavras(pagina.get(i));

				for (int j = 0; j < retorno.size(); j++) {
					chave = retorno.get(j);

					if (chaves.contains(chave)) {

						for (int a = 0; a < chaves.size(); a++) {

							if (chaves.get(a).equals(chave)) {

								String aux = address.get(a);
								aux += " <" + (pag.substring(flag + 1, pag.length())) + "," + (i + 1) + "," + (j + 1)
										+ ">";
								address.remove(a);
								address.add(a, aux);
							}
						}

					} else {
						chaves.add(chave);
						address.add(
								"<" + (pag.substring(flag + 1, pag.length())) + "," + (i + 1) + "," + (j + 1) + ">");
					}
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

			System.out.println("\nArquivo criado com sucesso!");

		} catch (Exception e) {
			System.out.println("\nO seguinte erro ocorreu: " + e.toString());
		}

	}

	@SuppressWarnings("deprecation")
	public static void pesquisarTermo() throws Exception {

		System.out.print("\nInforme o termo a ser pesquisado: ");
		String termo = console.nextLine();
		String print = "";
		boolean achou = false;

		System.out.println("\nAguarde...\n");

		try {
			FileInputStream arqEntrada = new FileInputStream("ArquivoInvertido.txt");
			DataInputStream entrada = new DataInputStream(arqEntrada);

			while (entrada.available() != 0) {

				String linha = entrada.readLine();
				if (linha.substring(0, termo.length()).equals(termo)) {
					print += linha + "\n\n";
					achou = true;
				}
			}

			if (!achou)
				System.out.println("Termo não encontrado!");
			else
				System.out.println("\nResultados encontrados:\n\n" + print);

			entrada.close();
			arqEntrada.close();

		} catch (FileNotFoundException e) {
			System.out.println("O Arquivo não existe.\n" + e.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		pausa();
	}

	public static void main(String[] args) {

		String enderecoProxy = null;
		int portaProxy = 0;

		try {

			arqPaginas = new Arquivo<>(Pagina.class.getConstructor(), "paginas.txt");

			int opcao;

			do {
				System.out.println("\n\nMáquina de Busca");
				System.out.println("----------------\n");
				System.out.println("1 - Listar");
				System.out.println("2 - Incluir");
				System.out.println("3 - Alterar");
				System.out.println("4 - Excluir");
				System.out.println("5 - Buscar");
				System.out.println("6 - Gerar Arquivo Invertido");
				System.out.println("7 - Buscar termo");
				System.out.println("0 - Sair");
				System.out.print("\nOpção: ");
				opcao = Integer.valueOf(console.nextLine());

				switch (opcao) {
				case 1:
					listarPaginas();
					break;
				case 2:
					incluirPagina();
					break;
				case 3:
					alterarPagina();
					break;
				case 4:
					excluirPagina();
					break;
				case 5:
					buscarPagina();
					break;
				case 6:
					criarArquivo(enderecoProxy, portaProxy);
					break;
				case 7:
					pesquisarTermo();
					break;
				case 0:
					System.out.println("\nPrograma Encerrado!");
					break;
				default:
					System.out.println("\nOpção Inválida!");
				}

			} while (opcao != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void listarPaginas() throws Exception {

		Object[] obj = arqPaginas.listar();

		System.out.println("\nLISTA DE PÁGINAS\n----------------");
		for (int i = 0; i < obj.length; i++) {
			System.out.println((Pagina) obj[i]);
		}
		pausa();

	}

	public static void incluirPagina() throws Exception {

		String url;

		System.out.println("\nINCLUSÃO DE PÁGINA\n");
		System.out.print("Informe a URL: ");
		url = console.nextLine();

		Pagina obj = new Pagina(-1, url, LocalDateTime.now());
		int id = arqPaginas.incluir(obj);
		System.out.println("\nPágina incluída com ID: " + id);

		pausa();
	}

	public static void alterarPagina() throws Exception {

		System.out.println("\nALTERAÇÃO DE PÁGINA\n");

		int id;
		System.out.print("ID da página: ");
		id = Integer.valueOf(console.nextLine());
		if (id <= 0)
			return;

		Pagina obj;
		if ((obj = (Pagina) arqPaginas.buscar(id)) != null) {
			System.out.println(obj);

			String url;

			System.out.print("\nNova URL: ");
			url = console.nextLine();

			if (url.length() > 0) {

				obj.url = (url.length() > 0 ? url : obj.url);
				obj.acesso = LocalDateTime.now().toString();

				if (arqPaginas.alterar(obj))
					System.out.println("\nPágina alterada.");
				else
					System.out.println("\nPágina não pode ser alterada.");
			}

		} else
			System.out.println("\nPágina não encontrada!");
		pausa();

	}

	public static void excluirPagina() throws Exception {

		System.out.println("\nEXCLUSÃO DE PÁGINA\n");

		int id;
		System.out.print("ID da página: ");
		id = Integer.valueOf(console.nextLine());
		if (id <= 0)
			return;

		Pagina obj;
		if ((obj = (Pagina) arqPaginas.buscar(id)) != null) {
			System.out.println(obj);

			if (arqPaginas.excluir(id)) {
				System.out.println("\nPágina excluída!");
			}

		} else
			System.out.println("\nPágina não encontrada.");
		pausa();

	}

	public static void buscarPagina() throws Exception {

		System.out.println("\nBUSCA DE PÁGINA POR CÓDIGO\n");

		int codigo;
		System.out.print("Informe o ID: ");
		codigo = Integer.valueOf(console.nextLine());
		if (codigo <= 0)
			return;

		Pagina obj;
		if ((obj = (Pagina) arqPaginas.buscar(codigo)) != null)
			System.out.println(obj);
		else
			System.out.println("\nPágina não encontrada.");
		pausa();

	}

	public static void pausa() throws Exception {
		System.out.println("\nPressione ENTER para continuar ...");
		console.nextLine();
		for (int i = 0; i < 50; i++)
			System.out.println();
	}

}
