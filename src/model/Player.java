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
	

	public void subtractPoints(double p) {
		this.points -= p;
	}
	
	public void addPoints(double p) {
		this.points += p;
	}

}
