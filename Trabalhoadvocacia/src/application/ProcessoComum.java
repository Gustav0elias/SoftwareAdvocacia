package application;

public class ProcessoComum extends Processo{

	public ProcessoComum() {}
	
	public ProcessoComum( Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ProcessoComum(int idade_abertura, String responsavel, int codigo, Cliente cliente, Data data) {
		super(idade_abertura, responsavel, codigo, cliente, data);
		// TODO Auto-generated constructor stub
	}

	
	
}
