package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JPanel;

import model.Kon;
import model.Wyscig;

public class WyscigWidok extends JPanel implements Runnable {

	private Thread animator;
	private List<Kon> listaKoni;
	private Wyscig wyscig;
	KonIkona konIkona;
	
	public WyscigWidok(Wyscig w) {
		this.wyscig = w;
		listaKoni = wyscig.ListaKoni();
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
			Kon kon = listaKoni.get(i);
			
			
			g2d.drawImage(konIkona.nastepnaKlatka(), (int)kon.getPozycja(), (100*i), this);
		}
		
	}

	@Override
	public void run() {
		while (this.wyscig.CzyTrwa()) {
			this.wyscig.NastepnyRuch();
			repaint();
			
            try {
                Thread.sleep(100);
            } 
            catch (InterruptedException e) {
            }

           
        }
		
	}

}
