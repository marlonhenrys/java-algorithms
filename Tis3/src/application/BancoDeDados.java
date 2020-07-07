package application;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	private static int logado;
	private static String secDev, secCli, secDiv, secHist;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/tis?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "tis3";
		String driver = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null)
			return true;
		else
			return false;
	}

	public String getInfunc(String op1) {
		try {
			String retorno;
			this.statement = this.connection.createStatement();
			String querry = "SELECT * from funcionario where idFunc = " + logado + ";";
			this.resultset = this.statement.executeQuery(querry);
			if (this.resultset.next()) {
				retorno = this.resultset.getString(op1);
				return retorno;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public String getInfDev(String op1, String op2) {
		try {
			String retorno;
			this.statement = this.connection.createStatement();
			String querry = "SELECT * from devedor where "+op2+" = '" + secDev + "';";
			this.resultset = this.statement.executeQuery(querry);
			if (this.resultset.next()) {
				retorno = this.resultset.getString(op1);
				return retorno;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public String getInfCli(String op1, String op2) {
		try {
			String retorno;
			this.statement = this.connection.createStatement();
			String querry = "SELECT * from cliente where "+op2+" = '" + secCli + "';";
			this.resultset = this.statement.executeQuery(querry);
			if (this.resultset.next()) {
				retorno = this.resultset.getString(op1);
				return retorno;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public String getInfHist(String op1) {
		try {
			String retorno;
			this.statement = this.connection.createStatement();
			String querry = "SELECT * from historico where idhistorico = " + secHist + ";";
			this.resultset = this.statement.executeQuery(querry);
			if (this.resultset.next()) {
				retorno = this.resultset.getString(op1);
				return retorno;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public String getInfDiv(String op1) {
		try {
			String retorno;
			this.statement = this.connection.createStatement();
			String querry = "SELECT * from divida where iddivida = " + secDiv + ";";
			this.resultset = this.statement.executeQuery(querry);
			if (this.resultset.next()) {
				retorno = this.resultset.getString(op1);
				return retorno;
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public ArrayList<String> listarClientes(String coluna, String valor) {
		try {
			ArrayList<String> result = new ArrayList<String>();
			String querry = "SELECT * from cliente order by idCli";
			this.resultset = this.statement.executeQuery(querry);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {
				if (this.resultset.getString("" + coluna + "").equals(valor))
					result.add("ID: " + this.resultset.getString("idCli") + "\t\tNome: "+ this.resultset.getString("nomeCli") + 
							"\t\tCPF/CNPJ: " + this.resultset.getString("identidadeCli") + "\t\tTelefone: " + this.resultset.getString("telCli")+
							"\t\tE-mail: "+ this.resultset.getString("emailCli"));
			}
			return result;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}
	
	public ArrayList<String> listarDevedores(String coluna, String valor) {
		try {
			ArrayList<String> result = new ArrayList<String>();
			String querry = "SELECT * from devedor order by idDev";
			this.resultset = this.statement.executeQuery(querry);
			this.statement = this.connection.createStatement();
			while (this.resultset.next()) {
				if (this.resultset.getString("" + coluna + "").equals(valor))
					result.add("ID: " + this.resultset.getString("idDev") + "\t\tNome: "+ this.resultset.getString("nomeDev") + 
							"\t\tCPF/CNPJ: " + this.resultset.getString("identidadeDev") + "\t\tTelefone: " + this.resultset.getString("telDev")+
							"\t\tE-mail: "+ this.resultset.getString("emailDev"));
			}
			return result;
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return null;
	}

	public boolean login(String user, String senha) {
		try {
			this.statement = this.connection.createStatement();
			String querry = "SELECT * from funcionario where usuario = '" + user + "' and senhaFunc = '" + senha + "';";
			this.resultset = this.statement.executeQuery(querry);
			if (this.resultset.next()) {
				setLogado(this.resultset.getString("idFunc"));
				return true;
			} else
				JOptionPane.showMessageDialog(null, "Usuáro ou senha inválidos");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return false;
	}

	public boolean inserirCliente(String nome, String identidade, String email, String tel, String endereco) {
		try {
			String querry = "insert into cliente (nomeCli, identidadeCli, emailCli, telCli, endCli) values ('" + nome
					+ "', '" + identidade + "', '" + email + "', '" + tel + "', '" + endereco + "');";
			this.statement.executeUpdate(querry);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Já existe este cliente.");
			return false;
		}
	}

	public boolean inserirDevedor(String nome, String identidade, String email, String tel, String endereco) {
		try {
			String querry = "insert into devedor (nomeDev, emailDev, telDev, identidadeDev, endDev) values ('" + nome
					+ "', '" + email + "', '" + tel + "', '" + identidade + "', '" + endereco + "');";
			this.statement.executeUpdate(querry);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Já existe este devedor.");
			return false;
		}
	}

	public boolean inserirFuncionario(String user, String nome, String senha, int tipo, String cpf) {
		try {
			String querry = "insert into funcionario (nomeFunc, senhaFunc, tipoFunc, cpfFunc, usuario) values ('" + nome
					+ "', '" + senha + "', '" + tipo + "', '" + cpf + "', '" + user + "');";
			this.statement.executeUpdate(querry);
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Já existe este usuário.");
			return false;
		}
	}
	
	public void alterarCli(String nome, String identidade, String email, String tel, String end, String id) {
		try {
			String querry = "update cliente set nomeCli = '" + nome + "', identidadeCli = '" + identidade + "', emailCli = '" + email + "', telCli = '" + tel + "', endCli = '" + end + "'  where idCli = " + id + ";";
			this.statement.executeUpdate(querry);
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}
	}
	
	public void alterarDev(String nome, String identidade, String email, String tel, String end, String id) {
		try {
			String querry = "update devedor set nomeDev = '" + nome + "', identidadeDev = '" + identidade + "', emailDev = '" + email + "', telDev = '" + tel + "', endDev = '" + end + "'  where idDev = " + id + ";";
			this.statement.executeUpdate(querry);
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao atualizar");
		}
	}

	public void alterarSenha(String user, String novaSenha) {
		try {
			String querry = "update funcionario set senhaFunc = '" + novaSenha + "' where usuario = '" + user + "';";
			this.statement.executeUpdate(querry);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void alterarTipo(String cpf, int novoTipo) {
		try {
			String querry = "update funcionario set tipoFunc = '" + novoTipo + "' where cpfFunc = '" + cpf + "';";
			this.statement.executeUpdate(querry);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public static int getLogado() {
		return logado;
	}

	private static void setLogado(String logado) {
		BancoDeDados.logado = Integer.parseInt(logado);
	}

	public static void setSecDev(String secDev) {
		BancoDeDados.secDev = secDev;
	}

	public static void setSecCli(String secCli) {
		BancoDeDados.secCli = secCli;
	}

//	private static void setSecDiv(String secDiv) {
//		BancoDeDados.secDiv = Integer.parseInt(secDiv);
//	}
//
//	private static void setSecHist(String secHist) {
//		BancoDeDados.secHist = Integer.parseInt(secHist);
//	}
}
