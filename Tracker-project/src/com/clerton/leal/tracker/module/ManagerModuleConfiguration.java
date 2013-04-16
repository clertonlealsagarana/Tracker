package com.clerton.leal.tracker.module;

import com.clerton.leal.tracker.database.DatabaseHelper;
import com.clerton.leal.tracker.manager.WorkoutManager;
import com.clerton.leal.tracker.manager.impl.WorkoutManagerImpl;
import com.clerton.leal.tracker.util.DateUtil;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 * 
 * Class responsible for doing the bind between concrete classes and interfaces.
 * And management singletons to injection.
 */
public class ManagerModuleConfiguration implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(WorkoutManager.class).to(WorkoutManagerImpl.class).in(Scopes.SINGLETON);
		binder.bind(DatabaseHelper.class).in(Scopes.SINGLETON);
		binder.bind(DateUtil.class).in(Scopes.SINGLETON);
	}

}
