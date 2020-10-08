/**
 * @ (#) Sonido.java
 * 
 * Clase Sonido.
 * Es una subclase que también hereda de la superclase Electrodomestico.
 * A los ya heredados, suma los campos potencia, funciones y conexiones.
 * Constructor incluyendo los atributos particulares de esta clase.
 * Métodos Getters y Setters de sus campos.
 * Sobrescribe el método toString para diferenciar que el electrodomestico que estamos imprimiendo es de tipo Sonido.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;

public class Sonido extends Electrodomestico{
	
	private String potencia;
	private String funciones;
	private String conexiones;

	
	public Sonido(String marca, String modelo, String color, Integer precio, Integer stock, Integer cantidad,
			String potencia, String funciones, String conexiones) {
			
		super(marca, modelo, color, precio, stock, cantidad);
		this.potencia = potencia;
		this.funciones = funciones;
		this.conexiones = conexiones;
	}

	
	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	
	public String getFunciones() {
		return funciones;
	}
	
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}
	
	public String getConexiones() {
		return conexiones;
	}

	public void setConexiones(String conexiones) {
		this.conexiones = conexiones;
	}

	
	@Override	
	public String toString(){
		String datosSonido = super.toString() + " - Caracteristicas: "
				+ "\n Potencia " + potencia + " - Funciones " + funciones + " - Conexiones " + conexiones;
		return datosSonido;
	}	
}