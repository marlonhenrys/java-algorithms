package application;

public class test {

	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados();
		bd.conectar();
		if(bd.estaConectado()) {
			for(int i = 0; i < bd.listarClientes("nomeCli", "aa").size(); i++) {   
			    System.out.print(bd.listarClientes("nomeCli", "aa").get(i) + "\n\n");
			} 
		}

	}

}
