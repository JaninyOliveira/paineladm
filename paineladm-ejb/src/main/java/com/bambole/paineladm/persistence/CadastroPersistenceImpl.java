package com.bambole.paineladm.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bambole.paineladm.model.Festa;
import com.bambole.paineladm.model.Usuario;

public class CadastroPersistenceImpl implements CadastroPersistence {

	@PersistenceContext(unitName = "PainelAdm")
	private EntityManager em;

	public Usuario cadastrar(Usuario usuario) {

		em.persist(usuario);
		em.flush();
		return usuario;

	}

}
