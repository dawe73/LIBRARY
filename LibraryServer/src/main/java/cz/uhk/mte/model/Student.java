package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Student implements Serializable{

	@Id
	@GeneratedValue
	protected int ID;
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	private List<Borrowing> borrowings;
	private String name;
	private String surname;
	private String mail;
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	private List<Reservation> reservations;
	
	
	public void setBorrowings(ArrayList<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	public List<Borrowing> getBorrowings() {
		return borrowings;
	}
	public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	
}