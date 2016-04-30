package menjacnica;

import java.util.LinkedList;

public interface MenjacnicaInterfejs {
	public void ubaciKurs (Kurs k);
	public void izbrisiKurs(Kurs k);
	public Kurs vratiKurs(String naziv);
	public LinkedList<Kurs> vratiKursnuListu();
	
	public void ucitajIzFajla(String putanja);
	public void sacuvajUFajl (String putanja);
}
