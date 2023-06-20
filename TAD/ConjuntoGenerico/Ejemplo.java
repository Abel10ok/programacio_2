package ConjuntoGenerico;

public class Ejemplo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Conjunto<Integer> c1, c2, cVacio;

			c1 = new Conjunto<Integer>();
			c2= new Conjunto<Integer>();

			c1.agregar(20);
			c1.agregar(30);
			c1.agregar(17);
			c1.agregar(18);
			c1.agregar(19);
			c1.agregar(100);
			c1.agregar(200);
			
			

			c2.agregar(1);
			c2.agregar(2);
			c2.agregar(20);
			c2.agregar(30);
			c2.agregar(40);
			c2.agregar(50);
			c2.agregar(60);
			c2.agregar(100);
			c2.agregar(200);




			
			System.out.println(c1);
			System.out.println(c1.dameUno());
			System.out.println(c1);
			System.out.println(c1.dameUno());
			System.out.println(c1);
			System.out.println(c1.dameUno());
			System.out.println(c1);
			System.out.println(c1.dameUno());
			System.out.println(c1);
			System.out.println(c1.dameUno());
			System.out.println(c1);
			System.out.println(c1.dameUno());
			System.out.println(c1);
			System.out.println(c1.dameUno());

			System.out.println("UNION DESTRUCTIVA");
			System.out.println(c1);
			System.out.println(c2);
			c1.union(c2);
			System.out.println(c1);


			
			System.out.println("UNION2 NODESTRUCTIVA");
			System.out.println(c1);
			System.out.println(c2);
			c1.union2(c2);
			System.out.println(c1.union2(c2));
			
			System.out.println("INTERSECCION DESTRUCTIVA");
			System.out.println(c1);
			System.out.println(c2);
			c1.interseccion(c2);
			System.out.println(c1);
			
			
//			
//			System.out.println(c1);
//			System.out.println(c2);
//			System.out.println(c1.interseccion2(c2));
//		
			}

}
