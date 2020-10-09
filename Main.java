import proyecto2.DataSistema;
import java.util.HashMap;
import java.util.Scanner;
import proyecto2.Cliente;
import proyecto2.Producto;

public class Main{

	public static DataSistema dato = new DataSistema();
	public static Producto prod = new Producto();

	public static void main(String args []){
		System.out.println("Bienvenido al Sistema de Ventas ");
		double precio = 0.00;
		int opcion = 0;
		int op1 = 0; 
		int idBuscar = 0, idProducto = 0, canProd = 0;
		int sino = 0;   
		boolean salida = false;
		boolean inMenuSalida = false;
		Scanner reader = new Scanner(System.in);
		Scanner readerOp = new Scanner(System.in);
		String nombre="",direccion="",nit="",dpi="",contacto="", descripcion = "";
		int descuento = 0;
		HashMap<Integer, Integer > lista = new HashMap<Integer, Integer>();


		while(!salida){
			System.out.println(" ");
			System.out.println("\t Este programa reporta errores"); 
			System.out.println("\t 1.- Cear un cliente");
			System.out.println("\t 2.- Eliminar un cliente por la ID"); 
			System.out.println("\t 3.- Crear una orden");
			System.out.println("\t 4.- Listados de Productos ");
			System.out.println("\t 5.- Lista de Clientes ");
			System.out.println("\t 6.- Lista de Ordenes");
			System.out.println("\t 7.- Modificar un cliente por la ID");
			System.out.println("\t 8.- MOdificar Producto ");
			System.out.println("\t9.- Salida ");   
			System.out.println(" ");

			opcion = reader.nextInt(); 


			switch(opcion){

				case 1:
				System.out.println("que deseas crear:  \n 1.- Empresa \n 2.-rsona Individual");
				op1 = reader.nextInt();
				if(op1 == 1){
					System.out.println("ingresa los siguientes datos");
					System.out.println("Nombre, direccion, NIT, DPI");
					System.out.println("");
					System.out.println("Nombre: ");
					nombre = readerOp.nextLine();
					System.out.println("Direccion: ");
					direccion = readerOp.nextLine();
					System.out.println("NIT :");
					nit = readerOp.nextLine();
					System.out.println("DPI : ");
					dpi = readerOp.nextLine();

					dato.altaCliente(nombre,direccion,nit,dpi);

				}else{
					System.out.println("ingresa los siguientes datos");
					System.out.println("Nombre, direccion, NIT, Contacto, Descuento");
					System.out.println("");
					System.out.println("Nombre: ");
					nombre = readerOp.nextLine();
					System.out.println("Direccion: ");
					direccion = readerOp.nextLine();
					System.out.println("NIT :");
					nit = readerOp.nextLine();
					System.out.println("Contacto : ");
					contacto = readerOp.nextLine();
					System.out.println("Descuento: ");
					descuento = readerOp.nextInt();
					//String nombre, String direccion, String nit, String contacto, int descuento
					dato.altaEmpresa(nombre,direccion,nit,contacto,descuento);

				}

				break; 


				case 2: 

				System.out.println("Ingrese el ID del empleado: ");
				idBuscar = readerOp.nextInt();
				dato.bajaCliente(idBuscar);
				System.out.println("eliminado con exito");

				break;

				case 3: 
				System.out.println("INGRESE EL ID DEL CLIENTE");

				idBuscar = readerOp.nextInt();
				Cliente c;
				try{
					c = dato.buscarCliente(idBuscar);

					while(!inMenuSalida){

					System.out.println("Ingrese el producto");
					idProducto = readerOp.nextInt();
					try{
						prod = dato.buscarProducto(idProducto);

						//verificamos la cantidad
						System.out.println("Ingrese la cantidad que desea : ");
						canProd = readerOp.nextInt();

						if( canProd < prod.getCantidad()){
							lista.put(idBuscar, canProd);
							prod.setCantidad(prod.getCantidad()-canProd);
							System.out.println("Agregado con exito: ");

						}else{
							System.out.println("la cantidad es mayor a la que tenemos, te podemos dar : " + prod.getCantidad());
						}
						//preguntamos si desea seguir ingresando 
						System.out.println("Deseas ingresar otro? \n 1.- Si \n 2.- Nope");
						sino = readerOp.nextInt();
						if(sino == 2){
							inMenuSalida = true;
						}

						}catch(Exception errorPro){
							System.out.println(errorPro.getMessage());
						}
					}
						//final while
						dato.crearOrdenes(idBuscar, lista);

				}catch(Exception errorCliente){
						System.out.println(errorCliente.getMessage());
					}

				break; 

				case 4:
				System.out.println("\t Listado de Producto");
				dato.listaProducto();

				break; 


				case 5:

				System.out.println("\t Listado de Clientes");
				dato.listaClientes();

				break; 

				case 6:
				System.out.println("\t Listado de Ordenes ");
				dato.listaOrdenes();
				
				break;
				
				case 7:
				System.out.println("\t Modificar cliente por ID: \n 1. Individual \n 2. Empresa ");
				sino = readerOp.nextInt();
				System.out.println("Ingresa el ID:");

				if(sino == 1){
					System.out.println("ingresa los siguientes datos");
					System.out.println("Nombre, direccion, NIT, DPI");
					System.out.println("");
					System.out.println("Nombre: ");
					nombre = readerOp.nextLine();
					System.out.println("Direccion: ");
					direccion = readerOp.nextLine();
					System.out.println("NIT :");
					nit = readerOp.nextLine();
					System.out.println("DPI : ");
					dpi = readerOp.nextLine();
					dato.modificacionIndividual(idBuscar, nombre, direccion, nit, dpi);
					//public void modificacionIndividual(int id,String nombre, String direccion, String nit, String dpi)
				}else{
					System.out.println("ingresa los siguientes datos");
					System.out.println("Nombre, direccion, NIT, Contacto, Descuento");
					System.out.println("");
					System.out.println("Nombre: ");
					nombre = readerOp.nextLine();
					System.out.println("Direccion: ");
					direccion = readerOp.nextLine();
					System.out.println("NIT :");
					nit = readerOp.nextLine();
					System.out.println("Contacto : ");
					contacto = readerOp.nextLine();
					System.out.println("Descuento: ");
					descuento = readerOp.nextInt();
					//modificacionEmpresa(int id,String nombre, String direccion, String nit, String contacto, int descuento)
					dato.modificacionEmpresa(idBuscar, nombre, direccion, nit, contacto, descuento);
				}
				

				break;
				
				case 8:
				System.out.println("ingrese el ID del producto ");
				idBuscar = readerOp.nextInt();
				System.out.println("Ingrese la cantidad");
				canProd = readerOp.nextInt();
				System.out.println("descripcion:");
				descripcion = readerOp.nextLine();
				System.out.println("Tipo : ");
				nombre = reader.nextLine();
				System.out.println("Precio:")
				precio = readerOp.nextDouble();

				dato.modificarProducto(idBuscar, canProd, descripcion, nombre,precio);
				//int id, int cantidad, String descripcion, String tipo, double precio)

				break;

				default: salida = true;
				break; 
			}
		}

	}
}	