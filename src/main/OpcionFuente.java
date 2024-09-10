package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class OpcionFuente {

	public JMenu getFuente(JTextField hojaSur, JTextPane hoja) {
		class BarraFuente implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				fuente = e.getActionCommand();
				hoja.setFont(new Font(fuente, estilo, size));
				fuenteTotal = "La fuente es: " + fuente + "  estilo es: " + tipoStyle + " el tamaño es:" + size;
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

	public JMenu getEstilo(JTextField hojaSur, JTextPane hoja) {
		class BarraEstilo implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand() == "Negrita") {

					estilo = Font.BOLD;
					tipoStyle = "Bold";
				} else if (e.getActionCommand() == "Cursiva") {
					estilo = Font.ITALIC;
					tipoStyle = "Italic";
				} else if (e.getActionCommand() == "Ambos") {
					estilo = Font.BOLD | Font.ITALIC;
					tipoStyle = "Bold y Italic";
				} else {
					estilo = Font.PLAIN;
					tipoStyle = "Plain";
				}

				hoja.setFont(new Font(fuente, estilo, size));
				fuenteTotal = "La fuente es: " + fuente + "  estilo es: " + tipoStyle + " el tamaño es:" + size;
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

	public JMenu getSizeF(JTextField hojaSur, JTextPane hoja) {
		class BarraSize implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				size = Integer.parseInt(e.getActionCommand());
				hoja.setFont(new Font(fuente, estilo, size));
				fuenteTotal = "La fuente es: " + fuente + "  estilo es: " + tipoStyle + " el tamaño es:" + size;
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

	public JTextField posicionPane = new JTextField();
	private String tipoStyle = "Plain";
	private String fuenteTotal;
	private String fuente = "Dialog";
	private int estilo = Font.PLAIN, size = 12;

}
