package cz.uhk.mte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.mte.model.Borrowing;
import cz.uhk.mte.service.BorrowingService;

public class BorrowingServiceImpl implements BorrowingService {
	@Autowired
	private BorrowingService borrowingDao;

	@Override
	public void delete(Borrowing borrowing) {
		borrowingDao.delete(borrowing);
	}

	@Override
	public List<Borrowing> getAllBorrowings() {
		return borrowingDao.getAllBorrowings();
	}

	@Override
	public Borrowing getBorrowingByID(int ID) {
		return borrowingDao.getBorrowingByID(ID);
	}

	@Override
	public void insertBorrowing(Borrowing borrowing) {
		borrowingDao.insertBorrowing(borrowing);
	}

	@Override
	public void update(Borrowing borrowing) {
		borrowingDao.update(borrowing);
	}

	public BorrowingService getBorrowingDao() {
		return borrowingDao;
	}

	public void setBorrowingDao(BorrowingService borrowingDao) {
		this.borrowingDao = borrowingDao;
	}

	
}
