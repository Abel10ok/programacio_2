package tp;

public class PinturaAltura extends Pintura{
	private int piso;
	private double seguro;
	private double alqAndamios;

	public PinturaAltura(int cliente, int nroEspecialista, String direccion, int metrosCuadrados,
			double precioPorMetrosCuadrados, int piso, double seguro, double alqAndamios) {
		super(cliente, nroEspecialista, direccion, metrosCuadrados, precioPorMetrosCuadrados);
		this.piso = piso;
		this.seguro = seguro;
		this.alqAndamios = alqAndamios;
	}

	public double finalizarServicio(double costoMateriales) {
		if(piso>5)
			alqAndamios = alqAndamios + (alqAndamios * 0.20);
		double costoTotal = this.getMetrosCuadrados() * this.getPrecioPorMetroCuadrado();
		 costoTotal  += + seguro + alqAndamios;
		return costoMateriales + costoTotal;
	}



}
