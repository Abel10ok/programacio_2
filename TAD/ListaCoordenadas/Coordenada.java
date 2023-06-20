package ListaCoordenadas;

import java.util.Iterator;

public class Coordenada {

	Tupla<Integer, Integer> punto;
	
	Coordenada(int x, int y){
		punto = new Tupla<Integer, Integer>(x, y);
	}
	
	public boolean esOrigen() {
		return punto.getDatox()==0 && punto.getDatoy()==0;
	}
	
	public int cuadrante() {
		//si la salida es -1 pertenece a los ejes
		if(punto.getDatox()>0 && punto.getDatoy()>0)
			return 1;
		if(punto.getDatox()<0 && punto.getDatoy()>0)
			return 2;
		if(punto.getDatox()<0 && punto.getDatoy()<0)
			return 3;
		if(punto.getDatox()>0 && punto.getDatoy()<0)
			return 4;
		return -1;
	}

	public boolean enEje() {
		return punto.getDatox()==0 || punto.getDatoy()==0;
	}
	
	@Override
	public String toString() {
		return "Coordenada [punto=" + punto + "]";
	}

}
