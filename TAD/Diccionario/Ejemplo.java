package Diccionario;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConjuntoDiccio c1 = new ConjuntoDiccio();
		
//		ConjuntoDiccio<Tupla<Integer,String>> c2 = new ConjuntoDiccio();
		c1.definir("f", "hola");
//		c1.definir(1, "chau");
		
		System.out.println(c1);

		c1.definir( 0, "abel");
		c1.definir( 1, "ludmila");
		c1.definir(2, "cielo");
		c1.definir(5, "cielo");
		c1.definir(6, "cielo");

//		c1.definir( 0, "nnnnl");
//		System.out.println(c1);
//		System.out.println(c1);	
//		System.out.println(c1.estaDefinida(1));
//		
//		System.out.println(c1.definicion(5));
//		
//		System.out.println(c1);
//		
//		System.out.println(c1.claves());
//		
//		System.out.println(c1.eliminar("k"));
//		System.out.println(c1);
//		
//		
//		System.out.println(c1.mismoValor("cielo"));
//		System.out.println(c1.diferenteValor());
		System.out.println(c1.indiceValor("hola"));




	}

}
