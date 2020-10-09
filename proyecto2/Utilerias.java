package proyecto2;
//usar metodos estaticos pero crear una instancia para poder tener un control de los contadores
public class Utilerias{
	private static int contador = -1;
	private static int contadorp = 1997;
	private static int contadorOrd = -1; 

	public Utilerias(){
	getIdCliente();
	getIdProducto(); 
	getIdOrdenes();
	}

 //getters 
	public static int getIdCliente(){
	return contador = contador+1;
	}

	public static int getIdProducto(){
	return 	contadorp = contadorp + 1;
	}

	public static int getIdOrdenes(){
	return 	contadorOrd = contadorOrd + 1;
	}
}