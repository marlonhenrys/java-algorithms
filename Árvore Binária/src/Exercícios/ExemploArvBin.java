package Exercícios;

public class ExemploArvBin {

	public static void main(String[] args) {
		CArvBin ab = new CArvBin();
		ab.adicionar(10);
		ab.adicionar(15);
		ab.adicionar(5);
		ab.adicionar(12);
		ab.adicionar(35);
		ab.adicionar(3);
		ab.adicionar(31);
		ab.adicionar(28);
		ab.adicionar(43);
		ab.adicionar(10);

		ab.imprimir(1);
		ab.imprimir(2);
		ab.imprimir(3);

		ab.delete(43);

		ab.imprimir(1);
		ab.imprimir(2);
		ab.imprimir(3);

		ab.delete(31);

		ab.imprimir(1);
		ab.imprimir(2);
		ab.imprimir(3);

		ab.delete(10);

		ab.imprimir(1);
		ab.imprimir(2);
		ab.imprimir(3);

		if (ab.contem(5))
			System.out.println("Tem o 5");
		else
			System.out.println("Nao tem o 5");

		if (ab.contem(6))
			System.out.println("Tem o 6");
		else
			System.out.println("Nao tem o 6");
	}
}
