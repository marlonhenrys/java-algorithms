package application;

import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField user;

	@FXML
	private PasswordField pass;

	@FXML
	private void verifyLog(MouseEvent event) {
		// Abrir Banco de dados e verificar.
		BancoDeDados bd = new BancoDeDados();
		bd.conectar();
		if (bd.estaConectado()) {
			if (bd.login(user.getText(), pass.getText())) {
				if (!bd.getInfunc("tipoFunc").equals("-1")) {
					Main janela = new Main();
					janela.loadScene("Sample.fxml", "Tela principal");
				}else
					JOptionPane.showMessageDialog(null, "Este usuário foi apagado.");
			}
		}
	}
}
