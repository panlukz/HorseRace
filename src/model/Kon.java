package model;

import java.util.Random;

public class Kon {

	private String nazwa;

	private double szybkosc;
	private double wytrzymalosc;
	private double szczescie;
	private int wiek;
	private boolean czyKontuzjowany;
	private double pozycja;

	private ImionaKoni imionaKoni = ImionaKoni.getInstance();

	public Kon() {
		Random generator = new Random();
		this.czyKontuzjowany = false;
		this.nazwa = imionaKoni.generateName();
		this.pozycja = 0;
		this.wiek = generator.nextInt(20) + 5;
		this.szybkosc = generator.nextInt(6) + 5;
		this.wytrzymalosc = generator.nextInt(9) + 2;
		this.szczescie = generator.nextInt(9) + 2;
	}

	public double getPozycja() {
		return this.pozycja;
	}

	public void setPozycja(double pozycja) {
		this.pozycja = pozycja;
	}

	public double getSzybkosc() {
		return this.szybkosc;
	}

	public void setSzybkosc(double s) {
		this.szybkosc = s;
	}

	public double getWytrzymalosc() {
		return this.wytrzymalosc;
	}

	public double getSzczescie() {
		return this.szczescie;
	}

	public int getWiek() {
		return this.wiek;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void zlapalKontuzje() {
		this.czyKontuzjowany = true;
		this.szybkosc = 1;
	}

	public boolean getCzyKontuzjowany() {
		return this.czyKontuzjowany;
	}

	@Override
	public String toString() {
		return this.nazwa;
	}

	// ///////////////////Nowe metody, przeprowadzam całą logikę ruchu do konia:

	private double obliczMnoznikWytrzymalosci(double dystansCalkowity) {
		// Obliczamy mnożnik dystansu
		double przebiegnietyDystans = this.getPozycja() / dystansCalkowity;
		double mnoznikWytrzymalosci = 1;

		if ((przebiegnietyDystans > 0.5) && (this.getWytrzymalosc() < 9)) {

			if ((this.getWytrzymalosc() > 6) && (przebiegnietyDystans > 0.75)) {
				mnoznikWytrzymalosci = 0.7;
			}

			else if ((this.getWytrzymalosc() > 4)
					&& (this.getWytrzymalosc() < 6)) {
				mnoznikWytrzymalosci = 0.7;
			}

			else if ((this.getWytrzymalosc() < 4)) {
				mnoznikWytrzymalosci = 0.5;
			}

		}
		return mnoznikWytrzymalosci;
	}

	private boolean czyZlapieKontuzje() {
		// Obliczamy kontuzję:
		if ((this.getWiek() > 15) && (this.getSzczescie() < 5)
				&& (new Random().nextInt(100) == 5)) {
			return true;
		}
		
		return false;
	}

	public void doMove(double dystansCalkowity) {

		double mnoznikWytrzymalosci = obliczMnoznikWytrzymalosci(dystansCalkowity);
		
		if(czyZlapieKontuzje())
			this.zlapalKontuzje();
		
		
		double nowaPozycja = this.getPozycja()
				+ (this.getSzybkosc() / 10.0) * mnoznikWytrzymalosci; // TODO 1
																		// zamienic
																		// na
																		// warunek...
		this.setPozycja(nowaPozycja);

	}

}
