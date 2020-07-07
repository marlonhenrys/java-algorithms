package aplicacoes;

import javax.swing.JOptionPane;

import estruturas.Data;

public class AppData {

	public static void main(String[] args) {

		Data hoje = new Data();
		Data data = new Data();

		JOptionPane.showMessageDialog(null,
				"Data de hoje: " + hoje.getDia() + "/" + hoje.getMes() + "/" + hoje.getAno());

		JOptionPane.showMessageDialog(null,
				"Dia da semana: " + hoje.diaDaSemana(hoje.getDia(), hoje.getMes(), hoje.getAno()));

		hoje.proximoDia();
		JOptionPane.showMessageDialog(null,
				"Data de amanhã: " + hoje.getDia() + "/" + hoje.getMes() + "/" + hoje.getAno());

		JOptionPane.showMessageDialog(null, "Quantidade de dias deste mês: " + hoje.diasNoMes());

		if (hoje.eAnoBisexto())
			JOptionPane.showMessageDialog(null, "Este ano é bisexto!");
		else
			JOptionPane.showMessageDialog(null, "Este ano não é bisexto!");

		data.adicionaDias(7);
		JOptionPane.showMessageDialog(null,
				"Data da próxima " + data.diaDaSemana(data.getDia(), data.getMes(), data.getAno()) + ": "
						+ data.getDia() + "/" + data.getMes() + "/" + data.getAno());
	}

}
