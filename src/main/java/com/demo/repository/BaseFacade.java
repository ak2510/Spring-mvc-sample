package com.demo.repository;

import java.util.List;

/**
 * The Interface BaseFacade.
 *
 * @param <T> the generic type
 * 
 * @author bsingh4
 */
public interface BaseFacade<T>
{

	/**
	 * Refresh.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T refresh(T entity);

	/**
	 * Creates the.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T create(T entity);

	/**
	 * Edits the.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T edit(T entity);

	/**
	 * Removes the.
	 *
	 * @param entity the entity
	 */
	public void remove(T entity);

	/**
	 * Find.
	 *
	 * @param primaryKey the primary key
	 * @return the t
	 */
	public T find(Object primaryKeyObject);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<T> findAll();

	/**
	 * Persist.
	 *
	 * @param entity the entity
	 */
	public void persist(T entity);

	/**
	 * Evict.
	 *
	 * @param entity the entity
	 */
	public void evict(T entity);

	public List<T> findByQueryString(final String propertyName,
									 final Object value);

	public List<T> findListByQueryString(final String propertyName,
										 final Object valueList);

	public List<T> findAllByPage(int page,int size);
}
