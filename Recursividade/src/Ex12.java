import javax.swing.JOptionPane;

public class Ex12 {

	public static void solucaoHanoi(int qtde) {
		solucaoHanoi(qtde, 1, 3, 2);
	}

	public static void solucaoHanoi(int qtde, int Origem, int Destino, int Aux) {

		if (qtde > 0) {
			solucaoHanoi(qtde - 1, Origem, Aux, Destino);
			System.out.println("Mova o disco do pino " + Origem + " para o pino " + Destino);
			solucaoHanoi(qtde - 1, Aux, Destino, Origem);
		}
	}

	public static void main(String[] args) {

		solucaoHanoi(Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de discos: ")));
	}
}