package com.codeminer42.tracker.manager;

import java.util.List;

import com.codeminer42.tracker.domain.Workout;
import com.google.inject.Inject;

/**
 * @author cletonleal@gmail.com
 * @since 23/03/2013
 */
public class WorkoutManager extends AbstractManager<Workout>{
	
	@Inject
	public WorkoutManager() {
		super(Workout.class);
	}
	
	public int getTotalSpentTime(){
		final List<Workout> workouts = getAll();
		int totalTime = 0;
		
		for (Workout workout : workouts) {
			totalTime += workout.getTimeSpentInMinutes();
		}
		
		return totalTime;
	}
	
}
