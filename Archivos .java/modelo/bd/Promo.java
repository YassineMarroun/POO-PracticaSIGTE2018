/**
 * @ (#) Promo.java
 * 
 * Clase Promo.
 * Esta clase permite crear objetos para las ofertas y promociones de las que dispone la tienda.
 * GestionTienda tiene un mapa donde se guarda cada una de las instancias creadas de Promo,
 * y además se desarrollan métodos para gestionar dichas promos.
 * Los campos que forman parte de esta clase son: nombre, descripcion, porcentajeDescuento,
 * ofertada y presentada de tipo Boolean y fechaPresentada de tipo Calendar.
 * Constructor sin parámetros y constructor con los parámetros indicados.
 * Los correspondientes Getters y Setters para todos los campos.
 * Método toString para visualizar en consola los datos de un objeto promo.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;
import java.util.Calendar;

public class Promo {
	
	String nombre;
	String descripcion;
	Integer porcentajeDescuento;
	Boolean ofertada;
	Boolean presentada;
	Calendar fechaPresentada;
	
	public Promo() {
	}

	public Promo(String nombre, String descripcion, Integer porcentajeDescuento) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentajeDescuento = porcentajeDescuento;
		this.ofertada = true;
		this.presentada = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Integer porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	public Boolean getOfertada() {
		return ofertada;
	}

	public void setOfertada(Boolean ofertada) {
		this.ofertada = ofertada;
	}

	public Boolean getPresentada() {
		return presentada;
	}

	public void setPresentada(Boolean presentada) {
		this.presentada = presentada;
	}

	public Calendar getFechaPresentada() {
		return fechaPresentada;
	}

	public void setFechaPresentada(Calendar fechaPresentada) {
		this.fechaPresentada = fechaPresentada;
	}
	
	@Override	
	public String toString(){
		String datosPromo = "\n Promocion: " + nombre + 
				   			"\n " + descripcion + 
				   			"\n Porcentaje de descuento: " + porcentajeDescuento + " %";
		return datosPromo;
	}	

}
