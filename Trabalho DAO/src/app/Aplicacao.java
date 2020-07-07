package app;

import java.util.List;

import crud.AtendimentoDAO;
import crud.MonitorDAO;
import entidades.Atendimento;
import entidades.Monitor;

public class Aplicacao {

	private static Monitor monitorLogado = null;
	private static String coordenadorLogado = null;
	private static MonitorDAO monitorDAO = new MonitorDAO();
	private static AtendimentoDAO atendimentoDAO = new AtendimentoDAO();

	public static void main(String[] args) {
		int opcao;

		do {
			System.out.println("Sistema de Monitoria - ICEI/PUC Minas\n-------------------------------------\n"
					+ "0 - Encerrar\n\nAcessar como: \n\n1 - Monitor \n2 - Coordenador");
			System.out.print("-------------------------------------\nOpção: ");
			opcao = Teclado.readInt();

			switch (opcao) {
			case 1:
				clear();
				menuMonitor();
				clear();
				break;
			case 2:
				clear();
				menuCoordenador();
				clear();
				break;
			case 0:
				clear();
				System.out.println("\nPrograma Encerrado...");
				break;
			default:
				clear();
				System.out.println("\nOpção Inválida!");
				pause();
			}

		} while (opcao != 0);

	}

	private static void menuMonitor() {
		int opcao;

		do {
			System.out.print("Número de matrícula: ");
			int matricula = Teclado.readInt();
			monitorLogado = monitorDAO.get(matricula);
			clear();
		} while (monitorLogado == null);

		System.out.println("Logado como: " + monitorLogado.getNome());
		pause();

		do {
			System.out.println(
					"[MONITOR] Sistema de Monitoria - ICEI/PUC Minas\n-----------------------------------------------\n"
							+ "0 - Voltar\n\nAtendimentos: \n\n1 - Registrar \n2 - Alterar \n3 - Excluir \n4 - Buscar \n5 - Listar");
			System.out.print("-----------------------------------------------\nOpção: ");
			opcao = Teclado.readInt();

			switch (opcao) {
			case 1:
				clear();
				registrarAtendimento();
				clear();
				break;
			case 2:
				clear();
				editarAtendimento();
				clear();
				break;
			case 3:
				clear();
				excluirAtendimento();
				clear();
				break;
			case 4:
				clear();
				pesquisarAtendimento();
				clear();
				break;
			case 5:
				clear();
				listarAtendimentos();
				clear();
				break;
			case 0:
				break;
			default:
				clear();
				System.out.println("\nOpção Inválida!");
				pause();
			}

		} while (opcao != 0);

	}

	private static void menuCoordenador() {
		int opcao;

		do {
			System.out.print("Curso: ");
			coordenadorLogado = Teclado.readLine().toUpperCase();
			clear();
		} while (coordenadorLogado == null);

		do {
			System.out.println(
					"[COORDENADOR] Sistema de Monitoria - ICEI/PUC Minas\n---------------------------------------------------\n"
							+ "0 - Voltar\n\nMonitores: \n\n1 - Cadastrar \n2 - Alterar \n3 - Excluir \n4 - Buscar \n5 - Listar");
			System.out.print("---------------------------------------------------\nOpção: ");
			opcao = Teclado.readInt();

			switch (opcao) {
			case 1:
				clear();
				cadastrarMonitor();
				clear();
				break;
			case 2:
				clear();
				alterarMonitor();
				clear();
				break;
			case 3:
				clear();
				excluirMonitor();
				clear();
				break;
			case 4:
				clear();
				pesquisarMonitor();
				clear();
				break;
			case 5:
				clear();
				listarMonitores();
				clear();
				break;
			case 0:
				break;
			default:
				clear();
				System.out.println("\nOpção Inválida!");
				pause();
			}

		} while (opcao != 0);

	}

	private static void listarMonitores() {
		System.out.println("\nLISTA DE MONITORES\n------------------\n");
		List<Monitor> lista = monitorDAO.getAll();

		for (Monitor m : lista) {
			if (m.getCurso().equals(coordenadorLogado))
				System.out.println(m + "\n");
		}
		pause();
	}

	private static void excluirMonitor() {
		System.out.println("\nEXCLUSÃO DE MONITOR\n-------------------\n");

		int id;
		System.out.print("Número de matrícula do Monitor: ");
		id = Teclado.readInt();

		Monitor obj = monitorDAO.get(id);
		if ((obj != null && obj.getCurso().equals(coordenadorLogado))) {
			System.out.println("\n" + obj);

			monitorDAO.delete(id);
			System.out.println("\nMonitor excluído com sucesso!");

		} else
			System.out.println("\nMonitor não encontrado!");
		pause();
	}

