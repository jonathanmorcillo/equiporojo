//Autor: Juan Martín
public class DiaClase {
	
	//Variables son objetos de las clases horario y fecha//
	private Fecha fechaDia;
	private Horario sesion;
	
	//Construcctor//
	
	public DiaClase (Fecha fechaDia) {
		this.fechaDia = fechaDia;
		this.sesion = new Horario();
	}
	
	//metodos//
	//getters//
	
	public Fecha getFechaDia() {
		return fechaDia;
	}
	
	public Horario getSesion() {
		return sesion;
	}
	
	//setter//
	
	public void setFechaDia (Fecha fechaDia) {
		this.fechaDia = fechaDia;
	}
	// Sobrecarga del método equals de la clase Object
	public boolean equals(Object object){
	 boolean igual = false;

	 if(object instanceof DiaClase){
	 DiaClase diaClase = (DiaClase) object;
	 if(diaClase.getFechaDia().equals(this.getFechaDia()))
	 igual = true;
	 }
	 return igual;
	 }
}

	