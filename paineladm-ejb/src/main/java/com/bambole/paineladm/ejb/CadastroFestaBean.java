package com.bambole.paineladm.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.bambole.paineladm.model.Cliente;
import com.bambole.paineladm.model.Festa;
import com.bambole.paineladm.model.Usuario;
import com.bambole.paineladm.persistence.CadastroFestaPersistence;
import com.bambole.paineladm.persistence.LogPersistence;
import com.bambole.paineladm.utils.ClienteUtils;

@Stateless(mappedName = "CadastroFestaBean")
public class CadastroFestaBean implements CadastroFesta {

	@Inject
	private CadastroFestaPersistence cadastroFestaPersistence;

	@Inject
	private LogPersistence logPersistence;

	@Inject
	private Festa festa;

	public Festa cadastrarFesta(Cliente cliente, String tipoFesta,
			String temaFesta, Integer numConvidados, Boolean conviteVirtual, Date dataFesta, double valor,
			String observacoes) throws Exception {

		Festa festaObj = new Festa();
		
		festaObj.setCliente(cliente);
		
		festaObj.setTipoFesta(tipoFesta);
		festaObj.setTemaFesta(temaFesta);
		festaObj.setNumConvidados(numConvidados);
		festaObj.setConviteVirtual(conviteVirtual);
		festaObj.setDataFesta(dataFesta);
		festaObj.setValor(valor);
		festaObj.setObservacoes(observacoes);

		festa = cadastroFestaPersistence.cadastrarFesta(festaObj);

		Usuario usuario = ClienteUtils.buscaUsuarioLogado();	

		logPersistence.registraLog(usuario, "Cadastro de Festa");

		return festa;

	}

	public Cliente buscarCliente(String cpf) throws Exception {
		Cliente cliente = cadastroFestaPersistence.buscarCliente(cpf);
		if(cliente == null) {
			throw new Exception("Cliente nao encontrado. Favor verificar o CPF digitado.");
		}
		return cliente;
	}
	
	public List<Festa> exibirListaFesta(){
		
		return cadastroFestaPersistence.listarFestas();
	}
} 
