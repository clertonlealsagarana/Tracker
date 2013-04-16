package com.clerton.leal.tracker.database;

import java.sql.SQLException;

import roboguice.util.Ln;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.clerton.leal.tracker.domain.Workout;
import com.google.inject.Inject;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

/**
 * 
 * @author clertonleal@gmail.com
 * @since 23/03/2013
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "codeminer42.db";
	private static final int DATABASE_VERSION = 1;
	
	@Inject
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase dataBase, ConnectionSource connectionSource) {
		try {
			Ln.i("Creating database");
			TableUtils.createTable(connectionSource, Workout.class);
		} catch (SQLException e) {
			Ln.e(e, "Can't create database");
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase dataBase, ConnectionSource connectionSource, int oldVersion, int newVersion) {}
	
}
