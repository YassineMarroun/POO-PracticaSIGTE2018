/**
 * @ (#) Ficha.java
 * 
 * Clase Ficha.
 * La clase Ficha representa el ticket de compra con los datos del cliente y los electrodomésticos
 * comprados en la tienda.
 * Contiene los campos numFicha, fechaFic, dniCliente y un ArrayList para incluir los artículos comprados
 * de tipo Electrodomestico.
 * Constructor sin parámetros y constructor con los atributos anteriormente mencionados.
 * Métodos selectores y métodos mutadores, o también llamados Getters y Setters para todos los campos.
 * Por último, tenemos el método toString, con el que se presenta de forma visual todos los datos
 * que contengan los campos de una instancia de Ficha.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Ficha {

	protected Integer numFicha;
	protected Calendar fechaFic;
	protected String dniCliente;
	protected ArrayList<Electrodomestico> electrodomesticos;
	protected Boolean financiar;
	protected Integer nomina;
	
	public Ficha () {
		
	}
	
	public Ficha (Integer numFicha, Calendar fechaFic, String dniCliente) {
		
		this.numFicha = numFicha;
		this.fechaFic = fechaFic;
		this.dniCliente = dniCliente;
		this.electrodomesticos = new ArrayList<Electrodomestico>();
	}
	
	public Integer getNumFicha() {
		return numFicha;
	}
	
	public void setNumFicha(Integer numFicha) {
		this.numFicha = numFicha;
	}
	
	public Calendar getFechaFic() {
		return fechaFic;
	}

	public void setFechaFic(Calendar fechaFic) {
		this.fechaFic = fechaFic;
	}
	
	public String getDniCliente() {
		return dniCliente;
	}
	
	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}
	
	public ArrayList<Electrodomestico> getElectrodomesticos() {
		return electrodomesticos;
	}

	public void setElectrodomesticos(ArrayList<Electrodomestico> electrodomesticos) {
		this.electrodomesticos = electrodomesticos;
	}   
	
	public Boolean getFinanciar() {
		return financiar;
	}

	public void setFinanciar(Boolean financiar) {
		this.financiar = financiar;
	}

	public Integer getNomina() {
		return nomina;
	}

	public void setNomina(Integer nomina) {
		this.nomina = nomina;
	}
	
	
	/*
	El método darFormatoFecha recibe el dato correspondiente a la fecha, que es de tipo Calendar,
	y mediante una instancia de SimpleDateFormat y llamando a su método format, devuelve la fecha en un String
	en el formato que queremos visualizar la fecha en la Ficha.
	 */
	public String darFormatoFecha(Calendar fechaFic){
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		return formatoFecha.format(fechaFic.getTime());
	}
	
	
	public String toString() {
		
		String datosFicha =   "\n Ficha: " + numFicha;
		datosFicha	= datosFicha + "\n Fecha: " + darFormatoFecha(fechaFic) +
							  "\n DNI del Cliente: " + dniCliente +
							  "\n Articulos comprados: \n";
		for (Electrodomestico electro: electrodomesticos) {
			electro.toStringFicha();
			datosFicha = datosFicha + electro.toStringFicha();
		}
		if (financiar && nomina==null) {
			datosFicha = datosFicha + " Pendiente tramite financiacion.";
		}
		if(financiar && nomina!=null){
			datosFicha = datosFicha + " Financiacion aprobada. " + "Nomina: " + nomina;
		}
		
		return datosFicha;
	}
}