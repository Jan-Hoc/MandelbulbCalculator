package ch.jh.maturarbeit.mandelbrot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ViewSpace {

	private int res;
	private Double increment;
	private Mandelbrot mandelbrot;
	private Double max; //Maximale Ausdehnung des Koordinatensystems ins Negative und Positive fuer alle Achsen.
	ArrayList<Point> partOfMandelbrot = new ArrayList<Point>(); // Speichert alle Punkte di zur Menge gehoeren

	public ViewSpace(int res, Double max) {
		this.res = res;
		increment = max * 2 / res;
		this.max = max;
		mandelbrot = new Mandelbrot();
	}

	public static void main(String[] args) throws IOException {
		ViewSpace viewSpace = new ViewSpace(5000, 2.00);		
		FileWriter writer = new FileWriter("C:\\Users\\janho\\OneDrive\\Desktop\\points.txt");
		PrintWriter print_line = new PrintWriter(writer);
		

		for (int i = 0; i <= viewSpace.getRes(); i++) {//Y-Koordinaten im 3D-Koordinatensystem (Displaykoordinaten X)
			System.out.println(i);
			for (int j = 0; j <= viewSpace.getRes(); j++) {//Z-Koordinaten im 3D-Koordinatensystem (Displaykoordinaten Y)
				
				for (int k = 0; k <= viewSpace.getRes(); k++) {//X-Koordinaten im 3D-Koordinatensystem 
					Point p = new Point(k * viewSpace.getIncrement() - viewSpace.getMax(), i * viewSpace.getIncrement() - viewSpace.getMax(), j * viewSpace.getIncrement() - viewSpace.getMax());
					viewSpace.mandelbrot.partOfMandelbrot(p, 100); //Anzahl Iterationen hier einstellen
					
					if(p.getPartOfMandelbrot()) { //Wenn p zur Menge gehoert, dann wird es zur Liste hinzugefuegt. Es geht zum naechsten Pixel (nicht sichtbare Pixel werden nicht berechnet um Rechenzeit zu verringern)
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
