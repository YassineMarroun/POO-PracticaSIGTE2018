/**
 * @ (#) GestionFicha.java
 * 
 * Clase GestionFicha.
 * En GestionFicha se implementan todos los m�todos relacionados con Ficha y FichaReparacion.
 * Esta clase tiene dos HashMap fichas y fichasRE donde incluimos todos los objetos que necesitemos guardar
 * de Ficha y FichaReparacion.
 *
 * @author Yassine Marroun
 * @version 1.00 2018/05/04
 */
package gestion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import modelo.bd.Cliente;
import modelo.bd.Electrodomestico;
import modelo.bd.Ficha;
import modelo.bd.FichaReparacion;
import modelo.bd.Usuario;
import utilidades.Enumerados;
import utilidades.Utiles;

public class GestionFicha {
	
	private Map<Integer, Ficha> fichas = new HashMap<Integer, Ficha> ();
	private Map<Integer, FichaReparacion> fichasRE = new HashMap<Integer, FichaReparacion> ();
	
	// M�todos para gestionar las FICHAS de compra.
	
	/*
	El m�todo numeroNuevaFicha comprueba el n�mero de elementos que tiene el mapa fichas,
	y lo devuelve sum�ndole uno para que le asignemos ese n�mero a la nueva ficha que creemos.
	 */
	public int numeroNuevaFicha() {
		if (fichas!=null && fichas.size()>0){
	       return fichas.size() + 1;
		}else{
		   return 1;
		}
	}
	
	
	/*
	El m�todo darFecha �nicamente devuelve la fecha actual mediante la clase Calendar.
	 */
	public Calendar darFecha(){
		Calendar fechaFic = Calendar.getInstance();
		fechaFic.getTime();
		return fechaFic;
	}
	
	
	/*
	El m�todo compraCliente solicita un dni, localiza en el mapa al cliente que le corresponde ese campo
	y llama al m�todo electrosAComprar pas�ndole dicho cliente. 
	 */
	public void compraCliente(){
		System.out.println("Introduzca el DNI del cliente para realizar la compra:  ");
		String dni = Utiles.sc.nextLine();
		Cliente cl = GestionTienda.clientes.get(dni);
		electrosAComprar(cl);
	}
	
	
	/*
	El m�todo electrosAComprar crea una ficha de compra, le asigna un n�mero y la fecha actual,
	solicita el modelo que se desea comprar y la cantidad de dicho art�culo.
	Mediante el m�todo clone, crea una nueva instancia del electrodomestico que ha localizado
	con ese modelo en el mapa electrodomesticos.
	Llama al m�todo cuentaStock pas�ndole ambos datos, cantidad y electrodomestico. Si la comprobaci�n en cuanto
	al n�mero de existencias es correcta, se incluye una instancia de ese electrodomestico a la lista
	correspondiente del cliente.
	Le pasa datos al m�todo rellenarFicha para terminar de incluir los datos de compra en la ficha.
	Se guarda en una variable total el precio final de sumar todos los art�culos comprados.
	El m�todo permite incluir m�s electrodom�sticos si es necesario, �nicamente se realiza una comprobaci�n
	respecto al modelo en la condici�n del while.
	Por �ltimo, llama a los m�todos asignarFichaACliente y tramitarFinanciacion pas�ndole cliente y ficha al primero,
	y ficha al segundo. Por �ltimo, imprime la ficha.
	 */
	private void electrosAComprar(Cliente cl) {
		
		try {
		Integer existencias = 0;
		Integer total = 0;
		Ficha ficha = new Ficha();
		ficha.setNumFicha(numeroNuevaFicha());
		ficha.setFechaFic(darFecha());
		System.out.println("Introduzca el MODELO comprado: ");
		String modelo = Utiles.sc.nextLine();
		while (!modelo.equals("S")) {	
			System.out.println("Introduzca el numero de articulos comprado: ");
			String cant = Utiles.sc.nextLine();
			Integer cantidad = Integer.parseInt(cant);
			Electrodomestico electro = new Electrodomestico();
			Object copia = GestionTienda.electrodomesticos.get(modelo).clone();
			electro = (Electrodomestico) copia;
			electro.setCantidad(cantidad);
			if (cl != null && electro !=null){
				cantidad = cantidad * -1;
				existencias = cuentaStock(GestionTienda.electrodomesticos.get(modelo), cantidad);
				if (cl.getElectrodomesticos()==null){
					cl.setElectrodomesticos(new ArrayList<Electrodomestico>());
				}
				if (existencias >= 0) {
					cl.getElectrodomesticos().add(electro);
					ficha = rellenarFicha(ficha, cl.getDni(), electro);
					total = total + electro.getCantidad() * electro.getPrecio();
				}
			} else{
				System.out.println("No existe Cliente o Electrodomestico.");
			}
			System.out.println("Introduzca el siguiente MODELO a comprar o S para terminar: ");
			modelo = Utiles.sc.nextLine();
		}
		
		asignarFichaACliente(cl, ficha);
		tramitarFinanciacion(ficha);
		System.out.println(ficha.toString());
		System.out.println(" Total: " + total + " euros.");
		
		} catch(Exception e) {
			   System.out.println("\nError en los datos introducidos. Intentelo de nuevo.");
		}
	}
	
	
	/*
	El m�todo cuentaStock recibe un objeto de tipo Electrodomestico y el campo cantidad.
	Actualiza el campo stock de dicho electrodomestico y tambi�n devuelve dicho dato para que se tenga
	el n�mero de existencias.
	 */
	private Integer cuentaStock(Electrodomestico electro, Integer cantidad) {
		
		Integer cambio = electro.getStock();
		cambio = cambio + cantidad;
		if (cambio >= 0) {
			electro.setStock(cambio);
		} else {
			System.out.println("Tenemos en stock " + electro.getStock() + " unidades del modelo " + electro.getModelo());
		}
		return cambio;
	}
	
	
	/*
	El m�todo tramitarFinanciacion recibe un objeto de tipo Ficha.
	Pide indicar si se solicita financiaci�n. En caso afirmativo, le asigna true al campo de tipo boolean financiar,
	en caso de no necesitar financiaci�n le da false. Por �ltimo, imprime la ficha.
	 */
	public void tramitarFinanciacion(Ficha ficha) {
		
		System.out.println("\nSolicita FINANCIACION: ");
		String financiar = Utiles.sc.nextLine();
		if (financiar.equals("Si")) {
			ficha.setFinanciar(true);
	    } else {
			ficha.setFinanciar(false);
		}
		System.out.println(ficha.toString());
	}
	
	
	/*
	El m�todo confirmarFinanciacion pide que se introduzca un n�mero de ficha, una vez localizada la ficha
	mediante el m�todo buscarFicha, asignamos a una variable de tipo Integer total el resultado que nos devuelve
	el m�todo calcularTotal habi�ndole pasado la ficha. A continuaci�n, solicita que se introduzca la nomina.
	Realiza c�lculos con la nomina para comprobar si es posible financiar la compra, en caso afirmativo
	mantiene el campo financiar con true y guarda tambi�n el campo nomina, de lo contrario asigna a financiar false.
	 */
	public void confirmarFinanciacion() {
		
		System.out.print("Introduzca el numero de Ficha: ");
        String numF = Utiles.sc.nextLine();
        Integer numFicha = Integer.parseInt(numF);
        Ficha ficha = buscarFicha(numFicha);
        Integer total = calcularTotal(ficha);
        if (ficha!=null){
        	System.out.println("Introduzca la NOMINA: ");
    		String nom = Utiles.sc.nextLine();
            Integer nomina = Integer.parseInt(nom);
            if (total/60 <= (nomina/100)*15) {
            	ficha.setFinanciar(true);
            	ficha.setNomina(nomina);
            } else {
            	ficha.setFinanciar(false);
            }
        	System.out.println(ficha.toString());
        	System.out.println(" Total: " + total + " euros.");
        } else {
        	System.out.println("Ficha no existente.");
        }
	}
	
	
	/*
	El m�todo calcularTotal recibe una ficha. Mediante un bucle for each, recorre la lista de electrodomesticos
	que contiene la ficha. Calcula el precio final de la compra sumando el precio de cada electrodomestico
	multiplicado por la cantidad que se haya adquirido.
	Por �ltimo, devuelve el resultado obtenido en la variable total.
	 */
	private Integer calcularTotal(Ficha ficha) {
		
		Integer total = 0;
		for (Electrodomestico el: ficha.getElectrodomesticos()) {
			total = total + el.getCantidad() * el.getPrecio();
		}
		return total;
	}


