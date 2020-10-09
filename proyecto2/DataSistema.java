package proyecto2;
import proyecto2.Producto;
import proyecto2.Cliente;
import proyecto2.Utilerias;
import proyecto2.ItemOrden;
import proyecto2.Individual;
import proyecto2.Empresa;
import proyecto2.Ordenes;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;	


public class DataSistema{
	
	private ArrayList<Producto> producto = new ArrayList<Producto>();
	private ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	private ArrayList<Ordenes> ordenes = new ArrayList<Ordenes>();
	//hash map


//	public static void main(String[] args) {
//		Scanner read = new Scanner(System.in);
//		DataSistema data = new DataSistema();

//		data.listaOrdenes();
//		data.listaClientes();
//		data.listaProducto();
//	}


	public DataSistema(){
		Utilerias util = new Utilerias();


		this.producto.add(new Producto(10, "zanahoria", "verdura", 2.00));
		this.producto.add(new Producto(12, "manzana", "fruta", 7.00));
		this.producto.add(new Producto(13, "pacaya", "verdura", 6.00));
		this.producto.add(new Producto(16, "jitomate", "verdura", 8.00));
		this.producto.add(new Producto(14, "durazno", "fruta", 9.00));
		this.producto.add(new Producto(16, "peras", "fruta", 7.00));
		this.producto.add(new Producto(9, "madarinas", "fruta", 6.00));
		this.producto.add(new Producto(8, "banano", "fruta", 8.00));
		this.producto.add(new Producto(17, "frijoles", "verdura", 9.00));


		this.cliente.add(new Individual("pepito", "lomas alto", "123-k", "324567899"));
		this.cliente.add(new Individual("pepito2", "lomas bajo", "1283-k", "32467899"));
		this.cliente.add(new Individual("pepito3", "lomas medio", "1253-k", "32456799"));
		this.cliente.add(new Individual("pepito4", "lomas chiquito", "1423-k", "34567899"));
//String nombre, String direccion, String nit, String contacto, int descuento 
		this.cliente.add(new Empresa("juanito", "lomas alto", "123-k", "hola@hola", 2));
		this.cliente.add(new Empresa("juanito2", "lomas bajo", "5676g","adios@adios", 9));
		this.cliente.add(new Empresa("juanito3", "lomas medio", "56789g","good@good", 3));
		this.cliente.add(new Empresa("juanito4", "lomas chiquito","6567f", "year@year", 5));
//int idCliente, HashMap<Integer, Integer> listaIdProd
		//HashMap<Integer, Integer > lista = new HashMap<Integer, Integer>();
		//lista.put(2, 2001);
		//lista.put(5, 2003);
		//this.crearOrdenes(1,lista);
	}

//altas
	public void altaCliente(String nombre, String direccion, String nit, String dpi){ 
		this.cliente.add(new Individual(nombre, direccion, nit, dpi));
	}

	public void altaEmpresa(String nombre, String direccion, String nit, String contacto, int descuento){ 
		this.cliente.add(new Empresa(nombre, direccion, nit, contacto, descuento));
	}

//bajas 
	public void bajaCliente(int id){
		try{
		Cliente cliente = buscarCliente(id);
		this.cliente.remove(cliente); 	
		} catch(Exception errorCliente){
			System.out.println(errorCliente.getMessage());
		}
			
	}

	public void bajaEmpresa(int id){
		try{
		Cliente empresa = buscarCliente(id);
		this.cliente.remove(empresa); 
		} catch(Exception errorEmpresa){
			System.out.println(errorEmpresa.getMessage());
		}
	}
	
	//bucadores
	public Cliente buscarCliente(int id ) throws Exception {
		
		for(Cliente i:this.cliente){
			if(i.getIdCliente() == id){
				return i; 
			}
		} 
		throw new Exception ("no se encontro en la lista");
	}

	public Producto buscarProducto(int id ) throws Exception{
		for(Producto i:this.producto){
			if(i.getId() == id){
			return i; 
			}
		}
		throw new Exception ("no existe");
	}


	//modificaciones a las personas individuales o empresas
	public void modificacionIndividual(int id,String nombre, String direccion, String nit, String dpi){
			
			try{
			Cliente i = this.buscarCliente(id);
			i.setNombre(nombre);
			i.setDireccion(direccion);
			i.setNit(nit);
			i.setDpi(dpi);

			} catch(Exception error){
				System.out.println(error.getMessage());

			}

	}

	public void modificacionEmpresa(int id,String nombre, String direccion, String nit, String contacto, int descuento){
		try{
			Cliente n = this.buscarCliente(id);
			n.setNombre(nombre);
			n.setDireccion(direccion);
			n.setNit(nit);
			n.setContacto(contacto);
			n.setDescuento(descuento);
		}catch(Exception error){
			System.out.println(error.getMessage());

		}


	}

	public void modificarProducto(int id, int cantidad, String descripcion, String tipo, double precio){
		try{
			Producto p = this.buscarProducto(id);
			p.setCantidad(cantidad);
			p.setDescripcion(descripcion);
			p.setTipo(tipo);
			p.setPrecio(precio);
		}catch(Exception errorMP){
			System.out.println("No se encontro el Producto");
		}
	}

	//crear ordenes 
	public void crearOrdenes(int idCliente, HashMap<Integer, Integer> listaIdProd){//integer cantidad, integer producto
		
		int contador = 0;
		try{
			Cliente i = this.buscarCliente(idCliente);

			Ordenes orden = new Ordenes(i,new Date());

			for(Map.Entry<Integer,Integer> lista : listaIdProd.entrySet()){
				int idProducto = lista.getValue();

				try{
					Producto producto = this.buscarProducto(idProducto);
					contador = contador+1;
					orden.addItemOrdenes(new ItemOrden(contador, lista.getKey(), producto));
				}catch(Exception erprod){
						System.out.println(erprod.getMessage());
				}
			}
			this.ordenes.add(orden);
		} catch(Exception error){
			System.out.println(error.getMessage());
		}

	}

	public void listaOrdenes(){
		for(Ordenes orden : this.ordenes){
			System.out.println(orden.toString());

		}
	}

	public void listaClientes(){
		for(Cliente cliente: this.cliente){
			System.out.println(cliente.toString());
		}
	}

	public void listaProducto(){
		for(Producto pro : this.producto){
			System.out.println(pro.toString());
		}
	}
}