package application;

public class ProcessoCriminal extends Processo {
	private String  numeroVara;
	
	public ProcessoCriminal() {
		
	}
	public ProcessoCriminal(int idade_abertura, String responsavel, int codigo, String numeroVara, Cliente cliente, Data data) {
		super(idade_abertura, responsavel, codigo, cliente, data);
		this.numeroVara = numeroVara;
	}

	public String getNumeroVara() {
		return  numeroVara;
	}

	public void setNumeroVara(String numeroVara) {
		this.numeroVara = numeroVara;
	}
	
	

	

	
}
