// Clase de Jonathan Morcillo L�pez
public class Calificacion {

	// Declaramos las variables
	private String asignatura, nota;

	// Constructor para inicializar asignatura
	public Calificacion(String asignatura) {
		this.asignatura = asignatura;
	}

	// Metodos getters y setters
	public String getAsignatura() {
		return asignatura;
	}

	public String getNota() {
		return nota;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	// Sobrecarga del m�todo equals de la clase Object
	public boolean equals(Object object) {
		boolean igual = false;

		if (object instanceof Calificacion) {
			Calificacion calificacion = (Calificacion) object;

			if (calificacion.getAsignatura().equalsIgnoreCase(this.getAsignatura()))
				igual = true;
		}
		return igual;
	}

}
