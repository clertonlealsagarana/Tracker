package com.codeminer42.tracker.adapter;

import java.util.List;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.codeminer42.tracker.R;
import com.codeminer42.tracker.domain.Workout;
import com.codeminer42.tracker.domain.WorkoutRow;
import com.codeminer42.tracker.util.DateUtil;
import com.google.inject.Inject;

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
	private DateUtil dateUtil;
	
	@Inject
	private Resources resources;
	
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
		 row.getTimeSpent().setText(dateUtil.getResourceSpentTime(workout.getTimeSpentInMinutes(),
				 													resources.getString(R.string.time_spent)));
		 row.getWorkoutType().setText(resources.getString(workout.getType().getResourceKey()));
		 row.getWorkoutDate().setText(dateUtil.getFormatedDate(workout.getDate()));
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
