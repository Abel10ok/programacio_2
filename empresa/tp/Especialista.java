package tp;

import java.util.*;

public class Especialista {
	private int numEspecialista;
	private String nombre;
	private String telefono;
	private String especialidad;
	private int codServicio;
	private List<Servicio> historial;

	public Especialista(int numEspecialista, String nombre, String telefono, String especialidad) {
		this.numEspecialista = numEspecialista;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especialidad = especialidad;
		historial = new ArrayList<Servicio>();
	}
	
	public void agregarCodigoServicio(int codigo) {
		this.codServicio = codigo;
	}
	
	public String devolverHistorial(){
		StringBuilder str = new StringBuilder();
		str.append(historial);
		return str.toString();
	}
	public void actualizarHistorial(Servicio Servicio, int cod) {
		Servicio.setCodServicio(cod);
		historial.add(Servicio);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numEspecialista);
		
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialista other = (Especialista) obj;
		return numEspecialista == other.numEspecialista;
	}

	public int getNumEspecialista() {
		return numEspecialista;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public int getCodServicio() {
		return codServicio;
	}



	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append("nombre=");
		str.append(nombre);
		str.append(" numero= ");
		str.append(numEspecialista);
		str.append("\n");
		return str.toString();
	}



	

}
