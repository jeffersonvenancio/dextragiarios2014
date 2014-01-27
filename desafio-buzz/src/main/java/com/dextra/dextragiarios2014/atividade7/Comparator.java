package com.dextra.dextragiarios2014.atividade7;

public class Comparator {

	public boolean comparaStrings (String...strings) {
		for (int i = 0; i < strings.length; i++ ){
			strings[i] = strings[i].toUpperCase();
		}
		boolean correto = true;
		for (String frase : strings) {
			for (int i = 0; i < strings.length; i++) {
				if (frase != strings[i]) {
					return false;
				}
			}
		}
		
		
		return correto;
		
	}
	
}