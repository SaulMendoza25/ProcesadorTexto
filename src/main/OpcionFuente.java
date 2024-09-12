package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class OpcionFuente {

	public JMenu getFuente(JTextField hojaSur, JTextPane hoja) {
		JMenu fuente = new JMenu("Fuente");
		JMenuItem srf = new JMenuItem("Serif");
		JMenuItem djs = new JMenuItem("DejaVu Serif");
		JMenuItem ctl = new JMenuItem("Cantarell");
		srf.addActionListener(new StyledEditorKit.FontFamilyAction("cambio_styke", srf.getText()));
		djs.addActionListener(new StyledEditorKit.FontFamilyAction("cambio_styke", djs.getText()));
		ctl.addActionListener(new StyledEditorKit.FontFamilyAction("cambio_styke", ctl.getText()));
		fuente.add(srf);
		fuente.add(djs);
		fuente.add(ctl);
		return fuente;
	}

	public JMenu getEstilo(JTextField hojaSur, JTextPane hoja) {
		JMenu estilo = new JMenu("Estilo");
		JMenuItem ngt = new JMenuItem("Negrita");
		JMenuItem crv = new JMenuItem("Cursiva");
//		JMenuItem ngt_crv = new JMenuItem("Ambos");
//		JMenuItem quitar = new JMenuItem("Ninguno");
		ngt.addActionListener(new StyledEditorKit.BoldAction());
		crv.addActionListener(new StyledEditorKit.ItalicAction());
//		ngt_crv.addActionListener(new BarraEstilo());
//		quitar.addActionListener(new BarraEstilo());
		estilo.add(ngt);
		estilo.add(crv);
		estilo.addSeparator();
//		estilo.add(ngt_crv);
//		estilo.add(quitar);
		return estilo;
	}

	public JMenu getSizeF(JTextField hojaSur, JTextPane hoja) {
		JMenu size = new JMenu("Tamaño");
		JMenuItem small = new JMenuItem("12");
		JMenuItem smallMedium = new JMenuItem("16");
		JMenuItem medium = new JMenuItem("18");
		JMenuItem tall = new JMenuItem("20");
		small.addActionListener(new StyledEditorKit.FontSizeAction("cambio_size",Integer.parseInt(small.getText())));
		smallMedium.addActionListener(new StyledEditorKit.FontSizeAction("cambio_size",Integer.parseInt(smallMedium.getText())));
		medium.addActionListener(new StyledEditorKit.FontSizeAction("cambio_size", Integer.parseInt(medium.getText())));
		tall.addActionListener(new StyledEditorKit.FontSizeAction("cambio_size",Integer.parseInt(tall.getText())));
		size.add(small);
		size.add(smallMedium);
		size.add(medium);
		size.add(tall);
		return size;
	}

	public JTextField posicionPane = new JTextField();

}
