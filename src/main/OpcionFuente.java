package main;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

public class OpcionFuente {

	private  Icon imagenIcon(String imagen) {
		return new ImageIcon(imagen);
	}

	public  JMenu getFuente() {
		class FuenteObtener extends StyledEditorKit.FontFamilyAction {
			private static final long serialVersionUID = 4672126712178448083L;

			public FuenteObtener(String nm, String family) {
				super(nm, family);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				super.actionPerformed(e);
			}
		}

		JMenu fuente = new JMenu("Fuente");
		fuente.setIcon(imagenIcon("src/images/diseno_de_fuentes.png"));
		String[] fuentes = { "Serif", "DejaVu Serif", "Cantarell" };
		for (int i = 0; i < fuentes.length; i++) {
			JMenuItem generador_de_fuentes = new JMenuItem(fuentes[i]);
			generador_de_fuentes.addActionListener(new FuenteObtener("cambio_style", generador_de_fuentes.getText()));
			fuente.add(generador_de_fuentes);
		}
		return fuente;
	}

	public JMenu getEstilo(JTextField hojaSur, JTextPane hoja) {

		JMenu estilo = new JMenu("Estilo");
		estilo.setIcon(imagenIcon("src/images/estilo.png"));
		JCheckBoxMenuItem ngt = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/images/bold.png"));
		KeyStroke controlNegrita = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
		KeyStroke controlCursiva = KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK);
		JCheckBoxMenuItem crv = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/images/italic.png"));

		ngt.addActionListener(new StyledEditorKit.BoldAction());
		ngt.setAccelerator(controlNegrita);
		crv.setAccelerator(controlCursiva);
		crv.addActionListener(new StyledEditorKit.ItalicAction());
		estilo.add(ngt);
		estilo.add(crv);
		return estilo;
	}
	public JMenu getColor(JTextPane hoja) {

		JMenu color = new JMenu("Color");
		
		color.setLayout(new GridLayout(3,1));
		String [] RGB= {"Red","Green","Blue"};
		
			JLabel JLRed = new JLabel(RGB[0]);
		   JRed = new JSlider(0,255,0);
			JRed.setName(RGB[0]);
			JRed.setPaintLabels(true);
			JRed.setMajorTickSpacing(50);
			JRed.setMinorTickSpacing(25);
			JRed.addChangeListener(new cambioJSlider(JRed.getName(),hoja));
			color.add(JLRed);
			color.add(JRed);
			color.addSeparator();
			JLabel JLGreen = new JLabel(RGB[1]);
				 JGreen = new JSlider(0,255,0);
			JGreen.setName(RGB[1]);
			JGreen.setPaintLabels(true);
			JGreen.setMajorTickSpacing(50);
			JGreen.setMinorTickSpacing(25);
			JGreen.addChangeListener(new cambioJSlider(JGreen.getName(),hoja));
			color.add(JLGreen);
			color.add(JGreen);
			color.addSeparator();
			
			JLabel JLBlue = new JLabel(RGB[2]);
				 JBlue = new JSlider(0,255,0);
			JBlue.setName(RGB[2]);
			JBlue.setPaintLabels(true);
			JBlue.setMajorTickSpacing(50);
			JBlue.setMinorTickSpacing(25);
			JBlue.addChangeListener(new cambioJSlider(JBlue.getName(),hoja));
			color.add(JLBlue);
			color.add(JBlue);

			
		return color;
	}
	private JSlider JRed;
	private  JSlider JGreen;
	private  JSlider JBlue;
	private int valorTipoColor;
	private class cambioJSlider implements ChangeListener{
		private static int rojo=0;
		private static int verde=0;
		private static int azul=0;
		private final String nombre;
		
		private final JTextPane hoja;
		public cambioJSlider(String nombre ,JTextPane hoja) {
			this.nombre=nombre;
		
			this.hoja=hoja;
		}
		@Override
		public void stateChanged(ChangeEvent e) {
			
	       if(nombre.equals("Red")) {
	    	   rojo=JRed.getValue();
	       }else if(nombre.equals("Green")) {
	    	   verde=JGreen.getValue();
	       }else {
	    	   azul=JBlue.getValue();
	       }
	       
			Color ColorLetra = new Color(rojo, verde, azul);
//			hoja.setText(ColorLetra.toString());
			 SimpleAttributeSet Style = new SimpleAttributeSet();
             StyleConstants.setForeground(Style, ColorLetra);
			 StyledDocument doc = hoja.getStyledDocument();
			 int start = hoja.getSelectionStart();
             int end = hoja.getSelectionEnd();

             // Aplicar el color rojo al texto seleccionado
             if (start != end) {  // Verificar si hay una selección
                 doc.setCharacterAttributes(start, end - start, Style, false);
             }
			
		}
		
	}
	public  JMenu getSizeF(JTextField hojaSur, JTextPane hoja) {
		JMenu size = new JMenu("Tamaño");
		size.setIcon(imagenIcon("src/images/tamano-del-texto.png"));
		generadorSize(size, 32);
		return size;
	}

	private  void generadorSize(JMenu menuSize, int cantidad) {
		int generador = 8;
		JRadioButtonMenuItem generado;
		ButtonGroup grupo = new ButtonGroup();
		for (int i = 4; i <= cantidad / 2; i++) {
			generado = new JRadioButtonMenuItem(String.valueOf(generador));
			generado.addActionListener(new StyledEditorKit.FontSizeAction("cambio_size", generador));
			grupo.add(generado);
			menuSize.add(generado);
			generador += 2;
		}

	}

}
