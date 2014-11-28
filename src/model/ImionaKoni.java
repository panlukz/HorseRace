package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ImionaKoni {
	
	
	private static String generujImie() {
		Random generator = new Random();
		List<String> imiona = new ArrayList<String>();
		
		imiona.add("Wiesiek");
		imiona.add("Poniedziałek");
		imiona.add("Kalosz");
		imiona.add("Kasztan");
		imiona.add("Książe");
		imiona.add("Cynamon");
		
		return imiona.get( generator.nextInt(imiona.size()) );
	}
	
	private static  String generujPrzydomek() {
		Random generator = new Random();
		List<String> przydomki = new ArrayList<String>();
		
		przydomki.add("Zużyty");
		przydomki.add("Sprytny");
		przydomki.add("Mroźny");
		przydomki.add("Zawźięty");
		przydomki.add("Rudy");
		przydomki.add("Zezowaty");
		
		return przydomki.get( generator.nextInt(przydomki.size()) );
	}
	
	public static String generujNazwe() {
		
		return generujPrzydomek() + " " + generujImie();
	}
	

}
