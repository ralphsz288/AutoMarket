package com.proiect.auto.masini;

public class Tir extends Masini {
	int tonaj_max;
	public Tir(String marca, String model, int an, int km, int pret, String culoare, String combustibil, int putere, String tip_masina, int tonaj_max) 
	{
		super(marca, model, an, km, pret, culoare, combustibil, putere, tip_masina);
		this.tonaj_max=tonaj_max;
	}
	public int getTonaj_max() {
		return tonaj_max;
	}
	public void setTonaj_max(int tonaj_max) {
		this.tonaj_max = tonaj_max;
	}
	
	public String toString() {
		return "Marca: " + marca + ", model: " + model + ", an: " + an + ", km: " + km + ", pret: " + pret + ", culoare: " + culoare + ", motor: " + combustibil + ", putere: " + putere + ", tip masina: " + tip_masina + ", tonaj maxim: " + tonaj_max;
	}

}
