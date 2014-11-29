package model;

public class Zaklad {

	private Gracz gracz;
	private Kon kon;
	private double stawka;
	
	public Zaklad(Gracz g, Kon k, double s) {
		this.gracz = g;
		this.kon = k;
		this.stawka = s;
	}
	
	public Gracz getGracz() {
		return this.gracz;
	}
	
	public Kon getKon() {
		return this.kon;
	}
	
	public double getStawka() {
		return stawka;
	}

}
