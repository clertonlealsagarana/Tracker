package com.codeminer42.tracker.application;

import com.codeminer42.tracker.module.ManagerModuleConfiguration;

import roboguice.RoboGuice;
import android.app.Application;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class ApplicationContext extends Application{
	
	@Override
	public void onCreate() {
		super.onCreate();
		RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
				RoboGuice.newDefaultRoboModule(this), new ManagerModuleConfiguration());
	}

}
