package cz.uhk.mte.service;

import java.util.List;

import cz.uhk.mte.model.Borrowing;

public interface BorrowingService {
	
	public void delete(Borrowing borrowing);

	public List<Borrowing> getAllBorrowings();

	public Borrowing getBorrowingByID(int ID);

	public void insertBorrowing(Borrowing borrowing);

	public void update(Borrowing borrowing);

}
