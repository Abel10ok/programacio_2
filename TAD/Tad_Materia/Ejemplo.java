package Tad_Materia;
import java.util.ArrayList;

public class Ejemplo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Materia mat = new Materia("programacion");
		ArrayList<Comision> arr = new ArrayList<Comision>();
		
		mat.agregarCom("com1");
		mat.agregarCom("com2");

		mat.agregarAlumno(1, "abel", "com1");
		mat.agregarAlumno(2, "cielo", "com1");
		mat.agregarAlumno(3, "ludmila", "com1");
		mat.agregarAlumno(4, "paola", "com1");
		
		ArrayList<Integer> arr3 = new ArrayList<Integer>();
		arr3 = mat.libretas("com2");


		
		System.out.println(arr3);

		Comision com = new Comision("river");
		com.agregarAlumno(10, "juanfer");
		com.agregarAlumno(5, "enzo");
		com.agregarAlumno(9, "julian");
		
//		
//		System.out.println(com);
//		ArrayList<Integer> arr2 = new ArrayList<Integer>();
//		
//		arr2 = com.obtenerLibretas();
//		
//		System.out.println(arr2);

		
		

		
	}

}
