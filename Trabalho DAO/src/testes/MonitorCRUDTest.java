package testes;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import crud.MonitorDAO;
import entidades.Monitor;

public class MonitorCRUDTest {
	
	private static MonitorDAO arqMonitor = new MonitorDAO();

	@Test
	public void addTest() {
		List<Monitor> lista = arqMonitor.getAll();
		int tamanho = lista.size();
		arqMonitor.add(new Monitor("nome", 111, "curso", "disciplina"));
		lista = arqMonitor.getAll();
		assertEquals("Erro ao inserir", (tamanho + 1), lista.size());
	}

	@Test
	public void getTest() {
		arqMonitor.add(new Monitor("nome", 222, "curso", "disciplina"));
		Monitor monitor = arqMonitor.get(222);
		assertEquals("Erro ao buscar", 222, monitor.getId());
	}

	@Test
	public void updateTest() {
		arqMonitor.add(new Monitor("nome", 333, "curso", "disciplina"));
		Monitor monitor = arqMonitor.get(333);
		monitor.setNome("novo nome");
		arqMonitor.update(monitor);
		Monitor novo = arqMonitor.get(333);
		assertEquals("Erro ao editar", "novo nome", novo.getNome());
	}

	@Test
	public void deleteTest() {
		arqMonitor.add(new Monitor("nome", 444, "curso", "disciplina"));
		arqMonitor.add(new Monitor("nome", 555, "curso", "disciplina"));
		List<Monitor> lista = arqMonitor.getAll();
		int tamanho = lista.size();
		arqMonitor.delete(444);
		lista = arqMonitor.getAll();
		assertEquals("Erro ao apagar", (tamanho - 1), lista.size());
	}
}
