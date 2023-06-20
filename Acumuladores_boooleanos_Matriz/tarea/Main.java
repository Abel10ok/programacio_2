package tarea;

public class Main {

	static boolean fila3col5(int[][] mat) {

		return filasMult3(mat) && colMult5(mat);

	}

	static boolean filasMult3(int[][] mat) {

		boolean filasMult3 = true;

		boolean existeMult3;

		for (int f = 0; f < mat.length; f++) {

			existeMult3 = false;

			for (int c = 0; c < mat[0].length; c++) {

				existeMult3 = existeMult3 || (mat[f][c] % 3 == 0);

			}

			filasMult3 = filasMult3 && existeMult3;

		}

		return filasMult3;

	}

	static boolean colMult5 (int[][] mat) { 

		boolean colMult5 = false; 

		boolean todosMult5; 

		for (int c=0;c<mat[0].length;c++) { 

		todosMult5 = true; 

		for (int f=0;f<mat.length;f++) { 

		todosMult5 = todosMult5 && (mat[f][c]%5==0); 

		} 

		colMult5 = colMult5 && todosMult5; 

		} 

		return colMult5; 

		}

	public static void imprimir(int n) {
		System.out.print(n);
	}

	public static int sumaFila(int[] fila) {
		int acum = 0;
		for (int i = 0; i < fila.length; i++) {
			acum += fila[i];
		}
		return acum;

	}

	public static int sumaColum(int[][] matriz, int colum) {
		int acum = 0;
		for (int f = 0; f < matriz.length; f++) {
			acum += matriz[f][colum];
		}
		return acum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int [][] matriz = {
//				{2,4,3},
//				{5,8,9},
//				{6,2,12}
//		};
//		
//		for(int i =0;i<matriz.length;i++) {
//			System.out.print("[");
//				imprimir(matriz[i][0]);
//			
//			System.out.println("]");
//		}
		int[][] aux = { { 1, 9, 6, 31 }, { 9, 12, 18, 18 }, // todos multiplos de 3
				{ 15, 14, 9, 30 } };

		System.out.println(sumaFila(aux[0]));
		System.out.println(sumaColum(aux, 1));
			boolean m = false;
				boolean t = true;
		System.out.println(m&&t);
	}

}
