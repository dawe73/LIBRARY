package cz.uhk.mte.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import android.app.Fragment;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import cz.uhk.mte.entity.ReservationAndroid;
import cz.uhk.mte.global.Globals;

public class LiteDbPersistenceService implements ILocalPersistenceService {

	private DbHelper orm;
	
	public LiteDbPersistenceService(){
		
		
	}
	
	private DbHelper getOrm() {
		if (orm == null) {
			orm = OpenHelperManager.getHelper(Globals.CURRENT_ACTIVITY, DbHelper.class);
		}
		return orm;
	}
	
	@Override
	public boolean InsertReservation(ReservationAndroid reservation) {

		try {
			
			Dao<ReservationAndroid, Integer> dao = getOrm().getDao(ReservationAndroid.class);
			dao.createIfNotExists(reservation);
			
			return true;
		} catch (SQLException e) {
			
			Log.e("Insert Reservation", "Error inserting reservation: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<ReservationAndroid> GetReservations() {
		
		try {
			Dao<ReservationAndroid, Integer> dao = getOrm().getDao(ReservationAndroid.class);

			ArrayList<ReservationAndroid> allReservations = (ArrayList<ReservationAndroid>) dao.queryForAll();
			
			ArrayList<ReservationAndroid> toDelete = new ArrayList<ReservationAndroid>();
			ArrayList<ReservationAndroid> toReturn = new ArrayList<ReservationAndroid>();
			
			Date now = new Date();
			
			for (ReservationAndroid reservationAndroid : allReservations) {
				if (now.after(reservationAndroid.getDateTo())) {
					toDelete.add(reservationAndroid);
				}
				else {
					toReturn.add(reservationAndroid);
				}
			}
			
			dao.delete(toDelete);
			
			return toReturn;
			
		} catch (SQLException e) {

			Log.e("Get Reservations", "Error loading reservations: " + e.getMessage());
			e.printStackTrace();
			
			return new ArrayList<ReservationAndroid>();
		}
		

	}

}
