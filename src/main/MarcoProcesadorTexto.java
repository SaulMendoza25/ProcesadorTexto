package main;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
		URL url = null;
		String address=null;
//		try {
//			url = new URI(
//					"https://static.wikia.nocookie.net/eswarhammer40k/images/c/c4/Esquema_Primera_Legi%C3%B3n_%C3%81ngeles_Oscuros.png/revision/latest?cb=20150224152846")
//					.toURL();
			address = "src/images/cuaderno.png";
//		} catch (MalformedURLException e) {
//
//			e.printStackTrace();
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new ImageIcon(address).getImage();

	}
}