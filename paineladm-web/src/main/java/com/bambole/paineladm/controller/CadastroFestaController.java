package com.bambole.paineladm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.bambole.paineladm.ejb.CadastroFesta;
import com.bambole.paineladm.model.Cliente;
import com.bambole.paineladm.model.Festa;

@ManagedBean(name = "cadastroFestaController")
public class CadastroFestaController {
	private String cpf;
	private String contratante;
	private String celular;
	private String email;
	private String tipoFesta;
	private String temaFesta;
	private Integer numConvidados;
	private Boolean conviteVirtual;
	private Date dataFesta;
	private double valor;
	private String observacoes;
	private Cliente cliente;
	private List<Festa> festas;
	
	@EJB(beanName = "CadastroFestaBean")
	private CadastroFesta cadastroFesta;

	@PostConstruct
	public void init() {
		contratante = "";
		celular = "";
		email = "";
		tipoFesta = "";
		temaFesta = "";
		numConvidados = 0;
		conviteVirtual = false;
		dataFesta = null;
		valor = 0.0;
		observacoes = "";
		cpf = "";
		cliente = null;
		festas = cadastroFesta.exibirListaFesta();
	}

	public String direcionaCadastroFesta() {

		return "/restricted/cadastro-festa.xhtml?faces-redirect=true";
	}

	public String cadastraFesta() {

		try {
			cliente = cadastroFesta.buscarCliente(cpf);
			cadastroFesta.cadastrarFesta(cliente, tipoFesta, temaFesta, numConvidados, conviteVirtual, dataFesta, valor,
					observacoes);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso! Festa cadastrada!", "Sucesso! Festa cadastrada!"));
			return "sucesso";
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), e.getMessage()));
			return "restricted/cadastro-festa.xhtml";
		}
	}

	public void buscarCliente(AjaxBehaviorEvent event) {
		try {
			cliente = cadastroFesta.buscarCliente(cpf);
			setCpf(cliente.getCpf());
			setContratante(cliente.getNome());
			setCelular(cliente.getCelular());
			setEmail(cliente.getEmail());
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), e.getMessage()));
		}
	}

	public String getContratante() {
		return contratante;
	}

	public void setContratante(String contratante) {
		this.contratante = contratante;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public CadastroFesta getCadastroFesta() {
		return cadastroFesta;
	}

	public void setCadastroFesta(CadastroFesta cadastroFesta) {
		this.cadastroFesta = cadastroFesta;
	}

	public String getTipoFesta() {
		return tipoFesta;
	}

	public void setTipoFesta(String tipoFesta) {
		this.tipoFesta = tipoFesta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Festa> getFestas() {
		return festas;
	}

	public void setFestas(List<Festa> festas) {
		this.festas = festas;
	}

}
