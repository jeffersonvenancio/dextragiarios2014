package com.dextra.dextragiarios2014.test.atividade7;

import junit.framework.Assert;

import org.junit.Test;

import com.dextra.dextragiarios2014.atividade7.Atividade7;

public class Atividade7Test {

	@Test
	public void verificaData(){
		Atividade7 calendario = new Atividade7();
		calendario.setAno(2014);
		calendario.setDia(12);
		calendario.setMes(14);
		Assert.assertTrue(calendario.verificaData(1l, 1l, 1l));
	}
}
