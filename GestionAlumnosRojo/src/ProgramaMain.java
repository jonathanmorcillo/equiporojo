import java.util.*;

public class ProgramaMain {
	
	//Autor: Jose Alberto. M�todo est�tico 3
		public static void listarAlumnos(ArrayList<Alumno> alumno) {
			alumno = new ArrayList<Alumno>();
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

	// Autor: Luj�n
	public static void mostrarMenu() {
		System.out.println("*********************************");
		System.out.println("***********   Men�   ************");
		System.out.println("*********************************");
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
	
	// Autor: Juan Mart�n
	

	public static int existe(ArrayList<Alumno> listaAlumnos, String dni) {
		boolean comprobar = false;
		int posicion=0;
		for (int i=0; i<listaAlumnos.size() && !comprobar; i++) { 
			if (listaAlumnos.get(i).getDni().equals(dni)) {
				comprobar = true;
				posicion = i;
			} else {
				comprobar = false;
			}	
		}
		
		if (comprobar==true) {
			return posicion;
		} else {
			return -1;
		}
	}
	
	// Autor: Juan Mart�n, Metodo 5 Matricular alumnos.
	
	
	
	
	
	
	// Autor: Juan Mart�n, Metodo 8 Listar calificaciones del alumno.
	
	public static void listarAlumnos(ArrayList<Alumno> listaAlumnos ,String dni) {
		 
		
	}
	
	
	// Autor: Luj�n. M�todo para sacar el d�a.
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
	
	// Autor: Luj�n. M�todo 9 Poner una falta (D�a completo). 
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
	
	// Autor: Luj�n. M�todo 10 Poner una falta (una sesi�n).
	public static void ponerFaltaSesion(ArrayList<Alumno> listaAlumnos, String dni, Fecha fechaDia)throws Exception{
		Scanner entrada = new Scanner(System.in);
		int sesion, exist, dia=0;
		exist = existe(listaAlumnos,dni);
		if(exist > 0) {
			System.out.println("Dime la sesi�n:");
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
	
	// Autor: Luj�n
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Alumno> alumno = new ArrayList<Alumno>();
		Scanner entrada = new Scanner(System.in);

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
				
				ProgramaMain.listarAlumnos(alumno);
				
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
