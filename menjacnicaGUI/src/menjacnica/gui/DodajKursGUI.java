package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JLabel lblProdajniKurs;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtKupovni;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtProdajni;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSrednji;
	private JTextField txtSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setTitle("Dodaj kurs");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 2, 5, 5));
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTxtSifra());
		contentPane.add(getTxtNaziv());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTxtKupovni());
		contentPane.add(getTxtProdajni());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTxtSrednji());
		contentPane.add(getTxtSkraceniNaziv());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setMaximumSize(new Dimension(32, 14));
			lblSifra.setMinimumSize(new Dimension(32, 14));
			lblSifra.setPreferredSize(new Dimension(32, 14));
		}
		return lblSifra;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}
		return lblNaziv;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}
	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setColumns(10);
		}
		return txtNaziv;
	}
	private JTextField getTxtKupovni() {
		if (txtKupovni == null) {
			txtKupovni = new JTextField();
			txtKupovni.setColumns(10);
		}
		return txtKupovni;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Kupovni kurs");
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Srednji kurs");
		}
		return lblNewLabel_1;
	}
	private JTextField getTxtProdajni() {
		if (txtProdajni == null) {
			txtProdajni = new JTextField();
			txtProdajni.setColumns(10);
		}
		return txtProdajni;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTxtSrednji() {
		if (txtSrednji == null) {
			txtSrednji = new JTextField();
			txtSrednji.setColumns(10);
		}
		return txtSrednji;
	}
	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setColumns(10);
		}
		return txtSkraceniNaziv;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.dodajKurs(txtNaziv.getText(), Double.parseDouble(txtKupovni.getText()),
							Double.parseDouble(txtProdajni.getText()), Double.parseDouble(txtSrednji.getText()), txtSifra.getText(),
							txtSkraceniNaziv.getText());
					obrisiPolja();
					dispose();
				}

				private void obrisiPolja() {
					txtKupovni.setText(null);
					txtProdajni.setText(null);
					txtSrednji.setText(null);
					txtSkraceniNaziv.setText(null);
					txtNaziv.setText(null);
					txtSifra.setText(null);
				}
			});
		}
		return btnDodaj;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
}
