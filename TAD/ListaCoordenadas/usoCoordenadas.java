package ListaCoordenadas;

public class usoCoordenadas {

	public static void main(String[] args) {
		
		ListaCoord lista = new ListaCoord();
		
		lista.agregar(2, 3);
		lista.agregar(-2, 3);
		lista.agregar(-2, -3);
		lista.agregar(1, 0);
		lista.agregar(4, 1);
		lista.agregar(0, 0);
		lista.agregar(0, 7);

		
		
		System.out.println(lista);
		System.out.println("La lista tiene: " + lista.cuantasEnCuad(1) + " puntos en cuadrante 1");
		System.out.println("La lista tiene: " + lista.cuantasEnCuad(3) + " puntos en cuadrante 3");
		
		System.out.println("La lista tiene: " + lista.cuantasEnEjes() + " puntos sobre los ejes");
		
	}
}