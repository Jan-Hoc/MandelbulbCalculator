package ch.jh.maturarbeit.mandelbrot;

public class Mandelbrot {

	public void quaternionMandelbrot(Point p, int iterations) { //Berechnet ob Punkt zur Menge gehoert und verändert dann partOfManelbrot von dem Punkt
		Quaternion quaternion = new Quaternion(0.00, p.getX(), p.getY(), p.getZ()); //Querschnitt der Quaterionen mit x0 = 0 (also Imaginärraum),mit Koordinaten des zu testenden Punktes
		Quaternion start = new Quaternion (0.00, 0.00, 0.00, 0.00); //Quaternion zum rechnen
		int counter = 0; //Zaehlt Anzahl Iterationen
		for(int i = 0; i <= iterations; i++) {
			counter++;
			start = start.potentiate(2).add(quaternion); //Variationen in der Potenz koennen hier angepasst werden
			if(start.norm() >= 2) {
				break;
			}
		}
		if(counter == iterations) {
			p.setPartOfMandelbrot(true);
		}
	}
	
	public void whiteMandelbrot(Point p, int iterations) {
		Double oldX = p.getX();
		Double oldY = p.getY();
		Double oldZ = p.getZ();
		
		Double newX;
		Double newY;
		Double newZ;
		
		int counter = 0;
		
		for(int i = 0; i <= iterations; i++) {
			counter++; 
			
			newX = p.getX() + Math.pow(oldX, 2) - Math.pow(oldY, 2) - Math.pow(oldZ, 2);
			newY = p.getY() + (4 * oldX * oldY * oldZ) / (Math.sqrt(Math.pow(oldY, 2) + Math.pow(oldZ, 2)));
			newZ = p.getZ() + 2 * oldX * (-1 * Math.pow(oldY, 2) + Math.pow(oldZ, 2)) / (Math.sqrt(Math.pow(oldY, 2) + Math.pow(oldZ, 2)));
			
			oldX = Double.valueOf(newX);
			oldY = Double.valueOf(newY);
			oldZ = Double.valueOf(newZ);
			
			if(Math.pow(oldX, 2) + Math.pow(oldY, 2) + Math.pow(oldZ, 2) >= 2) {
				break;
			}
		}
		
		if(counter == iterations) {
			p.setPartOfMandelbrot(true);
		}
	}
}
