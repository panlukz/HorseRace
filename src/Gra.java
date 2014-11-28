
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
	
	public Gra() {
		listaGraczy = new ArrayList<Gracz>();
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
	
	public void nowyWyscig(double d) {
		this.aktualnyWyscig =  new Wyscig(d);
	}
	
}
