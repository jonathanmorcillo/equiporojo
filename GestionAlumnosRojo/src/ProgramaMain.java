import java.util.*;

public class ProgramaMain {

	// Autor: LujÃ¡n
	public static void mostrarMenu() {
		System.out.println("********************************");
		System.out.println("***********   MenÃº   ***********");
		System.out.println("********************************");
		System.out.println("Selecciona una opciÃ³n:" + "\n1.  Dar de alta alumnos." + "\n2.  Dar de baja alumnos."
				+ "\n3.  Listar los alumnos." + "\n4.  Modificar alumnos." + "\n5.  Matricular alumnos."
				+ "\n6.  Dar de baja de una asignatura." + "\n7.  Introducir calificaciÃ³n trimestral."
				+ "\n8.  Listar calificaciones de alumnos." + "\n9.  Poner una falta (DÃ­a completo)."
				+ "\n10. Poner una falta (en una sesiÃ³n)." + "\n11. Pasar lista." + "\n12. Listar faltas."
				+ "\n13. Salir.");
	}

	// Autor: LujÃ¡n
	public static boolean repetir() {
		Scanner entrada = new Scanner(System.in);
		char repetir = ' ';

		System.out.println("Â¿Quieres repetir esta opciÃ³n?" + "\nEscribe Y si es sÃ­ y N si es no.");
		repetir = entrada.next().charAt(0);
		
		if(repetir=='Y'||repetir=='y') {
			return true;
		}else return false;

	}

	// Autor: Juan MartÃ­n

	public static int existe(ArrayList<Alumno> listaAlumnos, String dni) {
		boolean comprobar = false;
		int posicion = -1;
		for (int i = 0; i < listaAlumnos.size() && !comprobar; i++) {
			if (listaAlumnos.get(i).getDni().equals(dni)) {
				comprobar = true;
				posicion = i;
			} else {
				comprobar = false;
			}
		}

		if (comprobar == true) {
			return posicion;
		} else {
			return -1;
		}
	}

	// Autor: Jonathan Morcillo
	public static int matriculado(ArrayList<Alumno> listaAlumnos, String dni, String asignatura) throws Exception {

		// Creamos la variable para el bucle y otras 2 inicializadas en negativo
		// para
		// saber si encontramos al alumno y la asignatura
		int k, j = -1, exist = -1;

		// Comprobamos si existe el alumno y si es asi procedemos a buscar la
		// asignatura
		exist = existe(listaAlumnos, dni);
		if (exist == -1) {
			throw new Exception("No existe el alumno. Debe darlo de alta primero.");
		}
			for (k = 0; k < listaAlumnos.get(exist).getNotas().size(); k++) {

				// Comprobamos si esta alumno esta matriculado en la asignatura
				// y si es asi
				// ponemos la variable j al mismo valor de la posicion de esta
				// asignatura puesto
				// que sera la variable que devolveremos

				if (listaAlumnos.get(exist).getNotas().get(k).getAsignatura().equals(asignatura)) {
					j = k;
				}
			}
			return j;
		}
		

	// MÃ©todo estÃ¡tico 1

		public static void darDeAlta(ArrayList matriculados) throws Exception {

			// OpciÃ³n 1 del menÃº

			// Autor: Santiago PÃ©rez

			// Se recogen los datos del nuevo alumno del usuario

			Scanner entrada = new Scanner(System.in);

			String dni;
			String nombre;
			String apellidos;
			String telefono;
			String email;
			boolean comprobacion = false;

			System.out.println("Introduzca el dni de alumno a matricular:");
			dni = entrada.nextLine();

			System.out.println("Introduzca los apellidos de alumno a matricular:");
			apellidos = entrada.nextLine();

			System.out.println("Introduzca el nombre de alumno a matricular:");
			nombre = entrada.nextLine();

			System.out.println("Introduzca el telÃ©fono de alumno a matricular:");
			telefono = entrada.nextLine();

			System.out.println("Introduzca el email de alumno a matricular:");
			email = entrada.nextLine();

			// Se crea un nuevo alumno usando el constructor, y los set para telÃ©fono y
			// email
			Alumno nuevoAlumno = new Alumno(dni, nombre, apellidos);
			nuevoAlumno.setTelefono(telefono);
			nuevoAlumno.setEmail(email);

			// Se comprueba si el alumno ya existe
			int existe = existe(matriculados, dni);

			if (existe != -1) {// Si no existe se aÃ±ade, si existe se muestra un mensaje de error
				throw new Exception("Ya existe el alumno");
			} else {
				matriculados.add(nuevoAlumno);
			}

		}

