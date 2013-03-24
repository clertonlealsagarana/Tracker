package com.codeminer42.tracker.util;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class TimePickerFragment extends DialogFragment {

	private OnTimeSetListener onTimeSetListener;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new TimePickerDialog(getActivity(), onTimeSetListener, 0, 0, true);
	}
	
	public void setOnTimeSetListener(final OnTimeSetListener onTimeSetListener){
		this.onTimeSetListener = onTimeSetListener;
	}
	
}
