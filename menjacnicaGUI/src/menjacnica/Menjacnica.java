package menjacnica;

import java.util.LinkedList;

public class Menjacnica implements MenjacnicaInterfejs  {
	LinkedList<Kurs> valute;
	

	public Menjacnica() {
		valute=new LinkedList<>();
	}
	
	
	@Override
	public void ubaciKurs(Kurs k) {
		if(k==null){
			throw new RuntimeException("Greska");
			
		}
		if(valute.contains(k)){
			return;
		}
		
		valute.add(k);
		
	}

	@Override
	public void izbrisiKurs(Kurs k) {
		if(k==null){
			throw new RuntimeException("Greska");
		}
		if(valute.contains(k)){
			valute.remove(k);
		} 
	}

	@Override
	public Kurs vratiKurs(String naziv) {
		for (int i = 0; i < valute.size(); i++) {
			if(valute.get(i).getNaziv().equals(naziv)){
				return valute.get(i);
			}
		}
		
		return null;
	}
	
}

