package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Book implements Serializable {

	@Id
	@GeneratedValue
	protected int ID;
	
	@OneToMany(mappedBy="book")
	private List<Reservation> activeReservations;
	
	@OneToMany(mappedBy="book")
	private List<Borrowing> borrowings;
	
	//pokud jde knížka z actvie reserv do active borrwin  pøidá se podle isActive popø se zase odebere
//	@Transient
//	private List<Borrowing> activeBorrowings;
	
	@ManyToOne
	private Category category;
	
	private int count;
	private String ISBN;
	private String keywords;
	private int mainAuthors;
	private int secondaryAuthors;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Author> authors;
	
	private int pageCount;
	private String printerInfo;
	private Date released;
	@NotEmpty
	private String title;
	

	public Book(){

	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public List<Reservation> getActiveReservations() {
		return activeReservations;
	}


	public void setActiveReservations(List<Reservation> activeReservations) {
		this.activeReservations = activeReservations;
	}


	public List<Borrowing> getBorrowings() {
		return borrowings;
	}


	public void setBorrowings(List<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public int getMainAuthors() {
		return mainAuthors;
	}


	public void setMainAuthors(int mainAuthors) {
		this.mainAuthors = mainAuthors;
	}


	public int getSecondaryAuthors() {
		return secondaryAuthors;
	}


	public void setSecondaryAuthors(int secondaryAuthors) {
		this.secondaryAuthors = secondaryAuthors;
	}


	public List<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public String getPrinterInfo() {
		return printerInfo;
	}


	public void setPrinterInfo(String printerInfo) {
		this.printerInfo = printerInfo;
	}



	public Date getReleased() {
		return released;
	}


	public void setReleased(Date released) {
		this.released = released;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	


}