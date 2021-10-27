package agenciaviagens;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Viagem {

	private String dataIda;
	private String dataVolta;
	private Destino destViagem;
	private int dias;
	private double total;
	private Cliente cliente;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
	
	public int getDiarias() throws ParseException {
		Date ida = sdf.parse(this.dataIda);
		Date volta = sdf.parse(this.dataVolta);
		this.dias = (int) ((volta.getTime() - ida.getTime())/(1000 * 60 * 60 * 24));
		return this.dias;
	}
	
	public double getPrecoTotal() throws ParseException {
		this.total = (this.getDiarias() * this.destViagem.getPreco());
		return this.total;
	}
	
	
}
