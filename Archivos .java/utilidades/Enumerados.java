/**
 * @ (#) Enumerados.java
 * 
 * Clase Enumerados.
 * En esta clase Enumerados, vamos a tener una serie de tipos enumerados que nos van a permitir clasificar un objeto
 * según sus características y en función de los posibles valores que tenga su tipo enumerado correspondiente.
 * Esto nos va a permitir desarrollar diferentes funciones según los valores que adquiera un objeto
 * Los tipos enumerados que tenemos son los siguientes:
 * TipoEmpleado, EstadoReparacion, y Parado.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package utilidades;

public class Enumerados {

	public enum TipoEmpleado{
		TECNICO,
		CAJERO,
		FINANCIACION,
		POSTVENTA,
		COMERCIAL
	}
	
	public enum EstadoReparacion {
		PENDIENTE,
		EN_PROCESO,
		PARADO,
		FASE_PRUEBA,
		TERMINADO	
	}
	
	public enum Parado {
		FALTAN_PIEZAS,
        CONFIRMAR_CLIENTE	
	}
	
	
	/*
	Los métodos menuEstadoReparacion y menuParado, con la misma estructura for each, nos permiten visualizar
	las diferentes opciones que tiene cada tipo enumerado, para poder mostrar al usuario cuando está introduciendo
	los datos.
	 */
	public static String menuEstadoReparacion(){
		String tipos = "";
		for (Enumerados.EstadoReparacion vm: Enumerados.EstadoReparacion.values()){
			tipos = tipos + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tipos;
	}
	
	public static String menuParado(){
		String tiposP = "";
		for (Enumerados.Parado vm: Enumerados.Parado.values()){
			tiposP = tiposP + vm.ordinal() + ". " + vm.toString() + "; ";
		}
		return tiposP;
	}
}
