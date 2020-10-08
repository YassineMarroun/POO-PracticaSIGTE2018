/**
 * @ (#) Tienda.java
 * 
 * Clase Tienda.
 * Tal como pide el enunciado, Tienda es la clase principal que abre la aplicación.
 * Únicamente va a incluir la creación de un objeto menu.
 * La llamada de ese objeto al método menuInicio y al método menuPrincipal.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package gestion;

public class Tienda {

	public static void main (String[] args){		
		
        Menu menu = new Menu();
		menu.menuInicio();
        menu.menuPrincipal();
	}
}