package application;

public abstract class Processo {

	
	protected Integer idade_abertura;
	protected String responsavel;
	protected Integer codigo;
	protected Cliente cliente;
	

	
	
	public Processo(Integer idade_abertura, String responsavel, Integer codigo) {
		super();
		this.idade_abertura = idade_abertura;
		this.responsavel = responsavel;
		this.codigo = codigo;
		this.cliente = cliente;
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
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return  idade_abertura +  responsavel+ codigo
				;
	}
	
	
}
