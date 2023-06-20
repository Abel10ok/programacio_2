package herencia_figuras;

public class Rectangulo extends Figura {

	private double base;
	private double altura;
	
	
	public Rectangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}


	@Override
	public void area() {
		this.setArea( base * altura);
	}

	@Override
	public void perimetro() {
		this.setPerimetro( 2 * (base + altura));
	}


	public void setAltura(double altura) {
		this.altura = altura;
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(super.toString());
		str.append("base= ");
		str.append(base);
		str.append("altura= ");
		str.append(altura);
		return str.toString();
	}

}
