package tp;

public class Pintura extends Servicio {
	private int metrosCuadrados;
	private double precioPorMetroCuadrado;

	public Pintura(int cliente, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetroCuadrados) {
		super(cliente, nroEspecialista, direccion);
		this.metrosCuadrados = metrosCuadrados;
		this.precioPorMetroCuadrado = precioPorMetroCuadrados;
	}



	@Override
	public double finalizarServicio(double costoMaterial) {
		return costoMaterial +(precioPorMetroCuadrado * metrosCuadrados);
	}


	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}



	public double getPrecioPorMetroCuadrado() {
		return precioPorMetroCuadrado;
	}


}
