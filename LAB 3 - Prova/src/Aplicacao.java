
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Aplicacao {

	private static Scanner console = new Scanner(System.in);
	private static Arquivo<Cliente> arqClientes;

	public static void main(String[] args) {

		try {

			arqClientes = new Arquivo<>(Cliente.class.getConstructor(), "cliente.txt");

			int opcao;
			do {
				System.out.println("GEST�O DE CLIENTES");
				System.out.println("-----------------------------\n");
				System.out.println("1 - Inserir");
				System.out.println("2 - Listar");
				System.out.println("3 - Excluir");
				System.out.println("4 - Gerar Estat�sticas");
				System.out.println("0 - Sair");
				System.out.print("\nOpcao: ");
				opcao = Integer.valueOf(console.nextLine());

				switch (opcao) {
				case 1:
					inserirCliente();
					break;
				case 2:
					listarClientes();
					break;
				case 3:
					excluirCliente();
					break;
				case 4:
					gerarRelatorio();
					break;

				case 0:
					break;
				default:
					System.out.println("\nOpc�o Inv�lida!");
				}

			} while (opcao != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void inserirCliente() throws Exception {

		System.out.println("\nCADASTRO DE CLIENTE");
		System.out.print("\nNome: ");
		String nome = console.nextLine();
		System.out.print("Idade: ");
		int idade = console.nextInt();

		Cliente obj = new Cliente(nome, idade, -1);
		int id = arqClientes.incluir(obj);
		System.out.println("\nCliente cadastrado com ID: " + id);

		pausa();
	}

	public static void listarClientes() throws Exception {

		Object[] obj = arqClientes.listar();

		System.out.println("\nLISTA DE CLIENTES");
		for (int i = 0; i < obj.length; i++) {
			System.out.println((Cliente) obj[i]);
		}
		pausa();

	}

	public static void excluirCliente() throws Exception {

		System.out.println("\nEXCLUS�O DE CLIENTE");

		int id;
		System.out.print("\nID do Cliente: ");
		id = Integer.valueOf(console.nextLine());
		if (id <= 0)
			return;

		Cliente obj;
		if ((obj = (Cliente) arqClientes.buscar(id)) != null) {
			System.out.println(obj);

			if (arqClientes.excluir(id)) {
				System.out.println("\nCliente Exclu�do!");
			}

		} else
			System.out.println("\nCliente n�o encontrado!");
		pausa();

	}

	public static void gerarRelatorio() throws Exception {

		Object[] obj = arqClientes.listar();
		Cliente client;
		int numClientes = 0, somaIdades = 0, idadeMedia, maiorIdade = 0;

		for (int i = 0; i < obj.length; i++) {
			client = (Cliente) obj[i];
			numClientes++;
			somaIdades += client.getIdade();
			if (client.getIdade() > maiorIdade)
				maiorIdade = client.getIdade();
		}

		idadeMedia = somaIdades / numClientes;

		String sNumClientes = "", sidadeMedia, smaiorIdade;

		if (numClientes < 10)
			sNumClientes = "00" + numClientes;
		else if (numClientes < 100)
			sNumClientes = "0" + numClientes;
		else if (numClientes >= 100)
			sNumClientes = "" + numClientes;

		try {

			FileOutputStream arqSaida = new FileOutputStream("estatistica.txt");
			PrintStream saida = new PrintStream(arqSaida);

			saida.println("NC " + sNumClientes);
			saida.println("IM " + idadeMedia);
			saida.println("MI 0" + maiorIdade);

			saida.flush();
			saida.close();
			arqSaida.close();

			System.out.println("\n\nRelat�rio gravado com sucesso!");

		} catch (Exception e) {
			System.out.println("O seguinte erro ocorreu: " + e.toString());
		}

		System.out.println("\n\nN�mero de Cliente: " + numClientes + "\nIdade m�dia dos clientes: " + idadeMedia
				+ "\nMaior idade: " + maiorIdade);
		pausa();

	}

	public static void pausa() throws Exception {

		System.out.println("\nPressione ENTER para continuar ...");
		console.nextLine();
		console.nextLine();
		for (int i = 0; i < 50; i++)
			System.out.println("\n");
	}

}
