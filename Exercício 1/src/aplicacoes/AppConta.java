package aplicacoes;

import javax.swing.JOptionPane;

import estruturas.Conta;

public class AppConta {

	public static void main(String[] args) {

		Conta poupanca_maria = new Conta(1000);
		Conta poupanca_pedro = new Conta();
		float valor;

		System.out.println(
				"[Maria] Conta: " + poupanca_maria.getNumeroConta() + " | Saldo: R$ " + poupanca_maria.getSaldo());
		System.out.println(
				"[Pedro] Conta: " + poupanca_pedro.getNumeroConta() + " | Saldo: R$ " + poupanca_pedro.getSaldo());

		valor = Float.parseFloat(JOptionPane.showInputDialog("Informe um valor para transferência:"));
		System.out.println("\nTransferindo R$ " + valor + " de Maria para Pedro...\n");

		poupanca_maria.sacar(valor);
		poupanca_pedro.depositar(valor);

		System.out.println(
				"[Maria] Conta: " + poupanca_maria.getNumeroConta() + " | Saldo: R$ " + poupanca_maria.getSaldo());
		System.out.println(
				"[Pedro] Conta: " + poupanca_pedro.getNumeroConta() + " | Saldo: R$ " + poupanca_pedro.getSaldo());

	}

}
