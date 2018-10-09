package com.bambole.paineladm.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bambole.paineladm.model.Usuario;
import com.bambole.paineladm.persistence.CadastroPersistence;

@Stateless(mappedName = "CadastroBean")
public class CadastroBean implements Cadastro {

	@Inject
	private CadastroPersistence cadastroPersistence;

	public Usuario cadastrar(String usuario, String senha, String tipo) {
		Usuario usuarioObj = new Usuario();
		usuarioObj.setLogin(usuario);
		usuarioObj.setSenha(senha);
		usuarioObj.setAdmin("Admin".equals(tipo));
		usuarioObj.setContratante("Contratante".equals(tipo));
		usuarioObj.setFuncBambole("FuncBambole".equals(tipo));
		
		return cadastroPersistence.cadastrar(usuarioObj);
	}
}