	private static void alterarMonitor() {
		System.out.println("\nALTERAÇÃO DE MONITOR\n-------------------\n");

		int id;
		System.out.print("Número de matrícula do Monitor: ");
		id = Teclado.readInt();

		Monitor obj = monitorDAO.get(id);
		if ((obj != null && obj.getCurso().equals(coordenadorLogado))) {
			System.out.println("\n" + obj);
			System.out.println("\nPreencha com os novos dados:\n");
			System.out.print("Nome: ");
			obj.setNome(Teclado.readLine());
			System.out.print("Disciplina: ");
			obj.setDisciplina(Teclado.readLine());
			monitorDAO.update(obj);

			System.out.println("\nCadastro alterado com sucesso!");

		} else
			System.out.println("\nMonitor não encontrado!");
		pause();
	}

	private static void cadastrarMonitor() {
		System.out.println("\nCADASTRO DE MONITOR\n-------------------\n");
		System.out.print("Nome: ");
		String nome = Teclado.readLine();
		System.out.print("Matrícula: ");
		int matricula = Teclado.readInt();
		System.out.print("Disciplina: ");
		String disciplina = Teclado.readLine();

		Monitor monitor = new Monitor(nome, matricula, coordenadorLogado, disciplina);
		monitorDAO.add(monitor);

		System.out.println("\nCadastro realizado com sucesso!");
		pause();
	}

	private static void listarAtendimentos() {
		System.out.println("\nLISTA DE ATENDIMENTOS\n---------------------\n");
		List<Atendimento> lista = atendimentoDAO.getAll();

		for (Atendimento a : lista) {
			if (a.getMonitorID() == monitorLogado.getId())
				System.out.println(a + "\n");
		}
		pause();
	}

	private static void excluirAtendimento() {
		System.out.println("\nEXCLUSÃO DE REGISTRO DE ATENDIMENTO\n-----------------------------------\n");

		int id;
		System.out.print("ID do registro: ");
		id = Teclado.readInt();

		Atendimento obj = atendimentoDAO.get(id);
		if ((obj != null && obj.getMonitorID() == monitorLogado.getId())) {
			System.out.println("\n" + obj);

			atendimentoDAO.delete(id);
			System.out.println("\nRegistro excluído com sucesso!");

		} else
			System.out.println("\nRegistro não encontrado!");
		pause();
	}

	private static void editarAtendimento() {
		System.out.println("\nALTERAÇÃO DE REGISTRO DE ATENDIMENTO\n------------------------------------\n");

		int id;
		System.out.print("ID do registro: ");
		id = Teclado.readInt();

		Atendimento obj = atendimentoDAO.get(id);
		if ((obj != null && obj.getMonitorID() == monitorLogado.getId())) {
			System.out.println("\n" + obj);
			System.out.println("\nPreencha com os novos dados:\n");
			System.out.print("Data: ");
			obj.setData(Teclado.readLine());
			System.out.print("Matrícula do aluno: ");
			obj.setAlunoID(Teclado.readInt());
			System.out.print("Nome do aluno: ");
			obj.setNomeAluno(Teclado.readLine());
			System.out.print("Assunto: ");
			obj.setAssunto(Teclado.readLine());
			atendimentoDAO.update(obj);

			System.out.println("\nRegistro alterado com sucesso!");

		} else
			System.out.println("\nRegistro não encontrado!");
		pause();
	}

	private static void registrarAtendimento() {
		System.out.println("\nREGISTRO DE ATENDIMENTO\n----------------------\n");
		System.out.print("Data: ");
		String data = Teclado.readLine();
		System.out.print("Matrícula do aluno: ");
		int matricula = Teclado.readInt();
		System.out.print("Nome do aluno: ");
		String nome = Teclado.readLine();
		System.out.print("Assunto: ");
		String assunto = Teclado.readLine();

		Atendimento atendimento = new Atendimento(monitorLogado.getMatricula(), data, matricula, nome, assunto);
		atendimentoDAO.add(atendimento);

		System.out.println("\nRegistro realizado com sucesso!");
		pause();
	}

	private static void pesquisarMonitor() {
		System.out.println("\nPESQUISA DE MONITOR\n-------------------\n");

		int id;
		System.out.print("Número de matrícula do Monitor: ");
		id = Teclado.readInt();

		Monitor obj = monitorDAO.get(id);
		if ((obj != null && obj.getCurso().equals(coordenadorLogado)))
			System.out.println("\n" + obj);

		else
			System.out.println("\nMonitor não encontrado!");
		pause();
	}

	private static void pesquisarAtendimento() {
		System.out.println("\nPESQUISA DE REGISTRO DE ATENDIMENTO\n-----------------------------------\n");

		int id;
		System.out.print("ID do registro: ");
		id = Teclado.readInt();

		Atendimento obj = atendimentoDAO.get(id);
		if ((obj != null && obj.getMonitorID() == monitorLogado.getId()))
			System.out.println("\n" + obj);

		else
			System.out.println("\nRegistro não encontrado!");
		pause();
	}

	public static void pause() {
		System.out.println("\nPressione ENTER para continuar...");
		Teclado.readLine();
		for (int i = 0; i < 50; i++)
			System.out.println();
	}

	public static void clear() {
		for (int i = 0; i < 50; i++)
			System.out.println();
	}
}
