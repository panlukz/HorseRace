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
	
	public Kon(String n) {
		Random generator = new Random();
		this.czyKontuzjowany = false;
		this.nazwa = n;
		this.pozycja = 0; //Pozycja startowa konia w wyscigu (w przebytym dystansie)
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

}
