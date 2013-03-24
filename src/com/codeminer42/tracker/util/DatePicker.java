/*
 * Copyright 2012 Sagarana Tech.  All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Sagarana Tech ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Sagarana Tech.
 */
package com.codeminer42.tracker.util;

import java.util.Calendar;

import roboguice.util.Ln;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar c = Calendar.getInstance();
		final int year = c.get(Calendar.YEAR);
		final int month = c.get(Calendar.MONTH);
		final int day = c.get(Calendar.DAY_OF_MONTH);

		return new DatePickerDialog(getActivity(), this, year, month, day);
	}

	public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
		Ln.w("");
	}

}