package com.codeminer42.tracker.manager.impl;

import java.util.List;

import com.codeminer42.tracker.domain.Workout;
import com.codeminer42.tracker.manager.WorkoutManager;
import com.google.inject.Inject;

/**
 * @author cletonleal@gmail.com
 * @since 23/03/2013
 */
public class WorkoutManagerImpl extends AbstractManagerImpl<Workout> implements WorkoutManager{
	
	@Inject
	public WorkoutManagerImpl() {
		super(Workout.class);
	}
	
	@Override
	public int getTotalSpentTime(){
		final List<Workout> workouts = getAll();
		int totalTime = 0;
		
		for (Workout workout : workouts) {
			totalTime += workout.getTimeSpentInMinutes();
		}
		
		return totalTime;
	}
	
}
