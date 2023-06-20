package naves;

import java.awt.Point;

public class ObjetoGrafico {

	private Point posicion;
	private int velocidad;
	private int angulo;
	
	public ObjetoGrafico(int x, int y, int vel, int ang) {
		posicion = new Point(x,y);
		velocidad = vel;
		angulo = ang;
	}
	
//sobrecarga
	public ObjetoGrafico() {
//		this(0,0,0,0);
		posicion = new Point(0,0);
		velocidad = 0;
		angulo = 0;
	}
	
	public void mover() {
		posicion.translate(velocidad, velocidad);
		System.out.println("mover OG");
	}
	
	public void aumentarVelocidad(int delta) {
		velocidad+=delta;
	}

	@Override
	public String toString() {
		return "posicion=" + posicion + ", velocidad=" + velocidad + ", angulo=" + angulo
				+ "\n Clase =" + getClass().getSimpleName();
	}
	
	

}
