/**
 * @ (#) Empleado.java
 * 
 * Clase Empleado.
 * Es una subclase que tambi�n hereda de la clase madre Usuario.
 * Representa a los empleados que tiene la tienda.
 * A los campos ya heredados, esta clase solo a�ade el campo tipoEmpleado,
 * es un tipo enumerado que nos permite clasificar el tipo de empleado que vayamos a instanciar.
 * Constructor con los atributos heredados m�s el atributo particular de esta clase.
 * M�todos Getter y Setter de su atributo.
 * Por �ltimo, tenemos el m�todo toString con el que se visualiza los datos de los objetos creados
 * de la clase Empleado.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;
import utilidades.Enumerados;

public class Empleado extends Usuario{
	
	private Enumerados.TipoEmpleado tipoEmpleado;

	
	public Empleado(Enumerados.TipoEmpleado tipoEmpleado, String nombre, String apellidos, String dni) {
			
		super(nombre, apellidos, dni);
		this.tipoEmpleado = tipoEmpleado;
	}

	
	public Enumerados.TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(Enumerados.TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	

	@Override	
	public String toString(){
		String datosEmpleado = tipoEmpleado + super.toString();
		return datosEmpleado;
	}	
}