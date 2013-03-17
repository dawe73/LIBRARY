package cz.uhk.mte.model;

import org.joda.time.DateTime;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:50
 */
public class Reservation extends AbstractDbEntity {

	private Book Book;
	private DateTime DateFrom;
	private DateTime DateTo;
	private boolean IsActive;
	private String ReserverName;
	private String ReserverSurname;

	public Reservation(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}