package tarea;

public class Acumuladores {
	/*Que dado una matriz de enteros y un número, y que verifique si existe alguna fila donde todos sus
	elementos sean múltiplos del número recibido por parámetro.
	Si la matriz está vacía o si el número no es positivo, devuelve falso.
	Por ejemplo: para la matriz
	2 4 3
	6 3 9
	6 2 7
	Si le paso el número 3, devolverá verdadero porque en la fila del medio todos son múltiplos de 3.
	Por otro lado, si le paso el número 2, devolverá falso porque no hay ninguna fila con todos sus elementos
	múltiplos de 2.*/
	public boolean filaMultiplos(int [] fila,int num) {
		boolean ret = true;
		for(int i =0;i<fila.length;i++) {
			ret = ret && fila[i]%num==0;
		}
		return ret;
	}
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		if(num<1) {
			return false;
		}
		boolean ret = false;
		for(int fila = 0;fila<mat.length;fila++) {
			ret = ret || filaMultiplos(mat[fila],num);
		}
		return ret;
	}
	
	// ejercicio 2 hayInterseccionPorFila()
//	Que dado 2 matrices se verifica si hay intersección entre las filas de cada matriz, fila a fila.
//	Si las matrices tienen distinta cantidad de filas o si alguna matriz está vacía, devuelve falso.
//	Por ejemplo: para las siguientes matrices
//	mat1
//	1 2 3 4
//	3 4 5 6
//	7 8 9 0
//	mat2
//	4 5 6 7 8
//	7 8 9 3 5
//	2 4 7 1 2
//	mat3
//	3 8 9 0
//	1 2 7 8
//	1 2 3 4
//	mat4
//	1 2 3 4
//	3 4 5 6
//	Si pasamos mat1 y mat2, devolverá verdadero porque para cada fila la intersección es: {4}, {3,5} y {7}.
//	Si pasamos mat1 y mat3, devolverá falso porque las filas 2 y 3 no tienen intersección.
//	Si pasamos mat1 y mat4, devolverá falso porque no tienen la misma cantidad de filas.
	
	public boolean perteneceFila(int [] fila, int elem) {
		boolean ret = false;
		for(int i =0;i<fila.length;i++) {
			ret = ret || fila[i]==elem;
		}
		return ret;
	}
	
	public boolean interseccionMatrizes(int [] fila1, int[] fila2) {
		boolean ret = false;
		for(int i =0;i<fila2.length;i++) {
			ret = ret || perteneceFila(fila1,fila2[i]);
		}
		return ret;
	}
	
	public boolean hayInterseccionPorFila(int[][] mat1, int[][]mat2) {
		if((mat1.length!= mat2.length)|| (mat1.length==0 || mat2.length==0)) {
			return false;
		}
		boolean ret = true;
		for(int fila =0;fila<mat1.length;fila++) {
			ret = ret && interseccionMatrizes(mat1[fila],mat2[fila]);
		}
		return ret;
	}
	// ejercicio 3 algunaFilaSumaMasQueLaColumna()
//	Que dado una matriz y el índice de una columna, se verifica si existe alguna fila cuya suma de todos sus
//	elementos sea mayor estricto que la suma de todos los elementos de la columna indicada por parámetro.
//	Si el índice de la columna es inválido o la matriz está vacía, devuelve falso.
//	Por ejemplo: para la matriz
//	2 4 3
//	5 8 9
//	6 2 12
//	Si le pasamos la columna 0 (en java los índices de fila y columna comienzan en 0), nos devolverá
//	Verdadero porque la columna { 2, 5, 6} suma 13 y tanto la fila 1 como la fila 2 suma más que 13.
//	Sin embargo, si le pasamos la columna 2 como parámetro, nos devolverá Falso porque la columna {3, 9,
//	12} suma 24 y las filas suman 9, 22 y 18 respectivamente. Ninguna fila suma más que 24.
	
	public int sumaFila(int [] fila) {
		int acum = 0;
		for(int i= 0;i<fila.length;i++) {
			acum += fila[i];
		}
		return acum;
		
	}
	
	public int sumaColum(int [] [] matriz,int colum) {
		int acum =0;
		for(int f=0;f<matriz.length;f++) {
			acum += matriz[f][colum];
		}
		return acum;
	}
	
	
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) { 
		if((nColum>mat.length || nColum<0) || mat.length==0) {
			return false;
		}
		boolean ret = false;
		int sumaDeColum = sumaColum(mat,nColum);
		System.out.println(sumaDeColum);
		for(int fila =0;fila<mat.length;fila++) {
			ret = ret || sumaFila(mat[fila])>=sumaDeColum;
		}
		return true;
	}
	
	// ejercicio 4 hayInterseccionPorColumna()
//	Que dado 2 matrices se verifica si hay intersección entre las columnas de cada matriz, columna a
//	columna.
//	Si las matrices tienen distinta cantidad de columnas o alguna matriz está vacía, devuelve falso.
//	Por ejemplo: para las siguientes matrices
//	mat1
//	1 2 3 4
//	3 4 5 6
//	7 8 9 0
//	mat2
//	4 5 6 0
//	7 8 9 3
//	1 4 7 1
//	mat3
//	3 8 6 0
//	1 2 7 8
//	2 1 4 5
//	mat4
//	1 2 3
//	3 4 5
//	6 7 8
//	Si pasamos mat1 y mat2, devolverá verdadero porque para cada columna la intersección es: {1,7}, {4,8},
//	{9} y {0}.
//	Si pasamos mat1 y mat3, devolverá falso porque la columna 3 no tienen intersección.
//	Si pasamos mat1 y mat4, devolverá falso porque no tienen la misma cantidad de columnas.
//	
	
	public boolean pertenece(int num,int[][] matriz,int colum) {
		boolean ret = false;
		for(int fila=0;fila<matriz.length;fila++) {
			ret = ret || num == matriz[fila][colum];
		}
		return ret;
	}

	public boolean interseccionColum(int [] [] mat1,int[] []mat2,int colum) {
		boolean ret = false;
		for(int fila=0;fila<mat1.length;fila++) {
			ret = ret || pertenece(mat1[fila][colum],mat2,colum);
		}
		return ret;
	}
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][]mat2) { 
		if((mat1.length ==0 || mat2.length==0) || (mat1[0].length != mat2[0].length)) {
			return false;
		}
		boolean ret = true;
		for(int colum = 0;colum<mat1.length;colum++) {
			ret = ret && interseccionColum(mat1,mat2, colum);
		}
		return ret;
	}

}
