package com.bambole.paineladm.persistence;

import com.bambole.paineladm.model.Log;
import com.bambole.paineladm.model.Usuario;

public interface LogPersistence {

	public Log registraLog(Usuario usuario, String acao);
}
