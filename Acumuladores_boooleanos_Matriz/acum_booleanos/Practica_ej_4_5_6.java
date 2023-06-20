package acum_booleanos;

public class Practica_ej_4_5_6 {
	/*
	 * 4) Implementar una función que, dada una matriz de enteros, verifique que: a)
	 * todas las filas están en orden estrictamente ascendente b) todas las columnas
	 * tienen al menos un elemento impar, y otro par Signatura y documentación: //
	 * Pre-condición: “int[][] mtx” es una matriz N × M, esto es: // todas las filas
	 * tienen longitud N y todas las columnas, M; // con N, M > 0. // // No es
	 * necesario verificar explícitamente la pre-condición: // de no cumplirse, el
	 * código puede devolver cualquier valor, o // lanzar una excepción (p.ej.
	 * ArrayIndexOutOfBoundsException). public static boolean
	 * mayorDiversidad(int[][] mtx) ... Algunos ejemplos: [[1, 2, 3], [4, 5, 6]] →
	 * Verdadero [[1, 2, 3], [4, 5, 5]] → Falso [[1, 2, 3], [2, 4, 6]] → Falso No
	 * cumplen la pre-condición: [[1, 2], [3, 4], [5, 6, 7]] [[1], [2, 3]] [[1], [2,
	 * 3], []] [] [[]]
	 */

	public static boolean ascendente(int[] fila) {
		boolean ret = true;
		int menor = fila[0];
		for (int i = 1; i < fila.length; i++) {
			ret = ret && menor <= fila[i];
		}
		return ret;
	}

	public static boolean par(int n) {
		return n % 2 == 0;
	}

	public static boolean parColumna(int[][] matriz, int columna) {
		boolean ret = false;
		for (int fila = 0; fila < matriz.length; fila++) {
			ret = ret || matriz[fila][columna] % 2 == 0;
			System.out.println(matriz[fila][columna]);
		}
		return ret;
	}

	public static boolean imparColumna(int[][] matriz, int columna) {
		boolean ret = false;
		for (int fila = 0; fila < matriz.length; fila++) {
			ret = ret || matriz[fila][columna] % 2 != 0;
			System.out.println(matriz[fila][columna]);
		}
		return ret;
	}

	public static boolean mayorDiversidad(int[][] matriz) {
		boolean ret = true;
		boolean ret2 = true;
		boolean ret3 = true;
		for (int f = 0; f < matriz.length; f++) {
			ret = ret && ascendente(matriz[f]);
			ret2 = ret2 && parColumna(matriz, f);
			ret3 = ret3 && imparColumna(matriz, f);
		}
		return ret && (ret2 && ret3);
	}

	/*
	 * 5) Implementar funciones con potencias de 2 y logaritmos en base 2 a)
	 * Implementar una función que dado un vector de enteros devuelva verdadero 
	 * todos sus elementos son potencia de 2. Algunos ejemplos: [8, 2, 32] →
	 * Verdadero [ 2**3 , 2**1 , 2**5 ] [15, 2, 8] → Falso. No son todos potencias
	 * de 2
	 */
	public static boolean pertenece(int[] arr, int num) {
		boolean ret = false;
		for (int i = 0; i < arr.length; i++) {
			ret = ret || arr[i] == num;
		}
		return ret;
	}

	public static boolean potenciaDos(int[] arr) {
		boolean ret = true;
		for (int i = 0; i < arr.length; i++) {
			ret = ret && par(arr[i]);

		}
		return ret;
	}

	/*
	 * b) Utilizar el punto 5) para implementar una función que dada una matriz de
	 * enteros devuelva verdadero  en alguna fila todos sus elementos son potencia
	 * de 2. Algunos ejemplos: [[1, 2, 3], [8, 2, 1]] → Verdadero fila 2 = [ 2**3,
	 * 2**1, 2**0 ] [[1, 2, 3], [11, 2, 8], [[4, 5, 6]] → Falso ninguna lo cumple
	 */

	public static boolean potenciaDos(int n) {
		if (n == 1) {
			return true;
		}
		return n % 2 == 0;
	}

	public static boolean filaPotenciaDos(int[] fila) {
		boolean ret = true;
		for (int i = 0; i < fila.length; i++) {
			ret = ret && (potenciaDos(fila[i]));
		}
		return ret;
	}

	public static boolean potenciaDosAlgunaFila(int[][] matriz) {
		boolean ret = false;
		for (int f = 0; f < matriz.length; f++) {
			ret = ret || filaPotenciaDos(matriz[f]);

		}
		return ret;
	}
	/*
	 * c) Implementar una función que dada una matriz de enteros devuelva verdadero
	 *  en alguna fila algún elemento es Parte Entera( log2(c+1) ) donde c es el
	 * índice de la columna. Algunos ejemplos: [[1, 2, 3], [0, 1, 1]] → Verdadero
	 * fila 1 lo cumple Parte entera(log21)=0 Parte entera(log22)=1 Parte
	 * entera(log23)=1 [[1, 2, 3], [11, 2, 8], [[4, 5, 6]] → Falso ninguna lo cumple
	 * d) IMPORTANTE: Interpretar cual es la relación entre 2n y log2(n)
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fila = { 2, 3, 4, 5 };
		int[][] matriz = { { 2, 5, 7 }, { 9, 12, 14 }, { 14, 17, 19 } };
		// System.out.println(ascendente(fila));

		// System.out.println(parColumna(matriz,0));
		// System.out.println(imparColumna(matriz,0));
		// System.out.println(mayorDiversidad(matriz));

		int[] potencia = { 8, 2, 32 };
		int[] potencia2 = { 15, 2, 8 };

		// System.out.println(potenciaDos(potencia));
		// System.out.println(potenciaDos(potencia2));

		int[][] matriz2 = { { 1, 2, 3 }, { 8, 2, 1 }, };
		int[][] matriz3 = { { 1, 2, 3 }, { 11, 2, 8 }, { 4, 5, 6 } };

		System.out.println(potenciaDosAlgunaFila(matriz2));
		System.out.println(potenciaDosAlgunaFila(matriz3));

	}

}
