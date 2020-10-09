package proyecto2;
import proyecto2.Utilerias;
import proyecto2.ItemOrden;
import java.util.Date;
import java.util.ArrayList;
 

public class Ordenes{
	
	private int id;
	private Cliente cliente;
	private ArrayList<ItemOrden> item = new ArrayList<ItemOrden>();
	private Date fechaOrden;
	private double precioEnvio;
	private double total;
	private String tipoEnvio;
	private String estado;
	private int diasEnvio;

	public Ordenes(){
		setId(Utilerias.getIdOrdenes());
		setTotal(0.00);
		setDate(new Date());
	}

	public Ordenes(Date pFecha){
		setId(Utilerias.getIdOrdenes());
		setTotal(0.00);
		setDate(pFecha);
	}

	public Ordenes(Cliente cliente, Date pFecha){

		setId(Utilerias.getIdOrdenes());
		setTotal(0.00);
		setDate(pFecha);
		setCliente(cliente);
	}

	//agregar a el arraylist

	public void addItemOrdenes(ItemOrden item){
		this.item.add(item);
	}



	//setters 
	private void setId(int id){
		this.id=id; 
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}

	private void setDate(Date fechaOrden){
		this.fechaOrden = fechaOrden;
	}

	private void setPrecioEnvio(double precioEnvio){
		this.precioEnvio = precioEnvio;
	}

	private void setTotal(double total){
		this.total = total;
	}

	public void setTipoEnvio(String tipoEnvio){
		this.tipoEnvio = tipoEnvio;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}

	public void setDiasEnvio(int diasEnvio){
		this.diasEnvio = diasEnvio;
	}
	
	//getters 

	public int getId(){
		return this.id; 
	}

	public Cliente getCliente(){
		return this.cliente;
	}

	public Date getDate(){
		return this.fechaOrden;
	}

	public double getPrecioEnvio(){
		return this.precioEnvio;
	}

	public double getTotal(){
		return this.total;
	}

	public String getTipoEnvio(){
		return this.tipoEnvio;
	}

	public String getEstado(){
		return this.estado;
	}

	public int getDiasEnvio(){
		return this.diasEnvio;
	}


	public double getTotalOrden(){
		
		double sumatoria = 0.00;

		for(ItemOrden i:this.item){
			sumatoria = sumatoria + i.getTotalItem();

		}
		if(this.cliente.getDescuento()>0){
			sumatoria = sumatoria - (sumatoria * this.cliente.getDescuento());
		}
		return sumatoria;
	}


	@Override 

	public String toString(){

		String variable = "\n [Id Orden :"+ getId() + " \n";
		variable = variable + "[Cliente : " + this.cliente.toString() + "]\n";	
		variable = variable + "[Fecha : " + getDate() + "]\n";
		variable = variable + "[Precio de envio : " + getPrecioEnvio() + "]\n";
		variable = variable + "[Total : " + getTotal() + "]\n";
		variable = variable + "[Tipo envio : " + getTipoEnvio() + "]\n";
		variable = variable + "[Estado : " + getEstado() + "]\n";
		variable = variable + "[Dias Envio : " + getDiasEnvio()+"]\n"; 
		String items = "";
		for(ItemOrden i:this.item){
			items = items + i.toString();

		}
		variable = variable + "[items : " + items + "]\n";
		variable = variable + "[Total de la orden : " + getTotalOrden() + "]\n";
		variable = variable + "\n";
		return  variable;
	}

}