package Tad_Materia;

import java.util.ArrayList;

public class Materia {
	private String nombre;
	private ArrayList<Comision> comisiones;
	private String coordinador;

	public Materia(String nombre) {
		this.nombre = nombre;
		comisiones = new ArrayList<Comision>();
	}
	
	
	//AGREGAR COMISIONES
	public boolean agregarCom(String com) throws Exception {
		Comision nuevaCom = new Comision(com);
		if(perteneceCom(nuevaCom)) {
			throw new Exception ("Ya existe: "+com);                       
		}
		return comisiones.add(nuevaCom);
	}
	
	
	//AGREGAR DOCENTE
	public boolean agregarDoc(String nombre,String nombreCom ) throws Exception {
		Comision nuevaCom = new Comision(nombreCom);
		if(!perteneceDocente(nombre)) {
			for(int i = 0;i<comisiones.size();i++) {
				if(comisiones.get(i).equals(nuevaCom)) {
					return comisiones.get(i).agregarDocente(nombre);
				}
			}
			
		}
		return false;
		
	}
	
	//AGREGAR ALUMNO
	public boolean agregarAlumno(int libreta,String nombre,String com) throws Exception {
		Comision nuevaCom = new Comision(com);
		for(int i = 0;i<comisiones.size();i++) {
			if(comisiones.equals(nuevaCom)) {
				try {
					return comisiones.get(i).agregarAlumno(libreta, nombre);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	//obtenerLibretas 
	public ArrayList<Integer> libretas(String com){
		Comision nuevaCom = new Comision(com);
		ArrayList<Integer> arr = null;
		for(int i = 0;i<comisiones.size();i++) {
			if(comisiones.get(i).equals(nuevaCom)) {
				System.out.println("hola");
			}
		}
		return arr;
	}
	
	
	//CAMBIAR COORDINADOR
	public boolean cambiarCoord(String nombre) {
		return false;
	}
	
	
	//SABER SI UNA COMISION YA PERTENECE A LA MATERIA
	private boolean perteneceCom(Comision com) {
		return comisiones.contains(com);
	}
	
	
	//SABER SI UN DOCENTE PERTENECE A LA MATERIA
	public boolean perteneceDocente(String nombre) {
		boolean ret = false;
		for(int i = 0;i < comisiones.size();i++) {
			ret = ret || comisiones.get(i).perteneceDocente(nombre);
		}
		return ret;
	}
	


	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", comisiones=" + comisiones + ", coordinador=" + coordinador + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if(nombre == " " || !perteneceDocente(nombre)) {
			throw new Exception ("No es un docente: "+nombre);    
		}
		this.nombre = nombre;
	}


}
