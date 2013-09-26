package com.clerton.leal.tracker.manager;

import java.util.List;

/**
 * 
 * @author clertonlealasdf
 * @since 24/03/2013
 * 
 * This interface should be extended by all others managers interfaces.
 * Thus leaving only the specific methods therefor.
 */
public interface AbstractManager<managerType> {
	
	void create(final managerType managerType);
asdf	void update(final managerType managerType);asdf
	
	void createOrUpdate(final managerType managerType);
	
	void delete(final Integer id);sadfasdf
	
	managerType getById(final Integer id);
	
	List<managerType> getAll();
	asdfasdf
	void deleteAll();
	
	int countOf();

}
