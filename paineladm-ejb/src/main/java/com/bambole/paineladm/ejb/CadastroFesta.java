package com.bambole.paineladm.ejb;

import java.util.Date;

import com.bambole.paineladm.model.Cliente;
import com.bambole.paineladm.model.Festa;

public interface CadastroFesta {
	public Festa cadastrarFesta(Cliente cliente, String tipoFesta, String temaFesta, Integer numConvidados,
			Boolean conviteVirtual, Date dataFesta, double valor, String observacoes) throws Exception;

	public Cliente buscarCliente(String cpf) throws Exception;


}
