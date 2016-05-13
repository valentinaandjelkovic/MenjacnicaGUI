package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JComboBox comboBox;
	private JLabel lblVrstaTransakcije;
	private JTextField txtKupovni;
	private JTextField txtProdajni;
	private JLabel lblIznos;
	private JTextField txtIznos;
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnNewButton;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;

	private ButtonGroup bg=new ButtonGroup();
	
	
	

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI() {
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getComboBox());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getTxtKupovni());
		contentPane.add(getTxtProdajni());
		contentPane.add(getLblIznos());
		contentPane.add(getTxtIznos());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnNewButton());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(24, 22, 130, 37);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(297, 29, 137, 30);
		}
		return lblProdajniKurs;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(164, 34, 78, 20);
			comboBox.addItem("EUR");
			comboBox.addItem("USD");
			comboBox.addItem("CHF");

		}
		return comboBox;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(233, 119, 137, 30);
		}
		return lblVrstaTransakcije;
	}
	private JTextField getTxtKupovni() {
		if (txtKupovni == null) {
			txtKupovni = new JTextField();
			txtKupovni.setEditable(false);
			txtKupovni.setBounds(22, 70, 107, 20);
			txtKupovni.setColumns(10);
		}
		return txtKupovni;
	}
	private JTextField getTxtProdajni() {
		if (txtProdajni == null) {
			txtProdajni = new JTextField();
			txtProdajni.setEditable(false);
			txtProdajni.setColumns(10);
			txtProdajni.setBounds(285, 70, 107, 20);
		}
		return txtProdajni;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(24, 155, 46, 14);
		}
		return lblIznos;
	}
	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setBounds(24, 174, 105, 20);
			txtIznos.setColumns(15);
			
		}
		return txtIznos;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					txtIznos.setText(""+slider.getValue());
				}
			});
			slider.setPaintLabels(true);
			slider.setSnapToTicks(true);
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(5);
			slider.setMajorTickSpacing(10);
			slider.setBounds(84, 221, 286, 45);
			
		}
		return slider;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String poruka="";
					if(rdbtnKupovina.isSelected()){
						poruka=comboBox.getSelectedItem().toString()+" "+Double.parseDouble(txtIznos.getText())+" kupovina";
					} else {
						poruka=comboBox.getSelectedItem().toString()+" "+Double.parseDouble(txtIznos.getText())+" prodaja";
					}
					GUIKontroler.glavniProzor.getTextArea().append(poruka+" \n");
				}
			});
			btnIzvrsiZamenu.setBounds(35, 293, 123, 23);
		}
		return btnIzvrsiZamenu;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Odustani");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnNewButton.setBounds(303, 293, 89, 23);
		}
		return btnNewButton;
	}
	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setSelected(true);
			bg.add(rdbtnKupovina);
			rdbtnKupovina.setBounds(243, 156, 109, 23);
		}
		return rdbtnKupovina;
	}
	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			bg.add(rdbtnProdaja);
			rdbtnProdaja.setBounds(243, 173, 109, 23);
		}
		return rdbtnProdaja;
	}
}
