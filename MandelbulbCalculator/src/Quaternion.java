import java.lang.Math;

public class Quaternion {

	private Double x0;
	private Double x1;
	private Double x2;
	private Double x3;
	
	public Quaternion (Double x0, Double x1, Double x2, Double x3) {
		this.x0 = x0;
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
	}
	
	public Quaternion add (Quaternion b) {
		Quaternion a = this;
		Double x0 = a.x0 + b.x0;
		Double x1 = a.x1 + b.x1;
		Double x2 = a.x2 + b.x2;
		Double x3 = a.x3 + b.x3;
		return new Quaternion (x0, x1, x2, x3);
	}
	
	public Quaternion mult (Quaternion b) {
		Quaternion a = this;
		Double x0 = a.x0 * b.x0 - a.x1 * b.x1 - a.x2 * b.x2 - a.x3 * b.x3;
		Double x1 = a.x0 * b.x1 + a.x1 * b.x0 + a.x2 * b.x3 - a.x3 * b.x2;
		Double x2 = a.x0 * b.x2 - a.x1 * b.x3 + a.x2 * b.x0 + a.x3 * b.x1;
		Double x3 = a.x0 * b.x3 + a.x1 * b.x2 - a.x2 * b.x1 + a.x3 * b.x0;
		return new Quaternion(x0, x1, x2, x3);
	}
	
	public Quaternion potentiate (int p) {
		Quaternion r = new Quaternion (this.x0, this.x1, this.x2, this.x3);
		for(int i = 0; i < p - 1; i++) {
			r = r.mult(this);
		}
		return r;
		
	}
	public void printQuaternion() {
		System.out.println(x0 + " + " + x1 + "i + " + x2 + "j + " + x3 + "k");
	}
	
	public static void main(String[] args) {
		Quaternion test = new Quaternion(1.00, 2.00, 3.00, 4.00);
		Quaternion b = new Quaternion(4.00, 3.00, 2.00, 1.00);
		test.potentiate(2).printQuaternion();
		test.mult(test).printQuaternion();
		test.printQuaternion();

	}

}
