package application;


public abstract class Processo {

	
	protected int idade_abertura;
	protected String responsavel;
	protected int codigo;
	 Cliente cliente;
	 Data data;
	

	public Processo() {
	}
	
	public Processo(Cliente cliente ) {
		this.cliente=cliente;
	}
	public Processo(int idade_abertura, String responsavel, int codigo, Cliente cliente, Data data) {
		super();
		this.idade_abertura = idade_abertura;
		this.responsavel = responsavel;
		this.codigo = codigo;
		this.cliente= cliente;
		this.data = data;
		
	}
	public Integer getIdade_abertura() {
		return idade_abertura;
	}
	public void setIdade_abertura(Integer idade_abertura) {
		this.idade_abertura = idade_abertura;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setIdade_abertura(int idade_abertura) {
		this.idade_abertura = idade_abertura;
	}

	
	
	
}