	/*
	El m�todo rellenarFicha recibe un objeto Ficha, un campo dniCliente y un objeto Electrodomestico.
	Incluye dicho electrodomestico a la lista de electrodom�sticos de la ficha
	y por ultimo guarda la ficha en el mapa fichas.
	 */
	public Ficha rellenarFicha(Ficha ficha, String dniCliente, Electrodomestico electro){

		ficha.setDniCliente(dniCliente);
		if (ficha.getElectrodomesticos()==null){
			ficha.setElectrodomesticos(new ArrayList<Electrodomestico>());
		}
		ficha.getElectrodomesticos().add(electro);
		fichas.put(ficha.getNumFicha(), ficha);
		return ficha;
	}
	
	
	/*
	El m�todo asignarFichaACliente va a recibir un objeto de tipo Cliente y otro de tipo Ficha.
	�nicamente va a incluir dicha ficha en la lista de fichas correspondiente al cliente.
	 */
	public void asignarFichaACliente(Cliente clienteFicha, Ficha ficha) {
		
		if (clienteFicha.getFichas()==null){
			clienteFicha.setFichas(new ArrayList<Ficha>());
		}
		clienteFicha.getFichas().add(ficha);
	}
		
		
	/*
	El m�todo buscarFicha recibe una variable numFicha con la que localiza
	y devuelve la ficha que corresponda del mapa fichas.	
	 */
	public Ficha buscarFicha(Integer numFicha){		
		return fichas.get(numFicha);
	}	
		
	
	/*
	El m�todo buscarFichaPantalla solicita el dato para numFicha.
	Llama al m�todo buscarFicha pas�ndole dicha variable, e imprime en pantalla los datos de la ficha
	que le devuelva dicho m�todo.
	 */
	public void buscarFichaPantalla(){
        System.out.print("Buscar Ficha por su numero: ");
        String numF = Utiles.sc.nextLine();
        Integer numFicha = Integer.parseInt(numF);
        Ficha ficha = buscarFicha(numFicha);
        if (ficha!=null){
        	 System.out.println(ficha.toString());
        } else {
        	System.out.println("Ficha no existente.");
        }
    }	
		
	
	/*
	El m�todo buscarFichaPorDNI solicita un dni, recorre el mapa fichas e imprime aquella ficha
	que contenga el mismo campo dni.
	 */
	public void buscarFichaPorDNI(){
		String dni;
		boolean existe = false;
		System.out.print("Buscar Ficha por el DNI del Cliente: ");
        dni = Utiles.sc.nextLine();
        for(Ficha ficha: fichas.values()) {
			if (ficha.getDniCliente().equals(dni)){
				existe = true;
				System.out.println(ficha.toString());
			}
        }
        if (!existe){
			System.out.println("No existen Fichas de dicho Cliente.");
		}	
	}

	
	/*
	El m�todo visualizarFichas imprime en pantalla todos los objetos ficha que tenemos en el mapa fichas.
	 */
	public void visualizarFichas() {
		System.out.println("Listado de fichas.");
		
		for(Ficha fic: fichas.values()) {
			System.out.println(fic.toString());        
		}
	}
		
			
	// M�todos para gestionar las FICHAS de REPARACION.
		
