import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Gracz;
import model.Kon;
import model.Wyscig;


public class App {

	public App() {

	}

	public static void pokazUczestnikowWyscigu(Gra gra) {
		
		for (int i=0; i<gra.getUczestnicyWyscigu().size(); i++) {
			
			Kon k = gra.getUczestnicyWyscigu().get(i);
			System.out.println("-------------------------------------------------------------------------------------------------");
			System.out.println((i+1) + ". Kon " + k.getNazwa() + "\tWytrzymalosc: " + k.getWytrzymalosc() +
					"\tSzybkosc: " + k.getSzybkosc() + "\tSzczescie: " + k.getSzczescie() + "\tWiek: " + k.getWiek());
		
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Wpisz liczbę graczy (1-4): ");
		int liczbaGraczy = scan.nextInt();
		
		List<String> imionaGraczy = new ArrayList<String>();
		for (int i=0; i<liczbaGraczy; i++) {
			System.out.print("Wpisz imię dla gracza numer " + (i+1) + ": ");
			imionaGraczy.add(scan.next());
		}
		
		Gra nowaGra = new Gra(liczbaGraczy, imionaGraczy);
		
		while(nowaGra.CzyTrwa()) {
			
			nowaGra.nowyWyscig(100, 10); //TODO z tym też coś ogarnąć!
			
			System.out.print("\n\nW wyścigu udział biorą:\n");
			pokazUczestnikowWyscigu(nowaGra);
			
			for (Gracz gracz : nowaGra.getListaGraczy()) {
				
				if(gracz.getPunkty() > 0) {
					
					System.out.println("\n--------------------------");
					System.out.println("Gracz: " + gracz.getNazwa());
					System.out.println("Twoja gotowka: " + gracz.getPunkty());
					
					
					System.out.print("Stawiam gotówki (wpisz 0 jeżeli nie chcesz grać w tej rundzie): ");
					double stawka = scan.nextDouble();
					
					if(stawka != 0) {
						gracz.setStawka(stawka);
						System.out.print("Stawiam na konia nr: ");
						gracz.setObstawionyKon(nowaGra.getAktualnyWyscig().ListaKoni().get(scan.nextInt() - 1));
					}
					else {
						System.out.print("Nie bierzesz udziału w tej rundzie...");
					}
				}
				
			}
			
			nowaGra.startWyscigu();
	
			System.out.println("\nW wysciugu udział brały następujące konie:");
			pokazUczestnikowWyscigu(nowaGra);
			
			System.out.println("\nWyscig wygrywa kon: " + nowaGra.getAktualnyWyscig().getZwyciezcaWyscigu().getNazwa());
			
			for (Gracz gracz : nowaGra.getListaGraczy()) {
				
				if(gracz.getStawka() != 0) {
					if(nowaGra.getAktualnyWyscig().getZwyciezcaWyscigu() == gracz.getObstawionyKon()) {
						System.out.print(gracz.getNazwa() + " stawiałeś na: " + gracz.getObstawionyKon().getNazwa() +
								"! Gratulacje wygrałeś: " + gracz.getStawka() * nowaGra.getMnoznikStawki() + "\n");
					}
					else {
						
						System.out.print(gracz.getNazwa() + " stawiałeś na: " + gracz.getObstawionyKon().getNazwa() +
								" i niestety przegrałeś: " + gracz.getStawka() + "\n");
						
						if(gracz.getPunkty() <= 0)
							System.out.println("Niestety skończyła Ci się gotówka... Odpadasz...");
			
					}
				}
				else
					System.out.print(gracz.getNazwa() + " nie brałeś udziału w obstawianiu tego wyścigu.");
				
			}
			
			
		}
		
		System.out.println("Niestety wszystkim graczom skonczyla sie gotowka! :( Game over! Do książek!");
		
	}

}
