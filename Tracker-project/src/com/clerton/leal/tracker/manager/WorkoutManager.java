package com.clerton.leal.tracker.manager;

import com.clerton.leal.tracker.domain.Workout;

/**
 * 
 * @author clertonleal@gmail.com
 * @since 24/03/2013
 */
public interface WorkoutManager extends AbstractManager<Workout>{

	int getTotalSpentTime();
	
}
