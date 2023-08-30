package tp;

import java.util.Objects;

public abstract class Servicio {
//	private String tipoServicio;
	private int cliente;
	private int nroEspecialista;
	private String direccion;
	private  int codServicio=0;
	private static int iniciarCodigo =100;
	
	public Servicio(int cliente, int nroEspecialista, String direccion) {
		this.cliente = cliente;
		this.nroEspecialista = nroEspecialista;
		this.direccion = direccion;
		this.iniciarCodigo ++;
		this.codServicio = iniciarCodigo +1;
	}
	
	
	protected abstract double finalizarServicio(double costoMateriales);

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return codServicio == other.codServicio;
	}

	public int getCodServicio() {
		return codServicio;
	}

	public void setCodServicio(int codServicio) {
		this.codServicio = codServicio;
	}


//	public String getTipoServicio() {
//		return tipoServicio;
//	}
//
//	public void setTipoServicio(String tipoServicio) {
//		this.tipoServicio = tipoServicio;
//	}

	public int getNroEspecialista() {
		return nroEspecialista;
	}

	public void setNroEspecialista(int nroEspecialista) {
		this.nroEspecialista = nroEspecialista;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n");
		str.append(" [");
		str.append(codServicio);
		str.append(" - ");
		str.append(this.getClass().getSimpleName());
		str.append(" ]");
		str.append(direccion);
		str.append("\n");

		return str.toString();
	}



}
