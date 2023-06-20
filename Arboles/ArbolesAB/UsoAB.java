package ArbolesAB;

public class UsoAB {

	public static void main(String[] args) {
		ABB<Integer> ab = new ABB<Integer>();
		ABB<Integer> abVacio = new ABB<Integer>();
		
		ab.agregar(4);
		ab.agregar(5);
		ab.agregar(6);
		System.out.println("esta Balanceado? " + ab.estaBalanceado());
		ab.agregar(7);
		ab.agregar(8);
		ab.agregar(9);
		System.out.println("esta Balanceado? " + ab.estaBalanceado());
		
//		System.out.println("Altura: " + ab.altura());
//		System.out.println("Contiene el 6? " + ab.pertenece(6));
//		System.out.println("Contiene el 10? " + ab.pertenece(10));
//		
//		System.out.println("Cantidad de nodos: " + ab.cantNodos());
//		
//		System.out.println("In Order" + ab);		
//		ab.eliminar(7);		
//		System.out.println("In Order con nodo 7 eliminado" + ab);
//		System.out.println("Cantidad de nodos: " + ab.cantNodos());
//		
//		System.out.println();
//		System.out.println("Soy un arbol vacio: ");
//		System.out.println("esta Balanceado? " + abVacio.estaBalanceado());
//		
//		System.out.println("Altura: " + abVacio.altura());
//		System.out.println("Contiene el 6? " + abVacio.pertenece(6));
//		
//		System.out.println("Cantidad de nodos: " + abVacio.cantNodos());
//		
//		System.out.println(ab.hojasMayores(9));


		
		
//		System.out.println("Es completo? "+ ab.esCompleto());
////		ab.ingresarDato(4);
////		System.out.println("Es completo? "+ ab.esCompleto());
////		ab.ingresarDato(16);
////		System.out.println("Es completo? "+ ab.esCompleto());
////		ab.ingresarDato(9);
////		System.out.println("Es completo? "+ ab.esCompleto());
////		ab.ingresarDato(12);
////		System.out.println("Es completo? "+ ab.esCompleto());
////		ab.ingresarDato(8);
////		System.out.println("Es completo? "+ ab.esCompleto());
////		ab.ingresarDato(15);
//		
//
//		//completar haciendo el toString adecuado de AB, que arma un
//		//toString con cada elemento de sus nodos.
		

	}

}
