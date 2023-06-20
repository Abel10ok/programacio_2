package naves;

public class Asteroide extends ObjetoGrafico {

	double tamano;
	
	public Asteroide(int x, int y, int vel, int ang, double t) {
		// construir el objeto padre
		super(x, y, vel, ang);
		tamano = t;
	}
	
	
}
