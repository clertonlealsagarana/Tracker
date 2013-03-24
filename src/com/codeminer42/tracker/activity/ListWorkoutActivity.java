package com.codeminer42.tracker.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.codeminer42.tracker.R;
import com.codeminer42.tracker.manager.WorkoutManager;
import com.codeminer42.tracker.util.RequestCode;
import com.google.inject.Inject;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@ContentView(R.layout.activity_list_workout)
public class ListWorkoutActivity extends RoboActivity {

	@InjectView(R.id.buttonOpenWorkout)
	private Button openWorkout;
	
	@Inject
	private WorkoutManager workoutManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		setClickListenners();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list_workout, menu);
		return true;
	}
	
	private void setClickListenners(){
		openWorkout.setOnClickListener(onClickOpenWorkoutListener);
	}

	private final OnClickListener onClickOpenWorkoutListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			final Intent intent = new Intent(ListWorkoutActivity.this, AddWorkoutActivity.class);
			startActivityForResult(intent, RequestCode.ADD_WORKOUT);
		}
	};
}
