package manipulacaoObjetos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class GravaObjetos {

	public static void main(String[] args) {
		
		try {
			
			//Define o nome do arquivo a ser trabalhado		
			System.out.print("Informe o nome do Arquivo a ser gravado: ");
			String nomeArquivo = Teclado.readLine();

			//Objetos utilizados na manipulação do arquivo e seus dados			
			FileOutputStream arqSaida = new FileOutputStream(nomeArquivo);
			ObjectOutputStream saida = new ObjectOutputStream(arqSaida);
			
			System.out.print("Informe o número de registros a serem gravados: ");
			int numRegistros = Teclado.readInt();			

			//Adiciona os registros desejados
			for(int i=0;i<numRegistros;i++) {
				System.out.print("\nInforme o código da Empresa: ");
				int codigo = Teclado.readInt();
				
				System.out.print("Informe o nome da Empresa: ");
				String nomeEmpresa = Teclado.readLine();
				
				Empresa e = new Empresa(codigo, nomeEmpresa);
				saida.writeObject(e);
				
			}
			
			//Finalização da manipulação dos dados no arquivo			
			saida.flush();
			saida.close();
			arqSaida.close();
			
			System.out.println("\nDados Gravados com sucesso!");	
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("O Arquivo informado não existe.\n" + e.toString());
		}
		catch(IOException e) {
			System.out.println("O seguinte erro de I/O ocorreu:\n" + e.toString());
		}
		catch(Exception e) { //Tratamento genérico da excessão ocorrida
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}		
	}
}
