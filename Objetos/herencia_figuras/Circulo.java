package herencia_figuras;

public class Circulo extends Figura {

	private double radio;

	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public void area() {
		this.setArea(Math.PI * Math.pow(radio, 2));
	}

	@Override
	public void perimetro() {
		this.setPerimetro(2 * Math.PI * radio);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(super.toString());
		return str+ "radio: "+ radio;
	}

}
