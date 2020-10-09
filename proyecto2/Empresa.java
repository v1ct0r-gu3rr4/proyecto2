package proyecto2;

public class Empresa extends Cliente{
	 
	private String contacto;
	private int descuento;

	public Empresa(String nombre, String direccion, String nit, String contacto, int descuento){
		super(nombre, direccion, nit);
		setContacto(contacto);
		setDescuento(descuento);
	}

	//setters

	public void setContacto(String contacto){
		this.contacto = contacto;
	}

	public void setDescuento(int descuento){
		this.descuento=descuento;
	}

	public void setDpi(String dpi){
	}

	//getters

	public String getContacto(){
		return this.contacto;
	}

	public int getDescuento(){
		return this.descuento;
	}

}