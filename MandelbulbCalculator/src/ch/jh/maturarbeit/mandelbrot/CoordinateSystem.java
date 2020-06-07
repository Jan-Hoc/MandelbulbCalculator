package ch.jh.maturarbeit.mandelbrot;
public class CoordinateSystem {
	private int maxX;
	private int maxY;
	private int maxZ;

	public CoordinateSystem(int x, int y, int z) {//Legt Begrenzungen von den Dimensionen des Koordinatensystems fest, in dem sich die Menge befindet (max gilt sowohl für positiv als auch negativ.)
		maxX = x;
		maxY = y;
		maxZ = z;
	}

	public int getMaxX() { //Getters und Setters für die Variabeln
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public int getMaxZ() {
		return maxZ;
	}

	public void setMaxZ(int maxZ) {
		this.maxZ = maxZ;
	}
}
