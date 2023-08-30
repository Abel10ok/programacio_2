package tp;

public class GasistaInstalacion extends Servicio {
	private int cantArtefactos;
	private double precioPorArtefactos;

	public GasistaInstalacion(int cliente, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefactos) {
		super(cliente, nroEspecialista, direccion);
		this.cantArtefactos = cantArtefactos;
		this.precioPorArtefactos = precioPorArtefactos;
	}
	

	@Override
	public double finalizarServicio(double costoMaterial) {

		return costoMaterial + (precioPorArtefactos * cantArtefactos);
	}
	

	



}
