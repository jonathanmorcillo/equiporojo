import java.util.*;

import javax.swing.SingleSelectionModel;

public class ProgramaMain {


	// Autor: Luján
	public static void mostrarMenu() {
			System.out.println("********************************");
			System.out.println("***********   Menú   ***********");
			System.out.println("******************************** ");
			System.out.println("Selecciona una opción:" + "\n1. \t Dar de alta alumnos." + "\n2. \t Dar de baja alumnos."
					+ "\n3. \t Listar los alumnos." + "\n4. \t Modificar alumnos." + "\n5. \t Matricular alumnos."
					+ "\n6. \t Dar de baja de una asignatura." + "\n7. \t Introducir calificación trimestral."
					+ "\n8. \t Listar calificaciones de alumnos." + "\n9. \t Poner una falta (Día completo)."
					+ "\n10. \t Poner una falta (en una sesión)." + "\n11.  \t Pasar lista." + "\n12. \t Listar faltas."
					+ "\n13. \t Salir.");
		}

	// Autor: Luján
	public static char repetir() {
			Scanner entrada = new Scanner(System.in);
			char repetir = ' ';

			System.out.println("¿Quieres repetir esta opción?" + "\nEscribe Y si es sí y N si es no.");
			repetir = entrada.next().charAt(0);

			return repetir;
	}
	
	//Autor: Jose Alberto. Método estático 3
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
			System.out.print(cont+". Nombre: "+nombre+"\nApellido: "+apellido+"\nDNI: "+dni+"\nE-mail: "+email+"\nTeléfono: "+telefono+"\n");
			
		}
	}


	// Autor: Juan Martín

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
// Autor: Juan Martín, Metodo 5 Matricular alumnos.

	public static void Matricular(ArrayList<Alumno> listaAlumnos, String dni, String asignatura) throws Exception {
		if (matriculado(listaAlumnos, dni, asignatura) >= 0) {
			System.out.println("Se informa que el alumno "+dni+" ya se encuentra matriculado.");
		} else {
			Calificacion aux = new Calificacion(asignatura);
			listaAlumnos.get(existe(listaAlumnos, dni)).getNotas().add(aux);
			System.out.println("El alumno ha sido matriculado correctamente.");
		}
	}

	// Autor: Jose Alberto. Método 7: Introducir calificaciones.
	public static void introducirCalificacion(ArrayList<Calificacion> notas, String dni, ArrayList<Alumno> alumno)throws Exception {
		Scanner entrada = new Scanner(System.in);
		String nota, asignatura;
		int existe, pos=-1;
		
		existe = existe(alumno,dni);
		if (existe>0) {
			try{
				System.out.println("Introduzca la posición del alumno del cual desea introducir las calificaciones");
				pos=entrada.nextInt();
				
				entrada.next();
				
				System.out.println("Introduzca la asignatura que va a calificar");
				asignatura=entrada.nextLine();
			
				Calificacion calificacion = new Calificacion(asignatura);
				
				System.out.println("Introduzca la nota obtenida");
				nota=entrada.nextLine();
				
				calificacion.setNota(nota);
				
				alumno.get(pos).getNotas().add(calificacion);
				
				}catch (Exception except) {
					System.out.println(except.getMessage());
				}
		}
	}
	
// Autor: Juan Martín, Metodo 8 Listar calificaciones del alumno.

	public static void listarCalificaciones (ArrayList<Alumno> listaAlumnos) {
		Scanner entrada = new Scanner(System.in);
		int alumno, i;
		String nombre, apellidos, dni;
		
		listarAlumnos(listaAlumnos);
		
		do {
			
		System.out.println("Introduzca el número de lista del alumno que desea listar sus calificaciones");
		alumno = entrada.nextInt();
		if (alumno < 1 || alumno > listaAlumnos.size()) {
			System.out.println("Debe seleccionar el número de lista de un Alumno válido.");
		}
			
		} while (alumno < 1 || alumno > listaAlumnos.size());
		
		System.out.println("Has selecionado a :");
		apellidos = listaAlumnos.get(alumno-1).getApellidos();
		nombre = listaAlumnos.get(alumno-1).getNombre();
		dni = listaAlumnos.get(alumno-1).getDni();
		System.out.println(apellidos+", "+nombre+", "+dni);
		
		System.out.println("Boletin de notas");
		for (i = 0; i < listaAlumnos.get(alumno-1).getNotas().size(); i++) {
			
			System.out.println("Asignatura : "+listaAlumnos.get(alumno-1).getNotas().get(i).getAsignatura()+" Nota trimestral : "+listaAlumnos.get(alumno-1).getNotas().get(i).getNota());
		}
		

		
	}
	

	// Autor: Luján. Método para sacar el día.
	public static int sacarDia(ArrayList<Alumno> listaAlumnos, String dni, Fecha fechaDia) {
		int exist, dia=0;
		exist = existe(listaAlumnos,dni);
		for(int i = 0; i < listaAlumnos.get(exist).getFaltas().size(); i++) {
			if(listaAlumnos.get(exist).getFaltas().get(i).getFechaDia().equals(fechaDia)) {
				dia = i;
			}
		}
		return dia;
	}
	
	// Autor: Luján. Método 9 Poner una falta (Día completo). 
	public static void ponerFaltaDia(ArrayList<Alumno> listaAlumnos, String dni, Fecha fechaDia){
		Scanner entrada = new Scanner(System.in);
		int exist, dia=0;
		exist = existe(listaAlumnos,dni);
		if(exist > 0) {
			try {
				sacarDia(listaAlumnos, dni, fechaDia);
				listaAlumnos.get(exist).getFaltas().get(dia).getSesion().faltaDiaEntero();
			}catch(Exception excep) {
				System.out.println(excep.getMessage());
			}
		}
	}
	
	// Autor: Luján. Método 10 Poner una falta (una sesión).
	public static void ponerFaltaSesion(ArrayList<Alumno> listaAlumnos, String dni, Fecha fechaDia)throws Exception{
		Scanner entrada = new Scanner(System.in);
		int sesion, exist, dia=0;
		exist = existe(listaAlumnos,dni);
		if(exist > 0) {
			System.out.println("Dime la sesión:");
			sesion=entrada.nextInt();
			try {
				sacarDia(listaAlumnos, dni, fechaDia);
				listaAlumnos.get(exist).getFaltas().get(dia).getSesion().faltaHora(sesion);
			}catch(Exception excep) {
				System.out.println(excep.getMessage());
			}
		}else {
			throw new Exception("Error: No existe el alumno.");
		}	
}
	
	// Autor: Luján
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

