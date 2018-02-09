//Autor: Juan Mártin
public class DiaClase {
	
	//Variables son objetos de las clases horario y fecha//
	private Object fechaDia;
	private Object sesion;
	
	//Construcctor//
	
	public DiaClase (Object fechaDia, Object sesion) {
		this.fechaDia = fechaDia;
		this.sesion = sesion;
	}
	
	//metodos//
	//getters//
	
	public Object getFechaDia() {
		return fechaDia;
	}
	
	public Object getSesion() {
		return sesion;
	}
	
	//setter//
	
	public void setFechaDia (Object fechaDia) {
		this.fechaDia = fechaDia;
	}
	//sobrecarga equals//
//	public boolean equals (Object object) {
//		boolean igual = false;
//		
//		if (object instanceof Calificacion) {
//			Calificacion calificacion = (Calificacion) object;
//			
//		if(calificacion.getAsignatura ().equalsIgnoreCase(this.getAsignatira())) {
//			 igual = true;
//			}
//			return igual;
//		}
//	}
}

	