package com.bambole.paineladm.ejb;

import com.bambole.paineladm.model.Usuario;

public interface Cadastro {
	public Usuario cadastrar(String usuario, String senha, String tipo);
}
