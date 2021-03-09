package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	List<String> lista;
		
	public Parole() {
		lista = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		lista.add(p);
	}
	
	class ordineAlfabetico implements Comparator<String>{
		@Override
		public int compare(String stringa1, String stringa2) {
			return stringa1.compareTo(stringa2);
		}	
	}

	public List<String> getElenco() {
		List<String>risultato = new LinkedList<String>(lista);
		Collections.sort(risultato,new ordineAlfabetico());
		return risultato;
	}
	
	public void reset() {
		lista.clear();
	}
	
	public void cancella(String s) {
		lista.remove(s);
	}

	public String stampaElenco() {
		String risultato = "";
    	for(String s : lista) {
    		risultato += s+"\n";
    	}
    	return risultato;
	}

}