		// MÃ©todo estÃ¡tico 2

		public static void darDeBaja(ArrayList matriculados) throws Exception {

			// OpciÃ³n 2 del menÃº

			// Autor: Santiago PÃ©rez

			Scanner entrada = new Scanner(System.in);

			int borrar;
			int totalalumnos;
			String dni;

			// Se recoge el nÃºmero del alumno a eliminar
			System.out.println("Introduzca el nÃºmero del alumno a eliminar:");
			listarAlumnos(matriculados);
			borrar = entrada.nextInt();
			borrar = borrar - 1;

			// Se comprueba la longitud total del ArrayList de matriculados y que el nÃºmero
			// que
			// se desea borrar estÃ© dentro. Si lo estÃ¡ se borra ese alumno, si no, se
			// muestra
			// mensaje de error
			totalalumnos = matriculados.size();

			if (borrar >= 0 && borrar <= totalalumnos) {

				matriculados.remove(borrar);

			} else {
				throw new Exception("El alumno que desea borrar no existe");
			}
		}
	
	// Autor: Jose Alberto. MÃ©todo estÃ¡tico 3
	public static void listarAlumnos(ArrayList<Alumno> alumno) {
		//Obtenemos el tamaño del ArrayList de alumno y lo guardamos en una variable
		int num = alumno.size();
		int cont = 0;
		//Comprobamos si existen alumnos dentro del ArrayList. En caso de no haberlos, saltará el mensaje
		if (num == 0) {
			System.out.println("No hay alumnos");
		}
		//Creamos un iterador para poder mostrar los valores dentro del ArrayList de alumno
		Iterator<Alumno> iterador = alumno.iterator();
		while (iterador.hasNext()) {
			Alumno lista = iterador.next();
			//Creamos distintas variables para cada dato del alumno y hacemos uso de los métodos 
			//'get' para obtener esos datos y así poder mostrarlos
			String nombre = lista.getNombre();
			String apellido = lista.getApellidos();
			String dni = lista.getDni();
			String email = lista.getEmail();
			String telefono = lista.getTelefeno();
			cont += 1;
			//Mostramos por pantalla los datos de cada alumno
			System.out.print(cont + ". Nombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " + dni + "\nE-mail: "
					+ email + "\nTelÃ©fono: " + telefono + "\n");

		}
	}

