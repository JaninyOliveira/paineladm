package com.bambole.paineladm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "festa")
@NamedQueries({
		@NamedQuery(name = "Festa.all", query = "SELECT f FROM Festa f") })
public class Festa implements Serializable {

	private static final long serialVersionUID = -3310428560649134542L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	private Cliente cliente;

	@Column(name = "tipoFesta", unique = false, nullable = false)
	private String tipoFesta;

	@Column(name = "temaFesta", unique = false, nullable = true)
	private String temaFesta;

	@Column(name = "numConvidados", unique = false, nullable = false)
	private Integer numConvidados;

	@Column(name = "conviteVirtual", unique = false, nullable = true)
	private Boolean conviteVirtual;

	@Column(name = "dataFesta", unique = false, nullable = false)
	private Date dataFesta;

	@Column(name = "valor", unique = false, nullable = true)
	private double valor;

	@Column(name = "observacoes", unique = false, nullable = true)
	private String observacoes;

	public Festa() {
		super();
	}

	public Festa(Cliente cliente, String tipoFesta, String temaFesta, Integer numConvidados, Boolean conviteVirtual,
			Date dataFesta, double valor, String observacoes) {
		super();
		this.cliente = cliente;
		this.tipoFesta = tipoFesta;
		this.temaFesta = temaFesta;
		this.numConvidados = numConvidados;
		this.conviteVirtual = conviteVirtual;
		this.dataFesta = dataFesta;
		this.valor = valor;
		this.observacoes = observacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipoFesta() {
		return tipoFesta;
	}

	public void setTipoFesta(String tipoFesta) {
		this.tipoFesta = tipoFesta;
	}

	public String getTemaFesta() {
		return temaFesta;
	}

	public void setTemaFesta(String temaFesta) {
		this.temaFesta = temaFesta;
	}

	public Integer getNumConvidados() {
		return numConvidados;
	}

	public void setNumConvidados(Integer numConvidados) {
		this.numConvidados = numConvidados;
	}

	public Boolean getConviteVirtual() {
		return conviteVirtual;
	}

	public void setConviteVirtual(Boolean conviteVirtual) {
		this.conviteVirtual = conviteVirtual;
	}

	public Date getDataFesta() {
		return dataFesta;
	}

	public void setDataFesta(Date dataFesta) {
		this.dataFesta = dataFesta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
