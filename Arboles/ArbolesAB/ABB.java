package ArbolesAB;

public class ABB<T extends Comparable<T>> extends AB<T> {

	public boolean pertenece(T elem) {
		return pertenece(elem, raiz);
	}

	private boolean pertenece(T elem, Nodo<T> nodo) {
		if (nodo == null)
			return false;
		if (nodo.getInfo().equals(elem))
			return true;
		if (elem.compareTo(nodo.getInfo()) < 0)
			return pertenece(elem, nodo.getIzq());
		else
			return pertenece(elem, nodo.getDer());
	}

	public void agregar(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato);
		if (raiz == null)
			raiz = nuevo;
		else
			agregar(nuevo, raiz);
	}

	// Esta version del agregar no retorna un nodo
	// (tiene mas "ifs" que la version que retorna un nodo)
	protected void agregar(Nodo<T> nuevo, Nodo<T> padre) {
		if (nuevo.getInfo().compareTo(padre.getInfo()) < 0)
			if (padre.getIzq() == null)
				padre.setIzq(nuevo);
			else
				agregar(nuevo, padre.getIzq());
		else if (nuevo.getInfo().compareTo(padre.getInfo()) > 0)
			if (padre.getDer() == null)
				padre.setDer(nuevo);
			else
				agregar(nuevo, padre.getDer());
	}

//****************************************************
//  String con las hojas mayores que elem
//*****************************************************

	public String hojasMayores(T elem) {

		return "{ " + hojasMayores(elem, raiz) + " }";
	}

	private String hojasMayores(T elem, Nodo<T> nodo) {
		if (nodo == null)
			return "";

		if (nodo.getInfo().compareTo(elem) > 0) { // si info>elem
			if (nodo.getDer() == null && nodo.getIzq() == null)
				return nodo.getInfo().toString(); // caso base
			else
				return hojasMayores(elem, nodo.getIzq()) + hojasMayores(elem, nodo.getDer()); // caso recursivo
		} else // si info<=elem
			return hojasMayores(elem, nodo.getDer()); // caso recursivo
		// en este else uso el IREP del ABB
	}

	// El minimo de un arbol vacio no esta definido
	public T minimo() {
		if (raiz != null)
			return minimo(raiz);
		else
			throw new RuntimeException("No esta definido");
	}

	private T minimo(Nodo<T> nodo) {
		if (nodo != null)
			if (nodo.getIzq() == null)
				return nodo.getInfo();
			else
				return minimo(nodo.getIzq());
		return null;
	}

	// Retorna el nivel en el que esta un elemento
	// Si el elemento no esta retorna -1
	public int nivel(T elem) {
		if (raiz == null)
			return 0;
		if (!this.pertenece(elem))
			return -1;
		return nivel(elem, raiz, 1);
	}
	// ver que no pertenece elem no es igual a que sea null el arbol

	private int nivel(T elem, Nodo<T> nodo, int niv) {
		if (nodo.getInfo().equals(elem))
			return niv;
		if (nodo.getInfo().compareTo(elem) < 0) // info < elem
			return nivel(elem, nodo.getDer(), niv + 1);
		return nivel(elem, nodo.getIzq(), niv + 1);
	}

	// Retorna un String con la concatenacion de los valores
	// de los nodos desde la raiz hasta elem
	// Si el elemento no esta retorna ""
	public String caminoHasta(T elem) {
		if (!this.pertenece(elem))
			return "";
		return " ( " + caminoHasta(elem, raiz) + ")";
	}

	private String caminoHasta(T elem, Nodo<T> nodo) {
		if (nodo == null)
			return "";
		StringBuilder sb = new StringBuilder("");

		if (nodo.getInfo().equals(elem))
			sb.append(nodo.getInfo().toString() + " ");
		else if (elem.compareTo(nodo.getInfo()) < 0) // elem < nodo.info
			sb.append(nodo.getInfo() + " " + caminoHasta(elem, nodo.getIzq()));
		else // elem > nodo
			sb.append(nodo.getInfo() + " " + caminoHasta(elem, nodo.getDer()));
		return sb.toString();
	}

	//////////////// ELIMINAR NODO //////////////////////////////

	public void eliminar(T elem) {
		raiz = eliminar(elem, raiz);
	}

	public Nodo<T> eliminar(T elem, Nodo<T> nodo) {
		if (nodo != null) {
			if (elem.compareTo(nodo.getInfo()) < 0)
				nodo.setIzq(eliminar(elem, nodo.getIzq()));
			else if (elem.compareTo(nodo.getInfo()) > 0)
				nodo.setDer(eliminar(elem, nodo.getDer()));
			else {
				if (nodo.getIzq() == null)
					return nodo.getDer();
				if (nodo.getDer() == null)
					return nodo.getIzq();
				nodo.setInfo(minimo(nodo.getDer())); // selecciono Minimo del Derecho
				nodo.setDer(eliminar(nodo.getInfo(), nodo.getDer()));
			}
		}
		return nodo;
	}

	// EJERCICIO PARCIAL
	// implementar el siguiente metodo recursivo que cambie el nodo actual con el
	// mayor valor de sus hijos.
	// siempre que ambos no sean nulos. Si son nulos o alguno de los dos es nulo no
	// hace nada.

	public void cambiarPorHijoMayor() {
		if (raiz != null)
			cambiarPorHijoMayor(raiz);
	}

	private void cambiarPorHijoMayor(Nodo<T> raiz) {
		if (raiz.getIzq() != null && raiz.getDer() != null) {
			if (raiz.getIzq().getInfo().compareTo(raiz.getDer().getInfo()) < 0) {
				raiz = raiz.getDer();
				cambiarPorHijoMayor(raiz);
			} else if (raiz.getIzq().getInfo().compareTo(raiz.getDer().getInfo()) > 0) {
				raiz = raiz.getIzq();
				cambiarPorHijoMayor(raiz);

			}
		}
	}

	// EJERCICIO PARCIAL
	// implementar el siguiente metodo que devuleve el maximo valor de susu hojas.
	// En el caso de un arbol vacio retorna null
	// abb balanceado
//	public Nodo<T> maximoValorHoja() {
//		if (raiz != null) {
//			return maximoValorHoja(raiz);
//		}
//
//		return null;
//	}
//
//	private Nodo<T> maximoValorHoja(Nodo<T> raiz) {
//		if (raiz.getDer() == null && raiz.getIzq() == null) {// si es hoja
//			return raiz;
//		}
//		if (raiz.getDer() != null) {
//			if (raiz.getDer().getDer() == null && raiz.getIzq().getIzq() == null) {
//				maximoValorHoja (raiz.getDer());
//			}
//		}
//		if(raiz.getIzq()!=null) {
//			if(raiz.getDer().getDer()==null && raiz.getIzq().getIzq()==null) {
//				 maximoValorHoja( raiz.getIzq());			}
//		}
//		return raiz;
//	}
	//////////////////// PRINT IN-ORDER //////////////////////////////

	public String toString() {
		return "{" + toString(raiz) + "}";
	}

	private String toString(Nodo<T> nodo) {
		StringBuilder sb = new StringBuilder();
		if (nodo != null) {
			sb.append(nodo.getInfo()).append(" ");
			sb.append(toString(nodo.getIzq()));
			sb.append(toString(nodo.getDer()));
		}
		return sb.toString();
	}

}
