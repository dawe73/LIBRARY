package cz.uhk.mte.model;

import java.util.ArrayList;
import java.util.Date;


public class Author extends AbstractDbEntity {

	private Date birthDate;
	private ArrayList<Book> books;
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

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
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
	
	
	
}