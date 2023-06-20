package naves;

import java.awt.Point;

public class Nave extends ObjetoGrafico {
	
	private int energia;
	private int aceleracion;
	
	public Nave(int x, int y, int vel, int ang, int en) {
		// construir el objeto padre
		super(x, y, vel, ang);
		energia = en;
		aceleracion = 2;
	}
	
//sobrecarga
	public Nave() {
		//super();
		//llama primero al constructor vacio
		// de la superclase
		energia = 1000;
	}
	
	public void mover() {
		//esta implicito el super.aumentarVelocidad(...)
		aumentarVelocidad(aceleracion);
		super.mover();
		System.out.println("mover de Nave" + aceleracion);
	}
	

	
	
	
	
	
	
	
	
}
