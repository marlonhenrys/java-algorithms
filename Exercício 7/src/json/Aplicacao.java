package json;

import java.util.HashMap;
import java.util.Map;

import data.Data;
import data.ExcecaoDataInvalida;

public class Aplicacao {

	public static void main(String[] args) {

		Map<String, Object> json = new HashMap<String, Object>();

		try {
			json.put("p�scoa", new Data(21, 04, 2019));
			json.put("natal", new Data(25, 12, 2019));
			json.put("reveillon", new Data(31, 12, 2019));
			json.put("carnaval", new Data(5, 3, 2019));
		} catch (ExcecaoDataInvalida e) {
			e.printStackTrace();
		}

		json.forEach((k, v) -> System.out.println("Chave: " + k + " | Valor: " + v));

		Conversor.toJSON(json, "arquivo.txt");

		System.out.println("\nLendo do arquivo...\n");

		Map<String, Object> arquivo = Conversor.fromJSON("arquivo.txt");

		arquivo.forEach((k, v) -> System.out.println("Chave: " + k + " | Valor: " + v));
	}

}
