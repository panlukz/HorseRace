import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.GameCore;
import model.Player;
import model.HorseNames;
import model.Horse;
import model.Race;
import model.Bet;


public class App {

	public App() {
		
	}
	
	private static Scanner scan = new Scanner(System.in);

	public static void showRaceMembers(Race race) {
		
		for (int i=0; i<race.getHorsesList().size(); i++) {
			
			Horse k = race.getHorsesList().get(i);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println((i+1) + ". Kon " + k.getName() + "\tWytrzymalosc: " + k.getStrength() +
					"\tSzybkosc: " + k.getSpeed() + "\tSzczescie: " + k.getLuck() + "\tWiek: " + k.getAge());
		
		}
		
	}
	
	public static void showRaceSummary(Race race) {
		System.out.println("\nW wysciugu udział brały następujące konie:");
		showRaceMembers(race);
		
		System.out.println("\nWyscig wygrywa kon: " + race.getRaceWinner().getName());
		
		for (Bet bet : race.getBetList()) {
			
			if(bet.getHorse() == race.getRaceWinner()) {
				System.out.println(bet.getPlayer().getName() + " stawiałeś na " + bet.getHorse().getName() +
						"! Gratulacje wygrałeś " + bet.getBid() * race.getBidMultiplier());
			}
			else {
				System.out.println(bet.getPlayer().getName() + " stawiałeś na " + bet.getHorse().getName() +
						" i niestety przegrałeś: " + bet.getBid());
			}
			
		}
	}
	
	public static int getNumberOfPlayers() {
		int numberOfPlayers;
		do {
			System.out.print("Wpisz liczbę graczy (1-4): ");

			try {
			   numberOfPlayers = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) {
			  numberOfPlayers = 0;
			}


		} while(numberOfPlayers < 1 || numberOfPlayers > 4);
		
		return numberOfPlayers;
	}
	
	public static List<String> getPlayersNames(int numberOfPlayers) {
		Scanner scan = new Scanner(System.in);
		List<String> playersNames = new ArrayList<String>();
		System.out.println("Wprowadz imiona dla graczy (nie więcej niż 20 znaków)");
		for (int i=0; i<numberOfPlayers; i++) {
			String name;
			do {
				System.out.print("Gracz numer " + (i+1) + ": ");
				name = scan.nextLine();
			} while (name.length() < 1 || name.length() > 20);
			
			playersNames.add(name);
		}
		return playersNames;
		
	}
	
	public static void main(String[] args) {
		
		
		int numberOfPlayers = getNumberOfPlayers();
		
		List<String> playersNames = getPlayersNames(numberOfPlayers);
		
		GameCore newGame = new GameCore(numberOfPlayers, playersNames);
		
		while(newGame.isOn()) {
			
			int numberOfHorses = 10;
			int distanceLength = 100;
			newGame.newRace(distanceLength, numberOfHorses); //TODO z tym też coś ogarnąć!
			
			System.out.print("\n\nW wyścigu udział biorą:\n");
			showRaceMembers(newGame.getCurrentRace());
			
			for (Player player : newGame.getPlayers()) {
		
				System.out.println("\n--------------------------");
				System.out.println("Gracz: " + player.getName());
				System.out.println("Twoja gotowka: " + player.getPoints());
				
				double bid = getBid(player);
				
				if(bid > 0) {
					int numerObstawionegoKonia = getHorseNumber(player, numberOfHorses);
					Horse obstawionyKon = newGame.getCurrentRace().getHorsesList().get(numerObstawionegoKonia - 1);
					newGame.getCurrentRace().placeABet(player, obstawionyKon, bid);
						
				}
				else {
					System.out.print("Nie bierzesz udziału w tej rundzie...");
				}
				
				
			}
			
			newGame.startRace();
	
			showRaceSummary(newGame.getCurrentRace());
			
			System.out.println("\nRozpoczyna się następny wyścig...");
			scan.nextLine();
			
			
		}
		
		System.out.println("... ale niestety wszystkim graczom skonczyla sie gotowka! :( Game over! Do książek!");
		
	}

	private static int getHorseNumber(Player player, int numberOfHorses) {
		int numerObstawionegoKonia;
		do {
			System.out.print("Stawiam na konia nr: ");
			
			try {
				numerObstawionegoKonia = Integer.parseInt(scan.nextLine());
				}
				catch(NumberFormatException e) {
				  numerObstawionegoKonia = 0;
				}
			
		} while (numerObstawionegoKonia > numberOfHorses || numerObstawionegoKonia < 1);
		
		return numerObstawionegoKonia;
	}

	private static double getBid(Player player) {
		double bid;
		do {
			System.out.print("Stawiam gotówki (wpisz 0 jeżeli nie chcesz grać w tej rundzie): ");
			
			try {
				bid = Double.parseDouble(scan.nextLine());
				}
				catch(NumberFormatException e) {
					bid = -1;
				}
			
		} while (bid < 0 || bid > player.getPoints());
		
		return bid;
	}

}
