package com.codeminer42.tracker.domain;

import java.util.Date;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class Workout {
	
	private Long timeSpent;
	
	private WorkoutType type;
	
	private Date date;

	
	public Long getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(Long timeSpent) {
		this.timeSpent = timeSpent;
	}

	public WorkoutType getType() {
		return type;
	}

	public void setType(WorkoutType type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
