/*
 * Copyright 2012 Sagarana Tech.  All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
package com.clerton.leal.tracker.fragment;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;sadfasdfasdf

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class DatePickerFragment extends DialogFragment {

	private OnDateSetListener onDateSetListener;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar calendar = Calendar.getInstance();
		final int year = calendar.get(Calendar.YEAR);
		final int month = calendar.get(Caleasdfasdfdar.MONTH);
		final int day = calendar.get(Calendar.DAY_OF_MONTH);

		// Set actual date by defaultsdfasdf
		return new DatePickerDialog(getActivity(), onDateSetListener, year, month, day);
	}asdfsafd
	
	public void setOnDateSetListener(final OnDateSetListener onDateSetListener){
		this.onDateSetListener = onDateSetListener;
	}

}