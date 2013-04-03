package cz.uhk.mte.model;

import java.util.Date;



public class Borrowing extends AbstractDbEntity {

	private Book book;
	private Date dateFrom;
	private Date dateReceived;
	private Date dateTo;
	private int isActive;
	private int notes;
	private Student Student;

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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getNotes() {
		return notes;
	}

	public void setNotes(int notes) {
		this.notes = notes;
	}

	public Student getStudent() {
		return Student;
	}

	public void setStudent(Student student) {
		Student = student;
	}


}