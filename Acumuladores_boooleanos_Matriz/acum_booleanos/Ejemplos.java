package acum_booleanos;

public class Ejemplos {
	/*
	 * Ejemplo1: Queremos ver si toda una lista de números es par. Por ejemplo: -
	 * Arreglo A: [4 7 9 15 35 39] retorna false - Arreglo B: [4 8 10 2 12] retorna
	 * true A continuación, veremos dos soluciones: a) Versión 1a, Sin utilizar
	 * acumuladores
	 */

	public static boolean par(Integer x) {
		return x % 2 == 0;
	}

	public static boolean todoEsPar(Integer[] lista) {
		for (int i = 0; i < lista.length; i++) {
			if (!par(lista[i])) {
				return false;
			}
		}
		return true;
	}

	// b) USANDO ACUMULADOR BOOLEAN

	public static boolean todoEsPar2(Integer[] lista) {
		boolean ret = true;
		for (int i = 0; i < lista.length; i++) {
			ret = ret && par(lista[i]);
		}
		return ret;
	}

	/*
	 * Ejemplo 2: Queremos ver si algún número de una lista es par. - Arreglo A: [3
	 * 8 1 9 11] retorna true - Arreglo B: [9 5 1 7 3] retorna false En este ejemplo
	 * se utilizará el operador lógico OR. A continuación, veremos dos soluciones:
	 */

	public static boolean algunoPar(Integer[] array) {
		boolean ret = false;
		for (int i = 0; i < array.length; i++) {
			ret = ret || par(array[i]);
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] a = { 4, 7, 9, 15, 35, 39 };
		Integer[] b = { 4, 8, 10, 2, 12 };

		System.out.println(todoEsPar(a));
		System.out.println(todoEsPar(b));

		System.out.println(todoEsPar2(a));
		System.out.println(todoEsPar2(b));

		Integer[] c = { 3, 8, 1, 9, 11 };
		Integer[] d = { 9, 5, 1, 7, 3 };

		System.out.println(algunoPar(c));
		System.out.println(algunoPar(d));

	}

}
