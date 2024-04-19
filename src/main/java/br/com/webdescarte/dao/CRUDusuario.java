package br.com.webdescarte.dao;

public interface CRUDusuario<T> extends CRUDdescarte<T> {
		boolean login(T dados);
		String alterarSenha (T dados);
		String apagar(Integer id);
	}
	 

