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
	
	public int getSize() {
		return listaParole.size();
	}

}
