package com.dextra.dextragiarios2014.test.atividade_14;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.dextra.dextragiarios2014.atividade_14.CintoDoElvis;

public class CintoDoElvisTest {

	@Test
	public void qualOTamanhoDoCintoDoElvisHoje() {
		int tamanhoPrevisto = Calendar.getInstance().get(Calendar.YEAR) - 1930;
		Assert.assertEquals(tamanhoPrevisto,
				CintoDoElvis.INSTANCIA.getTamanhoDoCinto());
	}
}
