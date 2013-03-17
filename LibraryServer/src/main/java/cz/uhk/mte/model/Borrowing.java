package cz.uhk.mte.model;

import org.joda.time.DateTime;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:49
 */
public class Borrowing extends AbstractDbEntity {

	private Book Book;
	private DateTime DateFrom;
	private DateTime DateReceived;
	private DateTime DateTo;
	private int IsActive;
	private int Notes;
	private IStudent Student;

	public Borrowing(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}