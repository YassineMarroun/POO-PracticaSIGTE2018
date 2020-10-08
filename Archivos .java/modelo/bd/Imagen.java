/**
 * @ (#) Imagen.java
 * 
 * Clase Imagen.
 * Es una subclase que también hereda de la superclase Electrodomestico.
 * A los ya heredados, suma los campos pulgadasPantalla, resolucion y frecuencia.
 * Constructor incluyendo los atributos particulares de esta clase.
 * Métodos Getters y Setters de sus campos.
 * Sobrescribe el método toString para diferenciar que el electrodomestico que estamos imprimiendo es de tipo Imagen.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;

public class Imagen extends Electrodomestico{
	
	private Integer pulgadasPantalla;
	private String resolucion;
	private Integer frecuencia;

	
	public Imagen(String marca, String modelo, String color, Integer precio, Integer stock, Integer cantidad,
			Integer pulgadasPantalla, String resolucion, Integer frecuencia) {
			
		super(marca, modelo, color, precio, stock, 0);
		this.pulgadasPantalla = pulgadasPantalla;
		this.resolucion = resolucion;
		this.frecuencia = frecuencia;
	}

	
	public Integer getPulgadasPantalla() {
		return pulgadasPantalla;
	}

	public void setPulgadasPantalla(Integer pulgadasPantalla) {
		this.pulgadasPantalla = pulgadasPantalla;
	}
	
	public String getResolucion() {
		return resolucion;
	}
	
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	
	public Integer getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(Integer frecuencia) {
		this.frecuencia = frecuencia;
	}

	
	@Override	
	public String toString(){
		String datosImagen = super.toString() + " - Caracteristicas: "
	+ "\n Pulgadas pantalla " + pulgadasPantalla + " - Resolucion " + resolucion + " - Frencuencia " + frecuencia;
		return datosImagen;
	}	
}