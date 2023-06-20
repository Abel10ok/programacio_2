package ConjuntoGenerico;

import java.util.ArrayList;
import java.util.Iterator;

public class Conjunto2<T> implements Iterable<T> {
	
	private ArrayList<T> conj;
	private int indice; // la proxima posicion a retornar 
	//en dameUno()

/*
 * IREP:
 * conj.get(i).equals(conj.get(j))==false,
 *     para todo i!=j tal que 0 <= i,j < conj.size()
 *     
 * 0 <= indice <= conj.size() 
 */
	
	public Conjunto2() {
		conj = new ArrayList<T>();
		indice = 0;
	}
	
	public boolean pertenece(T elem){
		return conj.contains(elem);
	}
	
	public boolean agregar(T elem) {
		if (pertenece(elem))
			return false;
		return conj.add(elem);
	}
	
	public boolean quitar(T elem) {
		return conj.remove(elem);
	}
	
	public int tamanio() {
		return conj.size();
	}
	
	public boolean esVacio() {
		return (tamanio()==0);
	}
	
	public T dameUno() {
		if (this.esVacio())
			return null;
		if (indice==tamanio())
			indice=0;
		return conj.get(indice++);
	}
	
	
	// TAREA para el martes 6/9:
	// -------------------------
	// IMPLEMENTAR usando solo las operaciones basicas ya definidas
	// SIN acceder directamente a la estructura
	
	/*
	 *  {3,7,4} UNION {10,4,5} =  {3,7,4,10,5}
	 * 
	 *  {3,7,4} INTERSECCION {10,4,5} = {4}  
	 * 
	 */

	// La union queda en el conjunto this
	// (es destructiva)
	public void union(Conjunto2<T> otroConj) {
		
	}
	

	// La union queda en el retorno del metodo
	// no destructiva (el this queda sin cambios)
	public Conjunto2<T> union2(Conjunto2<T> otroConj) {
		Conjunto2<T> ret = new Conjunto2<T>();

		return ret;
	}

	// La interseccion quedara en el conjunto this
	// destructiva
	public void interseccion(Conjunto2<T> otroConj) {
		Iterator<T> it = this.iterator();
		while (it.hasNext()) {
			T elem = it.next();
			if (!otroConj.pertenece(elem))
				it.remove(); //borra el que devuelve next
		}

		// Esta version no funciona
//		for (int i=0; i<this.tamanio(); i++) {
//			T elem = dameUno();
//			if (!otroConj.pertenece(elem))
//				this.quitar(elem);
//		}
	}

	// La interseccion queda en el retorno del metodo
	// no destructiva (el this queda sin cambios)
	public Conjunto2<T> interseccion2(Conjunto2<T> otroConj) {
		return new Conjunto2<T>();
	}

	@Override
	public Iterator<T> iterator() {
		return conj.iterator();
	}
	

}









