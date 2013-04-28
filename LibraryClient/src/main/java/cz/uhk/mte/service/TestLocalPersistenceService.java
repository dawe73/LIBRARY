package cz.uhk.mte.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import cz.uhk.mte.global.Helpers;
import cz.uhk.mte.entity.ReservationAndroid;

public class TestLocalPersistenceService implements ILocalPersistenceService {

	
	private static TestLocalPersistenceService instance = new TestLocalPersistenceService();
	public static TestLocalPersistenceService GetInstance(){
		return instance;
	}
	
	private HashMap<Integer, ReservationAndroid> reservationDataBase;
	
	private TestLocalPersistenceService(){
		reservationDataBase = new HashMap<Integer, ReservationAndroid>();
		
		Random r = new Random();
		
		
		ReservationAndroid reservation = new ReservationAndroid();
		int id = r.nextInt(1000);
		reservationDataBase.put(id, reservation);
		reservation.setBookTitle("Kniha jungli");
		reservation.setDateFrom(new Date());
		reservation.setDateTo(new Date(new Date().getTime() + (1000 * 60 * 60 * 24)));
		reservation.setID(id);
		reservation.setName("Ja");
		reservation.setSurname("Sam");
		
		ReservationAndroid reservation2 = new ReservationAndroid();
		id = r.nextInt(1000);
		reservationDataBase.put(id, reservation2);
		reservation2.setBookTitle("Treba bible");
		reservation2.setDateFrom(new Date());
		reservation2.setDateTo(new Date(new Date().getTime() + (1000 * 60 * 60 * 24)));
		reservation2.setID(id);
		reservation2.setName("Ja");
		reservation2.setSurname("Sam");		
		
		ReservationAndroid reservation3 = new ReservationAndroid();
		id = r.nextInt(1000);
		reservationDataBase.put(id, reservation3);
		reservation3.setBookTitle("Kamasutra");
		reservation3.setDateFrom(new Date());
		reservation3.setDateTo(new Date(new Date().getTime() + (1000 * 60 * 60 * 24)));
		reservation3.setID(id);
		reservation3.setName("Ja");
		reservation3.setSurname("Sam");			
	}
	
	@Override
	public boolean InsertReservation(ReservationAndroid reservation) {
	
		reservationDataBase.put(reservation.getID(), reservation);
		
		return true;
	}

	@Override
	public ArrayList<ReservationAndroid> GetReservations() {
		
		ArrayList<ReservationAndroid> reservations = new ArrayList<ReservationAndroid>();
		
		for (ReservationAndroid reservation : reservationDataBase.values()) {
			reservations.add(reservation);
			
			Helpers.Wait(2);
		}
		
		return reservations;
	}

}
