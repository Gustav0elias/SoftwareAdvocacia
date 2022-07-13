package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class telaRemoverController {
	
	
	@FXML
	private AnchorPane removerScene;
	
	@FXML
	private TextField txfRemover;
	Repositorio rep = new Repositorio();
	
	
	//Botão reponsável por voltar para o menu inicial
	public void cancelar() {
		try {

			 FXMLLoader loader = new FXMLLoader(getClass().getResource("telaInicial.fxml")); 
			 AnchorPane root = loader.load(); 
			 Scene scene = new Scene (root);
			 Stage primaryStage= (Stage) removerScene.getScene().getWindow();
			 primaryStage.setScene(scene);
			 
			 
				}catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	//Botão responsável por remover
	public void remover() {
		
		String cpfRemover = txfRemover.getText();
		
		if(txfRemover.getText().isEmpty()) {
			Alert alertVazio = new Alert(Alert.AlertType.WARNING);
			alertVazio.setTitle("VAZIO");
			alertVazio.setContentText("O CPF não pode ficar em branco");
			alertVazio.showAndWait();
		}
		
		for (int i =0; i< rep.getProcesso().size(); i++) {
			if ( cpfRemover.equals(rep.getProcesso().get(i).getCliente().getCpf())) {
			rep.getProcesso().remove(i);
			
			Alert alertRemovido = new Alert(Alert.AlertType.INFORMATION);
			alertRemovido.setTitle("Removido");
			alertRemovido.setContentText("O cadastro foi removido com sucesso");
			alertRemovido.showAndWait();
			break;
			}
			else if(!cpfRemover.equals(rep.getProcesso().get(i).getCliente().getCpf())) {
				Alert alertRemover = new Alert(Alert.AlertType.WARNING);
				alertRemover.setTitle("ERRO NO REMOVER");
				alertRemover.setContentText("Esse cpf não está cadastrado no nosso banco de dados");
				alertRemover.showAndWait();
					
			}
		}
		
	}
	
	
	
}

