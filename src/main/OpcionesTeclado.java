package main;

import java.awt.event.ActionEvent;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

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
	public JButton letterRight() {
		JButton getLeft = new JButton(new StyledEditorKit.AlignmentAction("", 2));
		getLeft.setIcon(new ImageIcon("src/images/alinear_la_derecha.png"));
		return getLeft;
	}
	public JButton letterLeft() {
		JButton getLeft = new JButton(new StyledEditorKit.AlignmentAction("", 0));
		getLeft.setIcon(new ImageIcon("src/images/alinear_a_la_izquierda.png"));
		return getLeft;
	}
	public JButton letterCenter() {
		JButton getLeft = new JButton(new StyledEditorKit.AlignmentAction("", 1));
		getLeft.setIcon(new ImageIcon("src/images/alinear_al_centro.png"));
		return getLeft;
	}
	public JButton letterJustify() {
		JButton getLeft = new JButton(new StyledEditorKit.AlignmentAction("", 3));
		getLeft.setIcon(new ImageIcon("src/images/justificar_alinear.png"));
		return getLeft;
	}
	
	private class ActionSimples extends AbstractAction{
		private static final long serialVersionUID = 6559025813764239872L;
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
