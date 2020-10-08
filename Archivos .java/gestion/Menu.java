/**
 * @ (#) Menu.java
 * 
 * Clase Menu.
 * Esta clase recoge los diferentes menús para cada tipo de empleado de la tienda,
 * se selecciona la gestión a realizar y a dicha selección va relacionada una llamada al método correspondiente.
 * Para esta clase creamos dos objetos.
 * gestionTienda de tipo GestionTienda.
 * gestionFicha de tipo GestionFicha.
 * En función de la acción que se quiera hacer se invocan los métodos que corresponden a un objeto u otro.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package gestion;
import utilidades.Utiles;

public class Menu {
	
	private GestionTienda gestionTienda = new GestionTienda();
	private GestionFicha gestionFicha = new GestionFicha();
	
	
	/*
	El método menuInicio únicamente realiza una llamada al método crearDatosInicialesPruebas
	con el que inicializamos una serie de mapas electrodomesticos, clientes y promos, y la lista tecnicos,
	conteniendo ya objetos del tipo que les corresponde que sirven como base para realizar pruebas de unidades.
	 */
	public void menuInicio() {
		gestionTienda.crearDatosInicialesPruebas();
	}
	
	
	/*
	Menu Principal. Se elije una opción según el tipo de empleado que quiere realizar una gestion.
	Para cada tipo de empleado se despliega un menu para que seleccione una de las posibles funciones.
	 */
	public int menuPrincipal(){
		
		System.out.println("\n Menu Principal.");
		
		int menu = 0;
		Integer numOpcs = 6;
		
		do{
			System.out.println("1. Menu CAJERO");
			System.out.println("2. Menu FINANCIACION");
			System.out.println("3. Menu TECNICO");
			System.out.println("4. Menu COMERCIAL");
			System.out.println("5. Menu POSTVENTA");
			System.out.println("6. Salir.");
	    	System.out.print("Opcion> ");
	
	    	menu = Utiles.escanerInt();
			
			if (menu<1 || menu>numOpcs) {
				System.out.println("Opcion incorrecta. Vuelve a probar");
	    	}
				
	    	switch (menu){
	    			
	    		case 1:
	                menuCajero();
	                break;
	    		case 2:
	    			menuFinanciacion();
	                break;
	    		case 3:
	    			menuTecnico();
	    			break;
	    		case 4:
	                menuComercial();
	                break;
	    		case 5:
	    			menuPostventa();
	    			break;
	    		case 6:
	    			System.out.println("...");
	    			break;
	    	}
		} while(menu <= numOpcs);
		
	    return menu;
	}
	
	
	// Menu Cajero.
	
	private int menuCajero(){
		
		int menu1 = 0;
		Integer numOpcs = 12;
			
		do{ 
			System.out.println("\n");
			System.out.println("1. Nuevo Electrodomestico.");
			System.out.println("2. Actualizar Electrodomestico.");
			System.out.println("3. Buscar Electrodomestico.");
			System.out.println("4. Generar inventario de Electrodomesticos.");
			System.out.println("5. Nuevo Cliente.");
			System.out.println("6. Actualizar Cliente.");
			System.out.println("7. Buscar Cliente.");
			System.out.println("8. Realizar COMPRA.");
			System.out.println("9. Listado de Fichas.");
			System.out.println("10. Buscar Ficha por su numero.");
			System.out.println("11. Buscar Ficha por DNI del Cliente.");
			System.out.println("12. Salir.");
	    	System.out.print("Opcion> ");
	    		
	    	menu1 = Utiles.escanerInt();
				
			if (menu1<1 || menu1>numOpcs) {
				System.out.println("Opcion incorrecta. Vuelve a probar");
	    	}
				
	    	switch (menu1){
	    			
	    		case 1:
	    			gestionTienda.crearElectrodomestico();
	                break;
	    		case 2:
	    			gestionTienda.actualizarElectrodomestico();
	                break;
	    		case 3:
	    			gestionTienda.buscarElectrodomesticoPantalla();
	                break;
	    		case 4:
	    			gestionTienda.listarElectrodomesticos();
	                break;
	    		case 5:
	    			gestionTienda.crearCliente();
	                break;
	    		case 6:
	    			gestionTienda.actualizarCliente();
	                break;
	    		case 7:
	    			gestionTienda.buscarClientePantalla();
	    			break;
	    		case 8:
	    			gestionFicha.compraCliente();
	    			break;
	    		case 9:
	    			gestionFicha.visualizarFichas();
	    			break;
	    		case 10:
	    			gestionFicha.buscarFichaPantalla();
	    			break;	
	    		case 11:
	    			gestionFicha.buscarFichaPorDNI();
	    			break;
	    		case 12:
	    			System.out.println("...");
	    			menuPrincipal();
	    			break;
	    	}
		} while(menu1 <= numOpcs); 
		
		return menu1;	
	}
	
	
	// Menu Financiacion.
	
	private int menuFinanciacion(){
				
				int menu2 = 0;
				Integer numOpcs = 2;
					
				do{ 
					System.out.println("\n");
					System.out.println("1. Tramitar FINANCIACION.");
					System.out.println("2. Salir.");
			    	System.out.print("Opcion> ");
			    		
			    	menu2 = Utiles.escanerInt();
						
					if (menu2<1 || menu2>numOpcs) {
						System.out.println("Opcion incorrecta. Vuelve a probar");
			    	}
						
			    	switch (menu2){
			    			
			    		case 1:
			    			gestionFicha.confirmarFinanciacion();
			                break;
			    		case 2:
			    			System.out.println("...");
			    			menuPrincipal();
			    			break;
			    	}
				} while(menu2 <= numOpcs); 
				
				return menu2;	
			}
	
	
	// Menu Tecnico.
	
	private int menuTecnico(){
		
		int menu3 = 0;
		Integer numOpcs = 10;
			
		do{ 
			System.out.println("\n");
			System.out.println("1. Nueva Ficha de Reparacion.");
			System.out.println("2. Listado de Fichas de Reparacion.");
			System.out.println("3. Ver Fichas de Reparacion de un Tecnico.");
			System.out.println("4. Ver Historial de un Tecnico.");
			System.out.println("5. Ver Historial de un Electrodomestico.");
			System.out.println("6. Cambiar estado de Ficha.");
			System.out.println("7. Piezas a pedir.");
			System.out.println("8. Solicitar Confirmacion de Fichas de Reparacion.");
			System.out.println("9. Ver Fichas que estan En Proceso.");
			System.out.println("10. Salir.");
	    	System.out.print("Opcion> ");
	    		
	    	menu3 = Utiles.escanerInt();
				
			if (menu3<1 || menu3>numOpcs) {
				System.out.println("Opcion incorrecta. Vuelve a probar");
	    	}
				
	    	switch (menu3){
	    			
	    		case 1:
	    			gestionFicha.repararCliente();
	                break;
	    		case 2:
	    			gestionFicha.visualizarFichasRE();
	                break;
	    		case 3:
	    			gestionFicha.visualizaFichasRETecnico();
	                break;
	    		case 4:
	    			gestionFicha.historialTecnico();
	    			break;
	    		case 5:
	    			gestionFicha.historialElectro();
	    			break;
	    		case 6:
	    			gestionFicha.cambiarEstado();
	    			break;
	    		case 7:
	    			gestionFicha.listarPiezas();
	    			break;
	    		case 8:
	    			gestionFicha.solicitarConfirmacion();
	    			break;
	    		case 9:
	    			gestionFicha.fichasEnProceso();
	    			break;
	    		case 10:
	    			System.out.println("...");
	    			menuPrincipal();
	    			break;
	    	}
		} while(menu3 <= numOpcs); 
		
		return menu3;	
	}
	
	
	// Menu Comercial.
	
	private int menuComercial(){
		
		int menu4 = 0;
		Integer numOpcs = 3;
			
		do{ 
			System.out.println("\n");
			System.out.println("1. Enviar Promocion a Clientes.");
			System.out.println("2. Enviar Mail de Promociones del Cliente.");
			System.out.println("3. Salir.");
	    	System.out.print("Opcion> ");
	    		
	    	menu4 = Utiles.escanerInt();
				
			if (menu4<1 || menu4>numOpcs) {
				System.out.println("Opcion incorrecta. Vuelve a probar");
	    	}
				
	    	switch (menu4){
	    			
	    		case 1:
	                gestionTienda.enviarPromo();
	                break;
	    		case 2:
	    			gestionTienda.promosCliente();
	    		case 3:
	    			System.out.println("...");
	    			menuPrincipal();
	    			break;
	    	}
		} while(menu4 <= numOpcs); 
		
		return menu4;	
	}
	
	
	// Menu Postventa.
	
		private int menuPostventa(){
			
			int menu5 = 0;
			Integer numOpcs = 2;
				
			do{ 
				System.out.println("\n");
				System.out.println("1. Realizar DEVOLUCION.");
				System.out.println("2. Salir.");
		    	System.out.print("Opcion> ");
		    		
		    	menu5 = Utiles.escanerInt();
					
				if (menu5<1 || menu5>numOpcs) {
					System.out.println("Opcion incorrecta. Vuelve a probar");
		    	}
					
		    	switch (menu5){
		    			
		    		case 1:
		                gestionFicha.devolucionCliente();
		                break;
		    		case 2:
		    			System.out.println("...");
		    			menuPrincipal();
		    			break;
		    	}
			} while(menu5 <= numOpcs); 
			
			return menu5;	
		}
}