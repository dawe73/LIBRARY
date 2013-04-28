package cz.uhk.mte.model.Android;


import java.io.Serializable;
import java.util.Date;




public class ReservationAndroid implements Serializable, ILibraryEntity {
	
	protected int ID;

	private String bookTitle;
	private Date dateFrom;
	private Date dateTo;
	private String name;
	private String surname;
	private String email;
	private int bookID;

	public ReservationAndroid(){

	}


	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String name) {
		this.surname = name;
	}
	
	public int getID() {
		return ID;
	}

	@Override
	public void setID(int id) {
		this.ID = id;
	}


	public int getBookID() {
		return bookID;
	}


	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	
}