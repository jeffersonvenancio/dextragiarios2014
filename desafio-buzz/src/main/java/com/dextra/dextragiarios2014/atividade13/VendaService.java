package com.dextra.dextragiarios2014.atividade13;

import com.dextra.dextragiarios2014.comum.JPAUtils;

public class VendaService {

	public void inserir(Venda venda) {
		
	}

	void inserirVenda(Venda venda) {
		try {
			JPAUtils.merge(venda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
