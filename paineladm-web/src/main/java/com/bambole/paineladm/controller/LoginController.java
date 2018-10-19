package com.bambole.paineladm.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.bambole.paineladm.ejb.Login;
import com.bambole.paineladm.model.Usuario;
import com.bambole.paineladm.session.SessionContext;

@SessionScoped
@ManagedBean(name = "loginController")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 4011293576803461572L;
	private String usuario;
	private String senha;

	@EJB(beanName = "LoginBean")
	private Login login;

	public Usuario getUser() {
		return (Usuario) SessionContext.getInstance().getUsuarioLogado();
	}

	@PostConstruct
	public void init() {

		usuario = "";
		senha = "";

	}

	public String logar() {

		try {
			Usuario u = login.logar(usuario, senha);
			SessionContext.getInstance().setAttribute("usuarioLogado", u);
			return login.verificaStatus(usuario, senha);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), e.getMessage()));
			return "errologin";
		}

	}

	public String doLogout() {
		SessionContext.getInstance().encerrarSessao();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Logout efetuado com sucesso!", "Logout efetuado com sucesso!"));
		return "login";
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