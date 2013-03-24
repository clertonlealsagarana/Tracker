package com.codeminer42.tracker.manager;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import roboguice.util.Ln;

import com.codeminer42.tracker.database.DatabaseHelper;
import com.google.inject.Inject;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public abstract class AbstractManager<managerType> {

	@Inject
	private DatabaseHelper databaseHelper;
	
	private Class<managerType> clazz;
	
	private Dao<managerType, Integer> dao;
	
	private QueryBuilder<managerType, Integer> queryBuilder;
	
	
	public AbstractManager(Class<managerType> clazz){
		this.clazz = clazz;
	}
	
	protected Dao<managerType, Integer> getDao() throws SQLException{
		if(dao == null){
			dao = databaseHelper.getDao(clazz);
		}
		
		return dao;
	}
	
	protected QueryBuilder<managerType, Integer> getQueryBuilder() throws SQLException{
		if(queryBuilder == null){
			queryBuilder = getDao().queryBuilder();
		}
		
		queryBuilder.clear();
		
		return queryBuilder;
	}
	
	public void create(final managerType managerType){
		try {
			getDao().create(managerType);
		} catch (SQLException e) {
			Ln.e(e, "Error to create workout");
		}
	}
	
	public void update(final managerType managerType){
		try {
			getDao().update(managerType);
		} catch (SQLException e) {
			Ln.e(e, "Error to update workout");
		}
	}
	
	public void createOrUpdate(final managerType managerType){
		try {
			getDao().createOrUpdate(managerType);
		} catch (SQLException e) {
			Ln.e(e, "Error to createOrUpdate workout");
		}
	}
	
	public managerType getById(final Integer id){
		try {
			return getDao().queryForId(id);
		} catch (SQLException e) {
			Ln.e(e, "Error to getById workout");
		}
		
		return null;
	}
	
	public List<managerType> getAll(){
		try {
			return getDao().queryForAll();
		} catch (SQLException e) {
			Ln.e(e, "Error to getAll workout");
		}
		
		return Collections.emptyList();
	}
}
