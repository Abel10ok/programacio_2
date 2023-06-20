package Diccionario;

import java.util.ArrayList;
import java.util.Set;

public class ConjuntoDiccio<T> {

	private ArrayList<Tupla> conj;
//	private ArrayList<T> claves;
	private Integer indice;
	private Integer tamanio; // la proxima posicion a retornar
	// en dameUno()

	public ConjuntoDiccio() {
		conj = new ArrayList<Tupla>();
		tamanio = 0;
		indice = 0;
	}

	public void definir(T j, T string) {
		if (conj.size() == 1) {
			indice = 0;
		}
		if (!estaDefinida(j)) {
			Tupla tupla = new Tupla(j, string);
			indice++;
			tamanio++;
			conj.add(tupla);
		} else {
			for (int i = 0; i < conj.size(); i++) {
				if (conj.get(i).getDatox().equals(j)) {
					conj.get(i).setDatoy(string);
				}
			}
		}

	}

	public boolean eliminar(T clave) {
		for (int i = 0; i < conj.size(); i++) {
			if (conj.get(i).getDatox().equals(clave))
				return conj.remove(conj.get(i));
		}
		return false;
	}

	public boolean estaDefinida(T clave) {
		boolean ret = false;
		for (int i = 0; i < conj.size(); i++) {
			ret = ret || conj.get(i).getDatox().equals(clave);
		}
		return ret;
	}

	public String definicion(Integer clave) {
		for (int i = 0; i < conj.size(); i++) {
			if (conj.get(i).getDatox().equals(clave)) {
				return (String) conj.get(i).getDatoy();
			}
		}
		return "No existe clave";
	}

	public ArrayList<T> claves() {
		ArrayList ret = new ArrayList();
		for (int i = 0; i < conj.size(); i++) {
			ret.add(conj.get(i).getDatox());
		}

		return ret;
	}
	public ArrayList<Tupla> mismoValor(T valor) {
		ArrayList<Tupla> ret = new ArrayList<Tupla>();
		int cant =0;
		for (int i = 0; i < conj.size(); i++) {
			if(conj.get(i).getDatoy().equals(valor)) {
				System.out.println(conj.get(i).getDatoy());
				cant++;
			}
		}
		ret.add(new Tupla(cant,valor));
		return  ret;
	}
	
	public ArrayList<T> diferenteValor() {
		ArrayList<T> ret = new ArrayList<T>();
		for (int i = 0; i < conj.size(); i++) {
			if(!ret.contains(conj.get(i).getDatoy())) {
				ret.add((T) conj.get(i).getDatoy());
			}
		}
		return  ret;
	}
	
	public ArrayList<Integer> indiceValor(T valor) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < conj.size(); i++) {
				if(conj.get(i).getDatoy().equals(valor)) {
					ret.add(i);
				}
		}
		return  ret;
	}
	

	

	
//	public void insertar(Object object) {
//		claves.add((T) object);
//	}
//
//	public Set<T> claves2() {
//		Set<Integer>claves = new HashSet<Integer>();
//		claves = ((Object) conj).keySet();
//		return (Set<T>) claves;
//	}

	public boolean estaVacio() {
		return tamanio == 0;
	}

	@Override
	public String toString() {
		return "ConjuntoDiccio [conj=" + conj + ", indice=" + indice + ", tamanio=" + tamanio + "]";
	}

}
