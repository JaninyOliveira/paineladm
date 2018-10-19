package com.bambole.paineladm.ejb;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bambole.paineladm.model.Cliente;
import com.bambole.paineladm.model.Usuario;
import com.bambole.paineladm.persistence.CadastroClientePersistence;
import com.bambole.paineladm.persistence.LogPersistence;
import com.bambole.paineladm.utils.ClienteUtils;


@Stateless(mappedName = "CadastroClienteBean")
public class CadastroClienteBean implements CadastroCliente{
	
	@Inject
	private CadastroClientePersistence cadastroClientePersistence;
	
	@Inject
	private LogPersistence logPersistence;
	
	@Inject
	private Cliente cliente;
	
	
	public Cliente cadastrarCliente(String nome,String cpf, String celular, String telefone, String email) throws Exception {
		
		Cliente clienteObj = new Cliente();
		clienteObj.setNome(nome);
		clienteObj.setCpf(cpf);
		clienteObj.setCelular(celular);
		clienteObj.setTelefone(telefone);
		clienteObj.setEmail(email);
		
		cliente = cadastroClientePersistence.cadastrarCliente(clienteObj);
		Usuario usuario = ClienteUtils.buscaUsuarioLogado();

		logPersistence.registraLog(usuario, "Cadastro de Cliente");
		
		return cliente;
	}
	

}
