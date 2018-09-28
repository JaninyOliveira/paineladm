package com.bambole.paineladm.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bambole.paineladm.model.Usuario;
import com.bambole.paineladm.persistence.LoginPersistence;

@Stateless
public class LoginBean implements Login{
	
	@Inject
	private LoginPersistence loginPersistence;

	public Boolean logar(String usuario, String senha) {
		Usuario usuarioObj = loginPersistence.logar(usuario,senha);
		return null;
	}
	

}
