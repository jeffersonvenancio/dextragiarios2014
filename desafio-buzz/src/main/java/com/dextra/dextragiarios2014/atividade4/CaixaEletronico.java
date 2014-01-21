package com.dextra.dextragiarios2014.atividade4;

import java.util.List;

import javax.persistence.EntityManager;

import com.dextra.dextragiarios2014.comum.Cliente;
import com.dextra.dextragiarios2014.comum.Conta;
import com.dextra.dextragiarios2014.comum.JPAUtils;

public class CaixaEletronico {

	public static List<Conta> listaContasDeCliente(Long idCliente) {
		EntityManager em = null;
		Cliente cliente = null;
		try {
			em = JPAUtils.getEM();
			cliente = em.find(Cliente.class, idCliente);
		} finally { 
			if (em != null)
				em.close();
		}
		
		return cliente.getContas();
	}

	public static void adicionaContaParaCliente(Cliente cliente, Conta conta) {
		EntityManager em = null;
		try {
			em = JPAUtils.getEM();
			em.getTransaction().begin();
			cliente.addConta(conta);
			em.merge(cliente);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
	}
	
}
