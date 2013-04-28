package cz.uhk.mte.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.Reservation;
import cz.uhk.mte.service.ReservationService;

public class ReservationDao extends HibernateDaoSupport implements ReservationService {

	@Override
	public void delete(Reservation reservation) {
		getHibernateTemplate().delete(reservation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getAllReservations() {
		boolean active = false;
		return getHibernateTemplate().find("from Reservation r where r.isActive=?",active);
	}

	@Override
	public Reservation getReservationByID(int ID) {
		return (Reservation) getHibernateTemplate().get(Reservation.class, ID);
	}

	@Override
	public void insertReservation(Reservation reservation) {
		getHibernateTemplate().saveOrUpdate(reservation);
	}

	@Override
	public void update(Reservation reservation) {
		insertReservation(reservation);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getLastInsertedID(Reservation reservation) {
		List<Reservation> r = getHibernateTemplate().find("from Reservation r where r.dateFrom=? and r.dateTo=? and r.student=?",
				reservation.getDateFrom(),reservation.getDateTo(),reservation.getStudent());
		return r.get(0).getID();
	}

}
