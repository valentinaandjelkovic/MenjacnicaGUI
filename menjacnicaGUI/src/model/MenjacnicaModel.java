package model;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

import menjacnica.Kurs;


public class MenjacnicaModel extends AbstractTableModel {

	private final String[] kolone={"Sifra", "Skraceni naziv","Prodajni", "Srednji","Kupovni","Naziv"};
	private LinkedList<Kurs> kursnaLista;
	
	public MenjacnicaModel(LinkedList<Kurs> kursnaLista) {
		this.kursnaLista=kursnaLista;
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		return kursnaLista.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		switch (kolona) {
		case 0: return kursnaLista.get(red).getSifra();
		case 1: return kursnaLista.get(red).getSkraceniNaziv();
		case 2: return kursnaLista.get(red).getProdajni();
		case 3: return kursnaLista.get(red).getSrednji();
		case 4: return kursnaLista.get(red).getKupovni();
		case 5: return kursnaLista.get(red).getNaziv();
			

		default: return "NN";
	
		}
	}
	
	
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		
		return false;
	}
	
	public Kurs vratiKurs(int index){
		return kursnaLista.get(index);
	}
	
	
	public void ubaciSveUModel(LinkedList<Kurs> kursnaLista){
		this.kursnaLista=kursnaLista;
		fireTableDataChanged();

	}
	
	@Override
	public String getColumnName(int arg0) {
	
		return kolone[arg0];
	}
	
	
	
		
	
	
}
