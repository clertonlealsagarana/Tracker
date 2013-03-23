/*
 * Copyright 2012 Sagarana Tech.  All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
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
