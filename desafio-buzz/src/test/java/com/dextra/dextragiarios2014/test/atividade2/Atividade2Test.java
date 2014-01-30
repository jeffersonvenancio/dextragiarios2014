package com.dextra.dextragiarios2014.test.atividade2;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.dextra.dextragiarios2014.atividade2.Filho;

public class Atividade2Test {

	@Test
	public void teste1() {
		Filho f = new Filho();

		assertNotNull(f.abstrado());
	}

}
