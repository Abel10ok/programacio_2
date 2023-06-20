package naves;

import java.util.ArrayList;

public class Juego {

	public static void main(String[] args) {

		ArrayList<ObjetoGrafico> objetos;
		objetos = new ArrayList<ObjetoGrafico>();
		Nave nave1 = new Nave(0, 4, 4, 6, 100);
		Nave nave2 = new Nave(10, 4, 8, 6, 200);
		
		Asteroide asteroide1 = new Asteroide(0,0,4,8,500.5);
		Asteroide asteroide2 = new Asteroide(5,5,3,9,451.5);
		Asteroide asteroide3 = new Asteroide(8,8,2,7,451.5);

		objetos.add(nave1);
		objetos.add(nave2);
		objetos.add(asteroide1);
		objetos.add(asteroide2);
		objetos.add(asteroide3);

		for(ObjetoGrafico og:objetos) {
			og.mover();
			System.out.println(og.toString());
		}

	}

}
