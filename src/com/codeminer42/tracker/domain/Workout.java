package com.codeminer42.tracker.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
@Entity
public class Workout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "STOPTYPE_SEQ")
	@SequenceGenerator(name = "STOPTYPE_SEQ", sequenceName = "STOPTYPE_SEQ")
	private Integer id;
	
	@Column
	private Integer timeSpentInMinutes;
	
	@Enumerated(EnumType.STRING)
	private WorkoutType type;
	
	@Column
	private Date date;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTimeSpentInMinutes() {
		return timeSpentInMinutes;
	}

	public void setTimeSpentInMinutes(Integer timeSpentInMinutes) {
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
