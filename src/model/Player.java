package model;

public class Player {

	private String name;
	private double points;
	
	public Player(String n) {
		this.name = n;
		this.points = 100;
	}
	
	
	public double getPoints() {
		return points;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	//TODO ta klasa z czasem do usuniecia po tym jak zostaną wykorzystane w pełni 
	//metody odejmijPunkty i dodajPunkty.
	public void setPoints(double p) {
		this.points = p;
	}
	
	
	//TODO dwie klasy, dodaj i odejmij punkty. chyba tu przydalaby sie jakas walidacja co sprawdzalaby
	// czy punktow aby nie jest <0
	public void subtractPoints(double p) {
		this.points -= p;
	}
	
	public void addPoints(double p) {
		this.points += p;
	}
	
	

}
