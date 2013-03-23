package com.codeminer42.tracker.manager;

import java.sql.SQLException;

import roboguice.util.Ln;

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

	public void insert(final Workout workout){
		try {
			getDao().create(workout);
		} catch (SQLException e) {
			Ln.e(e, "Error to insert data");
		}
	}
	
}
