package com.dextra.dextragiarios2014.test.atividade4;

import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.dextra.dextragiarios2014.atividade4.CaixaEletronico;
import com.dextra.dextragiarios2014.comum.Cliente;
import com.dextra.dextragiarios2014.comum.Conta;
import com.dextra.dextragiarios2014.comum.JPAUtils;
import com.dextra.dextragiarios2014.comum.JPA_DB_Utils;

public class Atividade4Test {

	@BeforeClass
	public static void setUp() throws Exception {
		JPA_DB_Utils.start();
	}

	@Test
	public void testAdicionaContaParaCliente() {
		Cliente cliente = criaClienteTeste();
		Conta conta = new Conta(1000);

		CaixaEletronico.adicionaContaParaCliente(cliente, conta);
		//FIXME esse teste nao testa nada
	}

	@Test 
	public void testListaContasDeCliente() {
		Cliente cliente = criaClienteTeste();
		Conta conta = criaContaTeste(1000);
		Conta conta2 = criaContaTeste(-1000);
		cliente.getContas().add(conta);
		cliente.getContas().add(conta2);

		cliente = (Cliente) JPAUtils.merge(cliente);
		List<Conta> contasDeCliente = CaixaEletronico.listaContasDeCliente(1L);
		Assert.assertEquals(2, contasDeCliente.size());
	}
	
	private Cliente criaClienteTeste() {
		return (Cliente) JPAUtils.merge(new Cliente("Jeffinho PehFofo"));
	}
	
	private Conta criaContaTeste(double valor) {
		 return (Conta) JPAUtils.merge(new Conta(valor));
	}
	
}
