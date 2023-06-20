import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;

public class IteradoresEjemplo {

	public static void eliminarAlumnoPorLegajo(List<Alumno> alumnos, String legajo) {

//		for (Alumno alumno : alumnos) {
//			if(alumno.getLegajo().compareTo(legajo)==0) {//0 si los string son iguales
//					alumnos.remove(alumno);				//positivo si el legajo es mas grande que el otro en version String
//														//negativo si el legajo es menor.
//			}
//		}

		Iterator<Alumno> itAlumno = alumnos.iterator();
		while (itAlumno.hasNext()) {
			Alumno nuevoAlumno = itAlumno.next();
			if (nuevoAlumno.getLegajo().compareTo(legajo) == 0) {
				itAlumno.remove();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos.add(new Alumno("Martin", "1234"));
		alumnos.add(new Alumno("Abel", "4567"));
		alumnos.add(new Alumno("Cielo", "8910"));
		alumnos.add(new Alumno("Ludmi", "1011"));

		System.out.println(alumnos);
		eliminarAlumnoPorLegajo(alumnos, "4567");
		System.out.println(alumnos);

	}

}
