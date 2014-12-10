package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JPanel;

import model.Horse;
import model.Race;

public class WyscigWidok extends JPanel implements Runnable {

	private Thread animator;
	private List<Horse> listaKoni;
	private Race wyscig;
	KonIkona konIkona;
	
	public WyscigWidok(Race w) {
		this.wyscig = w;
		listaKoni = wyscig.getHorsesList();
		konIkona = new KonIkona();
	}
	
	@Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
	}
	
	public void paintComponent(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		for (int i=0; i<listaKoni.size(); i++) {
			Horse kon = listaKoni.get(i);
			
			
			g2d.drawImage(konIkona.nastepnaKlatka(), (int)kon.getPozycja(), (100*i), this);
		}
		
	}

	@Override
	public void run() {
		while (this.wyscig.isOn()) {
			this.wyscig.nextMove();
			repaint();
			
            try {
                Thread.sleep(100);
            } 
            catch (InterruptedException e) {
            }

           
        }
		
	}

}
