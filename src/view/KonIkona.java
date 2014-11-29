package view;

import java.awt.Image;

import javax.swing.ImageIcon;

public class KonIkona {

	ImageIcon[] tablicaKlatek = new ImageIcon[12];
	private int aktualnaKlatka;
	
	public KonIkona() {
		aktualnaKlatka = 0; //startowy obrazek konia
		
		for (int i = 0; i < 12; i++) {
			String kon = "/graphics/horses/Horse 4 Move " + (i + 1) + ".png";
				tablicaKlatek[i] = new ImageIcon(this.getClass().getResource(kon));
		} 
	}
	
	public Image nastepnaKlatka()
	{
		this.aktualnaKlatka++;
		
		if(aktualnaKlatka > tablicaKlatek.length - 1)
			aktualnaKlatka = 0;
		
		return tablicaKlatek[aktualnaKlatka].getImage();
			
	}

}
