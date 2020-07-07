package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class PesquisarController {

	@FXML
	private Button buscar;

	@FXML
	private TextField search, search1, dia, mes, ano;

	@FXML
	private TextArea encontrados;

	@FXML
	private ToggleGroup peloQue, qualPesq;

	@FXML
	private RadioButton cli, dev, divida, nome, ident, value, data, identificador;

	@FXML
	private void goBack(MouseEvent e) {
		Main janela = new Main();
		janela.loadScene("Sample.fxml", "Tela Principal");
	}

	@FXML
	private void search(MouseEvent event) {
		if (qualPesq.getSelectedToggle().equals(cli)) {
			String tipo = "";
			if (peloQue.getSelectedToggle().equals(nome)) {
				tipo = "nomeCli";
			} else if (peloQue.getSelectedToggle().equals(ident)) {
				tipo = "identidadeCli";
			} else if (peloQue.getSelectedToggle().equals(identificador))
				tipo = "idCli";
			encontrados.clear();
			pesqCli(tipo);
		}
		else if (qualPesq.getSelectedToggle().equals(dev)) {
			String tipo = "";
			if (peloQue.getSelectedToggle().equals(nome)) {
				tipo = "nomeDev";
			} else if (peloQue.getSelectedToggle().equals(ident)) {
				tipo = "identidadeDev";
			} else if (peloQue.getSelectedToggle().equals(identificador))
				tipo = "idDev";
			encontrados.clear();
			pesqDev(tipo);
		}
		else {
		} // chama pesquisa por dívida
		// código abaixo só deve ser executado ao encontrar um resultado
		if((peloQue.getSelectedToggle().equals(identificador) || peloQue.getSelectedToggle().equals(ident)) && !encontrados.getText().equals("")) {
			buscar.setVisible(true);
			buscar.setText(search.getText());
		}
	}

	@FXML
	private void show(MouseEvent e) {
		search1.setVisible(true);
		data.setVisible(true);
		dia.setVisible(true);
		mes.setVisible(true);
		ano.setVisible(true);
		value.setVisible(true);
	}

	@FXML
	private void hide(MouseEvent e) {
		search1.setVisible(false);
		data.setVisible(false);
		dia.setVisible(false);
		mes.setVisible(false);
		ano.setVisible(false);
		value.setVisible(false);
	}

	private void pesqCli(String tipo) {
		BancoDeDados db = new BancoDeDados();
		db.conectar();
		if (db.estaConectado()) {
			for (int i = 0; i < db.listarClientes(tipo, search.getText()).size(); i++)
				encontrados.appendText(db.listarClientes(tipo, search.getText()).get(i) + "\n\n");
		}
	}

	private void pesqDev(String tipo) {
		BancoDeDados db = new BancoDeDados();
		db.conectar();
		if (db.estaConectado()) {
			ArrayList<String> lista = db.listarDevedores(tipo, search.getText());
			int tam = lista.size();
			for (int i = 0; i < tam; i++)
				encontrados.appendText(lista.get(i) + "\n\n");
			if (tam == 1) {
				buscar.setVisible(true);

			}
		}
	}


	private void pesqDivida() {

	}

	@FXML
	private void selecionar(MouseEvent e) throws IOException {
		BancoDeDados db = new BancoDeDados();
		db.conectar();
		String tipo = "";
		if (db.estaConectado()) {
			String op = buscar.getText();
			if (qualPesq.getSelectedToggle().equals(cli)) {
				BancoDeDados.setSecCli(op);
				if (peloQue.getSelectedToggle().equals(ident)) {
					BancoDeDados.setSecCli(db.getInfCli("idCli", "identidadeCli"));
				}
				else if (peloQue.getSelectedToggle().equals(identificador)) {
					db.getInfCli("idCli", "idCli");
				}
				tipo = "cliente";
			} else if (qualPesq.getSelectedToggle().equals(dev)) {
				BancoDeDados.setSecDev(op);
				if (peloQue.getSelectedToggle().equals(ident)) {
					BancoDeDados.setSecDev(db.getInfDev("idDev", "identidadeDev"));
				}
				else if (peloQue.getSelectedToggle().equals(identificador)) {
					db.getInfDev("idDev", "idDev");
				}
				tipo = "devedor";
			}
			OpcoesPesqController janela = new OpcoesPesqController();
			janela.inicio(tipo);
		}
	}
}
