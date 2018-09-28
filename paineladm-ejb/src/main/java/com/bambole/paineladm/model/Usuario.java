package com.bambole.paineladm.model;

public class Usuario {
	private String login = "";
	private String senha = "";
	private Boolean admin;
	private Boolean contratante;
	private Boolean funcBambole;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, Boolean admin, Boolean contratante, Boolean funcBambole) {
		super();
		this.login = login;
		this.senha = senha;
		this.admin = admin;
		this.contratante = contratante;
		this.funcBambole = funcBambole;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getContratante() {
		return contratante;
	}

	public void setContratante(Boolean contratante) {
		this.contratante = contratante;
	}

	public Boolean getFuncBambole() {
		return funcBambole;
	}

	public void setFuncBambole(Boolean funcBambole) {
		this.funcBambole = funcBambole;
	}

}