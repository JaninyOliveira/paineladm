package com.bambole.paineladm.ejb;

public interface Login {
	public Boolean logar(String usuario, String senha);
	public String verificaStatus(String usuario, String senha);

}
