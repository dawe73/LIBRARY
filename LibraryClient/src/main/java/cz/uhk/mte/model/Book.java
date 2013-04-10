package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Book implements Serializable {

	protected int ID;
	
	private List<Reservation> activeReservations;
	
	private List<Borrowing> borrowings;
	
	private List<Borrowing> activeBorrowings;
	
	private Category category;
	
	private int count;
	private String ISBN;
	private String[] keywords;
	private int mainAuthors;
	private int secondaryAuthors;
	
	public List<Author> authors;
	
	private int pageCount;
	private String printerInfo;
	private Date release;
	private String title;
	

	public Book(){

	}


	public void setBorrowings(ArrayList<Borrowing> borrowings) {
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

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public int getMainAuthors() {
		return mainAuthors;
	}

	public void setMainAuthors(int mainAuthors) {
		this.mainAuthors = mainAuthors;
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

	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	public int getSecondaryAuthors() {
		return secondaryAuthors;
	}

	public void setSecondaryAuthors(int secondaryAuthors) {
		this.secondaryAuthors = secondaryAuthors;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
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


	public List<Borrowing> getActiveBorrowings() {
		return activeBorrowings;
	}


	public void setActiveBorrowings(List<Borrowing> activeBorrowings) {
		this.activeBorrowings = activeBorrowings;
	}


	public List<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	


}