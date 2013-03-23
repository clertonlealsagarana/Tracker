package com.codeminer42.tracker.activity;

import com.codeminer42.traker.R;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.view.Menu;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@ContentView(R.layout.activity_list_workout)
public class ListWorkoutActivity extends RoboActivity {

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
