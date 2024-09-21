package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LaminaProcesadorTexto extends JPanel {

	public LaminaProcesadorTexto() {
		setLayout(new BorderLayout());
		add(getLaminaSuperior(), BorderLayout.NORTH);
		add(getLaminaCentral(), BorderLayout.CENTER);
		add(getLaminaInferior(), BorderLayout.SOUTH);
		getMenuEmergente();

		numeroLetra.setBorder(BorderFactory.createEmptyBorder());

	}

	private JPopupMenu getMenuEmergente() {
		JPopupMenu MenuEmergente = new JPopupMenu();

		MenuEmergente.add(fuentes.getFuente());
		MenuEmergente.add(fuentes.getEstilo());
		MenuEmergente.add(fuentes.getSizeF());
		MenuEmergente.add(fuentes.getColorEmergente(hoja));
		hoja.setComponentPopupMenu(MenuEmergente);
		return MenuEmergente;
	}

	private JPanel getLaminaSuperior() {
		JPanel LaminaSuperior = new JPanel();
		
		LaminaSuperior.setLayout(new BorderLayout());
		OpcionesTeclado opcionesTeclados = new OpcionesTeclado(hoja);
		JToolBar MenuDeHerramienta = new JToolBar();
		MenuDeHerramienta.add(opcionesTeclados.copiar());
		MenuDeHerramienta.add(opcionesTeclados.cortar());
		MenuDeHerramienta.add(opcionesTeclados.pegar());
		MenuDeHerramienta.add(opcionesTeclados.letterLeft());
		MenuDeHerramienta.add(opcionesTeclados.letterCenter());
		MenuDeHerramienta.add(opcionesTeclados.letterRight());
		MenuDeHerramienta.add(opcionesTeclados.letterJustify());
		LaminaSuperior.add(barMenu(), BorderLayout.NORTH);
		LaminaSuperior.add(MenuDeHerramienta, BorderLayout.CENTER);
		return LaminaSuperior;
	}

	private JPanel getLaminaCentral() {
		JPanel laminaCentral = new JPanel();
		laminaCentral.setLayout(new BorderLayout());
		hoja.setBackground(new Color(245, 222, 179));
		hoja.getDocument().addDocumentListener(new modificiadorPrincipal());
		JScrollPane panel = new JScrollPane(hoja);
		panel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		laminaCentral.add(panel);
		return laminaCentral;
	}

	private JPanel getLaminaInferior() {
		JPanel laminaInferior = new JPanel();
		laminaInferior.setLayout(new BorderLayout());
		numeroLetra.setFont(new Font("Serial", Font.PLAIN | Font.ITALIC, 12));
		laminaInferior.add(numeroLetra, BorderLayout.EAST);
		return laminaInferior;
	}

	private JMenuBar barMenu() {
		JMenuBar barMenu = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu fuente = new JMenu("Menu");
		fuente.add(fuentes.getFuente());
		fuente.add(fuentes.getEstilo());
		fuente.add(fuentes.getSizeF());
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
			String textoSinEspacios = hoja.getText().replace(" ", "").replace("\n", "").replace("\r", "");
			for (int i = 1; i <= textoSinEspacios.length(); i++) {
				numeroLetra.setText("" + i);
			}
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (hoja.getText().length() == 0) {
				numeroLetra.setText("" + 0);
			} else {
				String textoSinEspacios = hoja.getText().replace(" ", "").replace("\n", "").replace("\r", "");
				for (int i = 1; i <= textoSinEspacios.length(); i++) {
					numeroLetra.setText("" + i);
				}
			}
		}
	}

	private OpcionFuente fuentes = new OpcionFuente();
	private JLabel numeroLetra = new JLabel("0");
	private OpcionArchivo archivos = new OpcionArchivo();
	private static final long serialVersionUID = -7496279298134415323L;
	private static JTextPane hoja = new JTextPane();
}
