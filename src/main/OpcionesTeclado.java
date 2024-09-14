package main;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class OpcionesTeclado  {

	public JMenuItem copiar() {
	JMenuItem getCopia = new JMenuItem("Copiar",new ImageIcon("src/images/copiar.png"));
//	getCopia.setHorizontalTextPosition(SwingConstants.LEFT);
	return getCopia;
	}
	public JMenuItem cortar() {
		JMenuItem getCortar = new JMenuItem("Cortar",new ImageIcon("src/images/cortar.png"));
		return getCortar;
	}
	public JMenuItem pegar() {
		JMenuItem getPegar = new JMenuItem("Pegar",new ImageIcon("src/images/pegar.png"));
		return getPegar;
	}
}
