package com.bambole.paineladm.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

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
		cadastro.cadastrar(usuario, senha, tipo);
		return "novousuario";
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
