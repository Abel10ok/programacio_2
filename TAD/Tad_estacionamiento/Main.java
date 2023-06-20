package Tad_estacionamiento;

public class Main {

	public static void main(String[] args) {
		Estacionamiento estUngs = new Estacionamiento(50,10,50,5,100,20);
		estUngs.ingresarAuto("AAA111", 11,"Docente");
		estUngs.ingresarAuto("BBB111", 12,"Alumno");
		estUngs.ingresarAuto("CCC111", 10,"General");
		
		System.out.println(estUngs);
		System.out.println();
		
		estUngs.sacarAuto("AAA111", 15);
		estUngs.ingresarAuto("DDD111", 10,"Alumno");
		
		
		System.out.println(estUngs);
		System.out.println();
		
		System.out.println("Esta automovil " + "AAA111: " + estUngs.estaAuto("AAA111"));
		System.out.println("Esta automovil " + "DDD111: " + estUngs.estaAuto("DDD111"));
		//no elimina auto!!!
	}

}
