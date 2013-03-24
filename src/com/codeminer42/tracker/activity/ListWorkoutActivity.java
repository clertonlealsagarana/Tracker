package com.codeminer42.tracker.activity;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.view.Menu;

import com.codeminer42.tracker.manager.WorkoutManager;
import com.codeminer42.tracker.util.DatePicker;
import com.codeminer42.traker.R;
import com.google.inject.Inject;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@ContentView(R.layout.activity_list_workout)
public class ListWorkoutActivity extends RoboFragmentActivity {

	@Inject
	private WorkoutManager workoutManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TimePicker timePicker = new TimePicker();
		//timePicker.show(getSupportFragmentManager(), "TimePicker");
		DatePicker datePicker = new DatePicker();
		datePicker.show(getSupportFragmentManager(), "DatePicker");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list_workout, menu);
		return true;
	}

}
