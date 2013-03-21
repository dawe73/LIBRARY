package cz.uhk.mte.model;

import java.util.ArrayList;
import java.util.Date;




/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:49
 */
public class Author extends AbstractDbEntity {

	private Date BirthDate;
	private ArrayList<Book> Books;
	private String Name;
	private String Surname;
	public Book m_Book;

	public Author(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}