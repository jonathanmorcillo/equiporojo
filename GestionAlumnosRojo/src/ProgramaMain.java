import java.util.*;

public class ProgramaMain {

	// Autor: Luján
	public static void mostrarMenu() {
		System.out.println("Selecciona una opción:" + "\n1. Dar de alta alumnnos." + "\n2. Dar de baja alumnos."
				+ "\n3. Listar los alumnos." + "\n4. Modificar alumnos." + "\n5. Matricular alumnos."
				+ "\n6. Dar de baja de una asignatura." + "\n7. Introducir calificación trimestral."
				+ "\n8. Listar calificaciones de alumnos." + "\n9. Poner una falta (Día completo)."
				+ "\n10. Poner una falta (en una sesión)." + "\n11. Pasar lista." + "\n12. Listar faltas."
				+ "\n13. Salir.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Autor: Luján
		Scanner entrada= new Scanner(System.in);
		
		int menu = 0;
		boolean repetir = false;
		do {
			mostrarMenu();
			menu=entrada.nextInt();
			
			switch(menu) {
			case 1:
				do {
				}while(repetir==true);
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				break;
			case 13:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Error.");
				break;
			}
					
		}while(menu!=13);
	}

}
