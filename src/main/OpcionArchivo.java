package main;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class OpcionArchivo {
	public JMenuItem getGuardar(JTextPane hoja) {
		JMenuItem guardado = new JMenuItem("Guardar");
		guardado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveText(hoja);

			}
		});
		return guardado;
	}

	public JMenuItem getGuardarComo(JTextPane hoja) {
		JMenuItem guardadoComo = new JMenuItem("Guardar Como");
		guardadoComo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				saveTextGuardar(hoja);

			}
		});
		return guardadoComo;
	}

	private static void saveTextGuardar(JTextPane hoja) {
		
		JFileChooser guardarComo = new JFileChooser();
		
		guardarComo.showSaveDialog(null);
		
		guardarComo.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		File archivo = guardarComo.getSelectedFile();
		guardarFichero(hoja.getText(), archivo);
	}

	public static void guardarFichero(String cadena,  File archivo) {

		
		FileWriter escribir;
		try {
           if(archivo!=null) {
			escribir = new FileWriter(archivo);
			escribir.write(cadena);
			escribir.close();
           }
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
		}
	}

	private static void saveText(JTextPane textPane) {
		// Obtener el StyledDocument del JTextPane
		StyledDocument doc = textPane.getStyledDocument();

		try {
			// Crear un BufferedWriter para escribir el contenido en un archivo de texto
			BufferedWriter writer = new BufferedWriter(new FileWriter("texto_guardado.txt"));

			// Escribir el texto del documento en el archivo
			writer.write(doc.getText(0, doc.getLength()));

			writer.close();

			JOptionPane.showMessageDialog(textPane, "Texto guardado correctamente.");
		} catch (BadLocationException | IOException ex) {
			ex.printStackTrace();
		}
	}
}
