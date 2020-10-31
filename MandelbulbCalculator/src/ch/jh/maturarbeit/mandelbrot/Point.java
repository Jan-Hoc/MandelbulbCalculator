package ch.jh.maturarbeit.mandelbrot;

public class Point {
	private Double x;
	private Double y;
	private Double z;
	
	private Boolean partOfMandelbrot = false;
	
	//Punkt mit Koordinaten x, y und z in 3D-Koordinatensystem. partOfMandelbulb sagt aus ob es Tell der Menge ist. 
	public Point(Double x, Double y, Double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	//Getters und Setters fuer Variabeln (fuer alle Variablen auto-generiert)
	public Boolean getPartOfMandelbrot() {
		return partOfMandelbrot;
	}

	public void setPartOfMandelbrot(Boolean partOfMandelbulb) {
		this.partOfMandelbrot = partOfMandelbulb;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Double getZ() {
		return z;
	}

	public void setZ(Double z) {
		this.z = z;
	}
}
