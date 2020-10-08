/**
 * @ (#) Telefonia.java
 * 
 * Clase Telefonia.
 * Es una subclase que también hereda de la superclase Electrodomestico.
 * A los ya heredados, suma los campos pantalla, camara y bateria.
 * Constructor incluyendo los atributos particulares de esta clase.
 * Métodos Getters y Setters de sus campos.
 * Sobrescribe el método toString para diferenciar que el electrodomestico que estamos imprimiendo
 * es de tipo Telefonia.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;

public class Telefonia extends Electrodomestico{
	
	private String pantalla;
	private String camara;
	private String bateria;

	
	public Telefonia(String marca, String modelo, String color, Integer precio, Integer stock, Integer cantidad,
			String pantalla, String camara, String bateria) {
			
		super(marca, modelo, color, precio, stock, cantidad);
		this.pantalla = pantalla;
		this.camara = camara;
		this.bateria = bateria;
	}

	
	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}
	
	public String getCamara() {
		return camara;
	}
	
	public void setCamara(String camara) {
		this.camara = camara;
	}
	
	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	
	@Override	
	public String toString(){
		String datosTelefonia = super.toString() + " - Caracteristicas: "
				+ "\n Pantalla " + pantalla + " - Camara " + camara + " - Bateria " + bateria;
		return datosTelefonia;
	}	
}