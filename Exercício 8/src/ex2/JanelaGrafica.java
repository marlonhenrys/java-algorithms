package ex2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JanelaGrafica extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton butADD, butSUB, butDIV, butMULT;
	private JTextField campo;
	private JLabel texto;
	private String operando1 = null, operando2 = null;
	private int operador;

	public JanelaGrafica() {
		super("Calculadora Simples");
		Container cPane = this.getContentPane();
		cPane.setLayout(new FlowLayout());
		texto = new JLabel("Valor: ");
		campo = new JTextField(5);
		butADD = new JButton("+");
		butSUB = new JButton("—");
		butDIV = new JButton("/");
		butMULT = new JButton("x");

		cPane.add(texto);
		cPane.add(campo);
		cPane.add(butADD);
		cPane.add(butSUB);
		cPane.add(butMULT);
		cPane.add(butDIV);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		butADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!campo.getText().equals(""))
					calcular(1);
			}
		});

		butSUB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!campo.getText().equals(""))
					calcular(2);
			}
		});

		butMULT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!campo.getText().equals(""))
					calcular(3);
			}
		});

		butDIV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!campo.getText().equals(""))
					calcular(4);
			}
		});

		this.pack();
	}

	private void calcular(int codigo) {
		if (operador == 0 && codigo != -1)
			operador = codigo;
		if (operando1 == null) {
			operando1 = campo.getText();
			campo.setText("");
		} else if (operando2 == null)
			operando2 = campo.getText();

		if (codigo == operador && operando1 != null && operando2 != null) {
			int x = Integer.parseInt(operando1);
			int y = Integer.parseInt(operando2);
			int z = 0;
			char simbol = ' ';

			campo.setText("");

			switch (operador) {
			case 1:
				z = x + y;
				simbol = '+';
				break;
			case 2:
				z = x - y;
				simbol = '-';
				break;
			case 3:
				z = x * y;
				simbol = 'x';
				break;
			case 4:
				z = x / y;
				simbol = '/';
				break;
			}

			JOptionPane.showMessageDialog(null, x + " " + simbol + " " + y + " = " + z, "Resultado",
					JOptionPane.DEFAULT_OPTION);

			operando1 = null;
			operando2 = null;
			operador = 0;
			campo.setEditable(true);

		} else if (codigo != operador && operando1 != null && operando2 != null) {
			campo.setEditable(false);
			JOptionPane.showMessageDialog(null, "Clique no mesmo botão!", "Aviso:", JOptionPane.WARNING_MESSAGE);
		}
	}
}
