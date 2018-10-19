package com.bambole.paineladm.utils;

import javax.faces.context.FacesContext;

import com.bambole.paineladm.model.Usuario;

public class ClienteUtils {

	public static Usuario buscaUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		return usuario;
	}
}
