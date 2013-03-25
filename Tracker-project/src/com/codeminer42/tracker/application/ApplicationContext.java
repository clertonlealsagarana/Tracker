package com.codeminer42.tracker.application;

import com.codeminer42.tracker.R;
import com.codeminer42.tracker.module.ManagerModuleConfiguration;
import com.codeminer42.tracker.util.DateUtil;
import com.google.inject.Inject;

import roboguice.RoboGuice;
import android.app.Application;
import android.content.res.Resources;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class ApplicationContext extends Application{
	
	@Inject
	private DateUtil dateUtil;
	
	@Inject
	private Resources resources;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE,
				RoboGuice.newDefaultRoboModule(this), new ManagerModuleConfiguration());
		
		// Set the default date pattern from language file in dateUtil
		dateUtil.setPattern(resources.getString(R.string.datePattern));
	}

}
