package com.bambole.paineladm.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.bambole.paineladm.ejb.Login;

@ManagedBean(name = "loginController")

public class LoginController implements Serializable {

	private static final long serialVersionUID = 4011293576803461572L;
	private String usuario;
	private String senha;
	
	@EJB(beanName = "LoginBean")
	private Login login;

	@PostConstruct
	public void init() {

		usuario = "";
		senha = "";

	}

	public String logar() {
		Boolean	logado = login.logar(usuario, senha);
		if (logado){
			return "sucesso";
		}else{
			return "falha";
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}