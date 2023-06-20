package Tad_estacionamiento;

public class Estacionamiento {
	int capacidad;
	Sector sectorDoc;
	Sector sectorAlu;
	Sector sectorGen;
	double recaudado;
	
	public Estacionamiento (int capDoc, int valorHoraD, int capAlu, int valorHoraA,
							int capGen, int valorHoraG) {
			capacidad = capDoc + capAlu + capGen;
			sectorDoc = new Sector("Docente", capDoc, valorHoraD);
			sectorAlu = new Sector("Alumno", capAlu, valorHoraA);
			sectorGen = new Sector("General", capGen, valorHoraG);
	}
	
	public boolean ingresarAuto(String mat, int hin, String sector) {
		validarHora(hin);
		if (estaAuto(mat))
			return false;
		obtenerSector(sector).ingresarAuto(mat, hin);
		return true;
	}
	
	public boolean sacarAuto(String mat, int hout) {
		validarHora(hout);
		if(!estaAuto(mat))
			throw new RuntimeException("el auto no esta estacionado");
		Sector s = this.sectorDondeEsta(mat);
		s.sacarAuto(mat, hout);
		recaudado = recaudado + s.pagarAlSalir(mat);
		return true;
	}
	
	public boolean estaAuto(String mat) {
		return (sectorDoc.estaAuto(mat)||sectorAlu.estaAuto(mat)||sectorGen.estaAuto(mat));
	}

	public double darRecaudado() {
		return recaudado;
	}

	@Override
	public String toString() {
		return "Estacionamiento \n [capacidad=" + capacidad + "\n sectorDoc=" + sectorDoc + "\n sectorAlu=" + sectorAlu
				+ "\n sectorGen=" + sectorGen + "\n recaudado=" + recaudado + "]";
	}

	private Sector obtenerSector(String sector) {
		if (sector=="Docente")
			return sectorDoc;
		else if (sector=="Alumno")
			return sectorAlu;
		else if (sector=="General")
			return sectorGen;
		else
			throw new IllegalArgumentException("Sector inexistente: "+sector);
	}
	private Sector sectorDondeEsta(String mat) {
		if (sectorDoc.estaAuto(mat))
			return sectorDoc;
		if (sectorAlu.estaAuto(mat))
				return sectorAlu;
		return sectorGen;
	}

	private void validarHora(int hora) {
		if (hora<0 || hora>23)
			throw new IllegalArgumentException("Hora no valida: "+hora);
	}

}
