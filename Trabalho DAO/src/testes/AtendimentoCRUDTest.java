package testes;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import crud.AtendimentoDAO;
import entidades.Atendimento;

public class AtendimentoCRUDTest {

	@Test
	public void addTest() {
		AtendimentoDAO arqAtendimento = new AtendimentoDAO();
		List<Atendimento> lista = arqAtendimento.getAll();
		int tamanho = lista.size();
		arqAtendimento.add(new Atendimento(111, "19/05/2019", 112, "nome", "assunto"));
		lista = arqAtendimento.getAll();
		assertEquals("Erro ao inserir", (tamanho + 1), lista.size());
	}

	@Test
	public void getTest() {
		AtendimentoDAO arqAtendimento = new AtendimentoDAO();
		arqAtendimento.add(new Atendimento(111, "19/05/2019", 113, "nome", "assunto"));
		Atendimento atendimento = arqAtendimento.get(1);
		assertEquals("Erro ao buscar", 1, atendimento.getId());
	}

	@Test
	public void updateTest() {
		AtendimentoDAO arqMonitor = new AtendimentoDAO();
		arqMonitor.add(new Atendimento(111, "19/05/2019", 114, "nome", "assunto"));
		Atendimento atendimento = arqMonitor.get(1);
		atendimento.setData("20/05/2019");
		arqMonitor.update(atendimento);
		Atendimento novo = arqMonitor.get(1);
		assertEquals("Erro ao editar", "20/05/2019", novo.getData());
	}

	@Test
	public void deleteTest() {
		AtendimentoDAO arqAtendimento = new AtendimentoDAO();
		arqAtendimento.add(new Atendimento(111, "19/05/2019", 115, "nome", "assunto"));
		arqAtendimento.add(new Atendimento(111, "19/05/2019", 116, "nome", "assunto"));
		List<Atendimento> lista = arqAtendimento.getAll();
		int tamanho = lista.size();
		arqAtendimento.delete(2);
		lista = arqAtendimento.getAll();
		assertEquals("Erro ao apagar", (tamanho - 1), lista.size());
	}
}