	// Autor: Jonathan Morcillo ; Método 4
	public static void modificarAlumnos(ArrayList<Alumno> listaAlumnos) throws Exception {
		Scanner entrada = new Scanner(System.in);
		int opcion=0;



		// Creamos las variables necesarias
		int i;
		String modify;
		boolean mod = false;

		// Llamamos al metodo para mostrar la lista de alumnos
		
		listarAlumnos(listaAlumnos);

		System.out.println("Introduzca la posicion del alumno a modificar");

		// Restamos 1 puesto que las posiciones empiezan en 1 y las celdas en 0
		i = entrada.nextInt() - 1;
		entrada.nextLine(); // limpiamos buffer

		Alumno al = listaAlumnos.get(i);

			
		System.out.println(
				"Introduzca la opcion a realizar:\n1.- Modificar dni\n2.- Modificar nombre\n3.- Modificar apellidos\n4.- Modificar telefono\n5.- Modificar email");
		opcion = entrada.nextInt();
		entrada.nextLine();

		// Creamos un menu con los distintos datos que se pueden modificar y en el que
		// los pasos son:
		// 1.- Mostrar dato actual
		// 2.- Pedir nuevo dato
		// 3.- Modificar los datos
		// 4.- Mostrar datos tras modificar
		switch (opcion) {

		case 1:
			do {
				System.out.println("Introduzca el nuevo dni para el alumno " + al.getNombre() + " "
						+ al.getApellidos() + " con dni actual : " + al.getDni());
				modify = entrada.nextLine();
				// Comprobamos que el nuevo dni no existe, si no existe se modifica y si existe
				// se lanza una excepcion para pedir uno diferente
				if (existe(listaAlumnos, modify) == -1) {
					al.setDni(modify);
					mod = true;
				} else {
					throw new Exception("El dni introducido ya existe, introduzca uno diferente");
				}
			} while (mod == false);
			System.out.println("El dni ha sido modificado ahora es: " + al.getDni());
			break;
		case 2:
			System.out.println("Introduzca el nuevo nombre para el alumno " + al.getNombre());
			modify = entrada.nextLine();
			al.setNombre(modify);
			System.out.println("El nuevo nombre del alumno es  " + al.getNombre());
			break;
		case 3:
			System.out.println(
					"Introduzca los nuevos apellidos para el alumno " + al.getNombre() + " " + al.getApellidos());
			modify = entrada.nextLine();
			al.setApellidos(modify);
			System.out.println("Los nuevos apellidos del alumno son  " + al.getApellidos());
			break;
		case 4:
			System.out.println("Introduzca el nuevo teléfono para el alumno " + al.getNombre() + " "
					+ al.getApellidos() + " con numero actual " + al.getTelefeno());
			modify = entrada.nextLine();
			al.setTelefono(modify);
			System.out.println("El nuevo teléfono del alumno es  " + al.getTelefeno());
			break;
		case 5:
			System.out.println("Introduzca el nuevo email para el alumno " + al.getNombre() + " "
					+ al.getApellidos() + " con email actual " + al.getEmail());
			modify = entrada.nextLine();
			al.setEmail(modify);
			System.out.println("El nuevo email del alumno es  " + al.getEmail());
			break;
		default:
			System.out.println("Opcion no válida");
			break;
		}
	}

	// Autor: Juan MartÃ­n, Metodo 5 Matricular alumnos.

	public static void matricular(ArrayList<Alumno> listaAlumnos) throws Exception {
		Scanner entrada = new Scanner(System.in);
		String dni, asignatura;
		System.out.println("Introduce dni");
		dni = entrada.nextLine();
		System.out.println("Introduce asignatura");
		asignatura = entrada.nextLine();
		if (matriculado(listaAlumnos, dni, asignatura) >= 0) {
			throw new Exception("Se informa que el alumno " + dni + " ya se encuentra matriculado.");
		} else {
			Calificacion aux = new Calificacion(asignatura);
			listaAlumnos.get(existe(listaAlumnos, dni)).getNotas().add(aux);
			System.out.println("El alumno ha sido matriculado correctamente.");
		}
	}

	// Autor: Jonathan Morcillo ; MÃ©todo 6
	public static void darBajaAsignatura(ArrayList<Alumno> listaAlumnos) throws Exception {
		Scanner entrada = new Scanner(System.in);

		// Creamos las variables para almacenar el dni y posteriormente la asignatura
		String dni = "";
		String asignatura = "";

		// Pedimos y almacenamos el dni
		System.out.println("Introduzca el dni del alumno");
		dni = entrada.nextLine();

		// Creamos variables para almacenar el resultado de si existe o no el alumno
		int j = existe(listaAlumnos, dni);

		// Comprobamos si existe el alumno y si es asi pedimos la asignatura
		if (j != -1) {
			System.out.println("Introduzca la asignatura a dar de baja");
			asignatura = entrada.nextLine();

			// Comprobamos que este matriculado y si es asi procedemos a darlo de baja
			int k = matriculado(listaAlumnos, dni, asignatura);

			if (k != -1) {
				listaAlumnos.get(j).getNotas().remove(k);

			} else {
				System.out.println("El alumno " + listaAlumnos.get(j).getNombre() + " "
						+ listaAlumnos.get(j).getApellidos() + " no estÃ¡ registrado en dicha asignatura");
			}
		} else {
			throw new Exception("El alumno no existe");
		}
	}

