//Autor: Santiago Pérez

public class Fecha {
	
	private int dia, mes, agno;
	
	//Se crean excepciones que delimitarán si la fecha es válida o no
	public static void fechaNoValida (int dianov, int mesnov, int agnonov) throws Exception {
		

		
	}
	
	//Constructor por parámetros
	public Fecha (int dia, int mes, int agno) throws Exception {
		
		//Excepciones propias. Van a controlar que la fecha sea válida
		
		//Excepción para cuando el año no es posterior a 2015
		if (agno<2016)
			throw new Exception ("Error: El año debe ser posterior a 2015.");
		
		//Excepción para cuando mes es menor de 1 o mayor que 12
		if (agno>2015&&(mes<1||mes>12))
			throw new Exception ("Error: El mes debe estar comprendido entre 1 y 12.");
		
		//Excepción para cuando día es menor que 1 o mayor que 31 en meses de 31 días
		if (agno>2015&&(mes==1||mes==3||mes==5||mes==7||mes==8||mes==10||mes==12)&&(dia>31||dia<1))
			throw new Exception ("Error: Para meses de 31 días, día debe estar comprendido entre 1 y 31.");
		
		//Excepción para cuando día es menor que 1 o mayor que 30 en meses de 30 días
		if (agno>2015&&(mes==4||mes==6||mes==9||mes==11)&&(dia>30||dia<1))
			throw new Exception ("Error: Para meses de 30 días, día debe estar comprendido entre 1 y 30.");
		
		//Excepción para cuando día es menor que 1 o mayor que 28 en febrero
		if (agno>2015&&(mes==2)&&(dia>28||dia<1))
			throw new Exception ("Error: Para febrero, día debe estar comprendido entre 1 y 28.");
		
		this.dia = dia;
		this.mes = mes;
		this.agno = agno;
		

	}
	
	//Getters
	public int getDia () {
		return dia;
	}
	
	public int getMes () {
		return mes;
	}
	
	public int getAgno () {
		return agno;
	}
	
	//Método para imprimir la fecha
	public void imprimeFecha() {
		
		//Se confecciona un string en el formato requerido, que después es devuelto
		String fech;
		
		fech = "Fecha: "+dia+" / "+mes+" / "+agno;
		
		System.out.println(fech);
	}

	// Sobrecarga del método equals de la clase Object
	public boolean equals(Object object) {
	 boolean igual = false;
	 if (object instanceof Fecha) {
	 Fecha fecha = (Fecha) object;
	 if (fecha.getDia() == this.getDia() && fecha.getMes()
	== this.getMes() && fecha.getAgno() == this.getAgno())
	 igual = true;
	 }
	 return igual;
	 } 
}
