package view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class PobieranieImionWidok extends JPanel implements Runnable {
	private JTextField txtImieGracz1;
	private JTextField txtImieGracz2;
	private JTextField txtImieGracz3;
	private JTextField txtImieGracz4;
	
	private List<String> tablicaImionGraczy;

	public PobieranieImionWidok() {
		setLayout(null);
		
		JButton btnRozpocznijGre = new JButton("Rozpocznij grę");
		btnRozpocznijGre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				
			}
		});
		btnRozpocznijGre.setBounds(164, 235, 128, 23);
		add(btnRozpocznijGre);
		
		JLabel lblGraczNr1 = new JLabel("Gracz nr 1:");
		lblGraczNr1.setBounds(46, 23, 63, 14);
		add(lblGraczNr1);
		
		JLabel lblGraczNr2 = new JLabel("Gracz nr 2:");
		lblGraczNr2.setBounds(46, 48, 63, 14);
		add(lblGraczNr2);
		
		JLabel lblGraczNr3 = new JLabel("Gracz nr 3:");
		lblGraczNr3.setBounds(46, 73, 63, 14);
		add(lblGraczNr3);
		
		JLabel lblGraczNr4 = new JLabel("Gracz nr 4:");
		lblGraczNr4.setBounds(46, 98, 63, 14);
		add(lblGraczNr4);
		
		txtImieGracz1 = new JTextField();
		txtImieGracz1.setBounds(119, 23, 86, 20);
		add(txtImieGracz1);
		txtImieGracz1.setColumns(10);
		
		txtImieGracz2 = new JTextField();
		txtImieGracz2.setBounds(119, 48, 86, 20);
		add(txtImieGracz2);
		txtImieGracz2.setColumns(10);
		
		txtImieGracz3 = new JTextField();
		txtImieGracz3.setBounds(119, 73, 86, 20);
		add(txtImieGracz3);
		txtImieGracz3.setColumns(10);
		
		txtImieGracz4 = new JTextField();
		txtImieGracz4.setBounds(119, 98, 86, 20);
		add(txtImieGracz4);
		txtImieGracz4.setColumns(10);
	}

	@Override
	public void run() {
				
	}
}
