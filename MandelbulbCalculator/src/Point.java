
public class Point {
	private Double x;
	private Double y;
	private Double z;
	
	private Boolean partOfMandelbulb = false;
	
	public Point(Double x, Double y, Double z) { //Punkt mit Koordinaten x, y und z in 3D-Koordinatensystem. partOfMandelbulb sagt aus ob es Tell der Menge ist. 
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Boolean getPartOfMandelbulb() {//Getters und Setters für Variabeln
		return partOfMandelbulb;
	}

	public void setPartOfMandelbulb(Boolean partOfMandelbulb) {
		this.partOfMandelbulb = partOfMandelbulb;
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