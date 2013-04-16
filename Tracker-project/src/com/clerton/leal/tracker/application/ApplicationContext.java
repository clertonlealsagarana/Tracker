package com.clerton.leal.tracker.application;

import com.clerton.leal.tracker.module.ManagerModuleConfiguration;
import com.clerton.leal.tracker.util.DateUtil;
import com.clerton.leal.tracker.R;
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
