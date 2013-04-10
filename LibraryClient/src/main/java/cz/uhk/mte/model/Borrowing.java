package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.Date;




public class Borrowing implements Serializable {

	protected int ID;
	
	private Book book;
	private Date dateFrom;
	private Date dateReceived;
	private Date dateTo;
	private boolean isActive;
	private int notes;
	
	private Student student;

	public Borrowing(){

	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}


	public int getNotes() {
		return notes;
	}

	public void setNotes(int notes) {
		this.notes = notes;
	}


	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	

}