package com.bambole.paineladm.persistence;

import com.bambole.paineladm.model.Usuario;

public interface LoginPersistence {

	Usuario logar(String usuario, String senha);

}
