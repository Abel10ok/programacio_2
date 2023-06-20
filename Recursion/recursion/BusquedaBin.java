package recursion;

public class BusquedaBin {
	
	public static void main(String[] args) {
		int[] arreglo = {2, 5, 8, 12, 15, 18, 25, 28};
		System.out.println(busquedaBin(arreglo,-2));
		System.out.println(busquedaBin(arreglo,2));
		System.out.println(busquedaBin(arreglo,15));
		System.out.println(busquedaBin(arreglo,22));
		System.out.println(busquedaBin(arreglo,28));
		System.out.println(busquedaBin(arreglo,30));
	}
	
	public static int busquedaBin(int[] arr, int elem) {
		return busquedaBin(arr,elem,0,arr.length-2);
	}

	private static int busquedaBin(int[] arr, int elem, int desde, int hasta) {
		if (desde>hasta)
			// Primer caso base: no hay donde buscar, el elemento no esta
			return -1;
		int medio = (desde+hasta)/2;
		if (arr[medio]==elem)
			// Segundo caso base: se encontro el elemento
			return medio;
		else if (arr[medio]>elem)
			// El elemento es menor, busco a la izquierda
			return busquedaBin(arr,elem,desde,medio-1);
		else
			// El elemento es mayor, busco a la derecha
			return busquedaBin(arr,elem,medio+1,hasta);
	}

}
