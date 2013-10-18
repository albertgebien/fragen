package br.com.brasiliashopping.persistencia;

import java.io.Serializable;
import java.util.List;

import br.com.brasiliashopping.entidades.EntidadeBase;
import br.com.brasiliashopping.exceptions.BaseException;

public abstract class CrudDAO<T extends EntidadeBase> extends DAO implements
		ICrudDAO<T> {

	private Class<T> clazz;
	
	
	public CrudDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * @param objeto
	 *            o objeto a ser inclu�do.
	 * @
	 *             Caso ocorra alguma exce��o na inclus�o.
	 */
	public T incluir(T objeto) {
		getEntityManager().persist(objeto);
		getEntityManager().flush();
		return objeto;
	}

	/**
	 * @param chave
	 *            A chave da entidade.
	 * @throws Exception 
	 * @
	 *             Caso ocorra alguma exce��o na exclus�o.
	 */
	public void excluir(Serializable chave) throws BaseException  {
		Object objeto = obter(chave);

		if (objeto == null) {
			throw new BaseException("Objeto nulo");
		}

		getEntityManager().remove(objeto);
	}

	/**
	 * @param objeto
	 *            o objeto a ser alterado.
	 * @throws Exception 
	 * @
	 *             Caso ocorra alguma exce��o na altera��o.
	 */
	public void alterar(T objeto) {
		getEntityManager().merge(objeto);
		getEntityManager().flush();
	}

	/**
	 * @return lista de objetos encontrados na consulta padr�o da entidade
	 * @
	 *             Caso ocorra alguma exce��o na listagem.
	 */
	public List<T> listar()  {
		return listar(clazz);
	}

	/**
	 * @param chave
	 *            A chave da entidade.
	 * @return A entidade encontrada.
	 * @
	 *             Caso ocorra alguma exce��o na consulta.
	 */
	public T obter(Serializable chave)  {
		return getEntityManager().find(clazz, chave);
	}
}
