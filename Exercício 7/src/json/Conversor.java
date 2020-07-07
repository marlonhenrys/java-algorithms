package json;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import data.Data;
import data.ExcecaoDataInvalida;

public class Conversor {

	public static Map<String, Object> fromJSON(String nomeArquivo) {

		Map<String, Object> json = new HashMap<String, Object>();

		try {

			FileInputStream arqEntrada = new FileInputStream(nomeArquivo);
			DataInputStream entrada = new DataInputStream(arqEntrada);

			while (entrada.available() != 0) {

				@SuppressWarnings("deprecation")
				String linha = entrada.readLine();
				linha = linha.replace("\"", " ").replace(":", " ").replace(",", " ").replace("/", " ").replace("{", " ")
						.replace("}", " ");
				StringTokenizer listaPalavras = new StringTokenizer(linha);

				listaPalavras.nextToken();

				String chave = listaPalavras.nextToken();

				listaPalavras.nextToken();

				int dia = Integer.parseInt(listaPalavras.nextToken());
				int mes = Integer.parseInt(listaPalavras.nextToken());
				int ano = Integer.parseInt(listaPalavras.nextToken());

				json.put(chave, new Data(dia, mes, ano));

			}

			entrada.close();
			arqEntrada.close();

		} catch (FileNotFoundException e) {
			System.out.println("O Arquivo informado não existe.\n" + e.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ExcecaoDataInvalida e) {
			e.printStackTrace();
		}

		return json;
	}

	public static void toJSON(Map<String, Object> json, String nomeArquivo) {

		try {
			FileOutputStream arqSaida = new FileOutputStream(nomeArquivo);
			PrintStream saida = new PrintStream(arqSaida);

			json.forEach((k, v) -> saida.println("{\"chave\": \"" + k + "\", \"valor\": \"" + v + "\"}"));

			saida.flush();
			saida.close();
			arqSaida.close();

			System.out.println("\nDados Gravados com sucesso!");

		} catch (Exception e) {
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}

	}
}
