package ConjuntoGenerico;

import java.util.ArrayList;
import java.util.Iterator;

public class Conjunto<T> {

	private ArrayList<T> conj;
	private Integer indice; // la proxima posicion a retornar
	// en dameUno()

	/*
	 * IREP: conj.get(i).equals(conj.get(j))==false, para todo i!=j tal que 0 <= i,j
	 * < conj.size()
	 * 
	 * 0 <= indice <= conj.size()
	 */

	public Conjunto() {
		conj = new ArrayList<T>();
		indice = 0;
	}

	public boolean pertenece(T elem) {
		return conj.contains(elem);
	}

	public boolean agregar(T elem) throws Exception {
		// COMPLETAR
		if (pertenece(elem))
			throw new Exception("El elemento esta repetido");
		return conj.add(elem);
	}

	public boolean quitar(T elem) {
		if (tamanio() != 0) {
			indice--;
		}
		return conj.remove(elem);
	}

	public int tamanio() {
		return conj.size();
	}

	public boolean esVacio() {
		return (tamanio() == 0);
	}

	public T dameUno() {
		// COMPLETAR
		if (esVacio()) {
			return null;		
		} 
		if(indice==tamanio()) {
			indice=0;
		}
		return conj.get(indice++);
	}

	// TAREA Obligatoria:
	// -------------------------
	// IMPLEMENTAR usando SOLO las operaciones basicas ya definidas
	// SIN acceder directamente a la estructura

	/*
	 * {3,7,4} UNION {10,4,5} = {3,7,4,10,5}
	 * 
	 * {3,7,4} INTERSECCION {10,4,5} = {4}
	 * 
	 */

	@Override
	public String toString() {
		return "Conjunto [conj=" + conj + ", indice=" + indice + "]";
	}

	// La union queda en el conjunto this
	// (es destructiva)
	public void union(Conjunto<T> otroConj) throws Exception {

		for (int i = 0; i < otroConj.tamanio(); i++) {
			T elem = otroConj.dameUno();
			if ((!this.pertenece(elem))) {
				this.agregar(elem);
			}
		}

	}

	// La union queda en el retorno del metodo
	// no destructiva (el this queda sin cambios)
	public Conjunto<T> union2(Conjunto<T> otroConj) throws Exception {
		Conjunto<T> ret = new Conjunto<T>();
		
		ret.union(otroConj);
		ret.union(this);
		return ret;
	}

	// La interseccion quedara en el conjunto this
	// destructiva
	public void interseccion(Conjunto<T> otroConj) {
		Iterator<T> it = this.conj.iterator();
		while(it.hasNext()) {
			T elem = it.next();
			if(!otroConj.pertenece(elem)) {
				it.remove();
			}
		}

	}

	// La interseccion queda en el retorno del metodo
	// no destructiva (el this queda sin cambios)
	public Conjunto<T> interseccion2(Conjunto<T> otroConj) throws Exception {
		Conjunto<T> ret = new Conjunto<T>();
		for (int i = 0; i < this.tamanio(); i++) {
			T elem = this.dameUno();
			if (otroConj.pertenece(elem)) {
				ret.agregar(elem);
			}
		}
		return ret;
	}

}
