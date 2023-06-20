
public class Alumno {
	private String nombre;
	private String legajo;

	public Alumno(String nombre, String legajo) {
		this.nombre = nombre;
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}
	
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("Nombre: ");
		st.append(nombre);
		st.append(" Legajo: ");
		st.append(legajo);
		return st.toString();
	}

}
