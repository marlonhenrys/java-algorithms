package ex1;

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
	private JButton butOK, butCANCEL;
	private JTextField nome, sexo, idade, estadoCivil;
	private JLabel texto1, texto2, texto3, texto4;

	public JanelaGrafica() {
		super("Cadastro de Pessoa");
		Container cPane = this.getContentPane();
		cPane.setLayout(new FlowLayout());
		texto1 = new JLabel("Nome: ");
		texto2 = new JLabel("Sexo: ");
		texto3 = new JLabel("Idade: ");
		texto4 = new JLabel("Estado Civil: ");
		nome = new JTextField(20);
		sexo = new JTextField(7);
		idade = new JTextField(3);
		estadoCivil = new JTextField(10);
		butOK = new JButton("OK");
		butCANCEL = new JButton("CANCELAR");

		cPane.add(texto1);
		cPane.add(nome);
		cPane.add(texto2);
		cPane.add(sexo);
		cPane.add(texto3);
		cPane.add(idade);
		cPane.add(texto4);
		cPane.add(estadoCivil);
		cPane.add(butOK);
		cPane.add(butCANCEL);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		butOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!nome.getText().equals("") && !sexo.getText().equals("") && !idade.getText().equals("")
						&& !estadoCivil.getText().equals("")) {
					Pessoa p = new Pessoa(nome.getText(), sexo.getText(), Integer.parseInt(idade.getText()),
							estadoCivil.getText());
					limparCampos();
					JOptionPane.showMessageDialog(null, p, "Cadastro realizado com sucesso!",
							JOptionPane.DEFAULT_OPTION);
				}
			}
		});

		butCANCEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});

		this.pack();
	}

	private void limparCampos() {
		nome.setText("");
		sexo.setText("");
		idade.setText("");
		estadoCivil.setText("");
	}
}
