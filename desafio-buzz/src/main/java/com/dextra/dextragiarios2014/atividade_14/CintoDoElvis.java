package com.dextra.dextragiarios2014.atividade_14;

import java.util.Calendar;

public class CintoDoElvis {
	public static final CintoDoElvis INSTANCIA = new CintoDoElvis();
	private final int tamanhoDoCinto;
	private static final int ANO_ATUAL = Calendar.getInstance().get(
			Calendar.YEAR);

	private CintoDoElvis() {
		tamanhoDoCinto = ANO_ATUAL - 1930;
	}

	public int getTamanhoDoCinto() {
		return tamanhoDoCinto;
	}

	public static void main(String[] args) {
		System.out.println("Elvis veste cinto tamanho " + INSTANCIA.getTamanhoDoCinto()+ ".");
	}
}
