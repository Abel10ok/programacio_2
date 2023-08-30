package tp;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente{
	private int dni;
	private String nombre;
	private String telefono;

	public Cliente(Integer dni, String nombre, String telefono) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return dni == other.dni;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append(" dni= ");
		str.append(dni);
		str.append(" Nombre= ");
		str.append(nombre);

		str.append(" Telefono= ");
		str.append(telefono);
		str.append("\n");
		return str.toString();
	}

}
