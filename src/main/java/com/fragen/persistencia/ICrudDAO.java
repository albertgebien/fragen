package br.com.brasiliashopping.persistencia;

import java.io.Serializable;
import java.util.List;

import br.com.brasiliashopping.entidades.EntidadeBase;
import br.com.brasiliashopping.exceptions.BaseException;

public interface ICrudDAO<T extends EntidadeBase> {

	/**
	 * Método para incluir um objeto.
	 * 
	 * @param objeto
	 *            o objeto a ser incluído.
	 * @throws BaseException
	 *             Caso ocorra alguma exceção na inclusão.
	 */
	T incluir(T objeto);

	/**
	 * Método para excluir um objeto.
	 * 
	 * @param chave
	 *            A chave da entidade.
	 * @throws BaseException
	 *             Caso ocorra alguma exceção na exclusão.
	 */
	void excluir(Serializable chave)throws BaseException ;

	/**
	 * Método para alterar um objeto.
	 * 
	 * @param objeto
	 *            o objeto a ser alterado.
	 * @throws BaseException
	 *             Caso ocorra alguma exceção na alteração.
	 */
	void alterar(T objeto);

	/**
	 * Método para obter a lista padrão de uma entidade.
	 * 
	 * @return lista de objetos encontrados na consulta padrão da entidade
	 * @throws BaseException
	 *             Caso ocorra alguma exceção na listagem.
	 */
	List<T> listar();

	/**
	 * Método para localizar um único objeto.
	 * 
	 * @param chave
	 *            A chave da entidade.
	 * @return A entidade encontrada.
	 * @throws BaseException
	 *             Caso ocorra alguma exceção na consulta.
	 */
	T obter(Serializable chave);
}
