package br.com.tratamentovip.core.persistence.repository;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, ID extends Serializable> {

	/** Save entity.
	 * @param entity
	 * @return Persistent entity
	 */
	T update(T entity);

	void persist(T entity);
	
	/** Remove entity.
	 * @param entity
	 */
	void makeTransient(T entity);

	/** Remove entity by id.
	 * @param entity
	 */
	void makeTransientByID(ID id);

	/** Count all entities.
	 * @return
	 */
	long countAll();

	/** Find an entity by it id.
	 * @param id
	 * @param lock
	 * @return
	 */
	T findById(ID id, boolean lock);
	

	/** Find an entity by it id.
	 * @param coluna
	 * @param id
	 * @return
	 */
	List<T> findColunaId(String coluna,ID id);

	/** Return all entities.
	 * @return
	 */
	List<T> findAll();

	/** Find a range of entities.
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	List<T> findEntries(int firstResult, int maxResults);
}
