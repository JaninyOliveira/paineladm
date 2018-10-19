package com.bambole.paineladm.ejb;

import com.bambole.paineladm.model.Cliente;

public interface CadastroCliente {
	public Cliente cadastrarCliente(String nome,String cpf, String celular, String telefone, String email) throws Exception;
}
