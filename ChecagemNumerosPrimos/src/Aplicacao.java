import java.util.ArrayList;
import java.util.Random;

public class Aplicacao {

	public static void main(String[] args) {
		double soma, media, dp;
		StopWatch clock = new StopWatch();
		Random rand = new Random();
		ArrayList<Double> temposAKS = new ArrayList<Double>();
		ArrayList<Double> temposERA = new ArrayList<Double>();
		ArrayList<Double> temposRAB = new ArrayList<Double>();
		ArrayList<Double> desviosAKS = new ArrayList<Double>();
		ArrayList<Double> desviosERA = new ArrayList<Double>();
		ArrayList<Double> desviosRAB = new ArrayList<Double>();

		for (int i = 10000000; i <= 10000010; i++) {

			int num = rand.nextInt(1000) + 1;

			System.out.println("\n\nUtilizando AKS...");
			clock.start();
			AKS.verifica(num);
			clock.stop();
			temposAKS.add(clock.getTime());

			System.out.println("\n\nUtilizando Erat�stenes...");
			clock.start();
			Eratostenes.verifica(num);
			clock.stop();
			temposERA.add(clock.getTime());

			System.out.println("\n\nUtilizando Miller Rabin...");
			clock.start();
			MillerRabin.verifica(num);
			clock.stop();
			temposRAB.add(clock.getTime());

		}

		soma = 0;

		for (double tempo : temposAKS)
			soma += tempo;

		media = soma / temposAKS.size();

		for (double tempo : temposAKS)
			desviosAKS.add(Math.pow((tempo - media), 2));

		soma = 0;

		for (double desvio : desviosAKS)
			soma += desvio;

		dp = Math.sqrt(soma / desviosAKS.size());

		System.out.println("\n\n\nM�dia AKS: " + media);
		System.out.println("\nDesvio Padr�o AKS: " + dp);

		soma = 0;
		dp = 0;
		media = 0;

		for (double tempo : temposERA)
			soma += tempo;

		media = soma / temposERA.size();

		for (double tempo : temposERA)
			desviosERA.add(Math.pow((tempo - media), 2));

		soma = 0;

		for (double desvio : desviosERA)
			soma += desvio;

		dp = Math.sqrt(soma / desviosERA.size());

		System.out.println("\nM�dia ERAT�STENES: " + media);
		System.out.println("\nDesvio Padr�o ERAT�STENES: " + dp);

		soma = 0;
		dp = 0;
		media = 0;

		for (double tempo : temposRAB)
			soma += tempo;

		media = soma / temposRAB.size();

		for (double tempo : temposRAB)
			desviosRAB.add(Math.pow((tempo - media), 2));

		soma = 0;

		for (double desvio : desviosRAB)
			soma += desvio;

		dp = Math.sqrt(soma / desviosRAB.size());

		System.out.println("\nM�dia MILLER RABIN: " + media);
		System.out.println("\nDesvio Padr�o MILLER RABIN: " + dp);

		System.out.println("\n----- AKS -----\n");
		for (double tempo : temposAKS)
			System.out.println(tempo);

		System.out.println("\n----- ERAT�STENES -----\n");
		for (double tempo : temposERA)
			System.out.println(tempo);

		System.out.println("\n----- MILLER RABIN -----\n");
		for (double tempo : temposRAB)
			System.out.println(tempo);

	}
}