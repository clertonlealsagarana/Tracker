package com.codeminer42.tracker.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.view.Menu;

import com.codeminer42.tracker.domain.Workout;
import com.codeminer42.tracker.manager.WorkoutManager;
import com.codeminer42.traker.R;
import com.google.inject.Inject;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@ContentView(R.layout.activity_list_workout)
public class ListWorkoutActivity extends RoboActivity {

	@Inject
	private WorkoutManager workoutManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		long millis = System.currentTimeMillis();
		Workout simple = new Workout();
		simple.setTimeSpent(millis);
		workoutManager.insert(simple);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list_workout, menu);
		return true;
	}

}
