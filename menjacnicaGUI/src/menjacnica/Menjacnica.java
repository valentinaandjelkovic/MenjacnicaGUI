package menjacnica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;


public class Menjacnica implements MenjacnicaInterfejs  {
	LinkedList<Kurs> kursnaLista=new LinkedList<>();
	private static Menjacnica instance;
	

	public static Menjacnica getInstance(){
		if(instance == null)
			instance = new Menjacnica();
		return instance;
	}

	
	
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



	@Override
	public void ucitajIzFajla(String putanja) {
		try {
			ObjectInputStream in=new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(putanja)));
			
			LinkedList<Kurs> kursnaLista2 = (LinkedList<Kurs>)(in.readObject());
			kursnaLista.clear();
			kursnaLista.addAll(kursnaLista2);
			
			in.close();
		
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}



	@Override
	public void sacuvajUFajl(String putanja) {
		try{
			ObjectOutputStream out = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(putanja)));
			
			out.writeObject(kursnaLista);
			
			out.close();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}
	}
	}


