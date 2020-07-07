package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadDividaController {
	static Stage s1;
    @FXML
    private TextField value, numProc;
    
    @FXML
    private Label label;
    
    @FXML
    private ToggleGroup tipo;

    @FXML
    private RadioButton um,dois;


    public void inicio() throws IOException {
		s1 = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("CadDivida.fxml"));
		Scene scene = new Scene(root);
		s1.setScene(scene);
		s1.setResizable(false);
		s1.show();
	}
    
    @FXML
    private void regDivida(MouseEvent event) {
    		//talvez tenhamos que passar o valor vazio caso não tenha escrito nada em numProc, ao invez de pegar direto;
    		
    }
    
    @FXML
    private void show(MouseEvent e) {
    	label.setVisible(true);
    	numProc.setVisible(true);
    }

    @FXML
    private void hide(MouseEvent e) {
    	label.setVisible(false);
    	numProc.setVisible(false);
    }
    
}