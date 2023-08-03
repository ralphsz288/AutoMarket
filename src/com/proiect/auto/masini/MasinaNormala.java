package com.proiect.auto.masini;

public class MasinaNormala extends Masini {

	public int locuri;

	public MasinaNormala(String marca, String model, int an, int km, int pret, String culoare, String combustibil,
			int putere, String tip_masina,int locuri) {
		super(marca, model, an, km, pret, culoare, combustibil, putere, tip_masina);
		this.locuri=locuri;
		
	}

}
