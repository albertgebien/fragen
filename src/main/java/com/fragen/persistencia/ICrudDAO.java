package br.com.brasiliashopping.persistencia;

import java.io.Serializable;
import java.util.List;

import br.com.brasiliashopping.entidades.EntidadeBase;
import br.com.brasiliashopping.exceptions.BaseException;

public interface ICrudDAO<T extends EntidadeBase> {

	/**
	 * M�todo para incluir um objeto.
	 * 
	 * @param objeto
	 *            o objeto a ser inclu�do.
	 * @throws BaseException
	 *             Caso ocorra alguma exce��o na inclus�o.
	 */
	T incluir(T objeto);

	/**
	 * M�todo para excluir um objeto.
	 * 
	 * @param chave
	 *            A chave da entidade.
	 * @throws BaseException
	 *             Caso ocorra alguma exce��o na exclus�o.
	 */
	void excluir(Serializable chave)throws BaseException ;

	/**
	 * M�todo para alterar um objeto.
	 * 
	 * @param objeto
	 *            o objeto a ser alterado.
	 * @throws BaseException
	 *             Caso ocorra alguma exce��o na altera��o.
	 */
	void alterar(T objeto);

	/**
	 * M�todo para obter a lista padr�o de uma entidade.
	 * 
	 * @return lista de objetos encontrados na consulta padr�o da entidade
	 * @throws BaseException
	 *             Caso ocorra alguma exce��o na listagem.
	 */
	List<T> listar();

	/**
	 * M�todo para localizar um �nico objeto.
	 * 
	 * @param chave
	 *            A chave da entidade.
	 * @return A entidade encontrada.
	 * @throws BaseException
	 *             Caso ocorra alguma exce��o na consulta.
	 */
	T obter(Serializable chave);
}
