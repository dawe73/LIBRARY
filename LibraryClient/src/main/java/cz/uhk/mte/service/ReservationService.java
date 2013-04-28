package cz.uhk.mte.service;

import java.util.ArrayList;
import java.util.Date;

import cz.uhk.mte.entity.ReservationAndroid;

public class ReservationService {
	ILibraryWebService webService;
	ILocalPersistenceService localPersistenceService;
	
	public ReservationService(){
		webService = LibraryWebServiceFactory.GetInstance().GetWebService();
		localPersistenceService = LocalPersistenceServiceFactory.GetInstance().GetLocalPersistenceService();
	}
	
	public boolean InsertReservation(int bookID, String bookTitle, String name, String surname, String email){
		
		Date date = new Date();
		
		ReservationAndroid reservation = new ReservationAndroid();
		reservation.setDateFrom(date);
		reservation.setDateTo(new Date(date.getTime() + (1000 * 60 * 60 * 24)));
		reservation.setName(name);
		reservation.setSurname(surname);
		reservation.setBookTitle(bookTitle);
		reservation.setEmail(email);
		
		int reservationID = webService.InsertReservation(reservation);
		if (reservationID > 0) {

			reservation.setID(reservationID);
			return localPersistenceService.InsertReservation(reservation);
		}
		return false; 
	}
	
	public ArrayList<ReservationAndroid> GetMyReservations(){
		
		ArrayList<ReservationAndroid> reservations = null;
		reservations = localPersistenceService.GetReservations();
		return reservations;
	}
	
}
