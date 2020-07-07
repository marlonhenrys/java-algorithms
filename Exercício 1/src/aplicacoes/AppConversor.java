package aplicacoes;

import javax.swing.JOptionPane;

import estruturas.Conversor;

public class AppConversor {

	public static void main(String[] args) {

		Conversor medidas = new Conversor();
		float original, convertido;
		int opcao;

		do {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma conversão:\n"
					+ "\n1 - Centímetros para Metros\n2 - Centímetros para Pés\n3 - Centímetros para Polegadas"
					+ "\n4 - Metros para Centímetros\n5 - Metros para Pés\n6 - Metros para Polegadas\n7 - Pés para Centímetros"
					+ "\n8 - Pés para Metros\n9 - Pés para Polegadas\n10 - Polegadas para Centímetros\n11 - Polegadas para Metros"
					+ "\n12 - Polegadas para Pés\n\n0 - SAIR\n\nOpção:"));

			switch (opcao) {

			case 0:
				JOptionPane.showMessageDialog(null, "Programa Encerrado!");
				break;

			case 1:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em centímetros:"));
				convertido = (float) medidas.converterCentimetrosParaMetros(original);
				JOptionPane.showMessageDialog(null, "Valor em metros: " + convertido);
				break;

			case 2:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em centímetros:"));
				convertido = (float) medidas.converterCentimetrosParaPes(original);
				JOptionPane.showMessageDialog(null, "Valor em pés: " + convertido);
				break;

			case 3:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em centímetros:"));
				convertido = (float) medidas.converterCentimetrosParaPolegadas(original);
				JOptionPane.showMessageDialog(null, "Valor em polegadas: " + convertido);
				break;

			case 4:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em metros:"));
				convertido = (float) medidas.converterMetrosParaCentimetros(original);
				JOptionPane.showMessageDialog(null, "Valor em centímetros: " + convertido);
				break;

			case 5:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em metros:"));
				convertido = (float) medidas.converterMetrosParaPes(original);
				JOptionPane.showMessageDialog(null, "Valor em pés: " + convertido);
				break;
			case 6:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterMetrosParaPolegadas(original);
				JOptionPane.showMessageDialog(null, "Valor em polegadas: " + convertido);
				break;
			case 7:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em pés:"));
				convertido = (float) medidas.converterPesParaCentimetros(original);
				JOptionPane.showMessageDialog(null, "Valor em centímetros: " + convertido);
				break;

			case 8:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em pés:"));
				convertido = (float) medidas.converterPesParaMetros(original);
				JOptionPane.showMessageDialog(null, "Valor em metros: " + convertido);
				break;
			case 9:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em pés:"));
				convertido = (float) medidas.converterPesParaPolegadas(original);
				JOptionPane.showMessageDialog(null, "Valor em polegadas: " + convertido);
				break;
			case 10:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterPolegadasParaCentimetros(original);
				JOptionPane.showMessageDialog(null, "Valor em centímetros: " + convertido);
				break;
			case 11:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterPolegadasParaMetros(original);
				JOptionPane.showMessageDialog(null, "Valor em metros: " + convertido);
				break;
			case 12:
				original = Float.parseFloat(JOptionPane.showInputDialog("Valor em polegadas:"));
				convertido = (float) medidas.converterPolegadasParaPes(original);
				JOptionPane.showMessageDialog(null, "Valor em pés: " + convertido);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}

		} while (opcao != 0);

	}

}
