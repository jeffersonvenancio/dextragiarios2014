package com.dextra.dextragiarios2014.test.atividade7;

import junit.framework.Assert;

import org.junit.Test;

import com.dextra.dextragiarios2014.atividade7.Atividade7;
import com.dextra.dextragiarios2014.atividade7.Comparator;

public class Atividade7Test {

	@Test
	public void verificaData(){
		Atividade7 calendario = new Atividade7();
		Assert.assertTrue(calendario.verificaData(1l, 1l, 1l));
	}
	
	@Test
	public void verificaString(){
		Comparator comparator = new Comparator();
		Assert.assertTrue(comparator.comparaStrings("Teste", "tesTe","tEste"));
	}
	
	
}
