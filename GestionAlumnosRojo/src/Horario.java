
// Autor: Luján
public class Horario {

	// Variables
	private char[] sesiones = new char[6];

	// Constructor
	public Horario() {
		for (int i = 0; i < sesiones.length; i++) {
			this.sesiones[i] = ' ';
		}
	}

	// Get
	public char[] getSesiones() {
		return this.sesiones;
	}

	// Método faltaDiaEntero que pone todas las horas a F.
	public void faltaDiaEntero() {
		for (int i = 0; i < sesiones.length; i++) {
			this.sesiones[i] = 'F';
		}
	}

	// Método faltaHora que pone falta en una sesion específica.
	public void faltaHora(int sesion) throws Exception {
		if ((sesion > 6) || (sesion < 1)) {
			throw new Exception("Error: La sesion tiene que ser entre 1 y 6.");
		}
		try {
			this.sesiones[sesion - 1] = 'F';
		} catch (Exception excep) {
			System.out.println(excep.getMessage());
		}
	}

	// Método imprimeHorario para mostrar el array completo.
	public void imprimeHorario() {
		for (int i = 0; i < sesiones.length; i++) {
			System.out.println(sesiones[i]);
			if (sesiones.length - 1 != i) {
				System.out.println("/");
			}
		}
	}
}
