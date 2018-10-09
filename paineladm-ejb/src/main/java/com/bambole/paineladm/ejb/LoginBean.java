package com.bambole.paineladm.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bambole.paineladm.model.Usuario;
import com.bambole.paineladm.persistence.LoginPersistence;

@Stateless(mappedName = "LoginBean")
public class LoginBean implements Login {

	@Inject
	private LoginPersistence loginPersistence;

	public Boolean logar(String usuario, String senha) {
		Usuario usuarioObj = loginPersistence.logar(usuario, senha);
		return usuarioObj != null;
	}

	public String verificaStatus(String usuario, String senha) {
		Usuario usuarioObj = loginPersistence.logar(usuario, senha);

		if (usuarioObj.getAdmin()) {
			return "admin";
		} else if (usuarioObj.getContratante()) {
			return "contratante";
		} else {
			return "funcBambole";
		}

	}

}
