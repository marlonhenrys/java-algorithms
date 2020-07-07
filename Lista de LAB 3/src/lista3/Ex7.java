package lista3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex7 {

	static Scanner ler = new Scanner(System.in);

	public static void run() {
		ArrayList<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
		ArrayList<Tarefa> tarefasAFazer = new ArrayList<Tarefa>();

		int qtde, tempo = 0;

		System.out.print("Informe a quantidade de tarefas: ");
		qtde = ler.nextInt();
		ler.nextLine();

		for (int i = 0; i < qtde; i++) {
			System.out.print("\nNome da tarefa: ");
			String nome = ler.next();
			System.out.print("\nTempo de duração (minutos): ");
			int duracao = ler.nextInt();
			ler.nextLine();

			listaDeTarefas.add(new Tarefa(nome, duracao));
		}

		System.out.print("\n\nTempo disponível (minutos): ");
		tempo = ler.nextInt();
		ler.nextLine();

		int tempoLivre;
		int IDtarefa;

		do {

			tempoLivre = tempoLivre(tarefasAFazer, tempo);
			IDtarefa = melhorOpcao(listaDeTarefas, tempoLivre);
			if (IDtarefa != -1) {
				tarefasAFazer.add(listaDeTarefas.get(IDtarefa));
				listaDeTarefas.remove(IDtarefa);
			}

		} while (tempoLivre > 0 && IDtarefa != -1);

		imprime(tarefasAFazer);
	}

	private static int melhorOpcao(ArrayList<Tarefa> lista, int tempoLivre) {
		int menor = lista.get(0).getDuracao(), pos = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getDuracao() < menor) {
				menor = lista.get(i).getDuracao();
				pos = i;
			}
		}

		if (lista.get(pos).getDuracao() <= tempoLivre)
			return pos;

		return -1;
	}

	private static int tempoLivre(ArrayList<Tarefa> lista, int tempo) {
		int tempoTotal = 0;
		for (Tarefa tarefa : lista)
			tempoTotal += tarefa.getDuracao();

		return (tempo - tempoTotal);
	}

	private static void imprime(ArrayList<Tarefa> lista) {
		System.out.println("\n\nTarefas a serem realizadas:\n");
		for (Tarefa tarefa : lista)
			System.out.println("Nome: " + tarefa.getNome() + " - Duração: " + tarefa.getDuracao());
	}
}

class Tarefa {
	private String nome;
	private int duracao;

	Tarefa(String nome, int duracao) {
		this.nome = nome;
		this.duracao = duracao;
	}

	Tarefa(Tarefa tarefa) {
		this.nome = tarefa.getNome();
		this.duracao = tarefa.getDuracao();
	}

	public String getNome() {
		return this.nome;
	}

	public int getDuracao() {
		return this.duracao;
	}
}
