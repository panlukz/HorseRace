package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
	

	private List<Player> players;
	private Race currentRace;
	private boolean isOn;	
	
	public GameLogic(int playersCount, List<String> playersNames) {
		this.players = new ArrayList<Player>();
		
		for(int i=0; i<playersCount; i++)
			this.players.add(new Player(playersNames.get(i)));
					
		this.isOn = true;
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
	
	public void newRace() {
		Random rand = new Random();
		double distance = rand.nextDouble() * 50 + 80;
		int horseCount = rand.nextInt(5) + 5;
		this.currentRace = new Race(distance, horseCount);
	}
	
	public void newRace(double distance, int horseCount) {
		this.currentRace =  new Race(distance, horseCount);
	}
	
	public List<Horse> getRaceMembers() {
		return this.currentRace.getHorsesList();
	}
	
	private boolean checkIfGameIsEnd() {
		for (Player player : this.players) {
			if (player.getPoints() > 0)
				return false;
		}
		
		return true;
	}
	
	//TODO nazwa tej metody nie do końca przedstawia to co ona robi
	//     metoda ma sprawdzać wyniki, a ona równiez zmienia punktacje u graczy
	public void checkRaceResults() {
				
		for (Bet bet : this.currentRace.getBetList()) {
			
			if(this.currentRace.getRaceWinner() == bet.getHorse())
				bet.getPlayer().addPoints(bet.getBid() * this.currentRace.getBidMultiplier());
			else {
				bet.getPlayer().subtractPoints(bet.getBid());
				
				if(bet.getPlayer().getPoints() <= 0)
					this.players.remove(bet.getPlayer());
			}
		}
		
		if(checkIfGameIsEnd())
			this.isOn = false;
		
	}
}
