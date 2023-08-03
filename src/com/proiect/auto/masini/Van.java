package com.proiect.auto.masini;

public class Van extends Masini {
	double volum;
	int locuri;
	public Van(String marca, String model, int an, int km, int pret, String culoare, String combustibil, int putere,
			String tip_masina,double volum,int locuri) {
		super(marca, model, an, km, pret, culoare, combustibil, putere, tip_masina);
		this.volum=volum;
		this.locuri=locuri;
	}
	public double getVolum() {
		return volum;
	}
	public void setVolum(double volum) {
		this.volum = volum;
	}
	public int getLocuri() {
		return locuri;
	}
	public void setLocuri(int locuri) {
		this.locuri = locuri;
	}
	public String toString() {
		return "Marca: " + marca + ", model: " + model + ", an: " + an + ", km: " + km + ", pret: " + pret + ", culoare: " + culoare + ", motor: " + combustibil + ", putere: " + putere + ", tip masina: " + tip_masina + ", volum: " + volum + ", locuri: " + locuri;
	}
}
