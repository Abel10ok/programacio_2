package herencia_figuras;

import java.util.ArrayList;

public class Principal {
	public static void main(String[] args) {
		StringBuilder sb;
		ArrayList<Figura> figuras = new ArrayList<Figura>();
		figuras.add(new Triangulo(3, 4, 5));
		figuras.add(new Triangulo(8, 5, 7));
		figuras.add(new Triangulo(6, 8, 10));
		figuras.add(new Rectangulo(10, 2));
		figuras.add(new Rectangulo(4, 3));
		figuras.add(new Rectangulo(5, 5));
		figuras.add(new Circulo(1));
		figuras.add(new Circulo(2));
		figuras.add(new Circulo(3));
		for (Figura f : figuras) {
			f.area();
			f.perimetro();
			sb = new StringBuilder(f.toString());
//			sb.append(" / Su area es: ").append(f.getArea());
//			sb.append(" y su perimetro es: ").append(f.getPerimetro());
			System.out.println(sb);
		}
	}

}
