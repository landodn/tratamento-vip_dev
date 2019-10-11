package br.com.tratamentovip.core.persistence.repository.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.tratamentovip.core.persistence.repository.DAO;

public abstract class AbstractDAOImpl<T, ID extends Serializable> implements DAO<T, ID> {
	
    private Class<T> persistentClass;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    protected CriteriaBuilder cb;
 
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(final DataSource dataSource) {	
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
    
    /**
     * 
     */
    @SuppressWarnings("unchecked")
	public AbstractDAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

	/**
	 * @return
	 */
	public Class<T> getPersistentClass() {
        return persistentClass;
    }
	
 
    public EntityManager getEntityManager() {
		return entityManager;
	}
    
    @Transactional (propagation = Propagation.SUPPORTS, readOnly = true)
    public T findById(ID id, boolean lock) {
        T entity;
        if (lock)
            entity = (T) entityManager.find(getPersistentClass(), id, LockModeType.WRITE);
        else
            entity = (T) entityManager.find(getPersistentClass(), id);
 
        return entity;
    }
 

  
    @SuppressWarnings("unchecked")
	public List<T> findAll() {
    	return entityManager.createQuery(new StringBuilder("select entity from ")
    					.append(getPersistentClass().getSimpleName())
    					.append(" as entity").toString())
    			.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<T> findColunaId(String coluna, Integer id) {
       	return entityManager.createQuery(new StringBuilder("select entity from ")
       					.append(getPersistentClass().getSimpleName())
       					.append(" where " + coluna + " = " + id)
       					.append(" as entity").toString())
       			.getResultList();
       }
 
  
    public T update(T entity) {
    	T entityPersist = entityManager.merge(entity);
    	flush();
    	return entityPersist;
    }
    
    public void update(){
    	entityManager.merge(persistentClass);
    	flush();
    }
    
    public void persist(T entity){
    	entityManager.persist(entity);
    	flush();
    }
    
    public void persist(){
    	entityManager.persist(persistentClass);
    	flush();
    }
 
   
    public void makeTransient(T entity) {
    	entityManager.remove(entity);
    }
    
    public void delete(Integer pk){
    	entityManager.remove(entityManager.getReference(getPersistentClass(), pk));
    }
    
  
    public void makeTransientByID(ID id) {
    	entityManager.createQuery(new StringBuilder("delete ")
		.append(getPersistentClass().getName())
		.append(" where id = ")
		.append(id)
		.toString()).executeUpdate();
    }

    public long countAll(){
    	return (Long) entityManager.createQuery(new StringBuilder("select count(*) from ")
    							.append(getPersistentClass().getName())
    							.toString()).getSingleResult();
    }
 
    /**
     * 
     */
    public void flush() {
    	entityManager.flush();
    }
 
    /**
     * 
     */
    public void clear() {
    	entityManager.clear();
    }
    

    @SuppressWarnings("unchecked")
	public List<T> findEntries(int firstResult, int maxResults){
    	return entityManager.createQuery(new StringBuilder("select entity from ")
    					.append(getPersistentClass().getSimpleName())
    					.append(" as entity").toString())
    		.setFirstResult(firstResult)
    		.setMaxResults(maxResults)
    		.getResultList();
    } 
    
    protected Session getSession() {
		Session session = ((Session) entityManager.getDelegate());
		return session;
	}
    
    protected Criteria createCriteria() {
		return getSession().createCriteria(persistentClass);
	}
    
    
    protected CriteriaQuery<T> getCriteria(){
    	cb = entityManager.getCriteriaBuilder();
    	CriteriaQuery<T> cQuery = cb.createQuery(persistentClass);
    	return cQuery;
    }

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
    
    
}
