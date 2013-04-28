package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Author implements Serializable{
	@Id
	@GeneratedValue
	protected int ID;
	
	private Date birthDate;
	
	@ManyToMany(mappedBy="authors")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Book> books;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;

	public Author(){
		this.books = new ArrayList<Book>();
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