	// Autor: Jose Alberto. MÃ©todo 7: Introducir calificaciones.
		public static void introducirCalificacion(ArrayList<Alumno> alumno)
				throws Exception {
			Scanner entrada = new Scanner(System.in);
			//Creamos las variables
			String nota, asignatura,dni;
			int existe, pos = -1;
			//Pedimos DNI
			System.out.println("Dime el D.N.I del alumno:");
			dni=entrada.nextLine();
			//Llamamos al método 'existe' para comprobar si existe el alumno
			existe = existe(alumno, dni);
			//En caso de no existir, saltará una excepción
			if (existe == -1) {
				throw new Exception("No existe el alumno");
			}
			//En caso de que el alumno exista, continuará el método
			if (existe > 0) {
				try {
					//Introducimos la posición del alumno
					System.out.println("Introduzca la posición del alumno del cual desea introducir las calificaciones");
					pos = entrada.nextInt();
					//Limpiamos el buffer
					entrada.next();
					//Introducimos la asignatura a la cual vamos a asignarle una calificación
					System.out.println("Introduzca la asignatura que va a calificar");
					asignatura = entrada.nextLine();
					//Creamos un nuevo objeto calificación para guardar la nota de la asignatura
					Calificacion calificacion = new Calificacion(asignatura);
					//Introducimos la nota y la asignamos en el objeto 'calificación'
					System.out.println("Introduzca la nota obtenida");
					nota = entrada.nextLine();

					calificacion.setNota(nota);
					//Exploramos el ArrayList de alumno y obtenemos la posición y las notas para añadirle la calificación
					alumno.get(pos).getNotas().add(calificacion);
					
				} catch (Exception except) {//En caso de que se introduzca algún dato de manera incorrecta, saltará la excepción
					System.out.println(except.getMessage());
				}
			}
		}

	// Autor: Juan MartÃ­n, MÃ©todo 8 Listar calificaciones del alumno.

	public static void listarCalificaciones(ArrayList<Alumno> listaAlumnos) {
		Scanner entrada = new Scanner(System.in);
		int alumno, i;
		String nombre, apellidos, dni;

		listarAlumnos(listaAlumnos);

		do {

			System.out.println("Introduzca el nÃºmero de lista del alumno que desea listar sus calificaciones");
			alumno = entrada.nextInt();
			if (alumno < 1 || alumno > listaAlumnos.size()) {
				System.out.println("Debe seleccionar el nÃºmero de lista de un Alumno vÃ¡lido.");
			}

		} while (alumno < 1 || alumno > listaAlumnos.size());

		System.out.println("Has selecionado a :");
		apellidos = listaAlumnos.get(alumno - 1).getApellidos();
		nombre = listaAlumnos.get(alumno - 1).getNombre();
		dni = listaAlumnos.get(alumno - 1).getDni();
		System.out.println(apellidos + ", " + nombre + ", " + dni);

		System.out.println("BoletÃ­n de notas");
		for (i = 0; i < listaAlumnos.get(alumno - 1).getNotas().size(); i++) {

			System.out.println("Asignatura : " + listaAlumnos.get(alumno - 1).getNotas().get(i).getAsignatura()
					+ " Nota trimestral : " + listaAlumnos.get(alumno - 1).getNotas().get(i).getNota());
		}

	}

	// Autor: LujÃ¡n. MÃ©todo 9 Poner una falta (DÃ­a completo).
	public static void ponerFaltaDia(ArrayList<Alumno> listaAlumnos) throws Exception{
		Scanner entrada = new Scanner(System.in);

		String dni;
		System.out.println("Dime el D.N.I del alumno:");
		dni=entrada.nextLine();
		// Comprobamos si existe el alumno
		int exist = existe(listaAlumnos, dni);
		if(exist == -1){
			throw new Exception("Error: El alumno no existe.");
		}
		//Si existe el alumno pedimos la fecha para poner la falta	
		int dia, mes, agno;
		System.out.println("Dime el dÃ­a:");
		dia=entrada.nextInt();
		System.out.println("Dime el mes:");
		mes=entrada.nextInt();
		System.out.println("Dime el aÃ±o:");
		agno=entrada.nextInt();
	
		DiaClase diaClase = new DiaClase(new Fecha(dia,mes,agno));
		
		int posicion = listaAlumnos.get(exist).getFaltas().indexOf(diaClase);
		
		//Si existe la fecha, ponemos faltas en el dÃ­a directamente.
		if(posicion != -1){
			listaAlumnos.get(exist).getFaltas().get(posicion).getSesion().faltaDiaEntero();
		}else{//Si no, ponemos las faltas y lo aÃ±adimos al ArrayList.
			diaClase.getSesion().faltaDiaEntero();
			listaAlumnos.get(exist).getFaltas().add(diaClase);
		}
		System.out.println("Se le ha puesto faltas en esta fecha: ");
		diaClase.getFechaDia().imprimeFecha();
								 
	}

