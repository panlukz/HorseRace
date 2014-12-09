import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import model.Gra;
import model.Wyscig;
import model.Kon;
import view.PobieranieImionWidok;
import view.WyscigWidok;
import view.PokazKonieWidok;


public class AppSwing extends JFrame{

	private Gra nowaGra;
	
	public AppSwing() {
		
		this.pokazOkno();
	}
	
	private void pokazOkno() {
		
		setSize(1000, 800);	//ustawiamy wymiary okna 
		setResizable(false);	//blokujemy mozliwosc rozszerzania okna
		
		setTitle("Wyścigi konne");	//ustawiamy tytuł dla okna
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//ustawiamy domyślne zachowanie przycisku X
		setLocationRelativeTo(null);	//ustawiamy domyślną lokalizację okna po otwarciu
		
		List<String> imionaGraczy;
		//pokazPobieranieImionGraczy();
		
		List<String> gracze = new ArrayList();
		gracze.add("kupa");
		gracze.add("zupa");
		Gra mokap = new Gra(2, gracze);
		mokap.nowyWyscig(600, 9);
		
		
		//pokazWyscig(mokap.getAktualnyWyscig());
		pokazKonie(mokap.getAktualnyWyscig());
	}
	
	public void pokazPobieranieImionGraczy() {
		
		this.add(new PobieranieImionWidok());
	}
	
	public void pokazWyscig(Wyscig wyscig) {
		//this.removeAll();
		this.add(new WyscigWidok(wyscig));
	}
	
	public void pokazKonie(Wyscig wyscig) {
		//this.removeAll();
		this.add(new PokazKonieWidok(wyscig.ListaKoni()));
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				JFrame ex = new AppSwing(); //tworzymy instancję naszej aplikacji
				ex.setVisible(true);	//ustawiamy jej widoczność na ekranie
				
			}
		});

	}

}
