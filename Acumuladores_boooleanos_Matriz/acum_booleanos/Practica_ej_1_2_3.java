package acum_booleanos;

public class Practica_ej_1_2_3 {

	static public boolean todosMayor8(Integer[] lista) {
		boolean ret = true;
		for (int i = 0; i < lista.length; i++) {
			ret = ret && lista[i] > 8;
		}
		return ret;
	}

	static public boolean algunoMenor23(Integer[] lista) {
		boolean ret = false;
		for (int i = 0; i < lista.length; i++) {
			ret = ret || lista[i] < 23;
		}
		return ret;
	}

	/*
	 * 1) Implementar con acumuladores una función booleana “mayor10” que recibe una
	 * lista de números, que sea verdadera si todos los números son mayores a 10.
	 */

	public static boolean mayor10(Integer[] lista) {
		boolean ret = true;
		for (int i = 0; i < lista.length; i++) {
			ret = ret && lista[i] > 10;
		}
		return ret;
	}

	/*
	 * 2) Implementar una función que determine si un arreglo es subconjunto de
	 * otro: public static boolean pertenecenTodos(int[] elems, int[] arreglo) ...
	 * 
	 * Casos borde a tener en cuenta: - elems está vacío (y la función devuelve
	 * verdadero) - arreglo está vacío (y la función devuelve falso) - alguno de los
	 * arreglos contiene duplicados (no influye, es suficiente con que estén una
	 * vez) Algunos ejemplos: [1, 2] ⊆ [3, 2, 1] [4, 1] ⊈ [1, 2, 3] [2, 2] ⊆ [1, 2,
	 * 3]
	 */

	public static boolean pertenece(Integer elems, Integer[] arreglo) {
		for (int i = 0; i < arreglo.length; i++) {
			if (elems == arreglo[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean pertenecenTodos(Integer[] elems, Integer[] arreglo) {
		if (elems.length == 0) {
			return false;
		} else if (elems.length == 0) {
			return true;
		}
		boolean ret = true;
		for (int i = 0; i < arreglo.length; i++) {
			ret = ret && pertenece(elems[i], arreglo);
		}
		return ret;
	}

	/*
	 * 3) Implementar la función, utilizando acumuladores booleanos, que reciba una
	 * matriz de enteros, y devuelva verdadero  en cada una de las filas, existe al
	 * menos un número negativo. public static boolean tieneNegativos(int[][] mat){
	 * ...
	 */

	public static boolean filaAlgunNegativo(int[] fila) {
		boolean ret = false;
		for (int i = 0; i < fila.length; i++) {
			ret = ret || fila[i] < 0;
		}
		return ret;
	}

	public static boolean tieneNegativos(int[][] mat) {
		boolean ret = true;
		for (int f = 0; f < mat.length; f++) {
			ret = ret && filaAlgunNegativo(mat[f]);
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Ejercicio: Realizar una función que dada una lista de números devuelva
		 * verdadero si: La lista tiene todos los números mayores que 8 La lista tiene
		 * algún número menor que 23 Utilizando acumuladores boléanos
		 */
		Integer[] lista1 = { 9, 10, 11 }; // cumple
		Integer[] lista2 = { 90, 100, 110 };
		System.out.println(todosMayor8(lista1) && algunoMenor23(lista1));// true
		System.out.println(todosMayor8(lista2) && algunoMenor23(lista2));// false

		// 1
		Integer[] lista = { 11, 12, 13, 14, 15, 16 };

		System.out.println(mayor10(lista));

		// 2
		Integer[] listaDos = {};
		Integer[] lista3 = { 1, 2, 3, 4 };
		System.out.println(pertenecenTodos(listaDos, lista3));

		// 3
		int[][] matriz = { { -1, 2, 3 }, { 4, -5, 6 }, { 7, 8, 9 } };

		System.out.println(tieneNegativos(matriz));

	}

}
