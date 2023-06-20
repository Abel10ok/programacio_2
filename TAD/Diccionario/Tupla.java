package Diccionario;

public class Tupla<T, Z> {
	private T x;
	private Z y;

	public Tupla(T n, Z s) { // Constructor
		x = n;
		y = s;
	}

	T getDatox() {
		return x;
	}

	Z getDatoy() {
		return y;
	}

	void setDatox(T datox) {
		x = datox;
	}

	void setDatoy(Z datoy) {
		y = datoy;
	}

	@Override
	public String toString() {
		return "<" + x + ", " + y + ">";
	}

}
