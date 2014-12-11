package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Race {

	private double distance;
	private List<Horse> horses;
	private boolean isOn;
	private Horse raceWinner;
	private List<Bet> bets;
	private double bidMultiplier = 3;
	
	public Race(double distanceLenght, int horsesCount) {
		this.bets = new ArrayList<Bet>();
		this.horses = new ArrayList<Horse>();
		this.isOn = true;		
		
		this.addHorses(horsesCount);
		this.distance = distanceLenght;
		
	}
	
	public double getBidMultiplier() {
		return this.bidMultiplier;
	}
	
	public void setBidMultiplier(double m) {
		this.bidMultiplier = m;
	}
	
	public void placeABet(Player g, Horse k, double s) {
		bets.add(new Bet(g, k, s));
	}
	
	public List<Bet> getBetList() {
		return this.bets;
	}
	
	private void addHorses(int horsesCount) {
		for (int i = 0; i < horsesCount; i++)
			this.horses.add(new Horse());
	}

	public double getDistance() {
		return distance;
	}
	
	public int getHorsesCount() {
		return this.horses.size();
	}
	
	public boolean isOn() {
		return isOn;
	}
	
	public Horse getRaceWinner() {
		return raceWinner;
	}
	
	public List<Horse> getHorsesList() {
		return horses;
	}
	
	public void start() {
		int step = 1;
		while(this.isOn) {
			this.nextMove();
			
			System.out.println("---------- " + step + " --------------");
			for (int i=0; i<this.horses.size(); i++) {
				Horse k = this.horses.get(i);
				System.out.println((i+1) + ". " + k.getName() + " " + k.getPosition()); //jedyne co bedzie drukowane do konsoli w okienkowej appce
				
			}
			
			step++;
		
			try {
	            Thread.sleep(20);
	        } 
	        catch (InterruptedException e) {
	        }
		}
	}

	public void nextMove() {
		
		System.out.println("----------  --------------");
		for (int i=0; i<this.horses.size(); i++) {
			Horse k = this.horses.get(i);
			System.out.println((i+1) + ". " + k.getName() + " " + k.getPosition()); //jedyne co bedzie drukowane do konsoli w okienkowej appce
		}
		
		//Jedziemy pętlą przez wszystkie konie na liście i zmieniamy im pozycję
		Random losowa = new Random();
		for (Horse horse : horses) {
			
			horse.doMove(this.distance);
				
			if(checkWinner(horse)) {
				this.raceWinner = horse;
				this.isOn = false;
				break;
			}
		}
	}
	
	private boolean checkWinner(Horse horse) {
		if(horse.getPosition() >= this.distance)
			return true;
		
		return false;
	}




}
