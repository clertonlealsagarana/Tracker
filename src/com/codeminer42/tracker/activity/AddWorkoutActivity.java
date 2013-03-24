package com.codeminer42.tracker.activity;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TimePicker;

import com.codeminer42.tracker.fragment.DatePickerFragment;
import com.codeminer42.tracker.fragment.TimePickerFragment;
import com.codeminer42.tracker.util.DateUtil;
import com.codeminer42.traker.R;
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
	
	/**
	 * This method will be called when the date button is pressed. The bind are in xml layout
	 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dateUtil.setPattern(getResources().getString(R.string.datePattern));
	}
	
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
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			workoutDate.setText(dateUtil.getFormatedDate(year, monthOfYear, dayOfMonth));
		}
	};
	
	private final OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			workoutTime.setText(hourOfDay + ":" + minute);
		}
	};
}
