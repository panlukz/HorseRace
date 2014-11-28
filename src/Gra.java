
import java.util.ArrayList;
import java.util.List;




import java.util.Scanner;

import model.Gracz;
import model.Kon;
import model.Wyscig;

public class Gra {

	private List<Gracz> listaGraczy;
	private Wyscig aktualnyWyscig;
	private Kon obstawionyKon;
	private boolean czyTrwa;
	
	public Gra() {
		listaGraczy = new ArrayList<Gracz>();
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
	
	public void nowyWyscig(double dystans, int liczbaKoni) {
		this.aktualnyWyscig =  new Wyscig(dystans, liczbaKoni);
	}
	
}
