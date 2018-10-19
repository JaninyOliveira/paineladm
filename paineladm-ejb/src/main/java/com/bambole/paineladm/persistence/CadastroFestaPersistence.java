package com.bambole.paineladm.persistence;

import com.bambole.paineladm.model.Cliente;
import com.bambole.paineladm.model.Festa;

public interface CadastroFestaPersistence {
	
	public Festa cadastrarFesta(Festa festa);

	public Cliente buscarCliente(String cpf);
}
