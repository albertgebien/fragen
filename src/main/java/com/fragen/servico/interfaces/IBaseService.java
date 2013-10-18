package br.com.brasiliashopping.servico.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.brasiliashopping.entidades.EntidadeBase;
import br.com.brasiliashopping.exceptions.BaseException;

public interface IBaseService<T extends EntidadeBase> {

	T obter(Serializable id) throws BaseException;

	void incluir(T t) throws BaseException;

	void alterar(T t) throws BaseException;

	void excluir(Serializable id) throws BaseException;

	List<T> listar() throws BaseException;

}
