package cz.uhk.mte.service;

import java.util.ArrayList;

import cz.uhk.mte.entity.ReservationAndroid;

public interface ILocalPersistenceService {
	
	public boolean InsertReservation(ReservationAndroid reservation);
	
	public ArrayList<ReservationAndroid> GetReservations();
}
