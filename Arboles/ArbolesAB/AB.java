package ArbolesAB;

public class AB<T> {
	protected Nodo<T> raiz;

	public AB() {
		raiz = null;
	}

	public void agregar(T dato) {
		Nodo<T> nuevo = new Nodo<T>(dato);
		if (raiz == null)
			raiz = nuevo;
		else
			agregar(nuevo, raiz);
	}

	private void agregar(Nodo<T> nuevo, Nodo<T> padre) {
		if (padre.getIzq() == null)
			padre.setIzq(nuevo);
		else if (padre.getDer() == null)
			padre.setDer(nuevo);
		else
			// Decision arbitraria
			// El arbol se construye sesgado a izquierda
			agregar(nuevo, padre.getIzq());
	}

	public boolean pertenece(T elem) {
		return pertenece(elem, raiz);
	}

	private boolean pertenece(T elem, Nodo<T> nodo) {
		if (nodo == null)
			return false;
		if (nodo.getInfo().equals(elem))
			return true;
		return pertenece(elem, nodo.getIzq()) || pertenece(elem, nodo.getDer());
	}

	public int cantNodos() {
		return cantNodos(raiz);
	}

	// metodo auxiliar recursivo
	private int cantNodos(Nodo<T> nodo) {
		if (nodo == null)
			// caso base
			return 0;

		// sumo la cantidad de nodos de mis subarboles
		// y cuento al nodo actual
		return 1 + cantNodos(nodo.getIzq()) + cantNodos(nodo.getDer());
	}

	public int altura() {
		return altura(raiz);
	}

	private int altura(Nodo<T> nodo) {
		if (nodo == null)
			return 0;
		return 1 + Math.max(altura(nodo.getIzq()), altura(nodo.getDer()));
	}

	public boolean estaBalanceado() {
		return balanceado(raiz);
	}

	private boolean balanceado(Nodo<T> nodo) {
		if (nodo == null)
			return true;
		if (Math.abs(altura(nodo.getIzq()) - altura(nodo.getDer())) <= 1)
			return (balanceado(nodo.getIzq()) && balanceado(nodo.getDer()));
		return false;
	}

	// TAREA PARA EL JUEVES 27/10
	// ---------------------------

	// Retorna la cantidad de hojas del arbol
	public int cantHojas() {
		return cantHojas(this.raiz);
	}

	private int cantHojas(Nodo<T> n) {
		if (n == null) {
			return 0;
		}
		return n.getIzq() == null && n.getDer() == null ? 1 : cantHojas(n.getIzq()) + cantHojas(n.getDer());
	}

	// Retorna un String con la concatenacion
	// de los valores de las hojas
	public String valoresHojas() {
		return null;
	}

	// Retorna la cantidad de nodos
	// que estan en el nivel recibido por parametro
	public int nodosPorNivel(int nivel) {
		return 0;
	}
}
