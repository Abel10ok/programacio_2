package ListaCoordenadas;


import java.util.ArrayList;
import java.util.Iterator;

public class ListaCoord {
	ArrayList<Coordenada> coordenadas;
	
	public ListaCoord(){
		coordenadas = new ArrayList<Coordenada>();
	}
	
	public void agregar(int x, int y){
		Coordenada t = new Coordenada(x, y);
		coordenadas.add(t);

	}

	@Override
	public String toString() {
		return coordenadas.toString() ;
	}

	public int cuantasEnCuad(int i) {
		int cont =0;
		for(Coordenada coor: coordenadas) {
			if(coor.cuadrante()==i)
				cont++;
		}
		return cont;
	}

	public int cuantasEnEjes() {
		int cont =0;
		for(Coordenada coor: coordenadas) {
			if(coor.enEje())
				cont++;
		}
		return cont;
	}

}
