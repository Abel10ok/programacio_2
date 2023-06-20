package PilaGenerica;


import java.util.LinkedList;

public class PilaEnteros {

	LinkedList<Integer> pila;
	Integer tamanio = 0;

	public PilaEnteros() {
		pila = new LinkedList<Integer>();
	}
	
	public void apilar(Integer elem){
		pila.addLast(elem);
		tamanio++;
	}

	public Integer desapilar(){
		if (esVacia())
			throw new RuntimeException("La pila esta vacia");
		tamanio--;
		return pila.removeLast();
	}
	
	public Integer tope(){
		if (esVacia())
			throw new RuntimeException("La pila esta vacia");
		return pila.getLast();
	}

	public boolean esVacia(){
		return pila.size()==0;
	}

	public Integer tamanio(){
		return tamanio;
		///  COMPLETAR
	}


	public String toString(){
		return null;
		/// COMPLETAR
	}


}

