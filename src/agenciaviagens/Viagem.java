package agenciaviagens;

public class Viagem {

	private String dataIda;
	private String dataVolta;
	private Destino destViagem;
	private int dias;
	private double total;
	private Cliente cliente;
	
	public Viagem() {
	}
	
	public String getDataVolta() {
		return dataVolta;
	}
	
	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}
	
	public String getDataIda() {
		return dataIda;
	}
	
	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setDestViagem(Destino destino) {
		this.destViagem = destino;
	}
	
	public Destino getDestViagem() {
		return this.destViagem;
	}
	
	public int getDiarias(){
		return this.dias;
	}
	
	public void setDiarias(int dias){
		this.dias = dias;
	}
	
	public double getPrecoTotal(){
		this.total = (this.getDiarias() * this.destViagem.getPreco());
		return this.total;
	}
	
	
}
