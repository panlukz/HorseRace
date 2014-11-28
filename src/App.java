import java.util.Scanner;

import model.Gracz;
import model.Kon;
import model.Wyscig;


public class App {

	public App() {

	}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Gra nowaGra = new Gra();
		
		System.out.println("Wprowadz swoje imie: ");
		String imieGracza = scan.nextLine();
		nowaGra.getListaGraczy().add(new Gracz(imieGracza));
		
		while(nowaGra.getListaGraczy().get(0).getPunkty() > 0) {
			
			nowaGra.nowyWyscig(100);
			
			//z tego pewnie metoda przygotowujaca wyscig:
			//imiona dla kuniow bedo losowane
			nowaGra.getAktualnyWyscig().dodajKonia(new Kon("Jeden"));
			nowaGra.getAktualnyWyscig().dodajKonia(new Kon("Dwa"));
			nowaGra.getAktualnyWyscig().dodajKonia(new Kon("Trzy"));
			nowaGra.getAktualnyWyscig().dodajKonia(new Kon("Cztery"));
			nowaGra.getAktualnyWyscig().dodajKonia(new Kon("Pięć"));
			
			//z tego tez chyba metoda pokazujaca uczestnikow wyscigu:
			for (Kon k : nowaGra.getAktualnyWyscig().ListaKoni()) {
				System.out.println("Kon " + k.getNazwa() + ", Wytrzymalosc: " + k.getWytrzymalosc() + ", Szybkosc: " + k.getSzybkosc() + ", Szczescie: " + k.getSzczescie() + ", Wiek: " + k.getWiek() + ", Kontuzja: " + k.getCzyKontuzjowany());
			}
			
			System.out.println("Twoja gotowka: " + nowaGra.getListaGraczy().get(0).getPunkty());
			
			System.out.println("Stawiam na konia nr: ");
			int numerKonia = scan.nextInt();
			nowaGra.getListaGraczy().get(0).setObstawionyKon(nowaGra.getAktualnyWyscig().ListaKoni().get(numerKonia - 1));
			
			System.out.println("Stawiam gotówki: ");
			double stawka = scan.nextDouble();
			
			while (!nowaGra.getAktualnyWyscig().CzyZakonczylSie()) {
				nowaGra.getAktualnyWyscig().NastepnyRuch();
				
				
				
				for (Kon k : nowaGra.getAktualnyWyscig().ListaKoni()) {
					System.out.println(k.getNazwa() + " " + k.getPozycja());
					
					
				}
				
				try {
		            Thread.sleep(20);
		        } 
		        catch (InterruptedException e) {
		        }
			}
	
			System.out.println("W wysciugu udział brali:");
			for (Kon k : nowaGra.getAktualnyWyscig().ListaKoni()) {
				System.out.println("Kon " + k.getNazwa() + ", Wytrzymalosc: " + k.getWytrzymalosc() + ", Szybkosc: " + k.getSzybkosc() + ", Szczescie: " + k.getSzczescie() + ", Wiek: " + k.getWiek() + ", Kontuzja: " + k.getCzyKontuzjowany());
			}
			
			System.out.println("Wyscig wygrywa kon: " + nowaGra.getAktualnyWyscig().getZwyciezcaWyscigu().getNazwa());
			
			if(nowaGra.getAktualnyWyscig().getZwyciezcaWyscigu() == nowaGra.getListaGraczy().get(0).getObstawionyKon()) {
				System.out.println("Gratulacje wygrałeś: " + stawka*3 + "\n");
				nowaGra.getListaGraczy().get(0).dodajPunkty(stawka*3);
			}
			else {
				System.out.println("Niestety przegrałeś: " + stawka + "\n");
				nowaGra.getListaGraczy().get(0).odejmijPunkty(stawka);
	
			}
		}
		
		System.out.println("Niestety skonczyla Ci sie gotowka! :( Zagraj jeszcze raz!");
		
	}


}
