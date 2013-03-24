package com.codeminer42.tracker.adapter;

import java.util.List;

import com.codeminer42.tracker.R;
import com.codeminer42.tracker.domain.Workout;
import com.codeminer42.tracker.domain.WorkoutRow;
import com.codeminer42.tracker.util.DateUtil;
import com.google.inject.Inject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 
 * @author clertonleal@gmail.com
 * @since 24/03/2013
 */
public class WorkoutAdapter extends BaseAdapter {

	private List<Workout> workouts;
	
	@Inject
	private LayoutInflater inflater;
	
	@Inject
	private Context context;
	
	@Inject
	private DateUtil dateUtil;
	
	@Inject
	public WorkoutAdapter(){}
	
	@Override
	public int getCount() {
		return workouts.size();
	}

	@Override
	public Object getItem(int position) {
		return workouts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return workouts.get(position).getId();
	}
	
	public void setListProvider(final List<Workout> workouts){
		this.workouts = workouts;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		WorkoutRow row = null;
		
		if ( view == null ) {
			view = inflateView();
			row = inflateRow(view);
			view.setTag(row);
		} else {
			row = (WorkoutRow) view.getTag();
		}
		
		fillRow(row, workouts.get(position));
		return view;
	}

	private void fillRow(final WorkoutRow row, final Workout workout) {
		 row.getTimeSpent().setText(getSpentTime(workout.getTimeSpentInMinutes()));
		 row.getWorkoutType().setText(((Activity)context).getResources().getString(workout.getType().getResourceKey()));
		 row.getWorkoutDate().setText(dateUtil.getFormatedDate(workout.getDate()));
	}

	private String getSpentTime(final Long timeSpentInMinutes) {
		final long hours = timeSpentInMinutes / 60;
		final long minutes = timeSpentInMinutes % 60;
		return (hours + ":" + minutes);
	}

	private WorkoutRow inflateRow(final View view) {
		final WorkoutRow row = new WorkoutRow();
		row.setTimeSpent((TextView) view.findViewById(R.id.textRowTimeSpent));
		row.setWorkoutType((TextView) view.findViewById(R.id.textRowType));
		row.setWorkoutDate((TextView) view.findViewById(R.id.textRowDate));
		return row;
	}

	private View inflateView(){
		return inflater.inflate(R.layout.row_workout, null);
	}
	
}
