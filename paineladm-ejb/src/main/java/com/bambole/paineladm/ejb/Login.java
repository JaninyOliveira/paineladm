package com.bambole.paineladm.ejb;

import com.bambole.paineladm.model.Usuario;

public interface Login {
	public Usuario logar(String usuario, String senha) throws Exception;
	public String verificaStatus(String usuario, String senha);
	public void verificaUsuario(String usuario, String senha) throws Exception;

}
