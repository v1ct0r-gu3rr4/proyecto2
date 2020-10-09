package proyecto2;
public class Individual extends Cliente{
	 
	private String dpi;

	public Individual(String nombre, String direccion, String nit, String dpi){
		super(nombre, direccion, nit);
		setDpi(dpi);

	}

	public void setDpi(String dpi){

		this.dpi=dpi;
	}

	public String getDpi(){
		return this.dpi;
	}


	public void setContacto(String contacto){
	}

	public void setDescuento(int descuento){
	}

	public String getContacto(){
		return "";
	}

	public int getDescuento(){
	return 0;
	}

}