	/*
	El m�todo numeroNuevaFichaRE comprueba el n�mero de elementos que tiene el mapa fichasRE,
	y lo devuelve sum�ndole uno para que le asignemos ese n�mero a la nueva fichaRE que creemos.	
	 */
	public int numeroNuevaFichaRE() {
		if (fichasRE!=null && fichasRE.size()>0){
	       return fichasRE.size() + 1;
		}else{
		   return 1;
		}
	}
		
	
	/*
	El m�todo repararCliente solicita que se introduzca un dni con el que se localiza a un cliente
	en el mapa clientes. Pide un n�mero de ficha de compra.
	Llama al m�todo comprobarFechaFic pas�ndole el objeto Cliente y la variable numFicha.
	Y llama tambi�n a electrosAReparar pas�ndole el cliente.
	 */
	public void repararCliente(){
		System.out.println("Introduzca el DNI del Cliente: ");
		String dni = Utiles.sc.nextLine();
		Cliente cl = GestionTienda.clientes.get(dni);
		System.out.println("Introduzca el NUMERO de Ficha: ");
		String numF = Utiles.sc.nextLine();
        Integer numFicha = Integer.parseInt(numF);
		comprobarFechaFic(cl, numFicha);
		electrosAReparar(cl);
	}
	
	
	/*
	El m�todo comprobarFechaFic recibe un cliente y una variable numFicha.
	Recorre el mapa fichas en busca del elemento en el que coincida primero el campo dniCliente
	y a continuaci�n numFicha.
	Una vez localizada la ficha, comprueba si su fecha tiene menos de dos a�os.
	En casa de ser una ficha que tiene menos de dos a�os imprime un mensaje de reparaci�n gratuita,
	en caso contrario, la reparaci�n tendr� un coste.
	 */
	private void comprobarFechaFic(Cliente cl, Integer numFicha) {
		
		for(Ficha ficha: fichas.values()) {
			if (ficha.getDniCliente().equals(cl.getDni())) {
				if (ficha.getNumFicha().equals(numFicha)) {
					Calendar dosAnnos = Calendar.getInstance();
					dosAnnos.add(Calendar.YEAR, -2);
					if(ficha.getFechaFic().before(dosAnnos)) {
						System.out.println("Compra realizada hace mas de dos a�os. Importe a pagar en funcion de la reparacion.");
					} else {
						System.out.println("\nReparacion GRATUITA.\n");
					}
				}
			} else {
				System.out.println("\nDatos incorrectos. No es posible crear Ficha de Reparacion.\n");
				break;
			} 
		}
	}
		
	
	/*
	El m�todo electrosAReparar crea una instancia de FichaReparacion, le asigna un n�mero y la fecha actual,
	solicita el modelo de electrodom�stico que se desea reparar. Incluye la instancia creada de ese Electrodomestico
	en la lista de electrodomesticos que tiene la fichaRE.
	El m�todo permite incluir m�s electrodom�sticos si es necesario, �nicamente se realiza una comprobaci�n
	respecto al modelo en la condici�n del while.
	Para terminar de completar los datos de la ficha de reparaci�n llama al m�todo rellenarFichaRE
	pas�ndole como par�metro fichaRE y el dni del cliente que electrosAReparar ha recibido.
	Por �ltimo, imprime la fichaRE que devuelve rellenarFichaRE.
	 */
	private void electrosAReparar(Cliente cl) {

		try {
		FichaReparacion fichaRE = new FichaReparacion();
		fichaRE.setNumFicha(numeroNuevaFichaRE());
		fichaRE.setFechaFic(darFecha());
		System.out.println("Introduzca el MODELO a REPARAR: ");
		String modelo = Utiles.sc.nextLine();
		while (!modelo.equals("S")) {	
			Electrodomestico electro = GestionTienda.electrodomesticos.get(modelo);
			if (cl != null && electro !=null){
				if (fichaRE.getElectrodomesticos()==null){
					fichaRE.setElectrodomesticos(new ArrayList<Electrodomestico>());
				}
				fichaRE.getElectrodomesticos().add(electro);
			} else{
				System.out.println("No existe Cliente o Electrodomestico.");
			}
			System.out.println("Introduzca el siguiente MODELO a REPARAR o S para terminar: ");
			modelo = Utiles.sc.nextLine();
		}
		fichaRE = rellenarFichaRE(fichaRE, cl.getDni());
		System.out.println(fichaRE.toStringRE());
		
		} catch(Exception e) {
			   System.out.println("\nError en los datos introducidos. Intentelo de nuevo.");
		}
	}
		
	
	/*
	El m�todo rellenarFichaRE recibe un objeto FichaReparacion y un campo dniCliente.
	Solicita datos para los campos nombreTecnico, piezas y observaciones para asignarlos a la fichaRE recibida.
	El campo estado, de tipo enumerado, al crear la ficha se establece como PENDIENTE.
	Llama al m�todo asignarTecnicoFicha pas�ndole fichaRE y el campo nombreTecnico.
	Por �ltimo, guarda la ficha de reparaci�n en el mapa fichasRE.
	 */
	public FichaReparacion rellenarFichaRE(FichaReparacion fichaRE, String dniCliente){

		fichaRE.setDniCliente(dniCliente);
		System.out.println("Introduzca el nombre del TECNICO: ");
		String nombreTecnico = Utiles.sc.nextLine();
		asignarTecnicoAFicha(fichaRE, nombreTecnico);
		System.out.println("Introduzca las PIEZAS necesarias para esta Ficha de Reparacion: ");
		String piezas = Utiles.sc.nextLine();
		fichaRE.setPiezas(piezas);
		System.out.println("Introduzca las OBSERVACIONES para esta Ficha de Reparacion: ");
		String observaciones = Utiles.sc.nextLine();
		fichaRE.setObservaciones(observaciones);
		fichaRE.setEstado(Enumerados.EstadoReparacion.PENDIENTE);
		fichasRE.put(fichaRE.getNumFicha(), fichaRE);
		return fichaRE;
	}	
		
	
	/*
	El m�todo asignarTecnicoAFicha recibe una instancia de FichaReparacion y una variable nombreTecnico,
	mediante el m�todo buscarTecnico comprueba si existe dicho t�cnico, en caso afimativo,
	asigna dicho campo nombreTecnico en la fichaRE, de lo contrario imprime un mensaje donde se hace saber
	que no se encuentra el nombre del t�cnico.
	 */
	public void asignarTecnicoAFicha(FichaReparacion fichaRE, String nombreTecnico){
		Boolean existe = false;
		if (fichaRE!=null){
			existe = buscarTecnico(nombreTecnico);
			if (existe){
				fichaRE.setNombreTecnico(nombreTecnico);
			} else{
				System.out.println("No existe el tecnico: " + nombreTecnico);
			}
		} else {
			System.out.println("No existe la ficha.");
		}
	}
		
	
	/*
	El m�todo buscarTecnico recibe una variable nombreTecnico. Recorre la lista tecnicos,
	en caso de encontrar el objeto en el que coincide el campo nombre, devuelve true,
	de lo contrario devuelve false.
	 */
	private Boolean buscarTecnico(String nombreTecnico){
		Boolean existe = false;
		for (Usuario tec: GestionTienda.tecnicos){
			if (tec.getNombre().equals(nombreTecnico)){
				existe = true;
				break;
			}
		}
		return existe;
	}	
		
	
	/*
	El m�todo buscarFichaRE recibe una variable numFichaRE con la que localiza y devuelve la fichaRE
	que corresponda del mapa fichasRE.
	 */
	public FichaReparacion buscarFichaRE(Integer numFichaRE){		
		return fichasRE.get(numFichaRE);
	}
	
	
	/*
	El m�todo darEstadoConsola muestra los posibles valores de tipo enumerado que se pueden dar al campo estado.
	Y devuelve aquel que se selecciona por teclado.
	 */
	public Enumerados.EstadoReparacion darEstadoConsola(){
		System.out.print(Enumerados.menuEstadoReparacion() + "\n");
        String iEs = Utiles.sc.nextLine();
        Integer iEstado = Integer.parseInt(iEs);
        return Enumerados.EstadoReparacion.values()[iEstado];
	}
	
	
	/*
	El m�todo motivoParado muestra los posibles valores de tipo enumerado que se pueden dar al campo parado.
	Devolviendo aquel que se selecciona por teclado.
	 */
	public Enumerados.Parado motivoParado(){
		System.out.print(Enumerados.menuParado() + "\n");
        String iPa = Utiles.sc.nextLine();
        Integer iParado = Integer.parseInt(iPa);
        return Enumerados.Parado.values()[iParado];
	}
	
	
	/*
	El m�todo cambiarEstado solicita que se introduzca por teclado el campo numFichaRE,
	localiza la ficha de reparaci�n mediante el m�todo buscarFichaRE. Asigna el nuevo estado
	mediante la devoluci�n que obtiene del m�todo darEstadoConsola. Si el nuevo estado es PARADO,
	llama al m�todo motivoParado para dar el valor correspondiente a la variable parado.
	Por �ltimo, modifica tambi�n el campo observaciones con aquello que se introduzca por teclado.
	 */
	public void cambiarEstado(){
		System.out.print("Introduzca el numero de Ficha a cambiar: ");
        String numF = Utiles.sc.nextLine();
        Integer numFichaRE = Integer.parseInt(numF);
        FichaReparacion fichaRE = buscarFichaRE(numFichaRE);
        if (fichaRE!=null){
        	System.out.print("Introduzca el nuevo ESTADO de la ficha: ");
        	Enumerados.EstadoReparacion estado = darEstadoConsola(); 
        	fichaRE.setEstado(estado);
        	if (estado == Enumerados.EstadoReparacion.PARADO) {
        		System.out.print("Introduzca el motivo por el que esta PARADA la ficha: ");
        		Enumerados.Parado iParado = motivoParado(); 
            	fichaRE.setParado(iParado);
        	}
        	System.out.print("Editar las OBSERVACIONES de la ficha: ");
        	String obs = Utiles.sc.nextLine(); 
        	fichaRE.setObservaciones(obs);
        	System.out.println(fichaRE.toStringRE());
        } else {
        	System.out.println("Ficha no existente.");
        }
	}
	
	
	/*
	El m�todo visualizarFichasRE imprime en pantalla todos los elementos fichaRE que tenemos en el mapa fichasRE.
	 */
	public void visualizarFichasRE() {
		System.out.println("Listado de Fichas de REPARACION.");
		
		for(FichaReparacion fic: fichasRE.values()) {
			System.out.println(fic.toStringRE());        
		}
	}
	
	
	/*
	El m�todo visualizaFichasRETecnico solicita que se introduzca un nombre para la variable nomTecnico,
	recorre el mapa fichasRE e imprime aquellas fichas de reparaci�n en las que coincida el campo nombreTecnico
	y cuyo estado sea distinto de TERMINADO.
	 */
	public void visualizaFichasRETecnico() {
		boolean existe = false;
		System.out.println("Introduzca el nombre del TECNICO: ");
		String nomTecnico = Utiles.sc.nextLine();
		System.out.println("Listado de fichas pendientes del Tecnico: " + nomTecnico);
		for(FichaReparacion fic: fichasRE.values()) {
			if (fic.getNombreTecnico().equals(nomTecnico) && fic.getEstado() != Enumerados.EstadoReparacion.TERMINADO){
				System.out.println(fic.toStringRE());
				existe = true;
			}
		}
		if (!existe){
			System.out.println("No existen fichas de este Tecnico.");		
		}
	}
	
	
	/*
	El m�todo historialTecnico solicita que se introduzca un nombre para la variable nomTecnico,
	recorre el mapa fichasRE e imprime aquellas fichas de reparaci�n en las que coincida el campo nombreTecnico
	y cuyo estado sea TERMINADO.
	 */
	public void historialTecnico() {
		boolean existe = false;
		System.out.println("Introduzca el nombre del TECNICO: ");
		String nomTecnico = Utiles.sc.nextLine();
		System.out.println("Historial de fichas del Tecnico: " + nomTecnico);
		for(FichaReparacion fic: fichasRE.values()) {
			if (fic.getNombreTecnico().equals(nomTecnico) && fic.getEstado() == Enumerados.EstadoReparacion.TERMINADO){
				System.out.println(fic.toStringRE());
				existe = true;
			}
		}
		if (!existe){
			System.out.println("No existen fichas de este Tecnico.");		
		}
	}
	
	
	/*
	El m�todo listarPiezas recorre el mapa fichasRE e imprime el n�mero de ficha y el campo piezas
	de aquellas fichas de reparaci�n cuyo estado sea PENDIENTE.
	 */
	public void listarPiezas() {
		boolean existe = false;
		System.out.println("Listado de PIEZAS a pedir: ");
		for(FichaReparacion fic: fichasRE.values()) {
			if (fic.getEstado() == Enumerados.EstadoReparacion.PENDIENTE){
				System.out.println("Numero de Ficha: " + fic.getNumFicha() + "  Piezas: " + fic.getPiezas());
				existe = true;
			}
		}
		if (!existe){
			System.out.println("No existen Fichas PENDIENTES para solicitar Piezas.");		
		}
	}
	
	
	/*
	El m�todo solicitarConfirmacion recorre el mapa fichasRE y muestra en pantalla aquellas fichas de reparaci�n
	cuyo estado sea PARADO y el motivo de ello sea CONFIRMAR_CLIENTE.
	 */
	public void solicitarConfirmacion() {
		boolean existe = false;
		System.out.println("Solicitar la Confirmacion a los Clientes de las siguientes Fichas de Reparacion: ");
		for(FichaReparacion fic: fichasRE.values()) {
			if (fic.getParado() == Enumerados.Parado.CONFIRMAR_CLIENTE){
				System.out.println(fic.toStringRE());
				existe = true;
			}
		}
		if (!existe){
			System.out.println("No existen Fichas a Confirmar por Cliente.");		
		}
	}
	
	
	/*
	El m�todo fichasEnProceso recorre el mapa fichasRE e imprime en pantalla aquellas fichas de reparaci�n
	que est�n en estado EN_PROCESO.
	 */
	public void fichasEnProceso() {
		boolean existe = false;
		System.out.println("Listado de Fichas que estan En Proceso: ");
		for(FichaReparacion fic: fichasRE.values()) {
			if (fic.getEstado() == Enumerados.EstadoReparacion.EN_PROCESO){
				System.out.println(fic.toStringRE());
				existe = true;
			}
		}
		if (!existe){
			System.out.println("No existen Fichas En Proceso.");		
		}
	}
	
	
	/*
	El m�todo historialElectro solicita que se introduzca un modelo de electrodomestico.
	Recorre el mapa fichasRE en busca de aquellas fichas de reparaci�n que contengan ese electrodom�stico
	en su lista. Finalmente imprime el n�mero de ficha y los campos piezas y observaciones de todas aquellas fichas
	que tengan incluido el electrodom�stico que se busca.
	 */
	public void historialElectro() {
		boolean existe = false;
		System.out.println("Introduzca el MODELO de electrodomestico: ");
		String modelo = Utiles.sc.nextLine();
		System.out.println("Historial del Electrodomestico: " + modelo);
		for(FichaReparacion ficRE: fichasRE.values()) {
			for (Electrodomestico el: ficRE.getElectrodomesticos()) {
				if (el.getModelo().equals(modelo)){
					System.out.println("Numero de Ficha: " + ficRE.getNumFicha() + "  Piezas: " + ficRE.getPiezas() +
							" Observaciones: " + ficRE.getObservaciones());
					existe = true;
				}
			}
		}
		if (!existe){
			System.out.println("No existe historial de este Electrodomestico.");		
		}
	}
	
	
	// M�todos para gestionar la POSTVENTA.
	
