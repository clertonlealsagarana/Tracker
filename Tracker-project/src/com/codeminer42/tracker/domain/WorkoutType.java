package com.codeminer42.tracker.domain;

import com.codeminer42.tracker.R;


/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 * 
 * The constructor of this Enum receives the key of i18n value of WorkoutType.
 */
public enum WorkoutType {

	RUN(R.string.run),
	SWIMMING(R.string.swimming),
	BIKE(R.string.bike)
	;
	
	
	private int resourceKey;
	
	private WorkoutType(final int resourceKey){
		this.resourceKey = resourceKey;
	}
	
	public int getResourceKey(){
		return resourceKey;
	}
	
}
