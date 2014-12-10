package model;

public class Bet {

	private Player player;
	private Horse horse;
	private double bid;
	
	public Bet(Player g, Horse k, double s) {
		this.player = g;
		this.horse = k;
		this.bid = s;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public Horse getHorse() {
		return this.horse;
	}
	
	public double getBid() {
		return bid;
	}

}