	/*
	El m�todo devolucionCliente solicita que se d� un dni, un modelo y la cantidad a devolver de dicho modelo.
	Localiza tanto al cliente como al electrodomestico en los correspondientes mapas clientes y electrodomesticos
	gracias a las variables dni y modelo introducidas.
	A continuaci�n, recorre el mapa fichas en busca de aquellas en las que coincida el dni dado
	con el campo dniCliente de la ficha. Una vez tiene la ficha, comprueba que no haya pasado m�s de tres meses
	desde que se hizo la compra, si es as�, llama al m�todo eliminarElectro pas�ndole la lista de electrodomesticos
	de la ficha localizada y queremos modificar, el modelo de electrodom�stico y la cantidad a devolver
	de dicho modelo. Tambi�n llama al m�todo cuentaStock pas�ndole el electrodomestico y la variable cantidad.
	El m�todo permite incluir m�s electrodom�sticos en la devoluci�n si es necesario, �nicamente se realiza una comprobaci�n respecto al modelo en la condici�n del while.
	Por �ltimo, imprime como quedan los datos de la ficha tras la devoluci�n.
	 */
	public void devolucionCliente(){
		
		try {
		Ficha fichaEncontrada = new Ficha();
		System.out.println("Introduzca el DNI del cliente para realizar la devolucion: ");
		String dni = Utiles.sc.nextLine();
		System.out.println("Introduzca el MODELO a devolver: ");
		String modelo = Utiles.sc.nextLine();
		while (!modelo.equals("S")) {
			System.out.println("Introduzca el numero de articulos a devolver: ");
			String cant = Utiles.sc.nextLine();
			Integer cantidad = Integer.parseInt(cant);
			Cliente cl = GestionTienda.clientes.get(dni);
			Electrodomestico electro = GestionTienda.electrodomesticos.get(modelo);
				if (cl != null){
					for(Ficha ficha: fichas.values()) {
						if (ficha.getDniCliente().equals(dni)){
							fichaEncontrada = ficha;
							Calendar tresMeses = Calendar.getInstance();
							tresMeses.add(Calendar.MONTH, +3);
								if(ficha.getFechaFic().before(tresMeses)) {
									eliminarElectro(ficha.getElectrodomesticos(), modelo, cantidad);
									cuentaStock(electro, cantidad);
								} else {
									System.out.println("Esta compra se ha realizado hace mas de TRES meses.");
								}
						}
					}					
				} else{
					System.out.println("No existe Cliente o Electrodomestico.");
				}
			System.out.println("Introduzca el siguiente MODELO a devolver o S para terminar: ");
			modelo = Utiles.sc.nextLine();
		}
		System.out.println("\nDevolucion Correcta.");
		System.out.println(fichaEncontrada.toString());
		
		} catch(Exception e) {
			   System.out.println("\nError en los datos introducidos. Intentelo de nuevo.");
		}
	}
	
	
	/*
	El m�todo eliminarElectro recibe un ArrayList que almacena objetos de tipo Electrodomestico,
	una variable modelo y otra variable cantidad.
	Recorre la lista en busca de la instancia electrodomestico en la que coincida el modelo.
	Una vez localizado dicho objeto electrodomestico, actualiza su campo cantidad rest�ndole la variable cantidad
	que se le ha pasado como par�metro. En caso de que la cantidad quede igual a 0,
	se elimina dicho electrodomestico de la lista.
	 */
	private void eliminarElectro(ArrayList<Electrodomestico> electroLista, String modelo, Integer cantidad){	
		
		Electrodomestico electroEncontrado = null;
		for(Electrodomestico el: electroLista) {
			if(el.getModelo().equals(modelo)){
				electroEncontrado = el;
				break;
			}
		}
		if(electroEncontrado != null) {
			Integer nuevaCant = electroEncontrado.getCantidad();
			nuevaCant = nuevaCant - cantidad;
			if (nuevaCant >= 0) {
				electroEncontrado.setCantidad(nuevaCant);
				if(nuevaCant == 0) {
					electroLista.remove(electroEncontrado);
				}
			} else {
				System.out.println("Se intenta devolver una cantidad mayor a la comprada.");
			}
		} else {
			System.out.println("Modelo no encontrado.");
		}
	}
}