package estruturas;
public class Instanciadora {
	private static int id = 0;
	private String tipoInstancia;

	public Instanciadora(String tipoRequerido) {
		id = id + 1;
		tipoInstancia = tipoRequerido;
	}

	public String toString() {
		return "Tipo: " + tipoInstancia + ", Id: " + id + "; ";
	}

	public static void main(String[] args) {
		Instanciadora[] instancias = new Instanciadora[2];
		instancias[0] = new Instanciadora("Prod");
		instancias[1] = new Instanciadora("Obj");
		for (int i = 0; i < 2; i++)
			System.out.print(instancias[i]);
		System.out.println();
	}
}
