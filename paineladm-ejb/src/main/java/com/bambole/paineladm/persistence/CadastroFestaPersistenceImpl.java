package com.bambole.paineladm.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bambole.paineladm.model.Cliente;
import com.bambole.paineladm.model.Festa;

public class CadastroFestaPersistenceImpl implements CadastroFestaPersistence{

	@PersistenceContext(unitName = "PainelAdm")
	private EntityManager em;
	
	public Festa cadastrarFesta(Festa festa) {
		em.persist(festa);
		em.flush();
		return festa;
	}

	public Cliente buscarCliente(String cpf) {
		TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findByCpf", Cliente.class);
		query.setParameter("cpf", cpf);
		
		List<Cliente> u = query.getResultList();
		
		if(u == null || u.isEmpty()) {
			return null;
		}
		return u.get(0);
	}
}
