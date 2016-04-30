package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
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

}
