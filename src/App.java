import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Gra;
import model.Gracz;
import model.ImionaKoni;
import model.Kon;
import model.Wyscig;
import model.Zaklad;


public class App {

	public App() {
		
	}
	
	private static Scanner scan = new Scanner(System.in);

	public static void pokazUczestnikowWyscigu(Wyscig wyscig) {
		
		for (int i=0; i<wyscig.ListaKoni().size(); i++) {
			
			Kon k = wyscig.ListaKoni().get(i);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println((i+1) + ". Kon " + k.getNazwa() + "\tWytrzymalosc: " + k.getWytrzymalosc() +
					"\tSzybkosc: " + k.getSzybkosc() + "\tSzczescie: " + k.getSzczescie() + "\tWiek: " + k.getWiek());
		
		}
		
	}
	
	public static void pokazPodsumowanieWyscigu(Wyscig wyscig) {
		System.out.println("\nW wysciugu udział brały następujące konie:");
		pokazUczestnikowWyscigu(wyscig);
		
		System.out.println("\nWyscig wygrywa kon: " + wyscig.getZwyciezcaWyscigu().getNazwa());
		
		for (Zaklad zaklad : wyscig.getListaZakladow()) {
			
			if(zaklad.getKon() == wyscig.getZwyciezcaWyscigu()) {
				System.out.println(zaklad.getGracz().getNazwa() + " stawiałeś na " + zaklad.getKon().getNazwa() +
						"! Gratulacje wygrałeś " + zaklad.getStawka() * wyscig.getMnoznikStawki());
			}
			else {
				System.out.println(zaklad.getGracz().getNazwa() + " stawiałeś na " + zaklad.getKon().getNazwa() +
						" i niestety przegrałeś: " + zaklad.getStawka());
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
		
		Gra nowaGra = new Gra(liczbaGraczy, imionaGraczy);
		
		while(nowaGra.CzyTrwa()) {
			
			nowaGra.nowyWyscig(100, 10); //TODO z tym też coś ogarnąć!
			
			System.out.print("\n\nW wyścigu udział biorą:\n");
			pokazUczestnikowWyscigu(nowaGra.getAktualnyWyscig());
			
			for (Gracz gracz : nowaGra.getListaGraczy()) {
		
				System.out.println("\n--------------------------");
				System.out.println("Gracz: " + gracz.getNazwa());
				System.out.println("Twoja gotowka: " + gracz.getPunkty());
					
				double stawka;
				do {
					System.out.print("Stawiam gotówki (wpisz 0 jeżeli nie chcesz grać w tej rundzie): ");
					
					try {
						stawka = Double.parseDouble(scan.nextLine());
						}
						catch(NumberFormatException e) {
							stawka = -1;
						}
					
				} while (stawka < 0 || stawka > gracz.getPunkty());
					
				if(stawka != 0) {
					int numerObstawionegoKonia;
					do {
						System.out.print("Stawiam na konia nr: ");
						
						try {
							numerObstawionegoKonia = Integer.parseInt(scan.nextLine());
							}
							catch(NumberFormatException e) {
							  numerObstawionegoKonia = 0;
							}
						
					} while (numerObstawionegoKonia > nowaGra.getAktualnyWyscig().ListaKoni().size() || numerObstawionegoKonia < 1);
					
					Kon obstawionyKon = nowaGra.getAktualnyWyscig().ListaKoni().get(numerObstawionegoKonia - 1);
					nowaGra.getAktualnyWyscig().zlozZaklad(gracz, obstawionyKon, stawka);
						
				}
				else {
					System.out.print("Nie bierzesz udziału w tej rundzie...");
				}
				
				
			}
			
			nowaGra.startWyscigu();
	
			pokazPodsumowanieWyscigu(nowaGra.getAktualnyWyscig());
			
			System.out.println("\nRozpoczyna się następny wyścig...");
			scan.nextLine();
			
			
		}
		
		System.out.println("... ale niestety wszystkim graczom skonczyla sie gotowka! :( Game over! Do książek!");
		
	}

}
