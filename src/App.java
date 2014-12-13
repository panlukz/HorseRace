import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logic.Bet;
import logic.GameLogic;
import logic.Horse;
import logic.Player;
import logic.Race;


public class App {

	public App() {
		
	}
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		showSplashScreen();
		
		int numberOfPlayers = getNumberOfPlayers();
		
		List<String> playersNames = getPlayersNames(numberOfPlayers);
		
		GameLogic newGame = new GameLogic(numberOfPlayers, playersNames);
		
		while(newGame.isOn()) {
			
			int numberOfHorses = 10;
			int distanceLength = 100;
			
			newGame.newRace(distanceLength, numberOfHorses);
			//newGame.newRace();
			
			for (Player player : newGame.getPlayers()) {
				clearScreen();
				System.out.print("\n\nW wyścigu udział biorą:\n");
				showRaceMembers(newGame.getCurrentRace());
				
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
			
			while(newGame.getCurrentRace().isOn()) {
				newGame.getCurrentRace().nextMove();
			
				try {
		            Thread.sleep(20);
		        } 
		        catch (InterruptedException e) {
		        }
			}
			
			newGame.checkRaceResults();
	
			showRaceSummary(newGame.getCurrentRace());
			
			System.out.println("\nRozpoczyna się następny wyścig...");
			scan.nextLine();
			
			
		}
		
		System.out.println("... ale niestety wszystkim graczom skonczyla sie gotowka! :( Game over! Do książek!");
		
	}
	
	public static String generateSpace(int howManySpace) {
		String space = new String();
		for (int i = 0; i < howManySpace; i++) {
			space += " ";
		}
		return space;
	}

	public static void showRaceMembers(Race race) {
		System.out.println("Nr\tNazwa" + generateSpace(16) + "Wytrzymałość" + generateSpace(2) + "Szybkość" + generateSpace(2) + "Szczęście" + generateSpace(1) + "Wiek ");
		for (int i=0; i<race.getHorsesList().size(); i++) {
			
			Horse h = race.getHorsesList().get(i);
			
			System.out.println("---------------------------------------------------------------------");
			System.out.println((i+1) + "\t" + h.getName() + generateSpace(30 - h.getName().length()) + h.getStamina() +
					"\t" + h.getSpeed() + "\t" + h.getLuck() + "\t" + h.getAge());
		
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

	private static int getHorseNumber(Player player, int horsesCount) {
		int betHorseNumber;
		do {
			System.out.print("Stawiam na konia nr: ");
			
			try {
				betHorseNumber = Integer.parseInt(scan.nextLine());
				}
				catch(NumberFormatException e) {
				  betHorseNumber = 0;
				}
			
		} while (betHorseNumber > horsesCount || betHorseNumber < 1);
		
		return betHorseNumber;
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
	
	private static void showSplashScreen() {
		clearScreen(); 
		System.out.println("            _|\\ _/|_,                           ._|\\_ /|_");
		System.out.println("	 ,((\\\\``-\\\\\\\\_       HORSE             _////-''//)).");
		System.out.println("        ,(())      `))\\       RACING           //(('     (()).");
		System.out.println("      ,(()))        < \\         GAME          / >       ((()).");
		System.out.println("     ((())'   |        \\                     /        |  `(())).");
		System.out.println("     )))))     >.__     \\                   /     __.<     (((((");
		System.out.println("     ((('     /    `-. .d|                  |b. .-'    \\     `)))");
		System.out.println("             /        `-`'     (enter)              `'-'\\");
		scan.nextLine();
		clearScreen();
	}
	
	private static void clearScreen() {
		for (int i = 0; i < 20; i++) {
			System.out.println("\n");

		}
	}

}