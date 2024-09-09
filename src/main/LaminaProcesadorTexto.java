package main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LaminaProcesadorTexto extends JPanel {
	public LaminaProcesadorTexto() {
		hoja.getDocument().addDocumentListener(new modificiadorPrincipal());
		numeroLetra.setEditable(false);
		numeroLetra.setBorder(BorderFactory.createEmptyBorder());
		hojaSur.setLayout(new BorderLayout());
		hojaSur.add(numeroLetra,BorderLayout.EAST);
		setLayout(new BorderLayout(0, 0));
		add(barMenu(), BorderLayout.NORTH);
		add(hoja, BorderLayout.CENTER);
		add(hojaSur, BorderLayout.SOUTH);
		hojaSur.setEditable(false);
	}

	private JMenu getFuente() {
		class BarraFuente implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				fuente = e.getActionCommand();
				hoja.setFont(new Font(fuente, estilo, size));
				fuenteTotal = "La fuente es: " + fuente + "  estilo es: " + tipoStyle + " el tamaño es:" +size;
				hojaSur.setText(fuenteTotal);

			}

		}
		JMenu fuente = new JMenu("Fuente");
		JMenuItem srf = new JMenuItem("Serif");
		JMenuItem djs = new JMenuItem("DejaVu Serif");
		JMenuItem ctl = new JMenuItem("Cantarell");
		srf.addActionListener(new BarraFuente());
		djs.addActionListener(new BarraFuente());
		ctl.addActionListener(new BarraFuente());
		fuente.add(srf);
		fuente.add(djs);
		fuente.add(ctl);
		return fuente;
	}
	 
	private JMenu getEstilo() {
		class BarraEstilo implements ActionListener {
       
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand() == "Negrita") {

					estilo = Font.BOLD;
					tipoStyle="Bold";
				} else if (e.getActionCommand() == "Cursiva") {
					estilo = Font.ITALIC;
					tipoStyle="Italic";
				} else if (e.getActionCommand() == "Ambos") {
					estilo = Font.BOLD | Font.ITALIC;
					tipoStyle="Bold y Italic";
				} else {
					estilo = Font.PLAIN;
					tipoStyle="Plain";
				}

				hoja.setFont(new Font(fuente, estilo, size));
				fuenteTotal = "La fuente es: " + fuente + "  estilo es: " + tipoStyle + " el tamaño es:" +size;
				hojaSur.setText(fuenteTotal);
			}

		}
		JMenu estilo = new JMenu("Estilo");
		JMenuItem ngt = new JMenuItem("Negrita");
		JMenuItem crv = new JMenuItem("Cursiva");
		JMenuItem ngt_crv = new JMenuItem("Ambos");
		JMenuItem quitar = new JMenuItem("Ninguno");
		ngt.addActionListener(new BarraEstilo());
		crv.addActionListener(new BarraEstilo());
		ngt_crv.addActionListener(new BarraEstilo());
		quitar.addActionListener(new BarraEstilo());
		estilo.add(ngt);
		estilo.add(crv);
		estilo.addSeparator();
		estilo.add(ngt_crv);
		estilo.add(quitar);
		return estilo;
	}

	private JMenu getSizeF() {
		class BarraSize implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(e.getActionCommand());
				hoja.setFont(new Font(fuente, estilo, size));
				fuenteTotal = "La fuente es: " + fuente + "  estilo es: " + tipoStyle + " el tamaño es:" +size;
				hojaSur.setText(fuenteTotal);
			}

		}
		JMenu size = new JMenu("Tamaño");
		JMenuItem small = new JMenuItem("12");
		JMenuItem smallMedium = new JMenuItem("16");
		JMenuItem medium = new JMenuItem("18");
		JMenuItem tall = new JMenuItem("20");
		small.addActionListener(new BarraSize());
		smallMedium.addActionListener(new BarraSize());
		medium.addActionListener(new BarraSize());
		tall.addActionListener(new BarraSize());
		size.add(small);
		size.add(smallMedium);
		size.add(medium);
		size.add(tall);
		return size;

	}

	private JMenuBar barMenu() {
		JMenuBar barMenu = new JMenuBar();
		barMenu.add(getFuente());
		barMenu.add(getEstilo());
		barMenu.add(getSizeF());
		return barMenu;
	}
    private class modificiadorPrincipal implements DocumentListener{
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			
			 String textoSinEspacios = hoja.getText().replace(" ", "");
			for(int i=1; i<=textoSinEspacios.length();i++) {
				numeroLetra.setText(""+i);
			}
			
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			if(hoja.getText().length()==0) {
				numeroLetra.setText(""+0);
			}else {
				 String textoSinEspacios = hoja.getText().replace(" ", "");
					for(int i=1; i<=textoSinEspacios.length();i++) {
						numeroLetra.setText(""+i);
					}
			
			}

		}
    	
    }

	private JTextField numeroLetra = new JTextField();
    private String tipoStyle="Plain";
    private String fuenteTotal;
	private static final long serialVersionUID = -7496279298134415323L;
	private String fuente = "Dialog";
	private int estilo = Font.PLAIN, size = 12;
//	private  int size = 12;
	private JTextPane hoja= new JTextPane();
	private JTextField hojaSur = new JTextField();
}




