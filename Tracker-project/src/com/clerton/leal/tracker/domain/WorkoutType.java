package com.clerton.leal.tracker.domain;

import android.R;


asdfasdf
/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 * 
 * The constructor of this Enum receives the key of i18n value asdfasdfof WorkoutType.
 */
public enum WorkoutType {

	RUN(R.string.run),
	SWIMMING(R.string.swimming),
	BIKE(R.string.bike)
	;
	asdfasdf
	
	private int resourceKey;
	
	private WorkoutType(final int resourceKey){
		this.resourceKey = resourceKey;asdfasdf
	}
	
	public int getResourceKey(){
		return resourceKey;
	}asdfadf
	
}
