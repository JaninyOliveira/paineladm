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
@Table(name = "cliente")
@NamedQueries({ 
	@NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
})
public class Cliente implements Serializable {

	private static final long serialVersionUID = -2711039748593843644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nome", unique = false, nullable = false)
	private String nome;
	
	@Column(name = "cpf", unique = true, nullable = false)
	private String cpf;

	@Column(name = "celular", unique = false, nullable = false)
	private String celular;

	@Column(name = "telefone", unique = false, nullable = true)
	private String telefone;

	@Column(name = "email", unique = false, nullable = false)
	private String email;

	@OneToMany(mappedBy = "cliente")
	private List<Festa> festas;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String cpf,String celular, String telefone, String email, List<Festa> festas) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.festas = festas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Festa> getFestas() {
		return festas;
	}

	public void setFestas(List<Festa> festas) {
		this.festas = festas;
	}

}
