package listasEnlazadas;

public class ListasEnlazadas {
	private Nodo head;

	public void agregar(Integer valor) {
		head = agregar(head, valor);
	}

	private Nodo agregar(Nodo nodo, Integer valor) {
		if (nodo == null)
			new Nodo(valor);
		else nodo.tail = agregar(nodo.tail, valor);
		return nodo;
	}

	public Integer sumarElementos() {
		return sumarElementos(head);
	}

	private Integer sumarElementos(Nodo nodo) {
		if (nodo == null)
			return 0;

		return head.valor + (sumarElementos(head.tail));
	}
	
	public static void main(String[] args) {
		ListasEnlazadas list = new ListasEnlazadas();
		list.agregar(1);
		list.agregar(2);
		list.agregar(3);
	}
}