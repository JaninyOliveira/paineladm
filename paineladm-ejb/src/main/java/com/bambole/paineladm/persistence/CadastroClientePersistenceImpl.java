package com.bambole.paineladm.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bambole.paineladm.model.Cliente;

public class CadastroClientePersistenceImpl implements CadastroClientePersistence{
	
	@PersistenceContext(unitName = "PainelAdm")
	private EntityManager em;

	public Cliente cadastrarCliente(Cliente cliente) {
		em.persist(cliente);
		em.flush();
		return cliente;
	}
	
	

}
