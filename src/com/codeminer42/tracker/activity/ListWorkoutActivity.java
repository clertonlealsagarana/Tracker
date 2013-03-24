package com.codeminer42.tracker.activity;

import roboguice.activity.RoboListActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.view.Menu;

import com.codeminer42.tracker.manager.WorkoutManager;
import com.codeminer42.traker.R;
import com.google.inject.Inject;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@ContentView(R.layout.activity_list_workout)
public class ListWorkoutActivity extends RoboListActivity {

	@Inject
	private WorkoutManager workoutManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list_workout, menu);
		return true;
	}

}
