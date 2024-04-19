package br.com.webdescarte.dao;

import java.util.List;

public interface CRUDdescarte<T> {
		String cadastrar(T dados);
		List<T> listar();
		String atualizar(T dados);
		String apagar(Integer id);
		
	}


