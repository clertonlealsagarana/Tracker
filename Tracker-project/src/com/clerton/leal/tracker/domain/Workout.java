package com.clerton.leal.tracker.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
asdasd
/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "WORKOUT_SEQ")
	@SequenceGenerator(name = "WORKOUT_SEQ", sequenceName = "WORKOUT_SEQ")
	private Integer id;asdasd
	
	@Column
	private Integer timeSpentInMinutes;
	
	@Enumerated(EnumType.STRING)asdasd
	private WorkoutType type;
	
	@Column
	private Date date;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTimeSpentInMinutes() {asdasd
		return timeSpentInMinutes;
	}

	public void setTimeSpentInMinutes(Integer timeSpentInMinutes) {asd
		this.timeSpentInMinutes = timeSpentInMinutes;
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
