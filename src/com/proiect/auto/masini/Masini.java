package com.proiect.auto.masini;

public class Masini {
	public String marca;
	public String model;
	public int an;
	public int km;
	public int pret;
	public String culoare;
	public String combustibil;
	public int putere;
	public String tip_masina;
	
	public Masini(String marca, String model, int an, int km, int pret, String culoare, String combustibil, int putere,
			String tip_masina) {

		this.marca = marca;
		this.model = model;
		this.an = an;
		this.km = km;
		this.pret = pret;
		this.culoare = culoare;
		this.combustibil = combustibil;
		this.putere = putere;
		this.tip_masina = tip_masina;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getAn() {
		return an;
	}

	public void setAn(int an) {
		this.an = an;
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getPret() {
		return pret;
	}

	public void setPret(int pret) {
		this.pret = pret;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public String getCombustibil() {
		return combustibil;
	}

	public void setCombustibil(String combustibil) {
		this.combustibil = combustibil;
	}

	public int getPutere() {
		return putere;
	}

	public void setPutere(int putere) {
		this.putere = putere;
	}

	public String getTip_masina() {
		return tip_masina;
	}

	public void setTip_masina(String tip_masina) {
		this.tip_masina = tip_masina;
	}
	
	

}
