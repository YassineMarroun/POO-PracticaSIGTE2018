/**
 * @ (#) Cliente.java
 * 
 * Clase Cliente.
 * Es una subclase que hereda de la clase madre Usuario.
 * La clase GestionTienda contiene un mapa donde almacenaremos cada objeto creado de la clase Cliente,
 * y además se desarrollan métodos para dar funcionalidad a dichos objetos.
 * Una instancia de la clase Cliente, además de los ya heredados, va a tener los campos domicilio, telefono
 * y tres ArrayList que almacenen objetos de tipo Electrodomestico, Ficha y Promo respectivamente.
 * Constructor sin parámetros y constructor con los atributos heredados más los atributos particulares de esta clase.
 * Métodos Getters y Setters de sus campos particulares.
 * Por último, tenemos el método toString, con el que visualizamos los datos personales de un Cliente,
 * un listado de los electrodomesticos que ha comprado, más la información que incluya o no
 * en su correspondiente lista promos. 
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;
import utilidades.Utiles;
import java.util.ArrayList;

public class Cliente extends Usuario{
	
	private String domicilio;
	private String telefono;
	private ArrayList<Electrodomestico> electrodomesticos;
	private ArrayList<Ficha> fichas;
	private ArrayList<Promo> promos;
	
	public Cliente () {
		
	}
	
	public Cliente(String nombre, String apellidos, String dni, String domicilio, String telefono) {
			
		super(nombre, apellidos, dni);
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.electrodomesticos = new ArrayList<Electrodomestico>();
		this.fichas = new ArrayList<Ficha>();
	}

	
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public ArrayList<Electrodomestico> getElectrodomesticos() {
		return electrodomesticos;
	}

	public void setElectrodomesticos(ArrayList<Electrodomestico> electrodomesticos) {
		this.electrodomesticos = electrodomesticos;
	}
	
	public ArrayList<Ficha> getFichas() {
		return fichas;
	}
	
	public void setFichas(ArrayList<Ficha> fichas) {
		this.fichas = fichas;
	}
	
	public ArrayList<Promo> getPromos() {
		return promos;
	}

	public void setPromos(ArrayList<Promo> promos) {
		this.promos = promos;
	}
	

	/*
	El método datosCliente solicita que se introduzcan por teclado datos para cada uno de los campos
	con los que finalmente crea y devuelve un objeto de tipo Cliente, sin incluir las listas,
	ya que éstas se rellenan mediante otros métodos que iremos detallando.
	 */
	public Cliente datosCliente() {  	  
        System.out.print("Introduzca el nombre del Cliente: ");
        String nombre = Utiles.sc.nextLine();
        System.out.print("Introduzca los apellidos del Cliente: ");
        String apellidos = Utiles.sc.nextLine();
        System.out.print("Introduzca el DNI: ");
        String dni = Utiles.sc.nextLine();
        System.out.print("Introduzca el DOMICILIO: ");
        String domicilio = Utiles.sc.nextLine();
        System.out.print("Introduzca el TELEFONO: ");
        String telefono = Utiles.sc.nextLine();
        Cliente cliente = new Cliente(nombre, apellidos, dni, domicilio, telefono);
        return cliente;       
	}
	
	
	@Override	
	public String toString(){
		String datosCliente = super.toString() + " - " + domicilio + " - " + telefono + 
							  "\n Electrodomesticos comprados: ";
							  for (Electrodomestico electro: electrodomesticos) {
								  electro.toStringFicha();
								  datosCliente = datosCliente + electro.toStringFicha();
							  }
							  datosCliente = datosCliente + "\n Tiene Promociones: ";							 
							  if (promos==null || promos.size()<=0){
								  datosCliente = datosCliente + "No.";
							  } else {
								  datosCliente = datosCliente + "Si.";
								  datosCliente = datosCliente + getPromos().toString();
							  }
		
							  datosCliente = datosCliente + "\n ********** \n ";
		return datosCliente;
	}	
}