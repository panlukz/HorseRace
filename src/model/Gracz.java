package model;

public class Gracz {

	private String nazwa;
	private double pieniadze;
	private Kon obstawionyKon;
	
	
	public Gracz(String n) {
		this.nazwa = n;
		this.pieniadze = 100;
	}
	
	public Kon getObstawionyKon() {
		return this.obstawionyKon;
	}
	
	public void setObstawionyKon(Kon k) {
		this.obstawionyKon = k;
	}
	
	public double getPieniadze() {
		return pieniadze;
	}
	
	public void setPieniadze(double p) {
		pieniadze = p;
	}
	
	

}
