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

public class telaAlterarController {

	
	@FXML
	private AnchorPane alterarScene;
	
	@FXML
	private TextField txfAberturaAlt;
	@FXML
	private TextField txfResponsavelAlt;
	@FXML
	private TextField txfCodigoAlt;
	@FXML
	private TextField txfData;
	@FXML
	private TextField txfNomeAlt;
	@FXML
	private TextField txfCpfPesquisa;
	@FXML
	private TextField txfIdadeAlt;
	@FXML
	private TextField txfDiaAlt;
	@FXML
	private TextField txfMesAlt;
	@FXML
	private TextField txfAnoAlt;
	
	
	@FXML 
	private Button botaoAlterar;
	
	Repositorio rep = new Repositorio();
	
	
	
	//Botão responsável por verificar se existe um cadastro com aquele CPF no banco de dados
	
	public void verificar() {
		
		
		String cpfAlterar = txfCpfPesquisa.getText();
		
		if(txfCpfPesquisa.getText().isEmpty()) {
			Alert alertVazio = new Alert(Alert.AlertType.WARNING);
			alertVazio.setTitle("VAZIO");
			alertVazio.setContentText("O CPF não pode ficar em branco");
			alertVazio.showAndWait();
		}
		
		
		for (int i =0; i<rep.getProcesso().size(); i++) {
			
			if (cpfAlterar.equals(rep.getProcesso().get(i).getCliente().getCpf())) {
				txfAberturaAlt.setText (String.valueOf( rep.getProcesso().get(i).getIdade_abertura()));
				txfResponsavelAlt.setText(rep.getProcesso().get(i).getResponsavel());
				txfCodigoAlt.setText (String.valueOf( rep.getProcesso().get(i).getCodigo()));
				txfNomeAlt.setText(rep.getProcesso().get(i).getCliente().getNome());
				txfIdadeAlt.setText (String.valueOf( rep.getProcesso().get(i).getCliente().getIdade()));
				txfDiaAlt.setText(rep.getProcesso().get(i).getData().getDia());
				txfMesAlt.setText(rep.getProcesso().get(i).getData().getMes());
				txfAnoAlt.setText(rep.getProcesso().get(i).getData().getAno());
				break;
				
		}	else if(!cpfAlterar.equals(rep.getProcesso().get(i).getCliente().getCpf())) {
				Alert alertRemover = new Alert(Alert.AlertType.WARNING);
				alertRemover.setTitle("ERRO NO Alterar");
				alertRemover.setContentText("Esse cpf não está cadastrado no nosso banco de dados");
				alertRemover.showAndWait();
					
			}
			
		}
			
		
	
			
			
		}
		
	//Botão responsavel por alterar as informações de cadastro, já que a veridicação foi realizada no método anterior
	public void alterar () {
		
		try {
		
		String cpfAlterar = txfCpfPesquisa.getText();
	
		int abertura = Integer.parseInt(txfAberturaAlt.getText());
		String responsavel = txfResponsavelAlt.getText();
		int codigo = Integer.parseInt(txfCodigoAlt.getText());
		
		String nome = txfNomeAlt.getText();
		String idade =txfIdadeAlt.getText();
	
		String dia = txfDiaAlt.getText();
		String mes = txfMesAlt.getText();
		String ano = txfAnoAlt.getText();
		
		
		for (int i =0; i<rep.getProcesso().size(); i++) {
			if (cpfAlterar.equals(rep.getProcesso().get(i).getCliente().getCpf())) {
				rep.getProcesso().get(i).setIdade_abertura(abertura);
				rep.getProcesso().get(i).setResponsavel(responsavel);
				rep.getProcesso().get(i).setCodigo(codigo);
				rep.getProcesso().get(i).getCliente().setNome(nome);
				rep.getProcesso().get(i).getCliente().setIdade(idade);
				rep.getProcesso().get(i).getData().setDia(dia);
				rep.getProcesso().get(i).getData().setMes(mes);
				rep.getProcesso().get(i).getData().setAno(ano);
				
					
				Alert alertAlterado = new Alert(Alert.AlertType.INFORMATION);
				alertAlterado.setTitle("Alterado");
				alertAlterado.setContentText("O cadastro foi alterado Com sucesso");
				alertAlterado.showAndWait();
				break;
		} 
			
		}
	}
		catch(RuntimeException e) {
			Alert alertVazio = new Alert(Alert.AlertType.ERROR);
			alertVazio.setTitle("VAZIO");
			alertVazio.setContentText("Preencha as informações necessárias");
			alertVazio.showAndWait();
		}	
	}
	
	
	//Botão para voltar para o menu inicial
	
	public void cancelar() {
		try {

			 FXMLLoader loader = new FXMLLoader(getClass().getResource("telaInicial.fxml")); 
			 AnchorPane root = loader.load(); 
			 Scene scene = new Scene (root);
			 Stage primaryStage= (Stage) alterarScene.getScene().getWindow();
			 primaryStage.setScene(scene);
			 
			 
				}catch (IOException e) {
					e.printStackTrace();
				}
	}
	
}
