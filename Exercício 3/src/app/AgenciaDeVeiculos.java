package app;

import veiculos.Caminhao;
import veiculos.Carro;
import veiculos.Fiat;
import veiculos.Sedan;

public class AgenciaDeVeiculos {

	public static void main(String[] args) {

		Carro car = new Carro(180, 35000, "Branco");
		Caminhao truck = new Caminhao(130, 95000, "Azul", 1800);
		Fiat uno = new Fiat(200, 27000, "Verde", 3500);
		Sedan civic = new Sedan(240, 75000, "Cinza", 2);

		System.out.println("[Carro] Velocidade: " + car.getVelocidade() + " km/h, Pre�o: R$ " + car.getPrecoVenda()
				+ ", Cor: " + car.getCor());

		System.out.println("\n[Caminh�o] Velocidade: " + truck.getVelocidade() + " km/h, Pre�o: R$ "
				+ truck.getPrecoVenda() + ", Cor: " + truck.getCor() + ", Carga: " + truck.getCarga() + " kg");

		System.out.println("\n[Fiat Uno] Velocidade: " + uno.getVelocidade() + " km/h, Pre�o: R$ " + uno.getPrecoVenda()
				+ ", Cor: " + uno.getCor() + ", Desconto de F�brica: R$ " + uno.getDescontoDeFabrica());

		System.out.println(
				"\n[Civic Sedan] Velocidade: " + civic.getVelocidade() + " km/h, Pre�o: R$ " + civic.getPrecoVenda()
						+ ", Cor: " + civic.getCor() + ", Comprimento: " + civic.getComprimento() + " m");
	}
}
