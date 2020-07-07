package estruturas;

public class Conta {
	private static long ultimaConta;
	private long numeroConta;
	private float saldo;

	public Conta() {
		setNumeroConta();
	}

	public Conta(float valor) {
		if (valor > 0) {
			setNumeroConta();
			saldo = valor;
		}
	}

	private void setNumeroConta() {
		numeroConta = ++ultimaConta;
	}

	public void sacar(float valor) {
		if (valor <= saldo && valor > 0)
			saldo -= valor;
	}

	public void depositar(float valor) {
		if (valor > 0)
			saldo += valor;
	}

	public long getNumeroConta() {
		return numeroConta;
	}

	public float getSaldo() {
		return saldo;
	}

}
