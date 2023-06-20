package Tad_Materia;

import java.util.*;
import java.util.Map.Entry;


public class Comision {

	private String nombre;
	private ArrayList<String> docentes;
	private TreeMap<Integer,String> alumnos;

	public Comision(String nombre) {
		this.nombre = nombre;
		docentes = new ArrayList<String>();
		alumnos = new TreeMap<Integer,String>();
	}
	
	
	public boolean agregarAlumno(int libreta,String nombre) throws Exception {
		if(nombre.equals(" ")) {
			throw new Exception ("Nombre vacio") ;
		}
		boolean ret = false;
		if(!perteneceAlumno(libreta)) {
			ret = true;
			alumnos.put(libreta, nombre);
			return ret;
		}
		
		throw new Exception ("Ya existe el alumno") ;
		
	}
	
	public boolean agregarDocente(String nombre) throws Exception {
		if(nombre.equals(" ")) {
			throw new Exception ("Nombre vacio") ;
		}
		if(!perteneceDocente(nombre)) {
			return docentes.add(nombre);
		}
		
		throw new Exception ("Ya existe el alumno") ;
	}
	
	public ArrayList<Integer> obtenerLibretas(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(Entry<Integer, String> entrada: alumnos.entrySet()) {
			int n = entrada.getKey();
			arr.add(n);
		}
		return arr;
		
	}
	
	public boolean perteneceDocente(String nombre) {
		return docentes.contains(nombre);
	}
	public boolean perteneceAlumno(int libreta) {
		return alumnos.containsKey(libreta);
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Comision [nombre=" + nombre + ", docentes=" + docentes + ", alumnos=" + alumnos + "]";
	}

		

}
