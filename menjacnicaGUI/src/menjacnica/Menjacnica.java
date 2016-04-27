package menjacnica;

import java.util.LinkedList;

public class Menjacnica implements MenjacnicaInterfejs  {
	LinkedList<Kurs> kursnaLista=new LinkedList<>();
	


	
	
	@Override
	public void ubaciKurs(Kurs k) {
		if(k==null){
			throw new RuntimeException("Greska");
			
		}
		if(kursnaLista.contains(k)){
			return;
		}
		
		kursnaLista.add(k);
		
	}

	@Override
	public void izbrisiKurs(Kurs k) {
		if(k==null){
			throw new RuntimeException("Greska");
		}
		if(kursnaLista.contains(k)){
			kursnaLista.remove(k);
		} 
	}

	@Override
	public Kurs vratiKurs(String naziv) {
		for (int i = 0; i < kursnaLista.size(); i++) {
			if(kursnaLista.get(i).getNaziv().equals(naziv)){
				return kursnaLista.get(i);
			}
		}
		
		return null;
	}
	
	public LinkedList<Kurs> vratiKursnuListu(){
		return kursnaLista;
	}
}

