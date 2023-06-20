package PilaGenerica;

import java.util.LinkedList;

public class Pila<E> {
	LinkedList<E> pila;
	int tamanio = 0;
	public Pila() {
		pila = new LinkedList<E>();
	}
	
	public void apilar(E elem){
		pila.addLast(elem);
		tamanio++;
		//COMPLETAR
	}

	public E desapilar(){
		if (esVacia())
			throw new RuntimeException("La pila esta vacia");
		//COMPLETAR
		tamanio--;
		return 	pila.removeLast();
	}
	
	public E tope(){
		if (esVacia())
			throw new RuntimeException("La pila esta vacia");
		//COMPLETAR
		return pila.getLast();
	}

	public boolean esVacia(){
		//COMPLETAR
		return tamanio==0;
	}

	@Override
	public String toString() {
		return "Pila [pila=" + pila + ", tamanio=" + tamanio + "]";
	}
         
        //CREAR LOS METODOS 
        // toString  y  tamanio

}

