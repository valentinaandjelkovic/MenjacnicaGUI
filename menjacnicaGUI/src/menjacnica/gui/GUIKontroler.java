package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import menjacnica.Kurs;
import menjacnica.Menjacnica;
import menjacnica.MenjacnicaInterfejs;

public class GUIKontroler extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static MenjacnicaGUI glavniProzor;
	public  static MenjacnicaInterfejs menjacnica;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler frame = new GUIKontroler();
					frame.setVisible(false);
					glavniProzor=new MenjacnicaGUI();
					menjacnica=new Menjacnica();
					glavniProzor.setVisible(true);
					glavniProzor.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIKontroler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public static LinkedList<Kurs> vratiKurnuListu(){
        Menjacnica instance = Menjacnica.getInstance();
		
		return instance.vratiKursnuListu();
	}

	public static void ucitajIzFajla() {
		
		try {
			JFileChooser jfc = new JFileChooser();
			int option = jfc.showOpenDialog(glavniProzor.getContentPane());

			if (option == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				menjacnica.ucitajIzFajla(file.getAbsolutePath());
				glavniProzor.getTextArea().append("Ucitan fajl: " + file.getAbsolutePath() + "\n");
				glavniProzor.osveziTabelu();
	 }
		}catch(Exception e){
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void sacuvajUFajl (){
		try
		{
			JFileChooser jfc = new JFileChooser();
			int option = jfc.showSaveDialog(glavniProzor.getContentPane());

			if (option == JFileChooser.APPROVE_OPTION)
			{
				File file = jfc.getSelectedFile();
				menjacnica.sacuvajUFajl(file.getAbsolutePath());
				glavniProzor.getTextArea().append("Sacuvan fajl: " + file.getAbsolutePath() + "\n"); 
			}
	} catch(Exception e){
		JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(),
				"Greska", JOptionPane.ERROR_MESSAGE);
	}
}
	
	public static void zatvoriAplikaciju(){
		int opcija=JOptionPane.showConfirmDialog(
				glavniProzor.getContentPane(),
				"Da li zelite da izadjete iz aplikacije?",
				"Exit",
				JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION)
			System.exit(0);	
	}

	public static void prikaziInformacije() {
		JOptionPane.showMessageDialog(
				glavniProzor.getContentPane(),
				"Autor: Valentina Andjelkovic 1/14",
				"About",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}
