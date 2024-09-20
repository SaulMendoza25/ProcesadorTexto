package main;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LaminaProcesadorTexto extends JPanel {
	
	public LaminaProcesadorTexto() {
//		ScrollPane panel = new ScrollPane();
		JScrollPane panel = new JScrollPane(hoja);
		panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		getMenuEmergente();
		
		panel.setBackground(new Color(245, 222, 179));
		hoja.getDocument().addDocumentListener(new modificiadorPrincipal());
		numeroLetra.setEditable(false);
		numeroLetra.setBorder(BorderFactory.createEmptyBorder());
		hojaSur.setLayout(new BorderLayout());
		hojaSur.add(numeroLetra, BorderLayout.EAST);
		setLayout(new BorderLayout(0, 0));
		add(getLaminaSuperior(), BorderLayout.NORTH);
		hoja.setBackground(new Color(245, 222, 179));
		add(panel, BorderLayout.CENTER);
		add(hojaSur, BorderLayout.SOUTH);
		hojaSur.setEditable(false);
	}
    private JPopupMenu getMenuEmergente() {
    	 JPopupMenu MenuEmergente = new JPopupMenu() ;
    	
    	MenuEmergente.add(fuentes.getFuente());
 		MenuEmergente.add(fuentes.getEstilo(hojaSur, hoja));
 		MenuEmergente.add(fuentes.getSizeF(hojaSur, hoja));
 		MenuEmergente.add(fuentes.getColorEmergente(hoja));
 		hoja.setComponentPopupMenu(MenuEmergente);
    	 return MenuEmergente;
    }
    
    private JPanel getLaminaSuperior() {
    	JPanel LaminaSuperior = new JPanel();
    	LaminaSuperior.setLayout(new BorderLayout());
    	OpcionesTeclado opcionesTeclados=new OpcionesTeclado(hoja);
    	JToolBar MenuDeHerramienta = new JToolBar();
    	MenuDeHerramienta.add(opcionesTeclados.copiar());
    	MenuDeHerramienta.add(opcionesTeclados.cortar());
    	MenuDeHerramienta.add(opcionesTeclados.pegar());
    	MenuDeHerramienta.add(opcionesTeclados.letterLeft());
    	MenuDeHerramienta.add(opcionesTeclados.letterCenter());
    	MenuDeHerramienta.add(opcionesTeclados.letterRight());
    	MenuDeHerramienta.add(opcionesTeclados.letterJustify());
    	LaminaSuperior.add(barMenu(), BorderLayout.NORTH);
    	LaminaSuperior.add(MenuDeHerramienta,BorderLayout.CENTER);
    	return LaminaSuperior;
    }
	private JMenuBar barMenu() {
		JMenuBar barMenu = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu fuente = new JMenu("Menu");
		fuente.add(fuentes.getFuente());
		fuente.add(fuentes.getEstilo(hojaSur, hoja));
		fuente.add(fuentes.getSizeF(hojaSur, hoja));
		fuente.add(fuentes.getColor(hoja));
		fuente.add(fuentes.getColorPantalla(hoja));
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
            
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			String textoSinEspacios = hoja.getText().replace(" ", "");
			for (int i = 1; i <= textoSinEspacios.length(); i++) {
				numeroLetra.setText("" + (i-happend));
			}
		}
		@Override
		public void removeUpdate(DocumentEvent e) {
			if (hoja.getText().length() == 0) {
				numeroLetra.setText("" + 0);
			} else {
				String textoSinEspacios = hoja.getText().replace(" ", "");
				for (int i = 1; i <= textoSinEspacios.length(); i++) {
					numeroLetra.setText("" + (i-happend) );
				}
			}
		}
	}
	private static int happend = 0;

	private OpcionFuente fuentes=new OpcionFuente();
	private JTextField numeroLetra = new JTextField();
	private OpcionArchivo archivos = new OpcionArchivo();
	private static final long serialVersionUID = -7496279298134415323L;
	private static JTextPane hoja = new JTextPane();
	private JTextField hojaSur = new JTextField();
}
