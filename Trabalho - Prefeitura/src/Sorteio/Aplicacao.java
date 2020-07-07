package Sorteio;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Aplicacao {

	public static int N = 1, M1 = 1, M2 = 1;

	static CDicionario F1 = new CDicionario();
	static CDicionario F2 = new CDicionario();
	static CDicionario E1 = new CDicionario();
	static CDicionario E2 = new CDicionario();

	public static Scanner ler;

	public static void limpaTela() {

		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

	public static String formataTel(String telefone) {

		String tel = "";

		if (telefone.length() == 10) {
			tel = "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 6) + "-" + telefone.substring(6, 10);

		} else if (telefone.length() == 11) {
			tel = "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 3) + " " + telefone.substring(3, 7)
					+ "-" + telefone.substring(7, 11);
		}

		return tel;
	}

	public static String formataCep(String cep) {

		String scep;

		scep = cep.substring(0, 5) + "-" + cep.substring(5, 8);

		return scep;
	}

	public static String formataCpf(long cpf) {

		String scpf;

		scpf = "" + cpf;
		scpf = scpf.substring(0, 3) + "." + scpf.substring(3, 6) + "." + scpf.substring(6, 9) + "-"
				+ scpf.substring(9, 11);

		return scpf;
	}

	public static void Cadastrar() {

		System.out.println("- Vagas para a FAIXA 1: " + (M1 - F1.quantidade()));
		System.out.println("- Vagas para a FAIXA 2: " + (M2 - F2.quantidade()));
		System.out.println("- Vagas na FILA DE ESPERA: " + (N - E1.quantidade() + E2.quantidade()));
		System.out.println("\n\nDeseja continuar?\n\n 0 : Confirmar\n1-9: Cancelar\n\n");
		System.out.print("Opção: ");
		int op = ler.nextInt();

		if (op == 0) {

			limpaTela();
			CMorador morador = new CMorador();

			System.out.println("CADASTRO DE MORADORES \n=====================\n");
			System.out.print("CPF: ");
			morador.CPF = ler.nextLong();
			ler.nextLine();
			System.out.print("Nome: ");
			morador.Nome = ler.nextLine();
			System.out.print("Quantidade de Dependentes: ");
			morador.qtdeDepend = ler.nextInt();
			ler.nextLine();
			System.out.print("Renda Familiar: ");
			morador.RendaFamiliar = ler.nextDouble();
			ler.nextLine();
			System.out.print("Telefone (Informe o DDD): ");
			morador.Telefone = ler.nextLine();
			System.out.print("Estado: ");
			morador.Estado = ler.nextLine();
			System.out.print("Cidade: ");
			morador.Cidade = ler.nextLine();
			System.out.print("Bairro: ");
			morador.Bairro = ler.nextLine();
			System.out.print("Endereço: ");
			morador.Endereco = ler.nextLine();
			System.out.print("Número: ");
			morador.NumeroRua = ler.nextInt();
			ler.nextLine();
			System.out.print("Complemento: ");
			morador.Complemento = ler.nextLine();
			System.out.print("CEP: ");
			morador.CEP = ler.nextLine();

			if (morador.RendaFamiliar <= 954) {

				if (F1.quantidade() < M1) {
					F1.adicionar(morador.CPF, morador);
					System.out.println("\nCadastro realizado com sucesso!");

				} else if (E1.quantidade() + E2.quantidade() < N) {
					E1.adicionar(morador.CPF, morador);
					System.out.println("\nCadastro realizado na fila de espera!");

				} else
					System.out.println("\nERRO: Não há vagas disponíveis!");

			} else if (morador.RendaFamiliar <= 2862) {

				if (F2.quantidade() <= M2) {
					F2.adicionar(morador.CPF, morador);
					System.out.println("\nCadastro realizado com sucesso!");

				} else if (E1.quantidade() + E2.quantidade() < N) {
					E2.adicionar(morador.CPF, morador);
					System.out.println("\nCadastro realizado na fila de espera!");

				} else {

					System.out.println("\nERRO: Não há vagas disponíveis!");
				}
			} else {

				System.out.println("\nNão é possível cadastrar um morador com a renda familiar informada.");
			}
		}
	}

	public static CMorador Pesquisar() {

		CMorador morador;

		System.out.print("Informe o CPF do morador: ");
		long key = ler.nextLong();

		if (F1.retornaValor(key) != null) {
			morador = (CMorador) F1.retornaValor(key);
			imprimeDadosCompletos(morador);

		} else if (F2.retornaValor(key) != null) {
			morador = (CMorador) F2.retornaValor(key);
			imprimeDadosCompletos(morador);

		} else if (E1.retornaValor(key) != null) {
			System.out.println("\nMorador cadastrado na FILA DE ESPERA.");

		} else if (E2.retornaValor(key) != null) {
			System.out.println("\nMorador cadastrado na FILA DE ESPERA.");

		} else {

			System.out.println("\nMorador não encontrado!");
		}

		return null;
	}

	public static void Excluir() {

		CMorador morador;

		System.out.print("Informe o CPF do morador: ");
		long key = ler.nextLong();

		if (F1.retornaValor(key) != null) {
			morador = (CMorador) F1.retornaValor(key);
			imprimeDadosCompletos(morador);

		} else if (F2.retornaValor(key) != null) {
			morador = (CMorador) F2.retornaValor(key);
			imprimeDadosCompletos(morador);

		} else
			System.out.println("\nMorador não encontrado!");

		System.out.println("\n\nDeseja continuar?\n\n 0 : Confirmar\n1-9: Cancelar\n\n");
		System.out.print("Opção: ");
		int op = ler.nextInt();

		if (op == 0) {

			if (F1.remove(key)) {
				System.out.println("\nMorador excluído com sucesso!");

				if (E1.quantidade() > 0) {
					morador = (CMorador) E1.removeRetornaComeco();
					F1.adicionar(morador.CPF, morador);
				}

			} else if (F2.remove(key)) {
				System.out.println("\nMorador excluído com sucesso!");

				if (E2.quantidade() > 0) {
					morador = (CMorador) E2.removeRetornaComeco();
					F2.adicionar(morador.CPF, morador);
				}

			} else {

				System.out.println("ERRO: morador não encontado.");
			}
		}
	}

	public static void imprimeDadosCompletos(CMorador CM) {

		System.out.println("\nCPF " + formataCpf(CM.CPF) + "  Nome " + CM.Nome + "\nQtde. Dependentes " + CM.qtdeDepend
				+ " - Renda Familiar R$ " + CM.RendaFamiliar + "\nTelefone: " + formataTel(CM.Telefone) + "\n"
				+ CM.Endereco + ", " + CM.NumeroRua + ", " + CM.Complemento + "  Bairro: " + CM.Bairro + "\nCidade: "
				+ CM.Cidade + "  Estado: " + CM.Estado + "  CEP: " + formataCep(CM.CEP));
	}

	public static void imprimeDadosSimples(CMorador CM) {

		System.out.println(
				"\nCPF " + formataCpf(CM.CPF) + " - Nome " + CM.Nome + " - Renda Familiar R$ " + CM.RendaFamiliar);
	}

	public static void listagemCompleta() throws IOException {

		int pag = 0, cont = 3, i = 1, j = 1;

		if (F1.quantidade() + F2.quantidade() != 0) {

			while (i <= F1.quantidade() || j <= F2.quantidade()) {

				if (cont >= 3) {
					cont = 1;
					pag++;
					System.out.println("\nLISTAGEM COMPLETA DE MORADORES (PÁGINA " + pag + ")");
				}

				if (i <= F1.quantidade() && j == 1) {
					System.out.println("\nFAIXA 1\n");
				}

				while (cont <= 3 && i <= F1.quantidade()) {
					imprimeDadosCompletos((CMorador) F1.retornaIndice(i));
					cont++;
					i++;
				}

				if (j <= F2.quantidade() && i > F1.quantidade() && cont <= 3) {
					System.out.println("\nFAIXA 2\n");
				}

				while (i > F1.quantidade() && cont <= 3 && j <= F2.quantidade()) {
					imprimeDadosCompletos((CMorador) F2.retornaIndice(j));
					cont++;
					j++;
				}

				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				ler.nextLine();
				limpaTela();
			}

		} else {

			System.out.println("\nA lista de moradores está vazia!");
			System.out.println("\nPressione ENTER para continuar...");
			System.in.read();
			ler.nextLine();
		}
	}

	public static void listagemSimples() throws IOException {

		int pag = 0, cont = 20, i = 1, j = 1;

		if (F1.quantidade() + F2.quantidade() != 0) {

			while (i <= F1.quantidade() || j <= F2.quantidade()) {

				if (cont >= 20) {
					cont = 1;
					pag++;
					System.out.println("\nLISTAGEM DE MORADORES (PÁGINA " + pag + ")");
				}

				if (i <= F1.quantidade() && j == 1) {
					System.out.println("\nFAIXA 1\n");
				}

				while (cont <= 20 && i <= F1.quantidade()) {
					imprimeDadosSimples((CMorador) F1.retornaIndice(i));
					cont++;
					i++;
				}

				if (j <= F2.quantidade() && i > F1.quantidade() && cont <= 20) {
					System.out.println("\nFAIXA 2\n");
				}

				while (i > F1.quantidade() && cont <= 20 && j <= F2.quantidade()) {
					imprimeDadosSimples((CMorador) F2.retornaIndice(j));
					cont++;
					j++;
				}

				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				ler.nextLine();
				limpaTela();
			}

		} else {

			System.out.println("\nA lista de moradores está vazia!");
			System.out.println("\nPressione ENTER para continuar...");
			System.in.read();
			ler.nextLine();
		}
	}

	public static void Sorteio() {

		Random Gerador = new Random();
		CMorador auxF1;
		CMorador auxF2;
		CMorador morador;

		System.out.print("Informe a quantidade de moradias a serem " + "sorteadas para a FAIXA 1: ");
		int qtdeMoradiaFAIXA1 = ler.nextInt();

		System.out.print("\nInforme a quantidade de moradias a serem " + "sorteadas para a FAIXA 2: ");
		int qtdeMoradiaFAIXA2 = ler.nextInt();

		limpaTela();

		System.out.println("MORADORES SORTEADOS\n===================");

		System.out.println("\nFAIXA 1:");
		for (int i = 1; i <= qtdeMoradiaFAIXA1; i++) {
			auxF1 = (CMorador) F1.retornaIndice(Gerador.nextInt(F1.quantidade()) + 1);
			imprimeDadosCompletos(auxF1);
			F1.remove(auxF1.CPF);
			if (E1.quantidade() > 0) {
				morador = (CMorador) E1.removeRetornaComeco();
				F1.adicionar(morador.CPF, morador);
			}
		}

		System.out.println("\nFAIXA 2:");
		for (int i = 1; i <= qtdeMoradiaFAIXA2; i++) {
			auxF2 = (CMorador) F2.retornaIndice(Gerador.nextInt(F2.quantidade()) + 1);
			imprimeDadosCompletos(auxF2);
			F2.remove(auxF2.CPF);
			if (E2.quantidade() > 0) {
				morador = (CMorador) E2.removeRetornaComeco();
				F2.adicionar(morador.CPF, morador);
			}
		}
	}

	public static void filaDeEspera() throws IOException {

		int pag = 0, cont = 20, i = 1, j = 1;

		if (E1.quantidade() + E2.quantidade() != 0) {

			while (i <= E1.quantidade() || j <= E2.quantidade()) {

				if (cont >= 20) {
					cont = 1;
					pag++;
					System.out.println("\nLISTAGEM DA FILA DE ESPERA (PÁGINA " + pag + ")");
				}

				if (i <= E1.quantidade() && j == 1) {
					System.out.println("\nFAIXA 1\n");
				}

				while (cont <= 20 && i <= E1.quantidade()) {
					imprimeDadosSimples((CMorador) E1.retornaIndice(i));
					cont++;
					i++;
				}

				if (j <= E2.quantidade() && i > E1.quantidade() && cont <= 20) {
					System.out.println("\nFAIXA 2\n");
				}

				while (i > E1.quantidade() && cont <= 20 && j <= E2.quantidade()) {
					imprimeDadosSimples((CMorador) E2.retornaIndice(j));
					cont++;
					j++;
				}

				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				ler.nextLine();
				limpaTela();
			}

		} else {

			System.out.println("\nA fila de espera está vazia!");
			System.out.println("\nPressione ENTER para continuar...");
			System.in.read();
			ler.nextLine();
		}
	}

	public static void Parametros() {

		System.out.print("Determine um limite para a FAIXA 1: ");
		M1 = ler.nextInt();

		System.out.print("Determine um limite para a FAIXA 2: ");
		M2 = ler.nextInt();

		System.out.print("Determine um limite para a FILA DE ESPERA: ");
		N = ler.nextInt();

		System.out.println("\nParâmetros alterados com sucesso!");
	}

	public static void main(String[] args) throws IOException {

		ler = new Scanner(System.in);
		int op;
		
		CMorador a = new CMorador(10010010010l,"Ana Maria",3,650.85,"3198576594","Belo Horizonte","Minas Gerais","31210100","Ap. 705","Rua Sergipe",123,"Savassi");
		CMorador b = new CMorador(20020020020l,"João Pedro",2,740.69,"3189546312","Belo Horizonte","Minas Gerais","32100120","Ap. 202","Rua Amapá",340,"Savassi");
		CMorador c = new CMorador(30030030030l,"Luiz Carlos",1,1420.52,"3178542315","Belo Horizonte","Minas Gerais","33100220","Casa","Rua da Prata",213,"Savassi");
		
		F1.adicionar(10010010010l, a);
		E1.adicionar(20020020020l, b);
		F2.adicionar(30030030030l, c);

		do {
			System.out.println("PREFEITURA DE TANGAMANDÁPIO\n===========================\n\nMENU: "
					+ "\n\n1 - Cadastrar Morador " + "\n2 - Imprimir lista de moradores cadastrados "
					+ "\n3 - Imprimir fila de espera" + "\n4 - Pesquisar Morador" + "\n5 - Desistência / exclusão "
					+ "\n6 - Sorteio " + "\n7 - Paramêtros " + "\n8 - Sair");
			System.out.print("\nOpção: ");
			op = ler.nextInt();

			switch (op) {

			case 1:

				limpaTela();
				Cadastrar();
				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				limpaTela();
				break;

			case 2:

				int op2 = 0;

				while (op2 != 1 && op2 != 2) {

					limpaTela();
					System.out.println("1 - Listagem Simples (apenas CPF e nome do morador) "
							+ "\n2 - Listagem Completa (todos os dados)");
					System.out.print("\nOpção: ");
					op2 = ler.nextInt();

					if (op2 == 1) {
						limpaTela();
						listagemSimples();
						limpaTela();

					} else if (op2 == 2) {
						limpaTela();
						listagemCompleta();
						limpaTela();
					}
				}

				break;

			case 3:

				limpaTela();
				filaDeEspera();
				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				limpaTela();
				break;

			case 4:

				limpaTela();
				Pesquisar();
				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				limpaTela();
				break;

			case 5:

				limpaTela();
				Excluir();
				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				limpaTela();
				break;

			case 6:

				limpaTela();
				Sorteio();
				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				limpaTela();
				break;

			case 7:

				limpaTela();
				Parametros();
				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				limpaTela();
				break;

			case 8:

				limpaTela();
				System.out.println("Encerrando Programa...");
				break;

			default:

				limpaTela();
				System.out.println("Opção inválida!");
				System.out.println("\nPressione ENTER para continuar...");
				System.in.read();
				limpaTela();
			}

		} while (op != 8);
	}

}
