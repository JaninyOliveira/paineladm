package com.bambole.paineladm.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bambole.paineladm.model.Usuario;

public class LoginPersistenceImpl implements LoginPersistence{
	
	@PersistenceContext(unitName = "PainelAdm")
	private EntityManager em;

	public Usuario logar(String usuario, String senha) {
		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByLoginSenha", Usuario.class);
		query.setParameter("login", usuario);
		query.setParameter("senha", senha);
		
		Usuario u = query.getSingleResult();
		return u;
	}

}
