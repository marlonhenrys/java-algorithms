package crud;

import java.util.List;

import entidades.Atendimento;
import interfaces.DAO;

public class AtendimentoDAO implements DAO<Atendimento, Integer> {

	private static ArqAtendimento<Atendimento> arqAtendimentos;

	@Override
	public Atendimento get(Integer chave) {
		Atendimento atendimento = null;

		try {
			arqAtendimentos = new ArqAtendimento<>(Atendimento.class.getConstructor(), "Atendimentos");

			atendimento = (Atendimento) arqAtendimentos.buscar(chave);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return atendimento;
	}

	@Override
	public void add(Atendimento item) {
		try {
			arqAtendimentos = new ArqAtendimento<>(Atendimento.class.getConstructor(), "Atendimentos");

			arqAtendimentos.incluir(item);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void update(Atendimento item) {
		try {
			arqAtendimentos = new ArqAtendimento<>(Atendimento.class.getConstructor(), "Atendimentos");

			arqAtendimentos.alterar(item);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer chave) {
		try {
			arqAtendimentos = new ArqAtendimento<>(Atendimento.class.getConstructor(), "Atendimentos");

			arqAtendimentos.excluir(chave);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Atendimento> getAll() {
		List<Atendimento> atendimentos = null;

		try {
			arqAtendimentos = new ArqAtendimento<>(Atendimento.class.getConstructor(), "Atendimentos");

			atendimentos = arqAtendimentos.listar();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return atendimentos;

	}
}
