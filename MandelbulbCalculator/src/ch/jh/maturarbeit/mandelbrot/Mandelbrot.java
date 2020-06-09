package ch.jh.maturarbeit.mandelbrot;

public class Mandelbrot {

	public void partOfMandelbrot(Point point, int iterations) { //Berechnet ob Punkt zur Menge gehoert und verändert dann partOfManelbrot von dem Punkt
		Quaternion quaternion = new Quaternion(0.00, point.getX(), point.getY(), point.getZ()); //Querschnitt der Quaterionen mit x0 = 0 (also Imaginärraum),mit Koordinaten des zu testenden Punktes
		Quaternion start = new Quaternion (0.00, 0.00, 0.00, 0.00); //Quaternion zum rechnen
		int counter = 0; //Zaehlt Anzahl Iterationen
		for(int i = 0; i <= iterations; i++) {
			counter = i;
			start = start.potentiate(2).add(quaternion); //Variationen in der Potenz koennen hier angepasst werden
			if(start.norm() >= 2) {
				break;
			}
		}
		if(counter == iterations) {
			point.setPartOfMandelbrot(true);
		}
	}
}
