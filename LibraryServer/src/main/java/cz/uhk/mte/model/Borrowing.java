package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Borrowing implements Serializable {

	@Id
	@GeneratedValue
	protected int ID;
	
	@ManyToOne()
	private Book book;
	private Date dateFrom;
	private Date dateReceived;
	private Date dateTo;
	private boolean isActive;
	
	@ManyToOne()
	private Student student;

	public Borrowing(){

	}

	public Borrowing(Reservation reservation) {
		this.book = reservation.getBook();
		this.dateFrom = reservation.getDateFrom();
		this.dateTo = reservation.getDateTo();
		this.isActive = true;
		this.student = reservation.getStudent();
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