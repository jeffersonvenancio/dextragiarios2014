package com.dextra.dextragiarios2014.atividade2;

public class Filho extends Pai {
	private String nome;

	public Filho() {
		nome = "Josna";
	}

	@Override
	public String abstrado() {
		return nome;
	}

}
