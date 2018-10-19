package com.bambole.paineladm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class Log implements Serializable{

	private static final long serialVersionUID = -8065076960717636604L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	private Usuario usuario;

	@Column(name = "acao", unique = false, nullable = false)
	private String acao;

	@Column(name = "data_acao", unique = false, nullable = false)
	private Date dataAcao;

	public Log() {
		super();
	}

	public Log(Usuario usuario, String acao, Date dataAcao) {
		super();
		this.usuario = usuario;
		this.acao = acao;
		this.dataAcao = dataAcao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Date getDataAcao() {
		return dataAcao;
	}

	public void setDataAcao(Date dataAcao) {
		this.dataAcao = dataAcao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
