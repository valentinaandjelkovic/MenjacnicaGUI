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
	public  static Menjacnica menjacnica;
	public static DodajKursGUI dodajKurs;
	public static IzvrsiZamenuGUI zamena;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIKontroler frame = new GUIKontroler();
					frame.setVisible(false);
					glavniProzor=new MenjacnicaGUI();
					dodajKurs=new DodajKursGUI();
					zamena=new IzvrsiZamenuGUI();
					zamena.setVisible(false);
					dodajKurs.setVisible(false);
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
	
	public static LinkedList<Kurs> vratiKursnuListu(){
		menjacnica= Menjacnica.getInstance();
     return menjacnica.vratiKursnuListu();
     
		
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

	public static void prikaziDodajKursProzor() {
		
		dodajKurs.setLocationRelativeTo(glavniProzor.getContentPane());
		dodajKurs.setVisible(true);
			
		
	}

	public static void dodajKurs(String naziv, double kupovni, double prodajni, double srednji,
			String sifra, String skraceniNaziv) {
		try{
		Kurs k=new Kurs();
		k.setNaziv(naziv);
		k.setKupovni(kupovni);
		k.setProdajni(prodajni);
		k.setSifra(sifra);
		k.setSkraceniNaziv(skraceniNaziv);
		k.setSrednji(srednji);
		
		menjacnica.ubaciKurs(k);
		glavniProzor.osveziTabelu();
		
		glavniProzor.getTextArea().append("Dodat kurs: "+naziv+" "+sifra+" "+kupovni+" "+srednji+" "+prodajni+" "+skraceniNaziv+ "\n");
		

		} catch(Exception e){
			JOptionPane.showMessageDialog(glavniProzor.getContentPane(), e.getMessage(),
					"Greska", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	

	public static void obrisiKurs(int index){
	
		Menjacnica menjacnica= Menjacnica.getInstance();
		
		Kurs k=menjacnica.vratiKursnuListu().get(index);
		
		int odgovor = JOptionPane.showConfirmDialog (
				glavniProzor.getContentPane(), 
				"Da li ste sigurni da zelite da izbrisete kurs?",
				"Obrisi kurs",
				JOptionPane.YES_NO_OPTION);
		
		if(odgovor == JOptionPane.YES_OPTION)
		{
			menjacnica.izbrisiKurs(k);
			glavniProzor.osveziTabelu();
			
			
			
			JOptionPane.showMessageDialog(
					glavniProzor.getContentPane(),
					"Uspesno brisanje kursa",
					"Obrisan kurs",
					JOptionPane.INFORMATION_MESSAGE);
			
			glavniProzor.getTextArea().append("Izbrisan red sa indeksom "+index+ "\n");
}

	}
	
	public static void otvoriProzorIzvrsiZamenu(){
		zamena.setVisible(true);
		zamena.setLocationRelativeTo(null);
	}
	
}