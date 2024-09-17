package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LaminaProcesadorTexto extends JPanel {
	
	public LaminaProcesadorTexto() {
		ScrollPane panel = new ScrollPane();
		
		getMenuEmergente();
		hoja.setBackground(new Color(245, 222, 179));
		hoja.getDocument().addDocumentListener(new modificiadorPrincipal());
		numeroLetra.setEditable(false);
		numeroLetra.setBorder(BorderFactory.createEmptyBorder());
		hojaSur.setLayout(new BorderLayout());
		hojaSur.add(numeroLetra, BorderLayout.EAST);
		setLayout(new BorderLayout(0, 0));
		add(barMenu(), BorderLayout.NORTH);
		panel.add(hoja);
		add(panel, BorderLayout.CENTER);
		add(hojaSur, BorderLayout.SOUTH);
		hojaSur.setEditable(false);
	}
    private JPopupMenu getMenuEmergente() {
    	 JPopupMenu MenuEmergente = new JPopupMenu() ;
    	
    	MenuEmergente.add(fuentes.getFuente(hojaSur, hoja));
 		MenuEmergente.add(fuentes.getEstilo(hojaSur, hoja));
 		MenuEmergente.add(fuentes.getSizeF(hojaSur, hoja));
 		
 		hoja.setComponentPopupMenu(MenuEmergente);
    	 return MenuEmergente;
    }
	private JMenuBar barMenu() {
		
		JMenuBar barMenu = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu fuente = new JMenu("Menu");
		
		fuente.add(opcionesTeclados.copiar());
		fuente.add(opcionesTeclados.cortar());
		fuente.add(opcionesTeclados.pegar());
		fuente.add(fuentes.getFuente(hojaSur, hoja));
		fuente.add(fuentes.getEstilo(hojaSur, hoja));
		fuente.add(fuentes.getSizeF(hojaSur, hoja));
		archivo.add(archivos.getGuardar(hoja));
		archivo.add(archivos.getGuardarComo(hoja));
		barMenu.add(archivo);
		barMenu.add(fuente);

		return barMenu;
	}

	private class modificiadorPrincipal implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
            
            hojaSur.setText("La fuente  "+fuentes.getFuente() + " el estilo  " + fuentes.getEstilos());
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			textPaneEnter();
			String textoSinEspacios = hoja.getText().replace(" ", "");

			for (int i = 1; i <= textoSinEspacios.length(); i++) {
				numeroLetra.setText("" + i);
			}

		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			textPaneEnter();
			if (hoja.getText().length() == 0) {
				numeroLetra.setText("" + 0);
			} else {
				String textoSinEspacios = hoja.getText().replace(" ", "");
				
				for (int i = 1; i <= textoSinEspacios.length(); i++) {
					numeroLetra.setText("" + i);
				}
			}

		}

	}
	public void textPaneEnter() {

	}
	
	private OpcionesTeclado opcionesTeclados=new OpcionesTeclado();
	private JTextField numeroLetra = new JTextField();
	private OpcionFuente fuentes = new OpcionFuente();
	private OpcionArchivo archivos = new OpcionArchivo();
	private static final long serialVersionUID = -7496279298134415323L;
	private JTextPane hoja = new JTextPane();
	private JTextField hojaSur = new JTextField();
}
