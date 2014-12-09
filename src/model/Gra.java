package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




import java.util.Scanner;

public class Gra {
	

	private List<Gracz> listaGraczy;
	private Wyscig aktualnyWyscig;
	private Kon obstawionyKon;
	private boolean czyTrwa;
	private Gracz aktualnyGracz;
	
	
	public Gra(int iloscGraczy, List<String> imionaGraczy) {
		this.listaGraczy = new ArrayList<Gracz>();
		
		for(int i=0; i<iloscGraczy; i++)
			this.listaGraczy.add(new Gracz(imionaGraczy.get(i)));
		
		this.aktualnyGracz = this.listaGraczy.get(0);
				
		czyTrwa = true;
	}
	
	public List<Gracz> getListaGraczy() {
		return this.listaGraczy;
	}
	
	public Wyscig getAktualnyWyscig() {
		return this.aktualnyWyscig;
	}
	
	public Kon getObstawionyKon() {
		return this.obstawionyKon;
	}
	
	public boolean CzyTrwa() {
		return this.czyTrwa;
	}
	
	public Gracz getAktualnyGracz() {
		return this.aktualnyGracz;
	}
	

	
	public void nowyWyscig(double dystans, int liczbaKoni) {
		this.aktualnyWyscig =  new Wyscig(dystans, liczbaKoni);
	}
	
	public List<Kon> getUczestnicyWyscigu() {
		return this.aktualnyWyscig.ListaKoni();
	}
	
	public void nastepnyGracz() {
		int indexAktualnegoGracza = this.listaGraczy.indexOf(aktualnyGracz);
		
		if(indexAktualnegoGracza + 1 < this.listaGraczy.size()) {
			this.aktualnyGracz = this.listaGraczy.get(indexAktualnegoGracza + 1);
		}
		else
			this.aktualnyGracz = this.listaGraczy.get(0);
	}
	
	private boolean sprawdzCzyKoniec() {
		for (Gracz gracz : this.listaGraczy) {
			if (gracz.getPunkty() > 0)
				return false;
		}
		
		return true;
	}
	
	
	public void startWyscigu() {
		
		this.aktualnyWyscig.start();
		
		for (Zaklad zaklad : this.aktualnyWyscig.getListaZakladow()) {
			
			if(this.aktualnyWyscig.getZwyciezcaWyscigu() == zaklad.getKon())
				zaklad.getGracz().dodajPunkty(zaklad.getStawka() * this.aktualnyWyscig.getMnoznikStawki());
			else {
				zaklad.getGracz().odejmijPunkty(zaklad.getStawka());
				
				if(zaklad.getGracz().getPunkty() <= 0)
					this.listaGraczy.remove(zaklad.getGracz());
			}
				
			
			
		}
		
		
		if(sprawdzCzyKoniec())
			this.czyTrwa = false;
		
	}
}
