/**
 * @ (#) Tienda.java
 * 
 * Clase Tienda.
 * Tal como pide el enunciado, Tienda es la clase principal que abre la aplicaci�n.
 * �nicamente va a incluir la creaci�n de un objeto menu.
 * La llamada de ese objeto al m�todo menuInicio y al m�todo menuPrincipal.
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