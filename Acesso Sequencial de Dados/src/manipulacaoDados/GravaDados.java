package manipulacaoDados;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class GravaDados {
	
	public static String getStringTamanhoFixo(String texto, int tamanho) {
		StringBuffer s1 = new StringBuffer(texto);
		s1.setLength(tamanho);
		return s1.toString();
	}
	
	public static void main(String[] args) {
		
		try {
			
			//Define o nome do arquivo a ser trabalhado
			System.out.print("Informe o nome do Arquivo a ser gravado: ");
			String nomeArquivo = Teclado.readLine();			
			
			//Objetos utilizados na manipulação do arquivo e seus dados
			FileOutputStream arqSaida = new FileOutputStream(nomeArquivo);
			PrintStream saida = new PrintStream(arqSaida);
			
			System.out.print("Informe o número de registros a serem gravados: ");
			int numRegistros = Teclado.readInt();			
			
			//Adiciona os registros desejados
			for(int i=0;i<numRegistros;i++) {
				System.out.print("\nInforme o código do Veículo: ");
				int codigo = Teclado.readInt();
				
				System.out.print("Informe o nome do Veiculo: ");
				String nomeVeiculo = Teclado.readLine();
				
				String linha = codigo + " " + nomeVeiculo;
				saida.println(linha);
				
				// >>> E se a duas linhas a seguir substituissem as 2 linhas anteriores? O que aconteceria com os registros?
				// >>> String linha2 = getStringTamanhoFixo(codigo+"", 5) + " " + getStringTamanhoFixo(nomeVeiculo, 15); 
				// >>> saida.println(linha2);

			}

			//Finalização da manipulação dos dados no arquivo
			saida.flush();
			saida.close();
			arqSaida.close();
			
			System.out.println("\nDados Gravados com sucesso!");
			
		}
		catch(Exception e) { //Tratamento genérico da excessão ocorrida
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}
		
	}
}
