package model;

public class Gracz {

	private String nazwa;
	private double punkty;
	private Kon obstawionyKon;
	private double stawka;	
	
	public Gracz(String n) {
		this.nazwa = n;
		this.punkty = 100;
		this.stawka = 0;
	}
	
	public Kon getObstawionyKon() {
		return this.obstawionyKon;
	}
	
	public void setObstawionyKon(Kon k) {
		this.obstawionyKon = k;
	}
	
	public double getStawka() {
		return this.stawka;
	}
	
	public void setStawka(double s) {
		this.stawka = s;
	}
	
	public double getPunkty() {
		return punkty;
	}
	
	public String getNazwa() {
		return this.nazwa;
	}
	
	
	//TODO ta klasa z czasem do usuniecia po tym jak zostaną wykorzystane w pełni 
	//metody odejmijPunkty i dodajPunkty.
	public void setPunkty(double p) {
		this.punkty = p;
	}
	
	
	//TODO dwie klasy, dodaj i odejmij punkty. chyba tu przydalaby sie jakas walidacja co sprawdzalaby
	// czy punktow aby nie jest <0
	public void odejmijPunkty(double p) {
		this.punkty -= p;
	}
	
	public void dodajPunkty(double p) {
		this.punkty += p;
	}
	
	

}
