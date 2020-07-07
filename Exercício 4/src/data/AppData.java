package data;

import javax.swing.JOptionPane;

public class AppData {

	public static void main(String[] args) {

		Data hoje = new Data();
		Data data = new Data();

		JOptionPane.showMessageDialog(null, "Hoje: " + hoje.toString());
		JOptionPane.showMessageDialog(null, "Data: " + data.toString());

		if (data.equals(hoje))
			JOptionPane.showMessageDialog(null, "As datas são iguais.");
	}
}