	// Autor: LujÃ¡n. MÃ©todo 10 Poner una falta (una sesiÃ³n).
	public static void ponerFaltaSesion(ArrayList<Alumno> listaAlumnos) throws Exception {
		Scanner entrada = new Scanner(System.in);
		String dni;
		int sesion;
		System.out.println("Dime el D.N.I del alumno:");
		dni=entrada.nextLine();
		// Comprobamos si existe el alumno
		int exist = existe(listaAlumnos, dni);
		if(exist == -1){
			throw new Exception("Error: El alumno no existe.");
		}
		//Si existe el alumno pedimos la fecha para poner la falta	
		int dia, mes, agno;
		System.out.println("Dime el dÃ­a:");
		dia=entrada.nextInt();
		System.out.println("Dime el mes:");
		mes=entrada.nextInt();
		System.out.println("Dime el aÃ±o:");
		agno=entrada.nextInt();
		System.out.println("Dime la sesiÃ³n:");
		sesion=entrada.nextInt();
	
		DiaClase diaClase = new DiaClase(new Fecha(dia,mes,agno));
		
		int posicion = listaAlumnos.get(exist).getFaltas().indexOf(diaClase);
		
		//Si existe la fecha, ponemos falta en la sesion directamente.
		if(posicion != -1){
			listaAlumnos.get(exist).getFaltas().get(posicion).getSesion().faltaHora(sesion);
		}else{//Si no, ponemos la falta y lo aÃ±adimos al ArrayList.
			diaClase.getSesion().faltaHora(sesion);
			listaAlumnos.get(exist).getFaltas().add(diaClase);
		}
		System.out.println("Se le ha puesto falta en la sesiÃ³n nÂº" + sesion + " y esta fecha: ");
		diaClase.getFechaDia().imprimeFecha();
	}
	
// Autor Juanma. MÃ©todo 11 pasar lista//
	public static void pasarLista(ArrayList<Alumno> listaAlumnos) throws Exception {

		Scanner entrada = new Scanner(System.in);

		String apellidos, nombre, dni;
		char respuesta;
		int opcion, dia, mes, agno, posicion;

		System.out.println("Dime el dÃ­a:");
		dia = entrada.nextInt();
		System.out.println("Dime el mes:");
		mes = entrada.nextInt();
		System.out.println("Dime el aÃ±o:");
		agno = entrada.nextInt();

		DiaClase diaClase = new DiaClase(new Fecha(dia, mes, agno));

		for (int i = 0; i < listaAlumnos.size(); i++) {
			System.out.println("Has selecionado a :");
			apellidos = listaAlumnos.get(i).getApellidos();
			nombre = listaAlumnos.get(i).getNombre();
			dni = listaAlumnos.get(i).getDni();
			System.out.println(apellidos + ", " + nombre + ", " + dni);

			System.out.println("Â¿Ha faltado? Y para si N para no.");
			respuesta = entrada.nextLine().charAt(0);

			if (respuesta == 'Y') {
				System.out.println("1. \t Poner falta dia completo.");
				System.out.println("2. \t Poner falta sesion");
				opcion = entrada.nextInt();
				entrada.nextLine();

				switch (opcion) {
				case 1:

					posicion = listaAlumnos.get(i).getFaltas().indexOf(diaClase);

					// Si existe la fecha, ponemos faltas en el dÃ­a directamente.
					if (posicion != -1) {
						listaAlumnos.get(i).getFaltas().get(posicion).getSesion().faltaDiaEntero();
					} else {// Si no, ponemos las faltas y lo aÃ±adimos al ArrayList.
						diaClase.getSesion().faltaDiaEntero();
						listaAlumnos.get(i).getFaltas().add(diaClase);
					}
					System.out.println("Se le ha puesto faltas en esta fecha: ");
					diaClase.getFechaDia().imprimeFecha();

					break;
				case 2:
					int sesion;
					System.out.println("Dime la sesiÃ³n:");
					sesion = entrada.nextInt();

					posicion = listaAlumnos.get(i).getFaltas().indexOf(diaClase);

					// Si existe la fecha, ponemos falta en la sesion directamente.
					if (posicion != -1) {
						listaAlumnos.get(i).getFaltas().get(posicion).getSesion().faltaHora(sesion);
					} else {// Si no, ponemos la falta y lo aÃ±adimos al ArrayList.
						diaClase.getSesion().faltaHora(sesion);
						listaAlumnos.get(i).getFaltas().add(diaClase);
					}
					System.out.println("Se le ha puesto falta en la sesiÃ³n nÂº" + sesion + " y esta fecha: ");
					diaClase.getFechaDia().imprimeFecha();
					break;
				default:
					throw new Exception("Solo puede elegir una opcion valida.");

				}
			}

		}

	}


