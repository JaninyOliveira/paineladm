package com.bambole.paineladm.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bambole.paineladm.model.Usuario;
import com.bambole.paineladm.persistence.LoginPersistence;

@Stateless(mappedName = "LoginBean")
public class LoginBean implements Login {

	@Inject
	private LoginPersistence loginPersistence;

	public Usuario logar(String usuario, String senha) throws Exception {
		Usuario usuarioObj = loginPersistence.logar(usuario, senha);
		if (usuarioObj == null) {
			throw new Exception(
					"Usuário não Existente ou Senha Inválida! Favor efetuar o cadastro ou verifique a senha informada!");
		}
		
		return usuarioObj;

	}

	public String verificaStatus(String usuario, String senha) {
		Usuario usuarioObj = loginPersistence.logar(usuario, senha);

		if (usuarioObj.getAdmin()) {
			return "restricted/admin";
		} else if (usuarioObj.getContratante()) {
			return "restricted/contratante";
		} else {
			return "restricted/funcBambole";
		}

	}

	public void verificaUsuario(String usuario, String senha) throws Exception {
		Usuario u = loginPersistence.logar(usuario, senha);
		if (u != null) {
			throw new Exception("Usuário já cadastrado!");
		}

	}

}
