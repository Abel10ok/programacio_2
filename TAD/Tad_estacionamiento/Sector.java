package Tad_estacionamiento;

import java.util.HashMap;
import java.util.Map;

public class Sector {

	String nombre;
	int lugares;
	double valorH;
	Map<String, Auto> automoviles;
	
	public Sector(String nom, int cap, double vH) {
		nombre=nom;
		lugares =cap;
		valorH=vH;
		automoviles= new HashMap<String, Auto>();
	}

	public double getValorH() {
		return valorH;
	}

	public void setValorH(double valor) {
		valorH = valor;
	}
	
	public int getLugares() {
		return lugares;
	}
	
	public void ingresarAuto(String matric, int hIn) {
		Auto auto = new Auto(matric, hIn);
		automoviles.put(matric, auto);
		lugares--;
	}

	public void sacarAuto(String mat, int hout) {
		//no se quita solamente se registra la hora de salida
		automoviles.get(mat).setHoraOut(hout);
		lugares++;
	}

	public boolean estaAuto(String mat) {
		// TODO Auto-generated method stub
		return automoviles.containsKey(mat);
	}

	public double pagarAlSalir(String mat) {
		if(automoviles.get(mat).estacionado())
			return -1;
		int tiempo = automoviles.get(mat).tiempoEstacionado();
		double monto = tiempo * this.getValorH();
		return monto;
	}


	@Override
	public String toString() {
		return "Sector [nombre=" + nombre + ", lugares=" + lugares + ", valorH=" + valorH + ", automoviles="
				+ automoviles + "]";
	}

}
