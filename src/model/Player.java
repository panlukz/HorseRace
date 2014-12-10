package model;

public class Gracz {

	private String nazwa;
	private double punkty;
	
	public Gracz(String n) {
		this.nazwa = n;
		this.punkty = 100;
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
