package logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
	

	private List<Player> players;
	private Race currentRace;
	private Horse betHorse;
	private boolean isOn;	
	
	public GameLogic(int playersCount, List<String> playersNames) {
		this.players = new ArrayList<Player>();
		
		for(int i=0; i<playersCount; i++)
			this.players.add(new Player(playersNames.get(i)));
					
		isOn = true;
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public Race getCurrentRace() {
		return this.currentRace;
	}
	
	public boolean isOn() {	
		return this.isOn;
	}
	
	public void newRace(double distance, int horseCount) {
		this.currentRace =  new Race(distance, horseCount);
	}
	
	public List<Horse> getRaceMembers() {
		return this.currentRace.getHorsesList();
	}
	
	private boolean checkIfEnd() {
		for (Player player : this.players) {
			if (player.getPoints() > 0)
				return false;
		}
		
		return true;
	}
	
	
	public void startRace() {
		
		this.currentRace.start();
		
		for (Bet bet : this.currentRace.getBetList()) {
			
			if(this.currentRace.getRaceWinner() == bet.getHorse())
				bet.getPlayer().addPoints(bet.getBid() * this.currentRace.getBidMultiplier());
			else {
				bet.getPlayer().subtractPoints(bet.getBid());
				
				if(bet.getPlayer().getPoints() <= 0)
					this.players.remove(bet.getPlayer());
			}
		}
		
		if(checkIfEnd())
			this.isOn = false;
		
	}
}
