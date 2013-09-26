package com.clerton.leal.tracker.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.clerton.leal.tracker.R;
import com.clerton.leal.tracker.domain.Workout;
import com.clerton.leal.tracker.domain.WorkoutAdapter;
import com.clerton.leal.tracker.fragment.SimpleDialogFragment;
import com.clerton.leal.tracker.manager.WorkoutManager;
import com.clerton.leal.tracker.util.DateUtil;
import com.clerton.leal.tracker.util.RequestCode;adfasdfasdfasdfasdfsad
import com.clerton.leal.tracker.util.ResultCode;
import com.google.inject.Inject;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@ContentView(R.layout.activity_list_workout)
public class ListWorkoutActivity extends RoboFragmentActivity {

	@InjectView(R.id.buttonOpenWorkout)
	private ImageButton openWorkout;
	
	@InjectView(R.id.textTotalTimeSpent)
	private TextView totalTimeSpent;
	
	@InjectView(R.id.listWorkouts)
	private ListView listView;
	
	@Inject
	private WorkoutManager workoutManager;
	
	@Inject
	private WorkoutAdapter adapter;
	
	@Inject
	private DateUtil dateUtil;
	
	@Inject
	private Resources resources;
	
	private final List<Workout> workouts = new ArrayList<Workout>();
	
	private SimpleDialogFragment simpleDialog;
	
	private Integer workoutToDelete;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setClickListenners();
		setUpListAdapter();
		rebuildList();
	}

	private void setUpListAdapter() {
		adapter.setListProvider(workouts);
		listView.setAdapter(adapter);
	}
	
	private void setTotalTimeSpent() {
		totalTimeSpent.setText(dateUtil.getResourceSpentTime(workoutManager.getTotalSpentTime(),
																resources.getString(R.string.total_time_spent)));
	}

	private void setClickListenners(){
		listView.setOnItemClickListener(onItemClickListener);
		openWorkout.setOnClickListener(onClickOpenWorkoutListener);
	}
	
	public void showDeleteDialog() {
		if( simpleDialog == null ) {
			simpleDialog = new SimpleDialogFragment();
			simpleDialog.setOnClickListener(onDeleteWorkoutListener);
		}
		
		simpleDialog.show(getSupportFragmentManager(), "SimpleDialog");
	}

	private final OnClickListener onClickOpenWorkoutListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			final Intent intent = new Intent(ListWorkoutActivity.this, AddWorkoutActivity.class);
			startActivityForResult(intent, RequestCode.ADD_WORKOUT);
		}
	};
	
	private final OnItemClickListener onItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
			workoutToDelete = (int) id;
			showDeleteDialog();
		}
	};
	
	private final android.content.DialogInterface.OnClickListener onDeleteWorkoutListener = new android.content.DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			workoutManager.delete(workoutToDelete);
			workoutToDelete = null;
			rebuildList();
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if( RequestCode.ADD_WORKOUT == requestCode && ResultCode.WORKOUT_ADDED == resultCode ){
			rebuildList();
		}
	}

	private void rebuildList() {
		workouts.clear();
		workouts.addAll(workoutManager.getAll());
		adapter.notifyDataSetChanged();
		setTotalTimeSpent();
	};
	
}
