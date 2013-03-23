package com.codeminer42.tracker.manager;

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

}
