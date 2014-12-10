package view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Horse;
import javax.swing.JProgressBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class PokazKonieWidok extends JPanel implements Runnable {

	public PokazKonieWidok(List<Horse> listaKoni) {
		setLayout(null);
		
		int kolumna = 0;
		int wiersz = 0;
		for (int i=0; i<listaKoni.size(); i++) {
			Horse kon = listaKoni.get(i);
			JPanel cechyKonia = new CechyKoniaWidok(kon);
			
			if(i!=0 && i%3 == 0) {
				wiersz++;
				kolumna = 0;
			}
			cechyKonia.setBounds(220*kolumna, 220*wiersz, 220, 180);
			
			JButton btnObstawKonia = new JButton("Postaw na tego konia");
			btnObstawKonia.setBounds(30 + 220*kolumna, 180 + 220*wiersz, 160, 20);
			
			this.add(cechyKonia);
			this.add(btnObstawKonia);
			
			kolumna++;
		}
		
		

	}

	@Override
	public void run() {
				
	}
}
