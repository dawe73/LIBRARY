package cz.uhk.mte.model;

import java.util.ArrayList;
import java.util.Date;


public class Book extends AbstractDbEntity {

	private ArrayList<Borrowing> activeBorrowings;
	private ArrayList<Reservation> activeReservations;
	private int availableCount;
	private String b;
	private ArrayList<Borrowing> borrowings;
	private int borrowingsCount;
	private Category category;
	private int count;
	private String ISBN;
	private String[] keywords;
	private int mainAuthors;
	private String mainHeading;
	private int pageCount;
	private String printerInfo;
	private Date release;
	private int secondaryAuthors;
	private int size;
	private String title;
	public ArrayList<Author> authors;

	public Book(){

	}

	public ArrayList<Borrowing> getActiveBorrowings() {
		return activeBorrowings;
	}

	public void setActiveBorrowings(ArrayList<Borrowing> activeBorrowings) {
		this.activeBorrowings = activeBorrowings;
	}

	public ArrayList<Reservation> getActiveReservations() {
		return activeReservations;
	}

	public void setActiveReservations(ArrayList<Reservation> activeReservations) {
		this.activeReservations = activeReservations;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public ArrayList<Borrowing> getBorrowings() {
		return borrowings;
	}

	public void setBorrowings(ArrayList<Borrowing> borrowings) {
		this.borrowings = borrowings;
	}

	public int getBorrowingsCount() {
		return borrowingsCount;
	}

	public void setBorrowingsCount(int borrowingsCount) {
		this.borrowingsCount = borrowingsCount;
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

	public String getMainHeading() {
		return mainHeading;
	}

	public void setMainHeading(String mainHeading) {
		this.mainHeading = mainHeading;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}

	


}