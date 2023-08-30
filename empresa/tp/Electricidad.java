package tp;

public class Electricidad extends Servicio {
	private double precioPorHora;
	private int horasTrabajadas;

	public Electricidad(int cliente, int nroEspecialista, String direccion, double precioPorHora, int horasTrabajadas) {
		super(cliente, nroEspecialista, direccion);
		this.precioPorHora = precioPorHora;
		this.horasTrabajadas = horasTrabajadas;
	}


	@Override
	public double finalizarServicio(double costoMaterial) {
		return costoMaterial + (precioPorHora * horasTrabajadas);
	}
	

}
