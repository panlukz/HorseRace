package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImionaKoni {
	
	private static ImionaKoni instance = new ImionaKoni();
	
	private List<String> imiona = new ArrayList<String>();
	private List<String> przydomki = new ArrayList<String>();
	
	private static Random generator = new Random();

	
	private ImionaKoni() {
		
		imiona.add("Wiesiek");
		imiona.add("Poniedziałek");
		imiona.add("Kalosz");
		imiona.add("Kasztan");
		imiona.add("Książe");
		imiona.add("Robak");
		imiona.add("Dionizy");
		imiona.add("Czarek");
		imiona.add("Patryk");
		imiona.add("Rafał");
		
		przydomki.add("Zużyty");
		przydomki.add("Sprytny");
		przydomki.add("Mroźny");
		przydomki.add("Zawźięty");
		przydomki.add("Rudy");
		przydomki.add("Szczęśliwy");
		przydomki.add("Enigmatyczny");
		przydomki.add("Garbaty");
		przydomki.add("Dostojny");
		przydomki.add("Śmiały");

	}
	
	public static ImionaKoni getInstance() {
		return instance;
	}
	
	private String generujImie() {
		int generatedDigit = generator.nextInt(imiona.size());
		String randomName = imiona.get(generatedDigit);
		imiona.remove(generatedDigit);
		return randomName;
	}
	
	private String generujPrzydomek() {
		int generatedDigit = generator.nextInt(przydomki.size());
		String randomNickname = przydomki.get(generatedDigit);
		przydomki.remove(generatedDigit);
		return randomNickname;
	}
	
	protected String generujNazwe() {
		return generujPrzydomek() + " " + generujImie();
	}
	

}
