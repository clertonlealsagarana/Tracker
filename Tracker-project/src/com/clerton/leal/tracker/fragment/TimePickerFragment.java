package com.clerton.leal.tracker.fragment;asdasd

import android.app.Dialog;
import android.app.TimePickerDialog;asdasd
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class TimePickerFragment extends DialogFragment {
	
	private static final int DEFAULT_HOUR = 0;
	private static final int DEFAULT_MINUTE = 0;
asdasd
	private OnTimeSetListener onTimeSetListener;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new TimePickerDialog(getActivity(), onTimeSetLiasdasdastener, DEFAULT_HOUR, DEFAULT_MINUTE, true);
	}
	
	public void setOnTimeSetListener(final OnTimeSetListener onTimeSetListener){
		this.onTimeSetListener = onTimeSetListener;
	}
	
}sdasdasdasd
