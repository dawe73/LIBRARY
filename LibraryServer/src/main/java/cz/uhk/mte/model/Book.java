package cz.uhk.mte.model;

import java.util.ArrayList;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:49
 */
public class Book extends AbstractDbEntity {

	private ArrayList<Borrowing> ActiveBorrowings;
	private int ActiveBorrowingsCount;
	private ArrayList<Reservation> ActiveReservations;
	private int ActiveReservationsCount;
	private int Available;
	private int AvailableCount;
	private String Bibliography;
	private ArrayList<Borrowing> Borrowings;
	private int BorrowingsCount;
	private Category Category;
	private int Count;
	private String ISBN;
	private String[] Keywords;
	private int MainAuthors;
	private String MainHeading;
	private int PageCount;
	private String PrinterInfo;
	private String Release;
	private int Reservations;
	private int ReservationsCount;
	private int SecondaryAuthors;
	private int Size;
	private String Title;
	public Author m_Author;

	public Book(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}