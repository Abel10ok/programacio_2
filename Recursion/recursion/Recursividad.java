package recursion;

public class Recursividad {

	public static void main(String args[]) {
		System.out.println("Suma del arreglo: " + suma(new int[] { 8, 10, 2, 4, 6 }));

		System.out.println("Maximo del arreglo: " + maximo(new int[] { 8, 10, 2, 4, 6 }));

		int[] arr = { 1, 2, 3, 3, 2, 1 };
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println(esPalindromo(arr));
		int[] arr1 = { 10, 21, 3, 33, 25, 4 };
		System.out.println(busquedaBin(arr1,211));
	}

	// Metodo publico (no recursivo)
	public static int suma(int[] arr) {
		// Suma del arreglo a partir de la posicion 0
		return suma(arr, 0);
	}

	// Metodo auxiliar privado RECURSIVO
	private static int suma(int[] arr, int i) {
		if (i == arr.length)
			// caso base
			return 0;
		else
			// caso recursivo
			return arr[i] + suma(arr, i + 1);
	}

	// Metodo publico (no recursivo)
	public static int maximo(int[] arr) {
		if (arr.length == 0)
			throw new RuntimeException("No es posible calcular el maximo para un arreglo vacio");
		// Maximo del arreglo a partir de la posicion 0
		return maximo(arr, 0);
	}

	private static int maximo(int[] arr, int i) {
		if (i == arr.length - 1)
			return arr[arr.length - 1];
		else
			return Math.max(arr[i], maximo(arr, i + 1));
	}

	// Tarea: retorna Verdadero si el arreglo se lee igual
	// desde el inicio hasta el fin
	// que desde del fin hasta el inicio
	public static boolean esPalindromo(int arr[]) {
		if (arr.length == 0)
			throw new RuntimeException("Arreglo vacio");
		if (arr.length % 2 != 0) {
			throw new RuntimeException("Arreglo impar");
		}
		return esPalindromo(arr, 0, arr.length - 1);
	}

	private static boolean esPalindromo(int[] arr, int comienzo, int fin) {
		if (comienzo >= fin) {
			return true;
		}
		if (arr[comienzo] != arr[fin]) {
			return false;
		}
		return esPalindromo(arr, comienzo + 1, fin - 1);
	}

	// Tarea: Retorna la posicion del arreglo donde se encuentra el valor
	// Si no esta en el arreglo, retorna -1
	public static int busquedaBin(int[] arr, int valor) {
		if(arr.length==0)
			throw new RuntimeException("arreglo vacio");
		return busquedaBin(arr,valor,0,0);
	}

	private static int busquedaBin(int[] arr, int valor,int pos,int cont) {
		if(pos>arr.length-1) {
			return -1;
		}
		if(arr[pos]==valor) {
			return cont;
		}
		return busquedaBin(arr,valor,pos+1,cont+1);
	}

}