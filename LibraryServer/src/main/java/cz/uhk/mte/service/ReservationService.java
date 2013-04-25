package cz.uhk.mte.service;

import java.util.List;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.IEntity;
import cz.uhk.mte.model.Reservation;

public interface ReservationService {

	public void delete(Reservation reservation);

	public List<Reservation> getAllReservations();

	public Reservation getReservationByID(int ID);

	public void insertReservation(Reservation reservation);

	public void update(Reservation reservation);
}
