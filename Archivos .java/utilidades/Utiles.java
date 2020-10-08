/**
 * @ (#) Utiles.java
 * 
 * Clase Utiles.
 * Esta clase se ha creado para incluir en ella m�todos generales que en un momento dado
 * pueden ser necesarios para que otras clases de distintos paquetes puedan desarrollar alguna funcionalidad
 * requerida.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package utilidades;
import java.util.Scanner;

public class Utiles {
	
	public static final Scanner sc = new Scanner(System.in);
	
	/*
	El m�todo escanerInt , en toda ocasi�n que necesitamos obtener por teclado datos de tipo Integer,
	evita posibles fallos de programa recogiendo los errores con un catch.
	 */	
	public static Integer escanerInt(){
		try{
			Integer numero = sc.nextInt();
			sc.nextLine(); 
			return numero;
		    }
		catch(Exception e){
				sc.nextLine(); 
				return -1;
		}
	}
}
