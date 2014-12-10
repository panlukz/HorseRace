package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HorseNames {
	
	private static HorseNames instance = new HorseNames();
	
	private List<String> names = new ArrayList<String>();
	private List<String> nicknames = new ArrayList<String>();
	
	private static Random generator = new Random();

	
	private HorseNames() {
		addNames();
		addNickNames();
	}
	
	
	
	private void addNickNames() {
		names.add("Wiesiek");
		names.add("Poniedziałek");
		names.add("Kalosz");
		names.add("Kasztan");
		names.add("Książe");
		names.add("Robak");
		names.add("Dionizy");
		names.add("Czarek");
		names.add("Patryk");
		names.add("Rafał");
	}



	private void addNames() {
		nicknames.add("Zużyty");
		nicknames.add("Sprytny");
		nicknames.add("Mroźny");
		nicknames.add("Zawźięty");
		nicknames.add("Rudy");
		nicknames.add("Szczęśliwy");
		nicknames.add("Enigmatyczny");
		nicknames.add("Garbaty");
		nicknames.add("Dostojny");
		nicknames.add("Śmiały");
	}



	public static HorseNames getInstance() {
		return instance;
	}
	
	private String generateFirstName() {
		int generatedDigit = generator.nextInt(names.size());
		String randomName = names.get(generatedDigit);
		names.remove(generatedDigit);
		return randomName;
	}
	
	private String generateNickname() {
		int generatedDigit = generator.nextInt(nicknames.size());
		String randomNickname = nicknames.get(generatedDigit);
		nicknames.remove(generatedDigit);
		return randomNickname;
	}
	
	protected String generateName() {
		if(names.size() == 0 && nicknames.size() == 0) {
			addNames();
			addNickNames();
		}
		
		return generateNickname() + " " + generateFirstName();
	}
	

}
