package com.codeminer42.tracker.manager;

import com.codeminer42.tracker.domain.Workout;

/**
 * 
 * @author clertonleal@gmail.com
 * @since 24/03/2013
 */
public interface WorkoutManager extends AbstractManager<Workout>{

	int getTotalSpentTime();
	
}
