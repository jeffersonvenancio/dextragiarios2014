package com.dextra.dextragiarios2014.test.atividade12;

import org.junit.Test;

import com.dextra.dextragiarios2014.atividade12.Kombi;
import com.dextra.dextragiarios2014.atividade12.Sogra;

public class KombiTest {

	private Kombi kombi = new Kombi();

	@Test
	public void colocarSograNaKombi() {

		for (int i = 0; i < 20; i++) {
			kombi.add(new Sogra());
		}
		kombi.viaja();
	}

}
