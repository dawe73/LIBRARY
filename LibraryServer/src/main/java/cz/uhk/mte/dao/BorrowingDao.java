package cz.uhk.mte.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Borrowing;
import cz.uhk.mte.service.BorrowingService;

public class BorrowingDao extends HibernateDaoSupport  implements BorrowingService {

	@Override
	public void delete(Borrowing borrowing) {
		getHibernateTemplate().delete(borrowing);		
	}

	@Override
	public List<Borrowing> getAllBorrowings() {
		return getHibernateTemplate().find("from Borrowing");
	}

	@Override
	public Borrowing getBorrowingByID(int ID) {
		return (Borrowing) getHibernateTemplate().get(Borrowing.class, ID);
	}

	@Override
	public void insertBorrowing(Borrowing borrowing) {
		getHibernateTemplate().saveOrUpdate(borrowing);
	}

	@Override
	public void update(Borrowing borrowing) {
		insertBorrowing(borrowing);
	}

}
