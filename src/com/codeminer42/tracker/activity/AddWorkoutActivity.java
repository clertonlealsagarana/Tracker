package com.codeminer42.tracker.activity;

import roboguice.activity.RoboFragmentActivity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.codeminer42.tracker.util.DatePickerFragment;
import com.codeminer42.tracker.util.TimePickerFragment;

/**
 * @author clerton@gmail.com
 * @since 23/03/2013
 */
public class AddWorkoutActivity extends RoboFragmentActivity {

	
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
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			
		}
	};
	
	private final OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			
		}
	};
}
