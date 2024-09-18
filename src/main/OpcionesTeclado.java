package main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class OpcionesTeclado  {
private JTextPane hoja;
public OpcionesTeclado(JTextPane hoja) {
	this.hoja=hoja;
}
	public JButton copiar( ) {
		JButton getCopia = new JButton(new ActionSimples("Copiar",new ImageIcon("src/images/copiar.png")));
//	getCopia.setHorizontalTextPosition(SwingConstants.LEFT);
	return getCopia;
	}
	public JButton cortar( ) {
		JButton getCortar = new JButton(new ActionSimples("Cortar",new ImageIcon("src/images/cortar.png")));
		return getCortar;
	}
	public JButton pegar( ) {
		JButton getPegar = new JButton(new ActionSimples("Pegar",new ImageIcon("src/images/pegar.png")));
		return getPegar;
	}
	private class ActionSimples extends AbstractAction{
		public ActionSimples(String nombre, Icon icono) {
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		 if (e.getActionCommand()=="Cortar") {
			hoja.setText("");
		}
			
		}
		
	}
}
