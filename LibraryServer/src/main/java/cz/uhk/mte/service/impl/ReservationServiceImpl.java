package cz.uhk.mte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.mte.model.Reservation;
import cz.uhk.mte.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationService reservationDao;

	@Override
	public void delete(Reservation reservation) {
		reservationDao.delete(reservation);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationDao.getAllReservations();
	}

	@Override
	public Reservation getReservationByID(int ID) {
		return reservationDao.getReservationByID(ID);
	}

	@Override
	public void insertReservation(Reservation reservation) {
		reservationDao.insertReservation(reservation);
	}

	@Override
	public void update(Reservation reservation) {
		reservationDao.update(reservation);
	}

	public ReservationService getReservationDao() {
		return reservationDao;
	}

	public void setReservationDao(ReservationService reservationDao) {
		this.reservationDao = reservationDao;
	}

	
}
