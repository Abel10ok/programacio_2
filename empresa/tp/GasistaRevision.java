package tp;

public class GasistaRevision extends Servicio {
	private int cantArtefactos;
	private double precioPorArtefactos;

	public GasistaRevision(int cliente, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefactos) {
		super(cliente, nroEspecialista, direccion);
		this.cantArtefactos = cantArtefactos;
		this.precioPorArtefactos = precioPorArtefactos;
	}
	

	
	@Override
	public double finalizarServicio(double costoMaterial) {
		double costoTotal = precioPorArtefactos * cantArtefactos;
		if(cantArtefactos>5)
			costoTotal = costoTotal - (costoTotal * 0.05);
		else if (cantArtefactos >10)
			costoTotal = costoTotal - (costoTotal * 0.15);
		return costoMaterial + costoTotal;
	}


}
