package br.com.brasiliashopping.servico.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.brasiliashopping.entidades.EntidadeBase;
import br.com.brasiliashopping.exceptions.BaseException;
import br.com.brasiliashopping.persistencia.ICrudDAO;
import br.com.brasiliashopping.servico.interfaces.IBaseService;

@Transactional(readOnly = true)
public abstract class BaseService<T extends EntidadeBase> implements IBaseService<T> {

	public T obter(Serializable id) throws BaseException {
		return getDAO().obter(id);
	}

	@Transactional(readOnly = false)
	public void incluir(T t) throws BaseException {
		getDAO().incluir(t);
	}

	@Transactional(readOnly = false)
	public void alterar(T t) throws BaseException {
		getDAO().alterar(t);
	}

	@Transactional(readOnly = false)
	public void excluir(Serializable chave) throws BaseException {
		getDAO().excluir(chave);
	}

	public List<T> listar() throws BaseException {
		return getDAO().listar();
	}

	protected abstract ICrudDAO<T> getDAO();

}