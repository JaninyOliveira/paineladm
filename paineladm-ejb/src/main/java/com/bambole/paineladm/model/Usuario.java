package com.bambole.paineladm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({ 
	@NamedQuery(name = "Usuario.findByLoginSenha", query = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
})
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 424541672691355778L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "login", unique = true, nullable = false)
	private String login;

	@Column(name = "senha", unique = true, nullable = false)
	private String senha;

	@Column(name = "admin", unique = false, nullable = true)
	private Boolean admin;

	@Column(name = "contratante", unique = false, nullable = true)
	private Boolean contratante;

	@Column(name = "funcBambole", unique = false, nullable = true)
	private Boolean funcBambole;
	
	@OneToMany(mappedBy = "usuario")
	private List<Log> logs;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}