package acum_booleanos;

public class Practica_ej_5_de_parcial {
	/*
	 * Ejercicio de parcial Implementar una función que dada una matriz de N x N
	 * elementos enteros y un arreglo de N elementos enteros determine si el
	 * elemento i del arreglo se encuentra en la fila i de la matriz: Casos borde a
	 * tener en cuenta: - arreglo está vacío (y la función devuelve verdadero) - mat
	 * está vacío (y la función devuelve falso) - la matriz contiene duplicados (no
	 * influye, es suficiente con que estén una vez)
	 */

	public static boolean perteneceAFilaMatriz(int[] fila, int elem) {
		boolean ret = false;
		for (int i = 0; i < fila.length; i++) {
			ret = ret || fila[i] == elem;
		}
		return ret;

	}

	public static boolean elementoArregloEnFilas(int[][] matriz, int[] arreglo) {
		if (matriz.length == 0) {
			return false;
		} else if (arreglo.length == 0) {
			return true;
		}
		boolean ret = true;
		for (int fila = 0; fila < matriz.length; fila++) {
			ret = ret && perteneceAFilaMatriz(matriz[fila], arreglo[fila]);
		}
		return ret;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matriz = { { 2, 5, 7 }, { 9, 12, 14 }, { 14, 17, 19 } };

		int[] arr = { 5, 12, 19 };

//        System.out.println(perteneceAFilaMatriz(matriz[0],arr[0]));
		System.out.println(elementoArregloEnFilas(matriz, arr));

	}

}
