/**
 * @ (#) Hogar.java
 * 
 * Clase Hogar.
 * Es una subclase que hereda de la clase madre Electrodomestico.
 * A los ya heredados, suma los campos cEnergetica, dimensiones y peso.
 * Constructor incluyendo los atributos particulares de esta clase.
 * Métodos Getters y Setters de sus campos.
 * Sobrescribe el método toString para describir el electrodomestico que estamos imprimiendo.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;

public class Hogar extends Electrodomestico{
	
	private String cEnergetica;
	private String dimensiones;
	private Integer peso;

	
	public Hogar(String marca, String modelo, String color, Integer precio, Integer stock, Integer cantidad,
			String cEnergetica, String dimensiones, Integer peso) {
			
		super(marca, modelo, color, precio, stock, 0);
		this.cEnergetica = cEnergetica;
		this.dimensiones = dimensiones;
		this.peso = peso;
	}

	
	public String getCEnergetica() {
		return cEnergetica;
	}

	public void setCEnergetica(String cEnergetica) {
		this.cEnergetica = cEnergetica;
	}
	
	public String getDimensiones() {
		return dimensiones;
	}
	
	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}
	
	public Integer getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	
	@Override	
	public String toString(){
		String datosHogar = super.toString() + " - Caracteristicas: "
				+ "\n Clase energetica " + cEnergetica + " - Dimensiones " + dimensiones + " - Peso " + peso;
		return datosHogar;
	}	
}