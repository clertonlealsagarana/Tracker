package com.codeminer42.tracker.activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.codeminer42.tracker.R;
import com.codeminer42.tracker.domain.Workout;
import com.codeminer42.tracker.domain.WorkoutType;
import com.codeminer42.tracker.fragment.DatePickerFragment;
import com.codeminer42.tracker.fragment.TimePickerFragment;
import com.codeminer42.tracker.manager.WorkoutManager;
import com.codeminer42.tracker.util.DateUtil;
import com.codeminer42.tracker.util.ResultCode;
import com.google.inject.Inject;

/**
 * @author clerton@gmail.com
 * @since 23/03/2013
 */
@ContentView(R.layout.activity_add_workout)
public class AddWorkoutActivity extends RoboFragmentActivity {

	@InjectView(R.id.buttonWorkoutTime)
	private Button workoutTime;
	
	@InjectView(R.id.spinnerWorkoutType)
	private Spinner workoutType;
	
	@InjectView(R.id.buttonWorkoutDate)
	private Button workoutDate;
	
	@InjectView(R.id.buttonAddWorkout)
	private Button addWorkout;
	
	@Inject
	private DateUtil dateUtil;
	
	@Inject
	private WorkoutManager workoutManager;
	
	@Inject
	private Resources resources;
	
	private final Workout workout = new Workout();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setupSpinerAdapter();
		setListenners();
	}

	private void setListenners() {
		workoutType.setOnItemSelectedListener(onItemSelectedListener);
		addWorkout.setOnClickListener(onAddWorkoutClickListener);
	}

	private void setupSpinerAdapter() {
		final List<String> workoutTypes = getWorkoutTypes();
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, workoutTypes);
		workoutType.setAdapter(adapter);
	}

	private List<String> getWorkoutTypes() {
		final List<String> workoutTypes = new ArrayList<String>();
		
		for (WorkoutType type : WorkoutType.values()) {
			workoutTypes.add(resources.getString(type.getResourceKey()));
		}
		
		return workoutTypes;
	}
	
	/**
	 * This method will be called when the date button is pressed. The bind are in xml layout
	 */
	public void showDatePickerDialog(final View view) {
		final DatePickerFragment datePickerFragment = new DatePickerFragment();
		datePickerFragment.setOnDateSetListener(onDateSetListener);
		datePickerFragment.show(getSupportFragmentManager(), "DatePicker");
	}
	
	/**
	 * This method will be called when the time button is pressed. The bind are in xml layout
	 */
	public void showTimePickerDialog(final View view){
		final TimePickerFragment timePickerFragment = new TimePickerFragment();
		timePickerFragment.setOnTimeSetListener(onTimeSetListener);
		timePickerFragment.show(getSupportFragmentManager(), "TimePicker");
	}
	
	private final OnDateSetListener onDateSetListener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int month, int day) {
			final Date date = dateUtil.getDate(year, month, day);
			workoutDate.setText(dateUtil.getFormatedDate(date));
			workout.setDate(date);
		}
	};
	
	private final OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hours, int minutes) {
			workoutTime.setText(dateUtil.getResourceSpentTime(hours, minutes, resources.getString(R.string.time_spent)));
			final int timeSpentInMinutes = ((hours * 60) + minutes);
			workout.setTimeSpentInMinutes(timeSpentInMinutes);
		}
	};
	
	private final OnItemSelectedListener onItemSelectedListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			workout.setType(WorkoutType.values()[position]);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {}
		
	};
	
	private final OnClickListener onAddWorkoutClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if( workout.getTimeSpentInMinutes() == null ){
				Toast.makeText(AddWorkoutActivity.this, resources.getString(R.string.time_needed), Toast.LENGTH_LONG).show();
				
			} else if( workout.getType() == null ){
				Toast.makeText(AddWorkoutActivity.this, resources.getString(R.string.type_needed), Toast.LENGTH_LONG).show();
				
			} else if( workout.getDate() == null ){
				Toast.makeText(AddWorkoutActivity.this, resources.getString(R.string.date_needed), Toast.LENGTH_LONG).show();
				
			} else{
				workoutManager.create(workout);
				Toast.makeText(AddWorkoutActivity.this, resources.getString(R.string.workout_saved), Toast.LENGTH_LONG).show();
				setResult(ResultCode.WORKOUT_ADDED);
				finish();
				
			}
		}
	};
	
}
