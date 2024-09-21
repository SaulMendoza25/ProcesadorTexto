package main;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
//import java.net.MalformedURLException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MarcoProcesadorTexto extends JFrame {
	private static final long serialVersionUID = 5753965109502493189L;

	public MarcoProcesadorTexto(String [] args) {
		int x = getScreenDefault().width;
		int y = getScreenDefault().height;

		setIconImage(logoMarco());
		
		setTitle("Bloc de Notas");
		setBounds(x / 4, y / 4, x / 2, y / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new LaminaProcesadorTexto());
	}

	private Dimension getScreenDefault() {
		Toolkit heramientaDefault = Toolkit.getDefaultToolkit();
		return heramientaDefault.getScreenSize();
	}

	private Image logoMarco() {
		String	address = "src/images/cuaderno.png";

		return new ImageIcon(address).getImage();

	}
}