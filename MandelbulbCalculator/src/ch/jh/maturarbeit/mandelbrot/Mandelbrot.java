package ch.jh.maturarbeit.mandelbrot;

public class Mandelbrot {
	//Berechnet ob Punkt zur Menge gehoert und veraendert dann partOfManelbrot von dem Punkt
	public void quaternionMandelbrot(Point p, int iterations) {
		//Querschnitt der Quaterionen mit x0 = 0 (also Imaginaerraum),mit Koordinaten des zu testenden Punktes
		Quaternion quaternion = new Quaternion(0.00, p.getX(), p.getY(), p.getZ()); 
		//Quaternion zum rechnen
		Quaternion start = new Quaternion (0.00, 0.00, 0.00, 0.00); 
		//Zaehlt Anzahl Iterationen
		int counter = 0; 
		for(int i = 0; i < iterations; i++) {
			counter++;
			//Variationen in der Potenz koennen hier angepasst werden
			start = start.potentiate(2);
			start = start.add(quaternion);
			//Wenn die Punke eine Kugel mit dem Radius von zwei verlassen, kehren sie auch nicht zurück, also kann hier der Loop unterbrochen werden
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
		
		Double newX = p.getX();
		Double newY = p.getY();
		Double newZ = p.getZ();
		
		int counter = 0;
		
		for(int i = 0; i < iterations; i++) {
			counter++; 
			//Neue Punkte berechnen nach Methode von White
			newX = p.getX() + Math.pow(oldX, 2) - Math.pow(oldY, 2) - Math.pow(oldZ, 2); 
			newY = p.getY() + ((4 * oldX * oldY * oldZ) / (Math.sqrt(Math.pow(oldY, 2) + Math.pow(oldZ, 2))));
			newZ = p.getZ() + (2 * oldX * (-1 * Math.pow(oldY, 2) + Math.pow(oldZ, 2)) / (Math.sqrt(Math.pow(oldY, 2) + Math.pow(oldZ, 2))));
			
			oldX = Double.valueOf(newX);
			oldY = Double.valueOf(newY);
			oldZ = Double.valueOf(newZ);
			//Wenn die Punke eine Kugel mit dem Radius von zwei verlassen, kehren sie auch nicht zurück, also kann hier der Loop unterbrochen werden
			if(Math.sqrt(Math.pow(oldX, 2) + Math.pow(oldY, 2) + Math.pow(oldZ, 2)) >= 2) {
				break;
			}
		}
		
		if(counter == iterations) {
			p.setPartOfMandelbrot(true);
		}
	}
}
