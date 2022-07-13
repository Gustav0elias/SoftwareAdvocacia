package application;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class telaInserirController implements Initializable{

	@FXML
	private AnchorPane inserirScene;
	@FXML
	private TextField txfAbertura;
	@FXML
	private TextField txfResponsavel;
	@FXML
	private TextField txfCodigo;
	@FXML
	private TextField txfDia;
	@FXML
	private TextField txfMes;
	@FXML
	private TextField txfAno;
	@FXML
	private TextField txfNome;
	@FXML
	private TextField txfCpf;
	@FXML
	private TextField txfIdade;
	@FXML
	private TextField txfCodmembro;
	@FXML
	private TextField txfNvara;
	@FXML
	private RadioButton radioCriminal;
	@FXML
	private RadioButton radioComum;
	
	@FXML
	private MenuItem menuItemComum;
	@FXML
	private MenuItem menuItemCriminal;
	@FXML 
	private Button botaoInserir;
	
	


	//Botão responsável por fazer a inserção das informações coletadas no textfield no repositório
	public void  inserir() {
		
		try {
		
		int abertura = Integer.parseInt(txfAbertura.getText());
		String responsavel = txfResponsavel.getText();
		int codigo = Integer.parseInt(txfCodigo.getText());
		
		String nome = txfNome.getText();
		String cpf = txfCpf.getText();
		String idade = txfIdade.getText();
		
		String dia = txfDia.getText();
		String mes = txfMes.getText();
		String ano = txfAno.getText();
	
	
		
		Processo processoComum = new ProcessoComum(abertura, responsavel, codigo, new ClienteNormal(nome, cpf, idade), new Data(dia, mes, ano));
	

		new Repositorio().inserir(processoComum);
		
		
		Alert alertInserido = new Alert(Alert.AlertType.INFORMATION);
		alertInserido.setTitle("Inserido");
		alertInserido.setContentText("O cadastro foi realizado Com sucesso");
		alertInserido.showAndWait();  
		
			
		
		}
		
		
		catch(RuntimeException e) {
			Alert alertVazio = new Alert(Alert.AlertType.ERROR);
			alertVazio.setTitle("VAZIO");
			alertVazio.setContentText("Preencha as informações necessárias");
			alertVazio.showAndWait();
		}
		
		}
			
	
	// Botão responsável por voltar para a tela inicial

	public void cancelar() {
		try {

			 FXMLLoader loader = new FXMLLoader(getClass().getResource("telaInicial.fxml")); 
			 AnchorPane root = loader.load(); 
			 Scene scene = new Scene (root);
			 Stage primaryStage= (Stage) inserirScene.getScene().getWindow();
			 primaryStage.setScene(scene);
			 
			 
				}catch (IOException e) {
					e.printStackTrace();
				}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
