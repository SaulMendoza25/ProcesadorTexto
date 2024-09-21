package main;



import java.awt.Color;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
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

	public JMenu getEstilo() {

		JMenu estilo = new JMenu("Estilo");
		estilo.setIcon(imagenIcon("src/images/estilo.png"));
		JCheckBoxMenuItem ngt = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/images/bold.png"));
		KeyStroke controlNegrita = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK);
		KeyStroke controlCursiva = KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK);
		KeyStroke controlSubrayado = KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK);
		JCheckBoxMenuItem crv = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/images/italic.png"));
        JCheckBoxMenuItem und =new JCheckBoxMenuItem("Subrayado",new ImageIcon("src/images/subrayado.png"));
        
		ngt.addActionListener(new StyledEditorKit.BoldAction());
		crv.addActionListener(new StyledEditorKit.ItalicAction());
		und.addActionListener(new StyledEditorKit.UnderlineAction());
		ngt.setAccelerator(controlNegrita);
		crv.setAccelerator(controlCursiva);
		und.setAccelerator(controlSubrayado);
		estilo.add(ngt);
		estilo.add(crv);
		estilo.add(und);
		return estilo;
	}
	public JMenu getColor(JTextPane hoja) {

		JMenu color = new JMenu("Color");
		color.setIcon(new ImageIcon("src/images/paleta_de_color.png"));
		color.setLayout(new GridLayout(3,1));
		String [] RGB= {"Red","Green","Blue"};
		
			JLabel JLRed = new JLabel(RGB[0]);
			JLRed.setAlignmentX(Component.CENTER_ALIGNMENT);
		    JRed = new JSlider(0,255,0);
			JRed.setName(RGB[0]);
			JRed.setPaintLabels(true);
			JRed.setMajorTickSpacing(50);
			JRed.setMinorTickSpacing(25);
			JRed.addChangeListener(new cambioJSliderLetraColor(JRed.getName(),hoja));
			color.add(JLRed);
			color.add(JRed);
			color.addSeparator();
			
			JLabel JLGreen = new JLabel(RGB[1]);
			JLGreen.setAlignmentX(Component.CENTER_ALIGNMENT);
			JGreen = new JSlider(0,255,0);
			JGreen.setName(RGB[1]);
			JGreen.setPaintLabels(true);
			JGreen.setMajorTickSpacing(50);
			JGreen.setMinorTickSpacing(25);
			JGreen.addChangeListener(new cambioJSliderLetraColor(JGreen.getName(),hoja));
			color.add(JLGreen);
			color.add(JGreen);
			color.addSeparator();
			
			JLabel JLBlue = new JLabel(RGB[2]);
			JLBlue.setAlignmentX(Component.CENTER_ALIGNMENT);
			JBlue = new JSlider(0,255,0);
			JBlue.setName(RGB[2]);
			JBlue.setPaintLabels(true);
			JBlue.setMajorTickSpacing(50);
			JBlue.setMinorTickSpacing(25);
			JBlue.addChangeListener(new cambioJSliderLetraColor(JBlue.getName(),hoja));
			color.add(JLBlue);
			color.add(JBlue);
			color.addSeparator();
			JLabel BetterCallSaul= new JLabel("Elije el color desado en las letras");
			BetterCallSaul.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			color.add(BetterCallSaul);
			JPanel colores_Primarios_Extendidos = new JPanel();
			
			for(int i=0;i<cadenaColores.length;i++) {
				JLabel generarColor = new JLabel();
				generarColor.setText(nombresColoresPrimarioExtendidos[i]);
				
				generarColor.setIcon(new ImageIcon("src/images/"+cadenaColores[i]));
				generarColor.addMouseListener(new AccionColorMouse(hoja));
				colores_Primarios_Extendidos.add(generarColor);
			}
			color.add(colores_Primarios_Extendidos);
		return color;
	}
	public JMenu getColorEmergente(JTextPane hoja) {

		JMenu color = new JMenu("Color");
		color.setIcon(new ImageIcon("src/images/paleta_de_color.png"));
		JPanel colores_Primarios_Extendidos = new JPanel();
	
		for(int i=0;i<cadenaColores.length;i++) {
			JLabel generarColor = new JLabel();
			generarColor.setText(nombresColoresPrimarioExtendidos[i]);
			
			generarColor.setIcon(new ImageIcon("src/images/"+cadenaColores[i]));
			generarColor.addMouseListener(new AccionColorMouse(hoja));
			colores_Primarios_Extendidos.add(generarColor);
		}
		color.add(colores_Primarios_Extendidos);
		return color;
	}
	public JMenu getColorPantalla(JTextPane hoja) {
		JMenu color = new JMenu("Color de Hoja");
		color.setIcon(new ImageIcon("src/images/PantallaColor.png"));
		color.setLayout(new GridLayout(3,1));
		String [] RGB= {"Red","Green","Blue"};

			JLabel JLRed = new JLabel(RGB[0]);
			JLRed.setAlignmentX(Component.CENTER_ALIGNMENT);
			JRedScreen = new JSlider(0,255,0);
			JRedScreen.setName(RGB[0]);
			JRedScreen.setPaintLabels(true);
			JRedScreen.setMajorTickSpacing(50);
			JRedScreen.setMinorTickSpacing(25);
			JRedScreen.addChangeListener(new cambioJSliderPantalla(JRedScreen.getName(),hoja));
			color.add(JLRed);
			color.add(JRedScreen);
			color.addSeparator();
			
			JLabel JLGreen = new JLabel(RGB[1]);
			JLGreen.setAlignmentX(Component.CENTER_ALIGNMENT);
			JGreenScreen = new JSlider(0,255,0);
			JGreenScreen.setName(RGB[1]);
			JGreenScreen.setPaintLabels(true);
			JGreenScreen.setMajorTickSpacing(50);
			JGreenScreen.setMinorTickSpacing(25);
			JGreenScreen.addChangeListener(new cambioJSliderPantalla(JGreenScreen.getName(),hoja));
			color.add(JLGreen);
			color.add(JGreenScreen);
			color.addSeparator();
			
			JLabel JLBlue = new JLabel(RGB[2]);
			JLBlue.setAlignmentX(Component.CENTER_ALIGNMENT);
			JBlueScreen = new JSlider(0,255,0);
			JBlueScreen.setName(RGB[2]);
			JBlueScreen.setPaintLabels(true);
			JBlueScreen.setMajorTickSpacing(50);
			JBlueScreen.setMinorTickSpacing(25);
			JBlueScreen.addChangeListener(new cambioJSliderPantalla(JBlueScreen.getName(),hoja));
			color.add(JLBlue);
			color.add(JBlueScreen);
		return color;
	}
	private class AccionColorMouse extends MouseAdapter{
		private final JTextPane hoja;
		
		public AccionColorMouse(JTextPane hoja) {
			this.hoja=hoja;
		}
		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			if(e.toString().contains("Rojo")) {
				agregarColorTexto(Color.RED,hoja);
			}
			else if(e.toString().contains("Azul")) {
				agregarColorTexto(Color.BLUE,hoja);
			}
			else if(e.toString().contains("Amarillo")) {
				agregarColorTexto(Color.YELLOW,hoja);
			}
			else if(e.toString().contains("Naranja")) {
				agregarColorTexto(Color.ORANGE,hoja);
			}
			else if(e.toString().contains("Celeste")) {
				agregarColorTexto(Color.CYAN,hoja);
			}
			else if(e.toString().contains("Negro")) {
				agregarColorTexto(Color.BLACK,hoja);
			}
			else if(e.toString().contains("Blanco")) {
				agregarColorTexto(Color.WHITE,hoja);
			}
			else if(e.toString().contains("Cafe")) {
				agregarColorTexto(new Color(161,130,98),hoja);
			}
			else {
				agregarColorTexto(Color.GREEN,hoja);
			}
			
		}
	}
	private class cambioJSliderLetraColor implements ChangeListener{
		private static int rojo=0;
		private static int verde=0;
		private static int azul=0;
		private final String nombre;
		
		private final JTextPane hoja;
		public cambioJSliderLetraColor(String nombre ,JTextPane hoja) {
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
			agregarColorTexto(ColorLetra,hoja);
			
		}
		
	}
	private class cambioJSliderPantalla implements ChangeListener{
		private static int rojo=0;
		private static int verde=0;
		private static int azul=0;
		private final String nombre;
		
		private final JTextPane hoja;
		public cambioJSliderPantalla(String nombre ,JTextPane hoja) {
			this.nombre=nombre;
		
			this.hoja=hoja;
		}
		@Override
		public void stateChanged(ChangeEvent e) {
			
	       if(nombre.equals("Red")) {
	    	   rojo=JRedScreen.getValue();
	       }else if(nombre.equals("Green")) {
	    	   verde=JGreenScreen.getValue();
	       }else {
	    	   azul=JBlueScreen.getValue();
	       }
	       
			Color ColorLetra = new Color(rojo, verde, azul);
			hoja.setBackground(ColorLetra);
			
		}
		
	}
	private void agregarColorTexto (Color color , JTextPane hoja) {
		 SimpleAttributeSet Style = new SimpleAttributeSet();
         StyleConstants.setForeground(Style, color);
		 StyledDocument doc = hoja.getStyledDocument();
		 int start = hoja.getSelectionStart();
         int end = hoja.getSelectionEnd();
         if (start != end) {  
             doc.setCharacterAttributes(start, end - start, Style, false);
         }
		
	}
	
	public  JMenu getSizeF() {
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
	private String[] cadenaColores= {"buttonRed.png","buttonBlue.png","buttonYellow.png","buttonBrown.png",
			"buttonOrange.png","buttonCyan.png","buttonBlack.png","buttonWhite.png","buttonGreen.png"};
	private String[] nombresColoresPrimarioExtendidos= {"Rojo","Azul","Amarillo","Cafe","Naranja","Celeste","Negro","Blanco","Verde"};
	private JSlider JRed;
	private  JSlider JGreen;
	private  JSlider JBlue;
	private  JSlider JRedScreen;
	private  JSlider JGreenScreen;
	private  JSlider JBlueScreen;
}
