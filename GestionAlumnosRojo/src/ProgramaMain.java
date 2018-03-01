import java.util.*;

public class ProgramaMain {

	// Autor: Luj�n
	public static void mostrarMenu() {
		System.out.println("********************************");
		System.out.println("***********   Men�   ***********");
		System.out.println("******************************** ");
		System.out.println("Selecciona una opci�n:" + "\n1. \t Dar de alta alumnos." + "\n2. \t Dar de baja alumnos."
				+ "\n3. \t Listar los alumnos." + "\n4. \t Modificar alumnos." + "\n5. \t Matricular alumnos."
				+ "\n6. \t Dar de baja de una asignatura." + "\n7. \t Introducir calificaci�n trimestral."
				+ "\n8. \t Listar calificaciones de alumnos." + "\n9. \t Poner una falta (D�a completo)."
				+ "\n10. \t Poner una falta (en una sesi�n)." + "\n11.  \t Pasar lista." + "\n12. \t Listar faltas."
				+ "\n13. \t Salir.");
	}

	// Autor: Luj�n
	public static boolean repetir() {
		Scanner entrada = new Scanner(System.in);
		char repetir = ' ';

		System.out.println("�Quieres repetir esta opci�n?" + "\nEscribe Y si es s� y N si es no.");
		repetir = entrada.next().charAt(0);
		
		if(repetir=='Y'||repetir=='y') {
			return true;
		}else return false;

	}

	// Autor: Juan Mart�n

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
	public static int matriculado(ArrayList<Alumno> listaAlumnos, String dni, String asignatura) {

		// Creamos la variable para el bucle y otras 2 inicializadas en negativo para
		// saber si encontramos al alumno y la asignatura
		int k, j = -1, exist = -1;

		// Comprobamos si existe el alumno y si es asi procedemos a buscar la asignatura
		exist = existe(listaAlumnos, dni);
		if (exist != -1) {
			for (k = 0; k < listaAlumnos.get(exist).getNotas().size(); k++) {

				// Comprobamos si esta alumno esta matriculado en la asignatura y si es asi
				// ponemos la variable j al mismo valor de la posicion de esta asignatura puesto
				// que sera la variable que devolveremos

				if (listaAlumnos.get(exist).getNotas().get(k).getAsignatura().equals(asignatura)) {
					j = k;
				}
			}
		}
		return j;
	}

	//M�todo est�tico 1
	
		public static void darDeAlta (ArrayList matriculados) {
			
			//Opci�n 1 del men�
			
			//Autor: Santiago P�rez
			
			//Se recogen los datos del nuevo alumno del usuario
			
			Scanner entrada = new Scanner (System.in);
			
			String dni;
			String nombre;
			String apellidos;
			String telefono;
			String email;
			boolean comprobacion=false;
			
			
			System.out.println ("Introduzca el dni de alumno a matricular:");
			dni=entrada.nextLine();
			
			System.out.println ("Introduzca los apellidos de alumno a matricular:");
			apellidos=entrada.nextLine();
			
			System.out.println ("Introduzca el nombre de alumno a matricular:");
			nombre=entrada.nextLine();
			
			System.out.println ("Introduzca el tel�fono de alumno a matricular:");
			telefono=entrada.nextLine();
			
			System.out.println ("Introduzca el email de alumno a matricular:");
			email=entrada.nextLine();
			
			//Se crea un nuevo alumno usando el constructor, y los set para tel�fono y email
			Alumno nuevoAlumno = new Alumno (dni, nombre, apellidos);
			nuevoAlumno.setTelefono(telefono);
			nuevoAlumno.setEmail(email);
			
			//Se comprueba si el alumno ya existe
			comprobacion=matriculados.contains(nuevoAlumno);
			
			//Si no existe se a�ade, si existe se muestra un mensaje de error
			if (comprobacion==false) {
				
				matriculados.add(nuevoAlumno);
				
			}
			
			else {
				
				System.out.println("El alumno ya existe.");
			}
			
		}
			
			//M�todo est�tico 2
		
			public static void darDeBaja (ArrayList matriculados) {
				
				//Opci�n 2 del men�
				
				//Autor: Santiago P�rez
				
				Scanner entrada = new Scanner (System.in);
				
				int borrar;
				int totalalumnos;
				
				//Se recoge el n�mero del alumno a eliminar
				System.out.println("Introduzca el n�mero del alumno a eliminar:");
				listarAlumnos(matriculados);
				borrar=entrada.nextInt();
				borrar=borrar-1;
				
				//Se comprueba la longitud total del ArrayList de matriculados y que el n�mero que
				//se desea borrar est� dentro. Si lo est� se borra ese alumno, si no, se muestra
				//mensaje de error
				totalalumnos=matriculados.size();
				
				if (borrar>=0&&borrar<=totalalumnos) {
				
				matriculados.remove(borrar);
				
				}
				
				else System.out.println("El alumno que desea borrar no existe");
			}
	
