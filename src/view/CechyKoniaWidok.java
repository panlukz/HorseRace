package view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import logic.Horse;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class CechyKoniaWidok extends JPanel implements Runnable {

	public CechyKoniaWidok(Horse kon) {
		setLayout(null);
		
		JLabel lblImieKonia = new JLabel(kon.getName());
		lblImieKonia.setBounds(15, 10, 168, 14);
		add(lblImieKonia);
		
		JLabel lblWiekKonia = new JLabel(Integer.toString(kon.getAge()));
		lblWiekKonia.setBounds(95, 105, 46, 14);
		add(lblWiekKonia);

		JProgressBar progBarSzczescie = new JProgressBar();
		progBarSzczescie.setMaximum(10);
		progBarSzczescie.setValue((int)kon.getLuck());
		progBarSzczescie.setBounds(95, 120, 93, 14);
		add(progBarSzczescie);
		
		JProgressBar progBarWytrzymalosc = new JProgressBar();
		progBarWytrzymalosc.setMaximum(10);
		progBarWytrzymalosc.setValue((int)kon.getStamina());
		progBarWytrzymalosc.setBounds(95, 135, 93, 14);
		add(progBarWytrzymalosc);
		
		JProgressBar progBarSzybkosc = new JProgressBar();
		progBarSzybkosc.setMaximum(10);
		progBarSzybkosc.setValue((int)kon.getSpeed());
		progBarSzybkosc.setBounds(95, 150, 93, 14);
		add(progBarSzybkosc);
		
		JLabel lblWiek = new JLabel("Wiek:");
		lblWiek.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWiek.setBounds(15, 105, 75, 14);
		add(lblWiek);
		
		JLabel lblSzczescie = new JLabel("Szczęście");
		lblSzczescie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSzczescie.setBounds(15, 120, 75, 14);
		add(lblSzczescie);
		
		JLabel lblWytrzymalosc = new JLabel("Wytrzymałość");
		lblWytrzymalosc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWytrzymalosc.setBounds(9, 135, 81, 14);
		add(lblWytrzymalosc);
		
		JLabel lblSzybkosc = new JLabel("Szybkość");
		lblSzybkosc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSzybkosc.setBounds(15, 150, 75, 14);
		add(lblSzybkosc);
		
	
		
		

	}

	@Override
	public void run() {
				
	}
}
