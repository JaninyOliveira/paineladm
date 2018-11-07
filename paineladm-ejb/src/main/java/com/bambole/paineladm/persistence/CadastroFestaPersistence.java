package com.bambole.paineladm.persistence;

import java.util.List;

import com.bambole.paineladm.model.Cliente;
import com.bambole.paineladm.model.Festa;

public interface CadastroFestaPersistence {
	
	public Festa cadastrarFesta(Festa festa);

	public Cliente buscarCliente(String cpf);
	
	public List<Festa> listarFestas();
}