	// Autor Juanma. MÃ©todo 12 listar faltas//
	public static void listarFaltas(ArrayList<Alumno> listaAlumnos) throws Exception{
		Scanner entrada = new Scanner(System.in);
		int alumno, i;

		String nombre, apellidos, dni;

		listarAlumnos(listaAlumnos);

		
			System.out.println("Introduzca el nÃºmero de lista del alumno que desea listar sus calificaciones");
			alumno = entrada.nextInt();
			if (alumno < 1 || alumno > listaAlumnos.size()) {
				throw new Exception ("Debe seleccionar el nÃºmero de lista de un Alumno vÃ¡lido.");
			}

		

		System.out.println("Has selecionado a :");
		apellidos = listaAlumnos.get(alumno - 1).getApellidos();
		nombre = listaAlumnos.get(alumno - 1).getNombre();
		dni = listaAlumnos.get(alumno - 1).getDni();
		System.out.println(apellidos + ", " + nombre + ", " + dni);

		System.out.println("Informe de faltas:");
		for (i = 0; i < listaAlumnos.get(alumno - 1).getFaltas().size(); i++) {

			(listaAlumnos.get(alumno - 1).getFaltas().get(i).getFechaDia()).imprimeFecha();
			System.out.print(" : ");
			(listaAlumnos.get(alumno - 1).getFaltas().get(i).getSesion()).imprimeHorario();
		}

	}

	// MÃ©todo Main que llama a los demÃ¡s mÃ©todos. 
	// Autor: LujÃ¡n
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner entrada = new Scanner(System.in);

		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

		int menu = 0;
		do {
			mostrarMenu();
			menu = entrada.nextInt();

			switch (menu) {
			case 1:
				do {
					try {
						darDeAlta(listaAlumnos);
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 2:
				do {
					try {
						darDeBaja(listaAlumnos);
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 3:

				listarAlumnos(listaAlumnos);

				break;
			case 4:
				try {
					modificarAlumnos(listaAlumnos);
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
				break;
			case 5:
				do {
					try{
						matricular(listaAlumnos);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 6:
				do {
					try{
						darBajaAsignatura(listaAlumnos);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 7:
				do {
					try{
						introducirCalificacion(listaAlumnos);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 8:
				do {
					listarCalificaciones(listaAlumnos);
				} while (repetir() == true);
				break;
			case 9:
				do {
					try{
						ponerFaltaDia(listaAlumnos);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 10:
				do {
					try{
						ponerFaltaSesion(listaAlumnos);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 11:
				try{
					pasarLista(listaAlumnos);
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				break;
			case 12:
				do {
					try{
						listarFaltas(listaAlumnos);
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 13:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Error.");
				break;
			}

		} while (menu != 13);
		System.out.println("Programa finalizado.");
	}

}


