import javax.swing.JOptionPane;

public class atividade1 { // i-�simo termo de Fibonacci

	public static int fibonacci(int pos) {

		if (pos == 0 || pos == 1)
			return pos;

		else
			return fibonacci(pos - 1) + fibonacci(pos - 2);

	}

	public static void main(String[] args) {

		StopWatch tempo = new StopWatch();

		int i = Integer.parseInt(JOptionPane.showInputDialog("Digite uma posi��o:"));

		tempo.start();
		System.out.println("Termo: " + fibonacci(i));
		tempo.stop();

		System.out.println("\nTempo de execu��o: " + tempo.getTime() + " nanossegundos");

	}
}