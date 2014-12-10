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

	public static void pokazUczestnikowWyscigu(Race wyscig) {
		
		for (int i=0; i<wyscig.getHorsesList().size(); i++) {
			
			Horse k = wyscig.getHorsesList().get(i);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println((i+1) + ". Kon " + k.getNazwa() + "\tWytrzymalosc: " + k.getWytrzymalosc() +
					"\tSzybkosc: " + k.getSzybkosc() + "\tSzczescie: " + k.getSzczescie() + "\tWiek: " + k.getWiek());
		
		}
		
	}
	
	public static void pokazPodsumowanieWyscigu(Race wyscig) {
		System.out.println("\nW wysciugu udział brały następujące konie:");
		pokazUczestnikowWyscigu(wyscig);
		
		System.out.println("\nWyscig wygrywa kon: " + wyscig.getRaceWinner().getNazwa());
		
		for (Bet bet : wyscig.getBetList()) {
			
			if(bet.getHorse() == wyscig.getRaceWinner()) {
				System.out.println(bet.getPlayer().getName() + " stawiałeś na " + bet.getHorse().getNazwa() +
						"! Gratulacje wygrałeś " + bet.getBid() * wyscig.getBidMultiplier());
			}
			else {
				System.out.println(bet.getPlayer().getName() + " stawiałeś na " + bet.getHorse().getNazwa() +
						" i niestety przegrałeś: " + bet.getBid());
			}
			
		}
	}
	
	public static int pobierzLiczbeGraczy() {
		int liczbaGraczy;
		do {
			System.out.print("Wpisz liczbę graczy (1-4): ");

			try {
			   liczbaGraczy = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e) {
			  liczbaGraczy = 0;
			}


		} while(liczbaGraczy < 1 || liczbaGraczy > 4);
		
		return liczbaGraczy;
	}
	
	public static List<String> pobierzListeImionGraczy(int liczbaGraczy) {
		Scanner scan = new Scanner(System.in);
		List<String> imionaGraczy = new ArrayList<String>();
		System.out.println("Wprowadz imiona dla graczy (nie więcej niż 20 znaków)");
		for (int i=0; i<liczbaGraczy; i++) {
			String imie;
			do {
				System.out.print("Gracz numer " + (i+1) + ": ");
				imie = scan.nextLine();
			} while (imie.length() < 1 || imie.length() > 20);
			
			imionaGraczy.add(imie);
		}
		return imionaGraczy;
		
	}
	
	public static void main(String[] args) {
		
		
		int liczbaGraczy = pobierzLiczbeGraczy();
		
		List<String> imionaGraczy = pobierzListeImionGraczy(liczbaGraczy);
		
		GameCore nowaGra = new GameCore(liczbaGraczy, imionaGraczy);
		
		while(nowaGra.isOn()) {
			
			int liczbaKoni = 10;
			int dlugoscDystansu = 100;
			nowaGra.newRace(dlugoscDystansu, liczbaKoni); //TODO z tym też coś ogarnąć!
			
			System.out.print("\n\nW wyścigu udział biorą:\n");
			pokazUczestnikowWyscigu(nowaGra.getCurrentRace());
			
			for (Player gracz : nowaGra.getPlayers()) {
		
				System.out.println("\n--------------------------");
				System.out.println("Gracz: " + gracz.getName());
				System.out.println("Twoja gotowka: " + gracz.getPoints());
				
				double stawka = pobierzStawke(gracz);
				
				if(stawka > 0) {
					int numerObstawionegoKonia = pobierzNumerKonia(gracz, liczbaKoni);
					Horse obstawionyKon = nowaGra.getCurrentRace().getHorsesList().get(numerObstawionegoKonia - 1);
					nowaGra.getCurrentRace().placeABet(gracz, obstawionyKon, stawka);
						
				}
				else {
					System.out.print("Nie bierzesz udziału w tej rundzie...");
				}
				
				
			}
			
			nowaGra.startRace();
	
			pokazPodsumowanieWyscigu(nowaGra.getCurrentRace());
			
			System.out.println("\nRozpoczyna się następny wyścig...");
			scan.nextLine();
			
			
		}
		
		System.out.println("... ale niestety wszystkim graczom skonczyla sie gotowka! :( Game over! Do książek!");
		
	}

	private static int pobierzNumerKonia(Player gracz, int liczbaKoni) {
		int numerObstawionegoKonia;
		do {
			System.out.print("Stawiam na konia nr: ");
			
			try {
				numerObstawionegoKonia = Integer.parseInt(scan.nextLine());
				}
				catch(NumberFormatException e) {
				  numerObstawionegoKonia = 0;
				}
			
		} while (numerObstawionegoKonia > liczbaKoni || numerObstawionegoKonia < 1);
		
		return numerObstawionegoKonia;
	}

	private static double pobierzStawke(Player gracz) {
		double stawka;
		do {
			System.out.print("Stawiam gotówki (wpisz 0 jeżeli nie chcesz grać w tej rundzie): ");
			
			try {
				stawka = Double.parseDouble(scan.nextLine());
				}
				catch(NumberFormatException e) {
					stawka = -1;
				}
			
		} while (stawka < 0 || stawka > gracz.getPoints());
		
		return stawka;
	}

}
