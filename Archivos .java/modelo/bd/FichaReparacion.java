/**
 * @ (#) FichaReparacion.java
 * 
 * Clase FichaReparacion.
 * Es una subclase que hereda de la clase Ficha, y en este caso se crea la instancia de FichaReparacion
 * cuando el ticket corresponde a una petición de reparación. 
 * Tiene de más los campos nombreTecnico, piezas, observaciones y de tipo Enumerado, estado y parado.
 * Constructor sin parámetros y constructor con los atributos heredados más los atributos particulares de esta clase.
 * Métodos Getters y Setters de sus atributos.
 * Por último, tenemos el método toString, con el que visualizamos todos los datos contenidos
 * en los objetos de la clase FichaReparacion.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;
import utilidades.Enumerados;
import java.util.ArrayList;
import java.util.Calendar;


public class FichaReparacion extends Ficha{

	private String nombreTecnico;
	private String piezas;
	private Enumerados.EstadoReparacion estado;
	private Enumerados.Parado parado;
	private String observaciones;
	
	public FichaReparacion() {
		
	}
	
	public FichaReparacion (Integer numFicha, Calendar fechaFic, String dniCliente, String nombreTecnico,
			String piezas, String observaciones) {
		
		super(numFicha, fechaFic, dniCliente);
		this.electrodomesticos = new ArrayList<Electrodomestico>();
		this.nombreTecnico = nombreTecnico;
		this.piezas = piezas;
		this.estado = Enumerados.EstadoReparacion.PENDIENTE;
		this.observaciones = observaciones;
	}
	
	public String getNombreTecnico() {
		return nombreTecnico;
	}
	
	public void setNombreTecnico(String nombreTecnico) {
		this.nombreTecnico = nombreTecnico;
	}
	
	public String getPiezas() {
		return piezas;
	}
	
	public void setPiezas(String piezas) {
		this.piezas = piezas;
	}
	
	public Enumerados.EstadoReparacion getEstado() {
		return estado;
	}
	
	public void setEstado(Enumerados.EstadoReparacion estado) {
		this.estado = estado;
	}
	
	public Enumerados.Parado getParado() {
		return parado;
	}
	
	public void setParado(Enumerados.Parado parado) {
		this.parado = parado;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	public String toStringRE() {
		
		String datosFichaRE = "\n Ficha de REPARACION: " +
							  "\n Ficha: " + numFicha +
							  "\n Fecha: " + darFormatoFecha(fechaFic) +
							  "\n DNI del Cliente: " + dniCliente +
							  "\n Nombre Tecnico: " + nombreTecnico +
							  "\n Articulos a REPARAR: ";
							  for (Electrodomestico electro: electrodomesticos) {
									electro.toStringFicha();
									datosFichaRE = datosFichaRE + electro.toStringFichaRE();
								} 
		datosFichaRE = datosFichaRE + " Piezas necesarias: " + piezas +
							  		  "\n Estado: " + estado.toString();
		if (estado == Enumerados.EstadoReparacion.PARADO && parado!=null){
			datosFichaRE = datosFichaRE + "\n Motivo: " + parado.toString();
		}
		datosFichaRE = datosFichaRE + " Observaciones: " + observaciones;
							  
		return datosFichaRE;
	}
}