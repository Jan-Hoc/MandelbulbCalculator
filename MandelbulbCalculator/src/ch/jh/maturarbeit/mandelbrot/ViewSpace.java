package ch.jh.maturarbeit.mandelbrot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ViewSpace {

	private int res;
	private Double increment;
	private Mandelbrot mandelbrot;
	private Double max; //Maximale Ausdehnun des Koordinatensystems ins Negative und Nositive.
	ArrayList<Point> partOfMandelbrot = new ArrayList<Point>(); // Speichert alle Punkte di zur Menge gehören

	public ViewSpace(int res, Double max) {
		this.res = res;
		increment = max * 2 / res;
		this.max = max;
		mandelbrot = new Mandelbrot();
	}

	public static void main(String[] args) throws IOException {
		ViewSpace viewSpace = new ViewSpace(1000, 2.00);
		Point p = new Point(0.00, 0.00, 0.00); //Punkt der berechnet werden soll
		
		FileWriter writer = new FileWriter("/Users/jan/Desktop/points");
		PrintWriter print_line = new PrintWriter(writer);
		

		for (int i = 0; i <= viewSpace.getRes(); i++) {//Y-Koordinaten im 3D-Koordinatensystem (Displaykoordinaten X)
			p.setY(i * viewSpace.getIncrement() - viewSpace.getMax());
			System.out.println(i);
			for (int j = 0; j <= viewSpace.getRes(); j++) {//Z-Koordinaten im 3D-Koordinatensystem (Displaykoordinaten Y)
				p.setZ(j * viewSpace.getIncrement() - viewSpace.getMax());
				
				for (int k = 0; k <= viewSpace.getRes(); k++) {//X-Koordinaten im 3D-Koordinatensystem 
					p.setX(k * viewSpace.getIncrement() - viewSpace.getMax());
					viewSpace.mandelbrot.partOfMandelbrot(p, 100); //Anzahl Iterationen hier einstellen
					if(p.getPartOfMandelbrot()) { //Wenn p zur Menge gehört, dann wird es zur Liste hinzugefügt. Es geht zum nächsten Pixel (nicht sichtbare Pxel werden nicht berechnet um Rechenzeit zu verringern)
						viewSpace.partOfMandelbrot.add(p.copy());
						print_line.println(p.getX().toString() + " " + p.getY().toString() + " " + p.getZ().toString());
						break;
					}
				}
			}
		}

		writer.close();
		print_line.close();
	}

	public int getRes() { //Getters und Setters für Variabeln
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public Double getIncrement() {
		return increment;
	}

	public void setIncrement(Double increment) {
		this.increment = increment;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}
}
