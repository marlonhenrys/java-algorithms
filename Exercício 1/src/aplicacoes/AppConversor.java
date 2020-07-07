package aplicacoes;

import javax.swing.JOptionPane;

import estruturas.Conversor;

public class AppConversor {

	public static void main(String[] args) {

		Conversor medidas = new Conversor();
		float original, convertido;
		int opcao;

		do {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma convers�o:\n"
					+ "\n1 - Cent�metros para Metros\n2 - Cent�metros para P�s\n3 - Cent�metros para Polegadas"
					+ "\n4 - Metros para Cent�metros\n5 - Metros para P�s\n6 - Metros para Polegadas\n7 - P�s para Cent�metros"
					+ "\n8 - P�s para Metros\n9 - P�s para Polegadas\n10 - Polegadas para Cent�metros\n11 - Polegadas para Metros"
					+ "\n12 - Polegadas para P�s\n\n0 - SAIR\n\nOp��o:"));

			switch (opcao) {

			case 0:
				JOptionPane.showMessageDialog(null, "Programa Encerrado!");
				break;

			case 1:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em cent�metros:"));
				convertido = (float) medidas.converterCentimetrosParaMetros(original);
				JOptionPane.showMessageDialog(null, "Valor em metros: " + convertido);
				break;

			case 2:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em cent�metros:"));
				convertido = (float) medidas.converterCentimetrosParaPes(original);
				JOptionPane.showMessageDialog(null, "Valor em p�s: " + convertido);
				break;

			case 3:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em cent�metros:"));
				convertido = (float) medidas.converterCentimetrosParaPolegadas(original);
				JOptionPane.showMessageDialog(null, "Valor em polegadas: " + convertido);
				break;

			case 4:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em metros:"));
				convertido = (float) medidas.converterMetrosParaCentimetros(original);
				JOptionPane.showMessageDialog(null, "Valor em cent�metros: " + convertido);
				break;

			case 5:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em metros:"));
				convertido = (float) medidas.converterMetrosParaPes(original);
				JOptionPane.showMessageDialog(null, "Valor em p�s: " + convertido);
				break;
			case 6:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterMetrosParaPolegadas(original);
				JOptionPane.showMessageDialog(null, "Valor em polegadas: " + convertido);
				break;
			case 7:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em p�s:"));
				convertido = (float) medidas.converterPesParaCentimetros(original);
				JOptionPane.showMessageDialog(null, "Valor em cent�metros: " + convertido);
				break;

			case 8:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em p�s:"));
				convertido = (float) medidas.converterPesParaMetros(original);
				JOptionPane.showMessageDialog(null, "Valor em metros: " + convertido);
				break;
			case 9:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em p�s:"));
				convertido = (float) medidas.converterPesParaPolegadas(original);
				JOptionPane.showMessageDialog(null, "Valor em polegadas: " + convertido);
				break;
			case 10:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterPolegadasParaCentimetros(original);
				JOptionPane.showMessageDialog(null, "Valor em cent�metros: " + convertido);
				break;
			case 11:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterPolegadasParaMetros(original);
				JOptionPane.showMessageDialog(null, "Valor em metros: " + convertido);
				break;
			case 12:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterPolegadasParaPes(original);
				JOptionPane.showMessageDialog(null, "Valor em p�s: " + convertido);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
			}

		} while (opcao != 0);

	}

}
