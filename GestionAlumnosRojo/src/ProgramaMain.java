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
	public static char repetir() {
			Scanner entrada = new Scanner(System.in);
			char repetir = ' ';

			System.out.println("�Quieres repetir esta opci�n?" + "\nEscribe Y si es s� y N si es no.");
			repetir = entrada.next().charAt(0);

			return repetir;
	}
	
	//Autor: Jose Alberto. M�todo est�tico 3
	public static void listarAlumnos(ArrayList<Alumno> alumno) {
		int num = alumno.size();
		int cont=0;
		if (num==0) {
			System.out.println("No hay alumnos");
		}
		Iterator<Alumno> iterador = alumno.iterator();
		while(iterador.hasNext()) {
			Alumno lista = iterador.next();
			String nombre=lista.getNombre();
			String apellido=lista.getApellidos();
			String dni=lista.getDni();
			String email=lista.getEmail();
			String telefono=lista.getTelefeno();
			cont+=1;
			System.out.print(cont+". Nombre: "+nombre+"\nApellido: "+apellido+"\nDNI: "+dni+"\nE-mail: "+email+"\nTel�fono: "+telefono+"\n");
			
		}
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

	public static int matriculado(ArrayList<Alumno> listaAlumnos, String dni, String asignatura) throws Exception {
		int i, j, posi = -1;
		boolean matriculadoo = false;
		if (existe(listaAlumnos, dni) >= 0) {
			j = existe(listaAlumnos, dni);
			for (i = 0; i < listaAlumnos.get(j).getNotas().size() && !matriculadoo; i++) {
				if (listaAlumnos.get(j).getNotas().get(i).getAsignatura().equals(asignatura)) {
					matriculadoo = true;
					posi = i;
				} else {
					matriculadoo = false;
				}
				
				if (matriculadoo == true) {
					return posi; 
				} else {
					return -1;
				}
			}
		} else {
			throw new Exception("No existe el alumno. Debe darlo de alta primero.");
		}
		return posi;

	}
// Autor: Juan Mart�n, Metodo 5 Matricular alumnos.

	public static void Matricular(ArrayList<Alumno> listaAlumnos, String dni, String asignatura) throws Exception {
		if (matriculado(listaAlumnos, dni, asignatura) >= 0) {
			System.out.println("Se informa que el alumno "+dni+" ya se encuentra matriculado.");
		} else {
			Calificacion aux = new Calificacion(asignatura);
			listaAlumnos.get(existe(listaAlumnos, dni)).getNotas().add(aux);
			System.out.println("El alumno ha sido matriculado correctamente.");
		}
	}

// Autor: Juan Mart�n, Metodo 8 Listar calificaciones del alumno.

	public static void listarCalificaciones (ArrayList<Alumno> listaAlumnos) {
		Scanner entrada = new Scanner(System.in);
		int alumno;
		listarAlumnos(listaAlumnos);

		System.out.println("Introduzca el n�mero de lista del alumno que desea listar sus calificaciones");
		alumno = entrada.nextInt();
		
		
	}
	
	
	// Autor: Luj�n
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Alumno> alumno = new ArrayList<Alumno>();
		Scanner entrada = new Scanner(System.in);
		
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		int menu = 0;
		do {
			mostrarMenu();
			menu = entrada.nextInt();

			switch (menu) {
			case 1:
				do {

				} while (repetir() == 'Y');
				break;
			case 2:
				do {

				} while (repetir() == 'Y');
				break;
			case 3:

				listarAlumnos(listaAlumnos);
				
				break;
			case 4:
				do {

				} while (repetir() == 'Y');
				break;
			case 5:
				do {

				} while (repetir() == 'Y');
				break;
			case 6:
				do {

				} while (repetir() == 'Y');
				break;
			case 7:
				do {

				} while (repetir() == 'Y');
				break;
			case 8:
				do {

				} while (repetir() == 'Y');
				break;
			case 9:
				do {

				} while (repetir() == 'Y');
				break;
			case 10:
				do {

				} while (repetir() == 'Y');
				break;
			case 11:
				break;
			case 12:
				do {

				} while (repetir() == 'Y');
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
