package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Author implements Serializable{
	protected int ID;
	
	private Date birthDate;
	
	private List<Book> books;
	
	private String name;
	
	private String surname;

	public Author(){

	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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

	public Author(Date birthDate, String name, String surname) {
		super();
		this.birthDate = birthDate;
		this.name = name;
		this.surname = surname;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	
}