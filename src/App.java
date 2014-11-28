import java.util.Scanner;

import model.Gracz;
import model.Kon;
import model.Wyscig;


public class App {

	public App() {

	}

	public static void pokazUczestnikowWyscigu(Gra gra) {
		for (Kon k : gra.getUczestnicyWyscigu()) {
			System.out.println("Kon " + k.getNazwa() + "\tWytrzymalosc: " + k.getWytrzymalosc() + "\tSzybkosc: " + k.getSzybkosc() + "\tSzczescie: " + k.getSzczescie() + "\tWiek: " + k.getWiek());
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Gra nowaGra = new Gra(1);
		
		//while(nowaGra.getListaGraczy().get(0).getPunkty() > 0) {
		while(nowaGra.CzyTrwa()) {
			
			nowaGra.nowyWyscig(100, 5);
			
			pokazUczestnikowWyscigu(nowaGra);
			
			System.out.println("Twoja gotowka: " + nowaGra.getAktualnyGracz().getPunkty());
			
			System.out.println("Stawiam na konia nr: ");
			int numerKonia = scan.nextInt();
			nowaGra.getAktualnyGracz().setObstawionyKon(nowaGra.getAktualnyWyscig().ListaKoni().get(numerKonia - 1));
			
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
			pokazUczestnikowWyscigu(nowaGra);
			
			System.out.println("Wyscig wygrywa kon: " + nowaGra.getAktualnyWyscig().getZwyciezcaWyscigu().getNazwa());
			
			if(nowaGra.getAktualnyWyscig().getZwyciezcaWyscigu() == nowaGra.getAktualnyGracz().getObstawionyKon()) {
				System.out.println("Gratulacje wygrałeś: " + stawka*3 + "\n");
				nowaGra.getAktualnyGracz().dodajPunkty(stawka*3);
			}
			else {
				System.out.println("Niestety przegrałeś: " + stawka + "\n");
				nowaGra.getAktualnyGracz().odejmijPunkty(stawka);
	
			}
		}
		
		System.out.println("Niestety skonczyla Ci sie gotowka! :( Zagraj jeszcze raz!");
		
	}

}
