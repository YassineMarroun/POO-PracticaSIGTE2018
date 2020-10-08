/**
 * @ (#) Electrodomestico.java
 * 
 * Clase Electrodomestico.
 * Es la superclase de las clases Hogar, Imagen, Informatica, Sonido y Telefonia.
 * En esta versi�n del sistema, representa cada modelo de electrodom�stico que tenemos en la tienda.
 * El aspecto que m�s trabajo puede dar es mantener un control respecto al n�mero de electrodom�sticos
 * que se tienen de un modelo, la cantidad que el cliente compra de dicho modelo y la cantidad que devuelva
 * si se da el caso. Para ello tenemos los campos stock y cantidad. Trabajamos con ambos en varios m�todos
 * para controlar el inventario y el n�mero de art�culos que figura en la ficha de compra del cliente,
 * respectivamente.
 * Esta clase implementa la interfaz cloneable que nos permiten crear copias de objetos electrodomestico
 * que ya tengamos con anterioridad.
 * Las subclases heredan tanto campos, constructores como m�todos de su superclase formando
 * una jerarqu�a de herencia.
 * Contiene los campos marca, modelo, color, precio, stock y cantidad. Y duplicado, variable
 * en la que guardaremos la nueva instancia de electrodomestico cuando necesitemos la copia de un objeto
 * que ya tenemos en alguna colecci�n.
 * Con ello podemos manipular la nueva copia sin que afecte a la instancia original.
 * Constructor sin par�metros y constructor con los campos mencionados.
 * M�todos selectores y m�todos mutadores, o tambi�n llamados Getters y Setters para todos los campos.
 * Para visualizar los datos tenemos cuatro m�todos toString:
 * El primero muestra todos los datos y va a ser el m�todo que utilicen las instancias que creemos
 * a partir de las subclases. El segundo, toStringInventario, ser� invocado en caso de querer listas,
 * como un listado de todos los electrodom�sticos, por ejemplo. toStringFicha, muestra tres atributos,
 * y hacemos uso de �l cuando se imprime una ficha, donde adem�s del electrodom�stico,
 * se muestran m�s datos del cliente. Por �ltimo, toStringFichaRE para fichas de reparaci�n.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;
import utilidades.Utiles;

public class Electrodomestico implements Cloneable{
	
	protected String marca;
	protected String modelo;
	protected String color;
	protected Integer precio;
	protected Integer stock;
	protected Integer cantidad;
	
	private Object duplicado = new Object();
	
	
	public Electrodomestico () {
		
	}
	
	public Electrodomestico (String marca, String modelo, String color, Integer precio, Integer stock, Integer cantidad) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;
		this.stock = stock;
		this.cantidad = cantidad;
	}
	
	
	/*
	El m�todo clone va a crear una nueva instancia de tipo Electrodomestico de un objeto que ya se tiene,
	devolviendo la copia creada.
	 */
	 @Override
	 public Object clone() throws CloneNotSupportedException {
	  Electrodomestico clone = (Electrodomestico)super.clone();
	     clone.duplicado = new Object();
	     return clone;
	 }

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	public Integer getStock() {
		return stock;
	}
	
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Object getDuplicado() {
		return duplicado;
	}

	public void setDuplicado(Object duplicado) {
		this.duplicado = duplicado;
	}

	
	/*
	El m�todo datosElectrodomestico solicita que se introduzcan por teclado datos para cada uno de los campos
	con los que finalmente crea y devuelve un objeto de tipo Electrodomestico.
	 */
	public Electrodomestico datosElectrodomestico(boolean alta, String clave) {  	  
		String modelo = clave;
		System.out.print("Introduzca la MARCA: ");
        String marca = Utiles.sc.nextLine();
        if (alta) {
        	System.out.print("Introduzca el MODELO: ");
        	modelo = Utiles.sc.nextLine();
        }
        System.out.print("Introduzca el COLOR: ");
        String color = Utiles.sc.nextLine();
        System.out.print("Introduzca el PRECIO: ");
        Integer precio =  Utiles.escanerInt();
        System.out.print("Introduzca el STOCK en tienda: ");
        Integer stock =  Utiles.escanerInt();
        Electrodomestico electrodomestico = new Electrodomestico(marca, modelo, color, precio, stock, 0);
        return electrodomestico;       
	}
	
	
	@Override
	public String toString() {		
		String datos = " " + marca + " " + modelo + " - " + color + " - " + precio + " � - En stock " + stock + " u.";	
		return datos;
	}
	
	public String toStringInventario() {
		String datosInventario =  " " + marca + " " + modelo + " - " + color + " - " + precio + " � - En stock " + stock + " u.";
		return datosInventario;
	}

	public String toStringFicha() {
		String datosFicha =  " " + marca + " " + modelo + " - " + precio + " � - Cantidad: " + cantidad + "\n";
		return datosFicha;
	}
	
	public String toStringFichaRE() {
		String datosFicha =  " " + marca + " " + modelo + " - " + precio + " �\n";
		return datosFicha;
	}
}