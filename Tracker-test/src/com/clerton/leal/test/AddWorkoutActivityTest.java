package com.clerton.leal.test;

import java.util.Calendar;
import java.util.List;

import roboguice.RoboGuice;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.clerton.leal.tracker.activity.AddWorkoutActivity;
import com.clerton.leal.tracker.domain.Workout;
import com.clerton.leal.tracker.domain.WorkoutType;
import com.clerton.leal.tracker.manager.WorkoutManager;
import com.clerton.leal.tracker.manager.impl.WorkoutManagerImpl;

/**
 * 
 * @author clertonleal@gmail.com
 * @since 24/03/2013
 */
public class AddWorkoutActivityTest extends ActivityInstrumentationTestCase2<AddWorkoutActivity> {

	private Activity activityContext;
	
	private WorkoutManager workoutManager;
	
	
	public AddWorkoutActivityTest() {
		super("com.clerton.leal.tracker.activity.AddWorkoutActivity", AddWorkoutActivity.class);
	}
	
	/**
	 * Is necessary to get a real context of a activity to manage the dependency injection.
	 * TODO study Roboeletric ou Robotium to manage this context
	 * This will be necessary to create classes test not dependent of a real activity. 
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activityContext = getActivity();
		workoutManager = new WorkoutManagerImpl();
		
		RoboGuice.injectMembers(activityContext, workoutManager);
		setUpTest();
	}

	private void setUpTest() {
		workoutManager.deleteAll();
		Workout workout = null;
		
		for(int x = 0; x < 3; x++){
			workout = new Workout();
			workout.setType(WorkoutType.values()[x]);
			workout.setDate(Calendar.getInstance().getTime());
			workout.setTimeSpentInMinutes(x * 100);
			workoutManager.create(workout);
		}
	}
	
	public void testGetTotalSpentTime() {
		setUpTest();
		
		assertEquals(300, workoutManager.getTotalSpentTime());
		
		Workout workout = new Workout();
		workout.setType(WorkoutType.BIKE);
		workout.setDate(Calendar.getInstance().getTime());
		workout.setTimeSpentInMinutes(400);
		workoutManager.create(workout);
		
		assertEquals(700, workoutManager.getTotalSpentTime());
	}
	
	public void testDelete() {
		setUpTest();
		
		final List<Workout> workouts = workoutManager.getAll();
		final Integer workoutId = workouts.get(0).getId();
		
		workoutManager.delete(workoutId);
		assertEquals(2, workoutManager.countOf());
		
		assertNull(workoutManager.getById(workoutId));
	}
	
	public void testCreate() {
		setUpTest();
		
		final Workout workout = new Workout();
		workout.setType(WorkoutType.SWIMMING);
		workout.setDate(Calendar.getInstance().getTime());
		workout.setTimeSpentInMinutes(400);
		
		workoutManager.create(workout);
		
		assertEquals(4, workoutManager.countOf());
		
		assertNotNull(workout.getId());
	}

	public void testDeleteAll() {
		setUpTest();
		
		workoutManager.deleteAll();
		
		assertEquals(0, workoutManager.countOf());
		
		assertEquals(0, workoutManager.getAll().size());
	}

}
