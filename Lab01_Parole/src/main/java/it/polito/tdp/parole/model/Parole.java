package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	LinkedList<String> listaParole;
		
	public Parole() {
		listaParole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear();
	}
	
	public void cancellaParola(String s) {
		listaParole.remove(s);
	}
	
	
	public int getSize() {
		return listaParole.size();
	}
	
	public boolean contiene(String s) {
		if(listaParole.contains(s))
			return true;
		return false;
	}

}
