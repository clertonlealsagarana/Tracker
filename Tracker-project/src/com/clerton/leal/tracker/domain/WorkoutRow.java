package com.clerton.leal.tracker.domain;

import android.widget.TextView;

/**
 * @author clertonleal@gmail.com
 * @since 24/03/2013
 */
public class WorkoutRow {

	private TextView timeSpent;
	
	private TextView workoutType;
	
	private TextView workoutDate;
	

	public TextView getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(TextView timeSpent) {
		this.timeSpent = timeSpent;
	}

	public TextView getWorkoutType() {
		return workoutType;
	}

	public void setWorkoutType(TextView workoutType) {
		this.workoutType = workoutType;
	}

	public TextView getWorkoutDate() {
		return workoutDate;
	}

	public void setWorkoutDate(TextView workoutDate) {
		this.workoutDate = workoutDate;
	}
	
}
