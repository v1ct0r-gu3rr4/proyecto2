package proyecto2;
import proyecto2.Producto; 

public class ItemOrden{
	

	private int noLinea;
	private int cant;
	private double precio;
	private Producto producto;
	private double subtotal;

	public ItemOrden(int noLinea, int cant, Producto p){
		setNoLinea(noLinea);
		setCant(cant);
		setProducto(p);
		setPrecio(p.getPrecio());
		setTotalItem(p.getPrecio() * cant);
	}


	//setters
	private void setNoLinea(int noLinea){
		this.noLinea = noLinea;
	}

	private void setCant(int cant){
	this.cant = cant;
	}
	private void setProducto(Producto producto){
		this.producto = producto;
	}

	private void setPrecio(double precio){
		this.precio = precio;
	}

	private void setTotalItem(double subtotal){
	this.subtotal = subtotal;
	}

	//getters

	public int getNoLinea(){
		return this.noLinea;
	}

	public int getCant(){
		return this.cant;
	}

	public Producto getPoducto(){
		return this.producto;
	}

	public double getPrecio(){
		return this.precio;
	}

	public double getTotalItem(){
		return this.subtotal;
	}

	@Override
	public String toString(){
		String variable = "[No Linea : " + getNoLinea() + ","; 
		variable = variable + "Cantidad : " + getCant() + ",";
		variable = variable + "producto : [" + producto.toString() + "]\n";
		variable = variable + "subtotal : " + getTotalItem() + "]";
		return variable;
	}



}