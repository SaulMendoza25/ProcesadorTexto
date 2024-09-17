package main;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class OpcionFuente {

		private  Icon imagenIcon(String imagen) {
			return new ImageIcon(imagen); 
		}
	public JMenu getFuente(JTextField hojaSur, JTextPane hoja) {
		class FuenteObtener extends StyledEditorKit.FontFamilyAction{

			private static final long serialVersionUID = 4672126712178448083L;
			public FuenteObtener(String nm, String family) {
				super(nm, family);
				
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fuentes=e.getActionCommand();
				super.actionPerformed(e);
				
			}
		}
		JMenu fuente = new JMenu("Fuente");
		fuente.setIcon(imagenIcon("src/images/diseno_de_fuentes.png"));
		JMenuItem srf = new JMenuItem("Serif");
		JMenuItem djs = new JMenuItem("DejaVu Serif");
		JMenuItem ctl = new JMenuItem("Cantarell");
		srf.addActionListener(new FuenteObtener("cambio_style", srf.getText()));
		djs.addActionListener(new FuenteObtener("cambio_style", djs.getText()));
		ctl.addActionListener(new FuenteObtener("cambio_style", ctl.getText()));
		fuente.add(srf);
		fuente.add(djs);
		fuente.add(ctl);
		return fuente;
	}

	public JMenu getEstilo(JTextField hojaSur, JTextPane hoja) {

		JMenu estilo = new JMenu("Estilo");
		estilo.setIcon(imagenIcon("src/images/estilo.png"));
		JCheckBoxMenuItem ngt = new JCheckBoxMenuItem("Negrita",new ImageIcon("src/images/bold.png"));
		KeyStroke controlNegrita = KeyStroke.getKeyStroke( KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK);
		KeyStroke controlCursiva = KeyStroke.getKeyStroke( KeyEvent.VK_I,InputEvent.CTRL_DOWN_MASK);
		JCheckBoxMenuItem crv = new JCheckBoxMenuItem("Cursiva",new ImageIcon("src/images/italic.png"));
		ngt.addActionListener(new StyledEditorKit.BoldAction() {

			private static final long serialVersionUID = 1112331812647558540L;
			int contador=1;
			@Override
			public void actionPerformed(ActionEvent e) {
				if(contador%2==0) {
					estilos="Sin negrita";
					contador++;
				}else {
					estilos="Con negrita";
					contador++;
				}
							
				super.actionPerformed(e);
			}
		});
		ngt.setAccelerator(controlNegrita);
		crv.setAccelerator(controlCursiva);
		crv.addActionListener(new StyledEditorKit.ItalicAction(){
			private static final long serialVersionUID = -1809338000974026141L;
			int contador=1;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(contador%2==0) {
					estilos="Sin cursiva";
					contador++;
				}else {
					estilos="Con cursiva";
					contador++;
				}
				
				super.actionPerformed(e);
			}
		});
		estilo.add(ngt);
		estilo.add(crv);

		return estilo;
	}

	public JMenu getSizeF(JTextField hojaSur, JTextPane hoja) {
		JMenu size = new JMenu("Tamaño");
		size.setIcon(imagenIcon("src/images/tamano-del-texto.png"));
		generadorSize(size, 50);
		return size;
	}
	private void generadorSize(JMenu menuSize,int cantidad) {
		int generador=8;
		JRadioButtonMenuItem generado;
		ButtonGroup grupo = new  ButtonGroup();
//		JRadioButtonMenuItem generador = new JRadioButtonMenuItem("12");
		for (int i = 4; i <= cantidad/2; i++) {
			generado =new JRadioButtonMenuItem(String.valueOf(generador));
			generado.addActionListener(new StyledEditorKit.FontSizeAction("cambio_size",generador));
			grupo.add(generado);
			menuSize.add(generado);
			generador+=2;
		}
		
	}
	public String getFuente() {
		return fuentes;
	}
	public String getEstilos() {
		return estilos;
	}
    private  String fuentes="Dialog";
    private String estilos="Ninguno";
    private int size;
}
