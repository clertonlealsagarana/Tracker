package com.clerton.leal.tracker.manager;

import java.util.List;

/**
 * 
 * @author clertonleal
 * @since 24/03/2013
 * 
 * This interface should be extended by all others managers interfaces.
 * Thus leaving only the specific methods therefor.
 */
public interface AbstractManager<managerType> {
	
	void create(final managerType managerType);
	
	void update(final managerType managerType);
	
	void createOrUpdate(final managerType managerType);
	
	void delete(final Integer id);
	
	managerType getById(final Integer id);
	
	List<managerType> getAll();
	
	void deleteAll();
	
	int countOf();

}
