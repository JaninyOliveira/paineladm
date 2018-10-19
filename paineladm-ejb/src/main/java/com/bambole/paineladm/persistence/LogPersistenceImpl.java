package com.bambole.paineladm.persistence;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bambole.paineladm.model.Log;
import com.bambole.paineladm.model.Usuario;

public class LogPersistenceImpl implements LogPersistence {

	@PersistenceContext(unitName = "PainelAdm")
	private EntityManager em;


	public Log registraLog(Usuario usuario, String acao) {

		Log log = new Log();

		log.setUsuario(usuario);
		log.setAcao(acao);
		log.setDataAcao(new Date());
		em.persist(log);
		em.flush();
		return log;
	}

}
