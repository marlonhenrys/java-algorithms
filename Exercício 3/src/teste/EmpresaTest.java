package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import entidades.ClienteFisico;
import entidades.ClienteJuridico;
import entidades.Empresa;
import entidades.Funcionario;

public class EmpresaTest {

	@Test
	public void addFuncionarioTest() {
		Funcionario func = new Funcionario("nomeFuncionario", "Bteste", "Cteste", "Dteste", "Eteste", "Fteste", "Geste",
				"Hteste", 954.50F);
		Empresa modular = new Empresa("1teste", "2teste", "3teste", "4teste", "5teste", "6teste", "7teste");

		modular.addFuncionario(func);

		ArrayList<Funcionario> listaFunc = modular.getFuncionarios();
		assertEquals("erro ao adicionar funcionário", listaFunc.get(0), func);
		assertEquals("erro na lista de funcionários", listaFunc.size(), 1);
	}

	@Test
	public void addClienteFisicoTest() {
		ClienteFisico clienteFis = new ClienteFisico("nomeClienteFisico", "Bteste", "Cteste", "Dteste", "Eteste",
				"Fteste", "Hteste", 954.50F);
		Empresa modular = new Empresa("1teste", "2teste", "3teste", "4teste", "5teste", "6teste", "7teste");

		modular.addClienteFisico(clienteFis);

		ArrayList listaClientes = modular.getClientes();
		ClienteFisico aux = (ClienteFisico) listaClientes.get(0);

		assertEquals("erro ao adicionar cliente físico", aux.getNome(), clienteFis.getNome());
		assertEquals("erro na lista de clientes", listaClientes.size(), 1);
	}

	@Test
	public void addClienteJuridicoTest() {
		ClienteJuridico clienteJur = new ClienteJuridico("nomeClienteJuridico", "Bteste", "Cteste", "Dteste", "Eteste",
				"Fteste", "Hteste", 954.50F);
		Empresa modular = new Empresa("1teste", "2teste", "3teste", "4teste", "5teste", "6teste", "7teste");

		modular.addClienteJuridico(clienteJur);

		ArrayList listaClientes = modular.getClientes();
		ClienteJuridico aux = (ClienteJuridico) listaClientes.get(0);

		assertEquals("erro ao adicionar cliente físico", aux.getNome(), clienteJur.getNome());
		assertEquals("erro na lista de clientes", listaClientes.size(), 1);
	}

}
