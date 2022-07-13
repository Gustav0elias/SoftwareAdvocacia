package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class telaRelatorioController implements Initializable{


	
	@FXML
	private TableView   <Processo> tabelaProcessos;
	@FXML
	private TableColumn <ProcessoComum, String> colAbertura;
	@FXML
	private TableColumn <ProcessoComum, String>colResponsavel;
	@FXML
	private TableColumn <ProcessoComum, String>colCodigo;
	@FXML
	private TableColumn <ProcessoComum, String>colNome;
	@FXML
	private TableColumn <ProcessoComum, String>colCpf;
	@FXML
	private TableColumn <ProcessoComum, String> colIdade;
	@FXML
	private TableColumn <ProcessoComum, String>colDia;
	@FXML
	private TableColumn <ProcessoComum, String>colMes;
	@FXML
	private TableColumn <ProcessoComum, String>colAno;
	
	
	
	
	
	@FXML
	private AnchorPane relatorioScene;
	
   
	//Botão responsável por voltar para o menu inicial
	public void cancelar () {
		try {

			 FXMLLoader loader = new FXMLLoader(getClass().getResource("telaInicial.fxml")); 
			 AnchorPane root = loader.load(); 
			 Scene scene = new Scene (root);
			 Stage primaryStage= (Stage) relatorioScene.getScene().getWindow();
			 primaryStage.setScene(scene);
			 
			 
				}catch (IOException e) {
					e.printStackTrace();
				}
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		
		//Códigos responsáveis por setar cada informação coletada no Repositório em sua determinada coluna
		 colResponsavel.setCellValueFactory(new PropertyValueFactory<ProcessoComum, String> ("responsavel"));
		colAbertura.setCellValueFactory(new PropertyValueFactory<ProcessoComum, String>("idade_abertura"));
		colCodigo.setCellValueFactory(new PropertyValueFactory<ProcessoComum, String>("codigo"));
		
		
		
		colNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente().getNome()));
		colCpf.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente().getCpf()));
		colIdade.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCliente().getIdade()));
		
		colDia.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getData().getDia()));
		colMes.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getData().getMes()));
		colAno.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getData().getAno()));
		
		
			preencherTabela();
			
		
	}
	
	public void preencherTabela() {
		//Mandando as informações do repositório para um ObservableList, pois esse é o tipo de lista que o tableView aceita
		ObservableList<Processo> processos = FXCollections.observableArrayList(new Repositorio().getProcesso());
		tabelaProcessos.setItems(processos);
	}
	
	
	
		
			
	
}
