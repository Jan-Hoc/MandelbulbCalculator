package ch.jh.maturarbeit.mandelbrot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ViewSpace {
	//Anzahl Zwischenschritte im Koordinatensystem
	private int res;
	private Double increment;
	private Mandelbrot mandelbrot;
	//Maximale Ausdehnung des Koordinatensystems ins Negative und Positive fuer alle Achsen
	private Double max; 

	public ViewSpace(int res, Double max) {
		this.res = res;
		increment = max * 2 / res;
		this.max = max;
		mandelbrot = new Mandelbrot();
	}

	public static void main(String[] args) throws IOException {
		ViewSpace viewSpace = new ViewSpace(2000, 3.00);		
		//Dateipfad wo Textdatei für MeshLab gespeichert werden soll
		FileWriter writer = new FileWriter("C:\\Users\\janho\\OneDrive\\Dokumente\\Schule\\Maturarbeit\\Punktwolken\\Quaternion\\Quaternion_2.txt");
		PrintWriter print_line = new PrintWriter(writer);
		
		//Y-Koordinaten im 3D-Koordinatensystem (Displaykoordinaten X)
		for (int i = 0; i <= viewSpace.getRes(); i++) {
			System.out.println(i);
			//Z-Koordinaten im 3D-Koordinatensystem (Displaykoordinaten Y)
			for (int j = 0; j <= viewSpace.getRes(); j++) {
				//X-Koordinaten im 3D-Koordinatensystem 
				for (int k = 0; k <= viewSpace.getRes(); k++) {
					Point p = new Point(k * viewSpace.getIncrement() - viewSpace.getMax(), i * viewSpace.getIncrement() - viewSpace.getMax(), j * viewSpace.getIncrement() - viewSpace.getMax());
					//Anzahl Iterationen hier einstellen
					viewSpace.mandelbrot.quaternionMandelbrot(p, 100, 2); 
					//Wenn p zur Menge gehoert, dann wird es zur Liste hinzugefuegt
					if(p.getPartOfMandelbrot()) { 
						print_line.println(Double.toString(p.getX()) + ";" + Double.toString(p.getY()) + ";" + Double.toString(p.getZ()));
						
					}
				}
			}
		}

		writer.close();
		print_line.close();
	}
	//Getters und Setters fuer Variablen (fuer alle Variablen auto-generiert)
	public int getRes() { 
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
