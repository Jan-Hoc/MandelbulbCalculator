package ch.jh.maturarbeit.mandelbrot;

import java.lang.Math;
//Fuer die benoetigten Rechenoperationen mit Quaternionen
public class Quaternion { 

	private Double x0;
	private Double x1;
	private Double x2;
	private Double x3;
	//Die Quaternion ist folgendermassen aufgebaut: x0 + x1*i + x2*j + x3*k
	public Quaternion (Double x0, Double x1, Double x2, Double x3) {
		this.x0 = x0;
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
	}
	//Funktion um Quaternion mit a zu addieren
	public Quaternion add (Quaternion a) { 
		Double x0 = this.x0 + a.x0;
		Double x1 = this.x1 + a.x1;
		Double x2 = this.x2 + a.x2;
		Double x3 = this.x3 + a.x3;
		return new Quaternion (x0, x1, x2, x3);
	}
	//Funktion um Quaternion mit a zu multiplizieren
	public Quaternion mult (Quaternion a) { 
		Double x0 = this.x0 * a.x0 - this.x1 * a.x1 - this.x2 * a.x2 - this.x3 * a.x3;
		Double x1 = this.x0 * a.x1 + this.x1 * a.x0 + this.x2 * a.x3 - this.x3 * a.x2;
		Double x2 = this.x0 * a.x2 - this.x1 * a.x3 + this.x2 * a.x0 + this.x3 * a.x1;
		Double x3 = this.x0 * a.x3 + this.x1 * a.x2 - this.x2 * a.x1 + this.x3 * a.x0;
		return new Quaternion(x0, x1, x2, x3);
	}
	//Funktion um Quaternion mit Faktor n zu potenzieren
	public Quaternion potentiate (int n) { 
		Quaternion r = new Quaternion (this.x0, this.x1, this.x2, this.x3);
		for(int i = 1; i < n; i++) {
			r = r.mult(this);
		}
		return r;
		
	}
	//Funktion um den Betrag einer Quaternion zu erhalten
	public Double norm() {
		Double norm = Math.sqrt(Math.pow(x0, 2) + Math.pow(x1, 2) + Math.pow(x2,  2) + Math.pow(x3, 2));
		return norm;
	}
	//Funktion um Quaternion auszudrucken nur (zu Testzwecken)
	public void printQuaternion() {
		System.out.println(x0 + " + " + x1 + "i + " + x2 + "j + " + x3 + "k");
	}
	//Getters und Setters fuer Variablen (fuer alle Variablen auto-generiert)
	public Double getX0() {
		return x0;
	}

	public void setX0(Double x0) {
		this.x0 = x0;
	}

	public Double getX1() {
		return x1;
	}

	public void setX1(Double x1) {
		this.x1 = x1;
	}

	public Double getX2() {
		return x2;
	}

	public void setX2(Double x2) {
		this.x2 = x2;
	}

	public Double getX3() {
		return x3;
	}

	public void setX3(Double x3) {
		this.x3 = x3;
	}

}
