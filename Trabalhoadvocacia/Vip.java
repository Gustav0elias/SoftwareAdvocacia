package application;

public class Vip  extends Cliente{

	String cod_membro;
	public Vip(String nome, String cpf, Integer idade) {
		super(nome, cpf, idade);
		
	}
	public String getCod_membro() {
		return cod_membro;
	}
	public void setCod_membro(String cod_membro) {
		this.cod_membro = cod_membro;
	}

}
