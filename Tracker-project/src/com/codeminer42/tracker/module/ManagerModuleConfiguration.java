package com.codeminer42.tracker.module;

import com.codeminer42.tracker.database.DatabaseHelper;
import com.codeminer42.tracker.manager.WorkoutManager;
import com.codeminer42.tracker.manager.impl.WorkoutManagerImpl;
import com.codeminer42.tracker.util.DateUtil;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class ManagerModuleConfiguration implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(WorkoutManager.class).to(WorkoutManagerImpl.class).in(Scopes.SINGLETON);
		binder.bind(DatabaseHelper.class).in(Scopes.SINGLETON);
		binder.bind(DateUtil.class).in(Scopes.SINGLETON);
	}

}
