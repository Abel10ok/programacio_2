package Tad_estacionamiento;

public class Auto {
	String matricula;
	int horaIn;
	int horaOut;
	
	public Auto(String matric, int hIn) {
		matricula=matric;
		horaIn=hIn;
		horaOut=-1;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getHoraIn() {
		return horaIn;
	}

	public int getHoraOut() {
		return horaOut;
	}
	
	public int tiempoEstacionado() {
		return (getHoraOut()==0)? 0 : getHoraOut()-getHoraIn();
	}

	public void setHoraOut(int horaOut) {
		if (horaOut<this.horaIn)
			throw new IllegalArgumentException("La hora de salida (" + horaOut
					+ ") no puede ser anterior a la de entrada (" + this.horaIn + ")");
		this.horaOut = horaOut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auto other = (Auto) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auto [matricula=" + matricula + ", horaIn=" + horaIn + ", horaOut=" + horaOut + "]";
	}

	public boolean estacionado() {
		// TODO Auto-generated method stub
		return this.getHoraOut()==-1;
	}
	
}
