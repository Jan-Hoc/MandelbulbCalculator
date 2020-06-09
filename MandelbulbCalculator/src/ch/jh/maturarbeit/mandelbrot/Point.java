package ch.jh.maturarbeit.mandelbrot;

public class Point {
	private Double x;
	private Double y;
	private Double z;
	
	private Boolean partOfMandelbrot = false;
	
	public Point(Double x, Double y, Double z) { //Punkt mit Koordinaten x, y und z in 3D-Koordinatensystem. partOfMandelbulb sagt aus ob es Tell der Menge ist. 
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point copy() {
		Point p = new Point(this.getX(), this.getY(), this.getZ());
		return p;
	}

	public Boolean getPartOfMandelbrot() {//Getters und Setters fuer die Variabeln
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
