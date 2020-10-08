/**
 * @ (#) Usuario.java
 * 
 * Clase Usuario.
 * Es la superclase de la que van a heredar las clases Cliente y Empleado.
 * Contiene los campos nombre, apellidos y dni que van a ser comunes a las subclases indicadas anteriormente.
 * Constructor sin parámetros y constructor con los atributos anteriormente mencionados.
 * Métodos selectores y métodos mutadores, o también llamados Getters y Setters para todos los campos.
 * Por último, tenemos el método toString, con el que se presenta de forma visual el objeto o los objetos creados
 * de la clase Usuario.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package modelo.bd;

public class Usuario {

	protected String nombre;
	protected String apellidos;
	protected String dni;
	
	
	public Usuario () {
		
	}
	
	public Usuario (String nombre, String apellidos, String dni) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	@Override
	public String toString() {
		String datosUsuario = " Nombre: " + nombre + " " + apellidos + " DNI: " + dni;
		return datosUsuario;
	}
}