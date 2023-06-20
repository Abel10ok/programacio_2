package herencia_figuras;

public class Triangulo extends Figura {
	private int l1;
	private int l2;
	private int l3;

	public Triangulo( int l1, int l2, int l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}



	@Override
	public void area() {
		double sp = (l1+l2+l3)/2;
		this.setArea(sp*(sp-l1)*(sp-l2)*(sp-l3));
	}

	@Override
	public void perimetro() {
		this.setPerimetro( l1+l2+l3);
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(super.toString());
		str.append("lado1= ");
		str.append(l1);
		str.append("lado2= ");
		str.append(l2);
		str.append("lado3= ");
		str.append(l3);
		return str.toString();
	}

}
