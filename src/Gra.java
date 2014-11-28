
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




import java.util.Scanner;

import model.Gracz;
import model.Kon;
import model.Wyscig;

public class Gra {
	
	private double mnoznikStawki = 3;
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
	
	public double getMnoznikStawki() {
		return this.mnoznikStawki;
	}
	
	public void setMnoznikStawki(double m) {
		this.mnoznikStawki = m;
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
		
		int step = 1;
		while(this.aktualnyWyscig.CzyTrwa()) {
			this.aktualnyWyscig.NastepnyRuch();
			
			System.out.println("---------- " + step + " --------------");
			for (int i=0; i<this.aktualnyWyscig.ListaKoni().size(); i++) {
				Kon k = this.aktualnyWyscig.ListaKoni().get(i);
				System.out.println((i+1) + ". " + k.getNazwa() + " " + k.getPozycja()); //jedyne co bedzie drukowane do konsoli w okienkowej appce
				
			}
			
			step++;
		
			try {
	            Thread.sleep(20);
	        } 
	        catch (InterruptedException e) {
	        }
		}
		
		for (Gracz gracz : this.listaGraczy) {
			
			if(gracz.getStawka() > 0) {
				
				if(this.aktualnyWyscig.getZwyciezcaWyscigu() == gracz.getObstawionyKon())
					gracz.dodajPunkty(gracz.getStawka() * mnoznikStawki);
				else
					gracz.odejmijPunkty(gracz.getStawka());
				
			}
		}
		
		if(sprawdzCzyKoniec())
			this.czyTrwa = false;
		
	}
}
