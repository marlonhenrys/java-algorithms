package crud;

import java.util.List;

import entidades.Monitor;
import interfaces.DAO;

public class MonitorDAO implements DAO<Monitor, Integer> {

	private static ArqMonitor<Monitor> arqMonitores;

	@Override
	public Monitor get(Integer chave) {
		Monitor monitor = null;

		try {
			arqMonitores = new ArqMonitor<>(Monitor.class.getConstructor(), "Monitores");

			monitor = (Monitor) arqMonitores.buscar(chave);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return monitor;
	}

	@Override
	public void add(Monitor item) {
		try {
			arqMonitores = new ArqMonitor<>(Monitor.class.getConstructor(), "Monitores");

			arqMonitores.incluir(item);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Monitor item) {
		try {
			arqMonitores = new ArqMonitor<>(Monitor.class.getConstructor(), "Monitores");

			arqMonitores.alterar(item);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer chave) {
		try {
			arqMonitores = new ArqMonitor<>(Monitor.class.getConstructor(), "Monitores");

			arqMonitores.excluir(chave);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Monitor> getAll() {
		List<Monitor> monitores = null;

		try {
			arqMonitores = new ArqMonitor<>(Monitor.class.getConstructor(), "Monitores");

			monitores = arqMonitores.listar();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return monitores;
	}
}
