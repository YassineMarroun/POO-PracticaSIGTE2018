/**
 * @ (#) GestionTienda.java
 * 
 * Clase GestionTienda.
 * La clase GestionTienda desarrolla todos los métodos que dan vida, que dan funcionalidad,
 * a toda instancia que vayamos a crear de las clases Electrodomestico, Cliente y Promo.
 * Para almacenar una colección de objetos tenemos los HashMap electrodomesticos, clientes y promos,
 * y el ArrayList tecnicos.
 * Estas colecciones tienen la función de registro general, es decir, en cada mapa o lista se guarda
 * respectivamente todo objeto creado que necesite almacenar el sistema de gestión, y a su vez estar disponibles,
 * ya que diferentes métodos necesitaran acceder a dichas colecciones con frecuencia.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package gestion;
import modelo.bd.Electrodomestico;
import modelo.bd.Empleado;
import modelo.bd.Hogar;
import modelo.bd.Imagen;
import modelo.bd.Informatica;
import modelo.bd.Promo;
import modelo.bd.Sonido;
import modelo.bd.Telefonia;
import modelo.bd.Usuario;
import modelo.bd.Cliente;
import utilidades.Enumerados;
import utilidades.Utiles;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionTienda {

	public static Map<String, Electrodomestico> electrodomesticos = new HashMap<String, Electrodomestico>();
	public static Map<String, Cliente> clientes = new HashMap<String, Cliente>();
	public static List<Usuario> tecnicos = new ArrayList<Usuario>();
	public static Map<String, Promo> promos = new HashMap<String, Promo> ();

	
	/*
	El método crearDatosInicialesPruebas realiza la función de banco de pruebas, es decir,
	en él creamos una serie de objetos que se incluyen en los correspondientes mapas o lista,
	mencionados anteriormente. Con ello tenemos una base sobre la que realicemos pruebas
	una vez se inicia el programa. 
	 */
	public void crearDatosInicialesPruebas() {
		
		Hogar electro1 = new Hogar("Bosch", "SMS58M18", "Inox", 499, 8, 0, "A+", "845x600x600", 56);
		Imagen electro2 = new Imagen("Samsung", "UE65MU6105KXXC", "Negro", 951, 12, 0, 65, "Ultra HD 4K", 1300);
		Informatica electro3 = new Informatica("Lenovo", "Ideapad 320-15ISK", "Negro Onyx", 399, 24, 0, "Intel Core i3-6006U", "8 GB", "1 TB");
		Sonido electro4 = new Sonido("Bose", "SoundLink Mini II", "Perla", 199, 18, 0, "100 - 240 V", "Bluetooth", "microUSB, AUX");
		Telefonia electro5 = new Telefonia("Sony", "Xperia XA2 Ultra", "Negro", 429, 32, 0, "Full HD (1080p)", "16 MP - 23 MP", "3580 mAh");
		
		electrodomesticos.put("SMS58M18", electro1);
		electrodomesticos.put("UE65MU6105KXXC", electro2);
		electrodomesticos.put("Ideapad 320-15ISK", electro3);
		electrodomesticos.put("SoundLink Mini II", electro4);
		electrodomesticos.put("Xperia XA2 Ultra", electro5);
		
		Cliente cliente1 = new Cliente("Pedro", "Sanchez", "2453175S", "Calle Los Alpes, 23.", "632012587");
		Cliente cliente2 = new Cliente("Isabel", "Romero Diaz", "3785425A", "Calle Arcillas, 37.", "693214758");
		Cliente cliente3 = new Cliente("Daniel", "Escalante", "41236984H", "Avenida de las Retamas, 11.", "630247852");
		Cliente cliente4 = new Cliente("Juan", "Silva", "75216235P", "Calle Los Arces, 72.", "916325748");
		
		clientes.put("2453175S", cliente1);
		clientes.put("3785425A", cliente2);
		clientes.put("41236984H", cliente3);
		clientes.put("75216235P", cliente4);
		
		Empleado tecnico1 = new Empleado (Enumerados.TipoEmpleado.TECNICO, "Jorge", "Garrido", "45786329S");
	    Empleado tecnico2 = new Empleado (Enumerados.TipoEmpleado.TECNICO, "Carlos", "Bueno", "85147956Y");
	    Empleado tecnico3 = new Empleado (Enumerados.TipoEmpleado.TECNICO, "Sergio", "Ibaiz", "54359624N");
        tecnicos.add(tecnico1);
        tecnicos.add(tecnico2);
        tecnicos.add(tecnico3);
        
        
        Promo promo1 = new Promo("Navidades", "Descuento aplicable del 23/12 al 08/01.", 10);
		Promo promo2 = new Promo("DiasEspeciales", "Descuento aplicable en fechas señaladas.", 15);
		Promo promo3 = new Promo("RebajasEnero", "Descuento aplicable del 09/01 al 08/02.", 25);
		Promo promo4 = new Promo("RebajasJulio", "Descuento aplicable del 01/07 al 31/07.", 25);
		Promo promo5 = new Promo("BlackFriday", "Descuento aplicable del 20/11 al 25/11.", 18);
		
		promos.put("Navidades", promo1);
		promos.put("DiasEspeciales", promo2);
		promos.put("RebajasEnero", promo3);
		promos.put("RebajasJulio", promo4);
		promos.put("BlackFriday", promo5);
       
	}
	
	
	// Métodos para gestionar ELECTRODOMESTICOS.
	
	/*
	El método crearElectrodomestico crea una nueva instancia de Electrodomestico,
	le asigna los datos de la instancia que devuelve el método datosElectrodomestico
	y por último llama al método guardarElectrodomestico, pasándole como parámetro el objeto
	Electrodomestico creado.
	 */
	public void crearElectrodomestico(){
		
		Electrodomestico electrodomestico = new Electrodomestico();		
		electrodomestico = electrodomestico.datosElectrodomestico(true, null);
		guardarElectrodomestico(electrodomestico);
		
	}
	
	
	/*
	El método guardarElectrodomestico, mediante el campo modelo, comprueba si ya existe un objeto igual en el mapa
	electrodomesticos, si no es así, incluye en el mapa el nuevo objeto recibido como parámetro.
	 */
	public void guardarElectrodomestico(Electrodomestico electrodomestico){		
		Electrodomestico electro = electrodomesticos.get(electrodomestico.getModelo());
		if (electro != null) {
			System.out.println("No se puede introducir este Electrodomestico. Ya esta registrado.");
		} else {
			electrodomesticos.put(electrodomestico.getModelo(), electrodomestico);
		}
	}
	
	
	/*
	El método actualizarElectrodomestico solicita un String para una variable modelo, se la pasa al método
	buscarElectrodomestico para recuperar el objeto que tenga el mismo campo modelo,
	una vez tiene el objeto electrodomestico que necesitamos, invoca con dicha instancia al método
	datosElectrodomestico para que se introduzca de nuevo todos los datos para esa instancia.
	Finalmente, la guarda en el mapa electrodomesticos.
	 */
	public void actualizarElectrodomestico(){
        String modelo;
        System.out.println("Introduzca el MODELO de electrodomestico para actualizar sus datos: ");
        modelo = Utiles.sc.nextLine();
        Electrodomestico electrodomestico = buscarElectrodomestico(modelo);
        if (electrodomestico!=null){
    		electrodomestico = electrodomestico.datosElectrodomestico(false, electrodomestico.getModelo());
    		electrodomesticos.put(electrodomestico.getModelo(), electrodomestico);
        } else{
        	System.out.println("No existe dicho MODELO.");
        }
    } 

	
	/*
	El método buscarElectrodomestico recibe una variable modelo y devuelve la instancia electrodomestico
	que contenga el mismo campo modelo.
	 */
	public Electrodomestico buscarElectrodomestico(String modelo){
		return electrodomesticos.get(modelo);
    }
	
	
	/*
	El método buscarElectrodomesticoPantalla solicita que se introduzca un String para una variable modelo.
	Se crea un objeto electrodomestico al que se asigna una instancia que recuperamos con
	buscarElectrodomestico pasándole modelo.
	Si existe, finalmente, imprime todos los datos de dicho electrodomestico.
	 */
	public void buscarElectrodomesticoPantalla(){
        String modelo;
        System.out.println("Buscar Electrodomestico por MODELO: ");
        modelo = Utiles.sc.nextLine();
        Electrodomestico electrodomestico = buscarElectrodomestico(modelo);
        if (electrodomestico!=null){
        	System.out.println(electrodomestico.toString());
        } else{
        	System.out.println("No existe dicho modelo.");
        }
    }
    
	
	/*
	El método listarElectrodomesticos recorre el mapa electrodomesticos mediante un bucle for extendido o for each,
	e imprime los datos que contiene todo objeto o instancia electrodomestico que tenemos almacenada en el mapa.
	Con este método visualizaremos, por ejemplo, el inventario de electrodomésticos que tenemos en tienda.
	 */
	public void listarElectrodomesticos(){
		for (Electrodomestico electro : electrodomesticos.values()) {
			System.out.println(electro.toStringInventario());
		}
	}
	
	
	// Métodos para gestionar CLIENTES.
	
	/*
	El método crearCliente crea una nueva instancia de Cliente, le asigna los datos de la instancia
	que devuelve el método datosCliente y por último llama al método guardarCliente,
	pasándole como parámetro el objeto Cliente creado.
	 */
	public void crearCliente(){
		
		Cliente cliente = new Cliente();		
		cliente = cliente.datosCliente();
		guardarCliente(cliente);	
	}
	
	
	/*
	El método guardarCliente, mediante el campo dni, comprueba si ya existe un objeto igual en el mapa clientes,
	si no es así, incluye en el mapa el nuevo objeto recibido como parámetro.
	 */
	public void guardarCliente(Cliente cliente){		
		Cliente cl = clientes.get(cliente.getDni());
		if (cl != null) {
			System.out.println("No se puede introducir el Cliente. Ya esta registrado.");
		} else {
			clientes.put(cliente.getDni(), cliente);
		}
	}
	
	
	/*
	El método actualizarCliente solicita un String para una variable dni, se la pasa al método buscarCliente
	para recuperar el objeto que tenga el mismo campo dni, una vez tiene el objeto cliente que necesitamos,
	invoca con dicha instancia al método datosCliente para que se introduzca de nuevo todos los datos
	para esa instancia. Finalmente, la guarda en el mapa clientes.
	 */
	public void actualizarCliente(){
        String dni;
        System.out.println("Introduzca el DNI del cliente para actualizar sus datos: ");
        dni = Utiles.sc.nextLine();
        Cliente cliente = buscarCliente(dni);
        if (cliente!=null){
        	cliente = cliente.datosCliente();
    		clientes.put(cliente.getDni(), cliente);
        } else{
        	System.out.println("Cliente no existente.");
        }
    } 
	
	
	/*
	El método buscarCliente recibe una variable dni y devuelve la instancia cliente que contengo el mismo campo dni.
	 */
	public Cliente buscarCliente(String dni){		
		return clientes.get(dni);
	}

	
	/*
	El método buscarClientePantalla solicita que se introduzca un String para una variable dni.
	Se crea un objeto cliente al que se asigna una instancia que recuperamos con buscarCliente pasándole dni.
	Si existe, finalmente, imprime todos los datos de dicho cliente.
	 */
	public void buscarClientePantalla(){
        String dni;
        System.out.println("Buscar Cliente por DNI: ");
        dni = Utiles.sc.nextLine();
        Cliente cliente = buscarCliente(dni);
        if (cliente!=null){
        	System.out.println(cliente.toString());
        } else{
        	System.out.println("Cliente no existente.");
        }
    }
	
	
	// Métodos para gestionar PROMOCIONES.
	
	/*
	El método buscarPromo devuelve una instancia de Promo en la que coincida el campo nombre
	que se ha pasado al método como parámetro. 
	 */
	public Promo buscarPromo(String nombre){
		return promos.get(nombre);
    }
	
	
	/*
	El método noOfertada, recibe por parámetro un cliente y una promo, comprueba, mediante el campo nombre,
	si dicho cliente tiene una instancia con los mismos datos en su lista promos, si es así,
	devuelve dicha instancia, si no retorna null.
	 */
	private Promo noOfertada(Cliente cl, Promo promo){
		if (cl.getPromos()==null){
			return null;			
		}
		for (Promo promoCli: cl.getPromos()){
			if (promoCli.getNombre().equals(promo.getNombre())){				
				 return promoCli;
			}
		}
		return null;
	}
	
	
	/*
	El método de tipo Boolean haPasadounAnno recibe una instancia promo, mediante su campo fechaPresentada
	comprueba si ha sido presentada, esta instrucción devuelve true en caso de que fechaPresentada contenga null
	o una fecha que no alcance al año respecto a la fecha actual.
	Si no cumple ninguna de las dos condiciones retorna false.
	 */
	private Boolean haPasadounAnno(Promo yaOfertada){		
	    Calendar haceUnAnno = Calendar.getInstance();
	    haceUnAnno.add(Calendar.YEAR, -1);
		if (yaOfertada.getFechaPresentada() == null || yaOfertada.getFechaPresentada().before(haceUnAnno)){	
			return true;
		}
		return false;
	}
	
	
	/*
	El objetivo del método enviarPromo es incluir una instancia de la promo que se quiera en un momento dado,
	en la lista promos que tiene cada objeto cliente.
	Primero solicita un String para la variable nombrePro, crea una instancia promo con los datos de la instancia
	que devuelve buscarPromo tras la búsqueda que ha realizado con nombrePro.
	Con un bucle for each recorre el mapa clientes, comprueba en cada cliente, mediante los métodos
	noOfertada y haPasadounAnno, si contiene una instancia de la promo que tenemos en su correspondiente
	lista promos, si no es así, la incluye.
	 */
	public void enviarPromo() {
		
		Boolean enviada = false;
		System.out.println("Introduce el nombre de la PROMOCION a enviar: ");
		String nombrePro = Utiles.sc.nextLine();
		Promo promo = buscarPromo(nombrePro);
		if (promo!=null){
			for (Cliente cl : clientes.values()) {
				Promo yaOfertada = noOfertada(cl, promo);           
				if (yaOfertada == null){
					if (cl.getPromos()==null){
						cl.setPromos(new ArrayList<Promo>());
					}
					promo.setFechaPresentada(Calendar.getInstance());
					cl.getPromos().add(promo);
					enviada = true;
				} else{
					if (haPasadounAnno(yaOfertada)){
						promo.setFechaPresentada(Calendar.getInstance());
						cl.getPromos().add(promo);
						enviada = true;
					}
				}
			}
			if (enviada){
				System.out.println("\nPromocion enviada correctamente.");
			} else {
				System.out.println("\nOferta ya presentada hace menos de un año a todos los clientes.");
			}
        } else{
        	System.out.println("\nNo existe Promocion.");
        }
	}
	
	
	/*
	El método promosCliente solicita un String para una variable dni. Localiza al cliente que tiene
	el mismo campo dni. Imprime su nombre, apellidos y las promos que tiene en su lista.
	Este método nos valdría para enviarle un correo electrónico al cliente con sus datos y promociones,
	tal como indica el enunciado.
	 */
	public void promosCliente() {
		System.out.println("Introduzca el DNI del cliente para enviarle sus PROMOCIONES: ");
		String dni = Utiles.sc.nextLine();
		Cliente cl = clientes.get(dni);
		if (cl != null){
			System.out.println("\nEstimado/a cliente: " + cl.getNombre() + " "+ cl.getApellidos() + 
							   ", tiene a su disposicion las siguientes PROMOCIONES:");
			for(Promo promo: cl.getPromos()){
				System.out.println(promo.toString());
			}
		}
	}
}