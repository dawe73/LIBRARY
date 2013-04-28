package cz.uhk.mte.service;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import cz.uhk.mte.entity.ReservationAndroid;

public class DbHelper extends OrmLiteSqliteOpenHelper {

	public DbHelper(Context context) {
		super(context, "libraryBase.db", null, 1);

	}
	
	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {
		
		try {
			TableUtils.createTable(connectionSource, ReservationAndroid.class);
		} catch (SQLException e) {
			
			Log.e("Db Create Table", "Error creating table: " + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {

	}

}
