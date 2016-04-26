package model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;


public class MenjacnicaModel extends AbstractTableModel {

	String[] kolone={"Sifra", "Skraceni naziv","Prodajni", "Srednji","Kupovni","Naziv"};
	LinkedList<Kurs> kursevi;
	
	public MenjacnicaModel() {
		kursevi=new LinkedList<>();
	}
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return kursevi.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		switch (kolona) {
		case 0: return kursevi.get(red).getSifra();
		case 1: return kursevi.get(red).getSkraceniNaziv();
		case 2: return kursevi.get(red).getProdajni();
		case 3: return kursevi.get(red).getSrednji();
		case 4: return kursevi.get(red).getKupovni();
		case 5: return kursevi.get(red).getNaziv();
			

		default: return "N/A";
	
		}
	}
	
	
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
}
