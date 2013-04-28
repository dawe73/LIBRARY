package cz.uhk.mte.entity;


import java.io.Serializable;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class ReservationAndroid implements Serializable, ILibraryEntity {

	@DatabaseField(generatedId = true)
	protected int ID;

	@DatabaseField
	private String bookTitle;
	
	@DatabaseField
	private int bookID;
	
	@DatabaseField
	private Date dateFrom;
	
	@DatabaseField
	private Date dateTo;
	
	@DatabaseField
	private String name;
	
	@DatabaseField
	private String surname;
	
	@DatabaseField
	private String email;
	

	public ReservationAndroid(){

	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
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
}