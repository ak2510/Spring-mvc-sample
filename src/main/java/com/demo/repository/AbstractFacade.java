package com.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractFacade<T> implements BaseFacade<T> {

	private Class<T> entityClass;

    /**
     * Instantiates a new abstract facade.
     * 
     * @param entityClass
     *            the entity class
     * @param entityManager
     *            the entity manager
     */
    public AbstractFacade(Class<T> entityClass) {
	this.entityClass = entityClass;
    }

    /**
     * Gets the entity manager.
     * 
     * @return the entity manager
     */
    protected abstract EntityManager getEntityManager();

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#refresh(java.lang.Object)
     */
    @Override
    public T refresh(T entity) {
	this.getEntityManager().refresh(entity);
	return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#create(java.lang.Object)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T create(T entity) {
	this.getEntityManager().persist(entity);
	return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#edit(java.lang.Object)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T edit(T entity) {
	this.getEntityManager().merge(entity);
	return entity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#remove(java.lang.Object)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(T entity) {
	this.getEntityManager().remove(this.getEntityManager().merge(entity));
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#find(java.lang.Long)
     */
    @Override
    public T find(Object primaryKeyObject) {
	return this.getEntityManager().find(entityClass, primaryKeyObject);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#findAll()
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List<T> findAll() {
	CriteriaQuery cq = this.getEntityManager().getCriteriaBuilder()
		.createQuery();
	cq.select(cq.from(entityClass));
	return this.getEntityManager().createQuery(cq).getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#persist(java.util.List)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void persist(T entity) {
	this.getEntityManager().persist(entity);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.shc.bms.model.facade.base.BaseFacade#evict(java.util.List)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void evict(T entity) {
	this.getEntityManager().detach(entity);
    }
   
    @SuppressWarnings("unchecked")
	public List<T> findByQueryString(final String propertyName,
			final Object value) {
		final String queryString = "SELECT h FROM " + entityClass.getName()
				+ " h where h." + propertyName + "= :propertyValue";
		Query q = this.getEntityManager().createQuery(queryString);
		q.setParameter("propertyValue", value);
		return q.getResultList();
	}
    
    @SuppressWarnings("unchecked")
	public List<T> findListByQueryString(final String propertyName,
			final Object valueList) {
		final String queryString = "SELECT h FROM " + entityClass.getName()
				+ " h where h." + propertyName + " IN :propertyValue";
		Query q = this.getEntityManager().createQuery(queryString);
		q.setParameter("propertyValue", valueList);
		return q.getResultList();
	}
    
	public List<T> findAllByPage(int page,int size) {
		final String queryString = "SELECT h FROM " + entityClass.getName()
		+ " h";
		Query q = this.getEntityManager().createQuery(queryString);
		q.setFirstResult((page - 1) * size);
	    q.setMaxResults(size);
	    return q.getResultList();
	}
}
