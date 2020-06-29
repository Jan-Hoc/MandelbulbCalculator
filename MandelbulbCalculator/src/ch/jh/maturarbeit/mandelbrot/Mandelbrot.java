package ch.jh.maturarbeit.mandelbrot;

public class Mandelbrot {
	//Berechnet ob Punkt zur Menge gehoert und veraendert dann partOfManelbrot von dem Punkt
	public void quaternionMandelbrot(Point p, int iterations, int power) {
		//Querschnitt der Quaterionen mit x0 = 0 (also Imaginaerraum),mit Koordinaten des zu testenden Punktes
		Quaternion quaternion = new Quaternion(0.00, p.getX(), p.getY(), p.getZ()); 
		//Quaternion zum rechnen
		Quaternion start = new Quaternion (0.00, 0.00, 0.00, 0.00); 
		//Zaehlt Anzahl Iterationen
		int counter = 0; 
		for(int i = 0; i < iterations; i++) {
			counter++;
			start = start.potentiate(power);
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

	
	public void whiteMandelbrot(Point p, int iterations, int power) {
		Double x = 0.00;
		Double y = 0.00;
		Double z = 0.00;
		
		Double r;
		Double theta;
		Double phi;
		
		int counter = 0;
		
		for(int i = 0; i < iterations; i++) {
			counter ++;
			r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
			theta = Math.atan2(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)), z);
			phi = Math.atan2(y, x);
			
			x = p.getX() + Math.pow(r, power) * Math.sin(theta * power + 0.5 * Math.PI) * Math.cos(phi * power + Math.PI);
			y = p.getY() + Math.pow(r, power) * Math.sin(theta * power + 0.5 * Math.PI) * Math.sin(phi * power + Math.PI);
			z = p.getZ() + Math.pow(r, power) * Math.cos(theta * power + 0.5 * Math.PI);
			//Wenn die Punke eine Kugel mit dem Radius von zwei verlassen, kehren sie auch nicht zurück, also kann hier der Loop unterbrochen werden
			if(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2) > 4) {
				break;
			}
		}
		
		if(counter == iterations) {
			p.setPartOfMandelbrot(true);
		}
	}
}