	// Autor: Jose Alberto. M�todo est�tico 3
	public static void listarAlumnos(ArrayList<Alumno> alumno) {
		int num = alumno.size();
		int cont = 0;
		if (num == 0) {
			System.out.println("No hay alumnos");
		}
		Iterator<Alumno> iterador = alumno.iterator();
		while (iterador.hasNext()) {
			Alumno lista = iterador.next();
			String nombre = lista.getNombre();
			String apellido = lista.getApellidos();
			String dni = lista.getDni();
			String email = lista.getEmail();
			String telefono = lista.getTelefeno();
			cont += 1;
			System.out.print(cont + ". Nombre: " + nombre + "\nApellido: " + apellido + "\nDNI: " + dni + "\nE-mail: "
					+ email + "\nTel�fono: " + telefono + "\n");

		}
	}

	// Autor: Jonathan Morcillo ; Metodo 4
	public static void modificarAlumnos(ArrayList<Alumno> listaAlumnos) throws Exception {
		Scanner entrada = new Scanner(System.in);
		int opcion;

		do {

			// Creamos las variables necesarias
			Alumno al;
			int i;
			String modify;
			boolean mod = false;

			// Llamamos al metodo para mostrar la lista de alumnos
			listarAlumnos(listaAlumnos);

			System.out.println("Introduzca la posicion del alumno a modificar");

			// Restamos 1 puesto que las posiciones empiezan en 1 y las celdas en 0
			i = entrada.nextInt() - 1;
			entrada.nextLine(); // limpiamos buffer

			al = listaAlumnos.get(i);

			System.out.println(
					"Introduzca la opcion a realizar:\n1.- Modificar dni\n2.- Modificar nombre\n3.- Modificar apellidos\n4.- Modificar telefono\n5.- Modificar email\n6.- Salir");
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
				System.out.println("Introduzca el nuevo telefono para el alumno " + al.getNombre() + " "
						+ al.getApellidos() + " con numero actual " + al.getTelefeno());
				modify = entrada.nextLine();
				al.setTelefono(modify);
				System.out.println("El nuevo telefono del alumno es  " + al.getTelefeno());
				break;
			case 5:
				System.out.println("Introduzca el nuevo email para el alumno " + al.getNombre() + " "
						+ al.getApellidos() + " con email actual " + al.getEmail());
				modify = entrada.nextLine();
				al.setEmail(modify);
				System.out.println("El nuevo email del alumno es  " + al.getEmail());
				break;
			case 6:
				System.out.println("Has salido");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (opcion != 6);

	}

	// Autor: Juan Mart�n, Metodo 5 Matricular alumnos.

	public static void Matricular(ArrayList<Alumno> listaAlumnos, String dni, String asignatura) throws Exception {
		if (matriculado(listaAlumnos, dni, asignatura) >= 0) {
			System.out.println("Se informa que el alumno " + dni + " ya se encuentra matriculado.");
		} else {
			Calificacion aux = new Calificacion(asignatura);
			listaAlumnos.get(existe(listaAlumnos, dni)).getNotas().add(aux);
			System.out.println("El alumno ha sido matriculado correctamente.");
		}
	}

	// Autor: Jonathan Morcillo ; Metodo 6
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
						+ listaAlumnos.get(j).getApellidos() + " no esta registrado en dicha asignatura");
			}
		} else {
			throw new Exception("El alumno no existe");
		}
	}

	// Autor: Jose Alberto. M�todo 7: Introducir calificaciones.
	public static void introducirCalificacion(ArrayList<Calificacion> notas, String dni, ArrayList<Alumno> alumno)
			throws Exception {
		Scanner entrada = new Scanner(System.in);
		String nota, asignatura;
		int existe, pos = -1;

		existe = existe(alumno, dni);
		if (existe > 0) {
			try {
				System.out.println("Introduzca la posici�n del alumno del cual desea introducir las calificaciones");
				pos = entrada.nextInt();

				entrada.next();

				System.out.println("Introduzca la asignatura que va a calificar");
				asignatura = entrada.nextLine();

				Calificacion calificacion = new Calificacion(asignatura);

				System.out.println("Introduzca la nota obtenida");
				nota = entrada.nextLine();

				calificacion.setNota(nota);

				alumno.get(pos).getNotas().add(calificacion);

			} catch (Exception except) {
				System.out.println(except.getMessage());
			}
		}
	}

	// Autor: Juan Mart�n, Metodo 8 Listar calificaciones del alumno.

	public static void listarCalificaciones(ArrayList<Alumno> listaAlumnos) {
		Scanner entrada = new Scanner(System.in);
		int alumno, i;
		String nombre, apellidos, dni;

		listarAlumnos(listaAlumnos);

		do {

			System.out.println("Introduzca el n�mero de lista del alumno que desea listar sus calificaciones");
			alumno = entrada.nextInt();
			if (alumno < 1 || alumno > listaAlumnos.size()) {
				System.out.println("Debe seleccionar el n�mero de lista de un Alumno v�lido.");
			}

		} while (alumno < 1 || alumno > listaAlumnos.size());

		System.out.println("Has selecionado a :");
		apellidos = listaAlumnos.get(alumno - 1).getApellidos();
		nombre = listaAlumnos.get(alumno - 1).getNombre();
		dni = listaAlumnos.get(alumno - 1).getDni();
		System.out.println(apellidos + ", " + nombre + ", " + dni);

		System.out.println("Boletin de notas");
		for (i = 0; i < listaAlumnos.get(alumno - 1).getNotas().size(); i++) {

			System.out.println("Asignatura : " + listaAlumnos.get(alumno - 1).getNotas().get(i).getAsignatura()
					+ " Nota trimestral : " + listaAlumnos.get(alumno - 1).getNotas().get(i).getNota());
		}

	}

	// Autor: Luj�n. M�todo para sacar el d�a.
	public static int sacarDia(ArrayList<Alumno> listaAlumnos, String dni, Fecha fechaDia) {
		int exist, dia = 0;
		exist = existe(listaAlumnos, dni);
		for (int i = 0; i < listaAlumnos.get(exist).getFaltas().size(); i++) {
			if (listaAlumnos.get(exist).getFaltas().get(i).getFechaDia().equals(fechaDia)) {
				dia = i;
			}
		}
		return dia;
	}

	// Autor: Luj�n. M�todo 9 Poner una falta (D�a completo).
	public static void ponerFaltaDia(ArrayList<Alumno> listaAlumnos, String dni, Fecha fechaDia) {
		Scanner entrada = new Scanner(System.in);
		int exist, dia = 0;
		exist = existe(listaAlumnos, dni);
		if (exist > 0) {
			try {
				sacarDia(listaAlumnos, dni, fechaDia);
				listaAlumnos.get(exist).getFaltas().get(dia).getSesion().faltaDiaEntero();
			} catch (Exception excep) {
				System.out.println(excep.getMessage());
			}
		}
	}

	// Autor: Luj�n. M�todo 10 Poner una falta (una sesi�n).
	public static void ponerFaltaSesion(ArrayList<Alumno> listaAlumnos, String dni, Fecha fechaDia) throws Exception {
		Scanner entrada = new Scanner(System.in);
		int sesion, exist, dia = 0;
		exist = existe(listaAlumnos, dni);
		if (exist > 0) {
			System.out.println("Dime la sesi�n:");
			sesion = entrada.nextInt();
			try {
				sacarDia(listaAlumnos, dni, fechaDia);
				listaAlumnos.get(exist).getFaltas().get(dia).getSesion().faltaHora(sesion);
			} catch (Exception excep) {
				System.out.println(excep.getMessage());
			}
		} else {
			throw new Exception("Error: No existe el alumno.");
		}
	}

	// M�todo Main que llama a los dem�s m�todos. 
	// Autor: Luj�n
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
					darDeAlta(listaAlumnos);
				} while (repetir() == true);
				break;
			case 2:
				do {
					darDeBaja(listaAlumnos);
				} while (repetir() == true);
				break;
			case 3:

				listarAlumnos(listaAlumnos);

				break;
			case 4:
				do {
					try {
						modificarAlumnos(listaAlumnos);
					}catch(Exception ex) {
						System.out.println(ex.getMessage());
					}
				} while (repetir() == true);
				break;
			case 5:
				do {

				} while (repetir() == true);
				break;
			case 6:
				do {

				} while (repetir() == true);
				break;
			case 7:
				do {

				} while (repetir() == true);
				break;
			case 8:
				do {

				} while (repetir() == true);
				break;
			case 9:
				do {

				} while (repetir() == true);
				break;
			case 10:
				do {

				} while (repetir() == true);
				break;
			case 11:
				break;
			case 12:
				do {

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


