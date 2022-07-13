package application;

public class ClienteVip  extends Cliente{

	String cod_membro;
	
	public ClienteVip(String nome, String cpf, String idade) {
		super(nome, cpf, idade);
		
	}
	public String getCod_membro() {
		return cod_membro;
	}
	public void setCod_membro(String cod_membro) {
		this.cod_membro = cod_membro;
	}

}
