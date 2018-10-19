package com.bambole.paineladm.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.bambole.paineladm.ejb.Cadastro;

@ManagedBean(name = "cadastroController")
public class CadastroController {

	private String usuario;
	private String senha;
	private String tipo;

	@EJB(beanName = "CadastroBean")
	private Cadastro cadastro;

	@PostConstruct
	public void init() {

		usuario = "";
		senha = "";
		tipo = "";

	}

	public String cadastrar() {

		return "novousuario";
	}

	public String cadastraNovo() {
		try {
			cadastro.cadastrar(usuario, senha, tipo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso! Usuário cadastrado!", "Sucesso! Usuário cadastrado!"));
			return "login";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), e.getMessage()));
			return "novousuario";
		}

	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

}
