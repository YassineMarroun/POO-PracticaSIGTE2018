/**
 * @ (#) Informatica.java
 * 
 * Clase Informatica.
 * Es una subclase que también hereda de la superclase Electrodomestico.
 * A los ya heredados, suma los campos procesador, ram y almacenamiento.
 * Constructor incluyendo los atributos particulares de esta clase.
 * Métodos Getters y Setters de sus campos.
 * Sobrescribe el método toString para diferenciar que el electrodomestico que estamos imprimiendo
 * es de tipo Informatica.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;

public class Informatica extends Electrodomestico{
	
	private String procesador;
	private String ram;
	private String almacenamiento;

	
	public Informatica(String marca, String modelo, String color, Integer precio, Integer stock, Integer cantidad,
			String procesador, String ram, String almacenamiento) {
			
		super(marca, modelo, color, precio, stock, 0);
		this.procesador = procesador;
		this.ram = ram;
		this.almacenamiento = almacenamiento;
	}

	
	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	
	public String getRam() {
		return ram;
	}
	
	public void setRam(String ram) {
		this.ram = ram;
	}
	
	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public void setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
	}

	
	@Override	
	public String toString(){
		String datosInformatica = super.toString() + " - Caracteristicas: "
				+ "\n Procesador " + procesador + " - RAM " + ram + " - Almacenamiento " + almacenamiento;
		return datosInformatica;
	}	
}