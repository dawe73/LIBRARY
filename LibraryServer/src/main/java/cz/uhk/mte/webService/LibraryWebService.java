package cz.uhk.mte.webService;

import java.util.List;

import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Reservation;


public interface LibraryWebService {

	public Book getBookByID(int ID);

	public Reservation reserveBook(String surname, String name, int bookID);

	public List<Book> searchBooks(String title);

}