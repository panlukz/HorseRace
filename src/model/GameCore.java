package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




import java.util.Scanner;

public class GameCore {
	

	private List<Player> players;
	private Race currentRace;
	private Horse obstawionyKon;
	private boolean isOn;
	private Player currentPlayer;
	
	
	public GameCore(int playersCount, List<String> playersNames) {
		this.players = new ArrayList<Player>();
		
		for(int i=0; i<playersCount; i++)
			this.players.add(new Player(playersNames.get(i)));
		
		this.currentPlayer = this.players.get(0);
				
		isOn = true;
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public Race getCurrentRace() {
		return this.currentRace;
	}
	
	public Horse getObstawionyKon() {
		return this.obstawionyKon;
	}
	
	public boolean isOn() {	
		return this.isOn;
	}
	
	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}
	

	
	public void newRace(double distance, int horseCount) {
		this.currentRace =  new Race(distance, horseCount);
	}
	
	public List<Horse> getRaceMembers() {
		return this.currentRace.getHorsesList();
	}
	
	public void nextPlayer() {
		int currentPlayerIndex = this.players.indexOf(currentPlayer);
		
		if(currentPlayerIndex + 1 < this.players.size()) {
			this.currentPlayer = this.players.get(currentPlayerIndex + 1);
		}
		else
			this.currentPlayer = this.players.get(0);
	}
	
	private boolean checkIfEnd() {
		for (Player gracz : this.players) {
			if (gracz.getPoints() > 0)
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
