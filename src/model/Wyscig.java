package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Wyscig {

	private double dystans;
	private List<Kon> listaKoni;
	private boolean czyZakonczylSie;
	private Kon zwyciezcaWyscigu;
	
	public Wyscig(double dlugoscDystansu, int liczbaKoni) {
		this.listaKoni = new ArrayList<Kon>();
		this.czyZakonczylSie = false;		
		
		this.dodajKonie(liczbaKoni);
		this.dystans = dlugoscDystansu;
		
	}
	
	private void dodajKonie(int liczbaKoni) {
		for (int i = 0; i < liczbaKoni; i++)
			this.listaKoni.add(new Kon());
	}

	public double getDystans() {
		return dystans;
	}
	
	public int getIloscKoni() {
		return this.listaKoni.size();
	}
	
	public boolean CzyZakonczylSie() {
		return czyZakonczylSie;
	}
	
	public Kon getZwyciezcaWyscigu() {
		return zwyciezcaWyscigu;
	}
	
	public List<Kon> ListaKoni() {
		return listaKoni;
	}

	public void NastepnyRuch() {
		//Jedziemy pętlą przez wszystkie konie na liście i zmieniamy im pozycję
		// oczywiście biorąc pod uwagę kryteria
		Random losowa = new Random();
		for (Kon k : listaKoni) {
			
			// Obliczamy mnożnik dystansu
			double dystans = k.getPozycja() / this.dystans;
			double mnoznikWytrzymalosci = 1;
				
			if((dystans > 0.5) && (k.getWytrzymalosc() < 9)) {
					
				if((k.getWytrzymalosc() > 6) && (dystans > 0.75)) {
					mnoznikWytrzymalosci = 0.7;
				}
					
				else if((k.getWytrzymalosc() > 4) && (k.getWytrzymalosc() < 6)) {
					mnoznikWytrzymalosci = 0.7;
				}
					
				else if((k.getWytrzymalosc() < 4)) {
					mnoznikWytrzymalosci = 0.5;
				}
					
			}
			
			//Obliczamy kontuzję:
			if ((k.getWiek() > 15) && (k.getSzczescie() < 5) && (losowa.nextInt(100) == 5)) {
				k.zlapalKontuzje();
				
			}
				
				
			//Obliczyliśmy już składowe do wyliczenia długosci ruchu konia, teraz wyliczamy
			double nowaPozycjaKonia = k.getPozycja() + (k.getSzybkosc()/10) * mnoznikWytrzymalosci; //TODO 1 zamienic na warunek...
			k.setPozycja(nowaPozycjaKonia);
				
				
			//Jeżeli okaże się że dany z koni pokonał dystans wyścigu, czyli wygrał
			if(k.getPozycja() >= this.dystans) {
				this.zwyciezcaWyscigu = k;
				this.czyZakonczylSie = true;
				break;
			}
		}
	}




}
