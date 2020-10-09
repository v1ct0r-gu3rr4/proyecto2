package proyecto2;
import proyecto2.Utilerias;

public class Producto{
	
	private int cantidad;
	private String descripcion;
	private String tipo;
	private int id;
	private double precio;

	public Producto(){
		setId(Utilerias.getIdProducto());
	}

	public Producto(int cantidad, String descripcion, String tipo, double precio){
		setId(Utilerias.getIdProducto());
		setCantidad(cantidad);
		setDescripcion(descripcion);
		setTipo(tipo);
		setPrecio(precio);
	}

//setters
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setPrecio(double precio){
		this.precio = precio;
	}
//getters
	public int getCantidad(){
		return this.cantidad;

	}
	public String getDescripcion(){
		return this.descripcion ;
	}
	public String getTipo(){
		return this.tipo;
	}
	public int getId(){
		return this.id;
	}
	public double getPrecio(){
		return this.precio;
	}

	@Override
	public String toString(){
		String variable = "[Id :"+ getId() + " ]";
		variable = variable + "cantidad : " + getCantidad() + ",";
		variable = variable + "descripcion : " + getDescripcion() + ",";
		variable = variable + "tipo : " + getTipo() + ",";
		variable = variable + "Precio : " + getPrecio() + "]"; 
		
		return variable;
	}
}