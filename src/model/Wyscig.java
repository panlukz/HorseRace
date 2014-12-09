package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Wyscig {

	private double dystans;
	private List<Kon> listaKoni;
	private boolean czyTrwa;
	private Kon zwyciezcaWyscigu;
	private List<Zaklad> listaZakladow;
	private double mnoznikStawki = 3;
	
	public Wyscig(double dlugoscDystansu, int liczbaKoni) {
		this.listaZakladow = new ArrayList<Zaklad>();
		this.listaKoni = new ArrayList<Kon>();
		this.czyTrwa = true;		
		
		this.dodajKonie(liczbaKoni);
		this.dystans = dlugoscDystansu;
		
	}
	
	public double getMnoznikStawki() {
		return this.mnoznikStawki;
	}
	
	public void setMnoznikStawki(double m) {
		this.mnoznikStawki = m;
	}
	
	public void zlozZaklad(Gracz g, Kon k, double s) {
		listaZakladow.add(new Zaklad(g, k, s));
	}
	
	public List<Zaklad> getListaZakladow() {
		return this.listaZakladow;
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
	
	public boolean CzyTrwa() {
		return czyTrwa;
	}
	
	public Kon getZwyciezcaWyscigu() {
		return zwyciezcaWyscigu;
	}
	
	public List<Kon> ListaKoni() {
		return listaKoni;
	}
	
	public void start() {
		int step = 1;
		while(this.czyTrwa) {
			this.NastepnyRuch();
			
			System.out.println("---------- " + step + " --------------");
			for (int i=0; i<this.listaKoni.size(); i++) {
				Kon k = this.listaKoni.get(i);
				System.out.println((i+1) + ". " + k.getNazwa() + " " + k.getPozycja()); //jedyne co bedzie drukowane do konsoli w okienkowej appce
				
			}
			
			step++;
		
			try {
	            Thread.sleep(20);
	        } 
	        catch (InterruptedException e) {
	        }
		}
	}

	public void NastepnyRuch() {
		
		System.out.println("----------  --------------");
		for (int i=0; i<this.listaKoni.size(); i++) {
			Kon k = this.listaKoni.get(i);
			System.out.println((i+1) + ". " + k.getNazwa() + " " + k.getPozycja()); //jedyne co bedzie drukowane do konsoli w okienkowej appce
			
		}
		
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
			double nowaPozycjaKonia = k.getPozycja() + (k.getSzybkosc()/10.0) * mnoznikWytrzymalosci; //TODO 1 zamienic na warunek...
			k.setPozycja(nowaPozycjaKonia);
				
				
			//Jeżeli okaże się że dany kuń pokonał dystans wyścigu, czyli wygrał
			if(k.getPozycja() >= this.dystans) {
				this.zwyciezcaWyscigu = k;
				this.czyTrwa = false;
				break;
			}
		}
	}




}
