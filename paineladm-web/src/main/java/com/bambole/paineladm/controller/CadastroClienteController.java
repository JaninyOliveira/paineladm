package com.bambole.paineladm.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.bambole.paineladm.ejb.CadastroCliente;

@ManagedBean(name = "cadastroClienteController")
public class CadastroClienteController {
	
	private String nome;
	private String cpf;
	private String celular;
	private String telefone;
	private String email;

	
	@EJB(beanName = "CadastroClienteBean")
	CadastroCliente cadastroCliente;
	
	@PostConstruct
	public void init() {

		nome = "";
		cpf = "";
		celular = "";
		telefone = "";
		email = "";

	}
	
	public String cadastrar(){
		return "/restricted/cadastro-cliente.xhtml";
		
	}
	
	public String cadastrarNovo() {
		try {
			cadastroCliente.cadastrarCliente(nome, cpf, celular, telefone, email);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso! Usuário cadastrado!", "Sucesso! Usuário cadastrado!"));
			return "sucesso";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), e.getMessage()));
			return "/restricted/cadastro-cliente.xhtml";
		}

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CadastroCliente getCadastroCliente() {
		return cadastroCliente;
	}

	public void setCadastroCliente(CadastroCliente cadastroCliente) {
		this.cadastroCliente = cadastroCliente;
	}
	
	
}
