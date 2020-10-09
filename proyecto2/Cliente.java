package proyecto2;
import proyecto2.Utilerias;

public abstract class Cliente{

	private String nombre = "";
	private int idCliente;
	private String direccion = "";
	private String nit = "";

	public Cliente(){
		//System.out.println(Utilerias.getIdCliente());
		setIdCliente(Utilerias.getIdCliente());
	}

	public Cliente(String nombre, String direccion, String nit){
		setIdCliente(Utilerias.getIdCliente());
		setNombre(nombre);
		setDireccion(direccion);
		setNit(nit);
	}
	//setters para los atributos
	public void setNombre(String nombre ){
		this.nombre = nombre;
	}
	public void setIdCliente(int idCliente ){
		this.idCliente = idCliente;
	}
	public void setDireccion(String direccion ){
		this.direccion = direccion;
	}
	public void setNit(String nit ){
		this.nit = nit;
	}
	public abstract void setDpi(String dpi);
	public abstract void setContacto(String contacto);
	public abstract void setDescuento(int descuento);


	//getters para los atributos
	public String getNombre(){
		return this.nombre;
	}
	public int getIdCliente(){
		return this.idCliente;
	}
	public String getDireccion(){
		return this.direccion;
	}
	public String getNit(){
		return this.nit;
	}

	public abstract String getContacto();

	public abstract int getDescuento();

	@Override 
	public String toString(){
		String variable = "[cliente : ID = "+ getIdCliente() + " ,";
		variable = variable + "Nombre : " + getNombre() + ",";
		variable = variable + "Direccion : " + getDireccion() + ","; 
		variable = variable + "Nit : " + getNit() + "]";
		return variable;
	}
}