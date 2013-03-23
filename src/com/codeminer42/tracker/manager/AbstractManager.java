package com.codeminer42.tracker.manager;

import java.sql.SQLException;

import com.codeminer42.tracker.database.DatabaseHelper;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public abstract class AbstractManager<managerType> {

	@Inject
	private DatabaseHelper databaseHelper;
	
	private Class<managerType> clazz;
	
	private Dao<managerType, Integer> dao;
	
	
	public AbstractManager(Class<managerType> clazz){
		this.clazz = clazz;
	}
	
	protected Dao<managerType, Integer> getDao() throws SQLException{
		if(dao == null){
			dao = databaseHelper.getDao(clazz);
		}
		
		return dao;
	}
}
