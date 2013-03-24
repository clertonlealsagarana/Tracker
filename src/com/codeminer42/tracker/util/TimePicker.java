package com.codeminer42.tracker.util;

import java.util.Calendar;

import roboguice.util.Ln;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar calendar = Calendar.getInstance();
		final int hour = calendar.get(Calendar.HOUR_OF_DAY);
		final int minute = calendar.get(Calendar.MINUTE);

		return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
	}
	
	@Override
	public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
		Ln.w("");
	}
	
}
