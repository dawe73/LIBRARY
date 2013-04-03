package cz.uhk.mte.model;

import java.util.Date;


public class Reservation extends AbstractDbEntity {

	private Book nook;
	private Date dateFrom;
	private Date dateTo;
	private boolean isActive;
	private Student student;

	public Reservation(){

	}

	public Book getNook() {
		return nook;
	}

	public void setNook(Book nook) {
		this.nook = nook;
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