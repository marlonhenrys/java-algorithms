package application;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ConfigController {

	@FXML
	private void alteraSenha(MouseEvent e){
		BancoDeDados db = new BancoDeDados();
		db.conectar();
		if(db.estaConectado()){
			String antiga,novaSenha,confirma;
			antiga = JOptionPane.showInputDialog("Insira sua senha atual");
			if(db.getInfunc("senhaFunc").equals(antiga)) {
				novaSenha = JOptionPane.showInputDialog("Insira a nova senha");
				confirma = JOptionPane.showInputDialog("Favor confirmar a nova senha");
				if(confirma.equals(novaSenha))
					db.alterarSenha(db.getInfunc("idFunc"), novaSenha);
				else JOptionPane.showMessageDialog(null,"As senhas digitadas n�o s�o iguais");
			}
			else JOptionPane.showMessageDialog(null, "A senha antiga est� incorreta.");
		}

	}

	@FXML
	private void alteraPerm(MouseEvent e) throws IOException{
		BancoDeDados db = new BancoDeDados();
		db.conectar();
		if(db.estaConectado()) {
			if(db.getInfunc("tipoFunc").equals("2")) {
				AltUser janela = new AltUser();
				janela.inicio();
			}
			else JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�o para alterar um usu�rio.");
		}
	}

	@FXML
	private void goBack(MouseEvent event){
		Main janela = new Main();
		janela.loadScene("Sample.fxml","Tela principal");
	}	
}