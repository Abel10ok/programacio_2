package herencia_figuras;

public abstract class  Figura {
	private double area=0;
	private double perimetro=0;
	
	public Figura() {
		super();
	}


	public abstract void  area();

	public abstract void  perimetro();



	public double getArea() {
		return area;
	}



	public void setArea(double area) {
		this.area = area;
	}



	public double getPerimetro() {
		return perimetro;
	}



	public void setPerimetro(double perimetro) {
		this.perimetro = perimetro;
	}


	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(" area= ");
		str.append(area);
		str.append(" perimetro= ");
		str.append(perimetro);
		return str.toString();
	}
	
	
		
}
