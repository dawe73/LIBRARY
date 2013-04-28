package cz.uhk.mte.model.Android;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Book;


public class BookAndroid implements Serializable, ILibraryEntity {

	protected int ID;
	
	private String categoryTitle;
	private int count;
	private int availableCount;
	private String ISBN;
	private String keywords;
	private String mainAuthors;
	
	private int pageCount;
	private String printerInfo;
	private Date release;
	private String title;
	
	
	
	public BookAndroid(Book b) {
		super();
		ID = b.getID();
		this.categoryTitle = b.getCategory().getTitle();
		this.count = b.getCount();
		this.availableCount = b.getAvailableCount();
		ISBN = b.getISBN();
		this.keywords = b.getKeywords();
		this.mainAuthors = convertAuthor(b.getAuthors());
		this.pageCount = b.getPageCount();
		this.printerInfo = b.getPrinterInfo();
		this.release = b.getReleased();
		this.title = b.getTitle();
	}
	
	private String convertAuthor(List<Author> authors){
		String jmeno = "";
		for (int i = 0; i < authors.size(); i++) {
			Author a =	authors.get(i);
			jmeno = a.getName() +" "+a.getSurname();
			if (i < authors.size()-1) {
				jmeno = jmeno + ", ";
			}
		}
		
		return jmeno;
	}

	public int getID() {
		return ID;
	}

	@Override
	public void setID(int id) {
		this.ID = id;
	}
	
	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	
	public String getMainAuthors() {
		return mainAuthors;
	}

	public void setMainAuthors(String mainAuthors) {
		this.mainAuthors = mainAuthors;
	}
	
	
	public String getPrinterInfo() {
		return printerInfo;
	}

	public void setPrinterInfo(String printerInfo) {
		this.printerInfo = printerInfo;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public Date getRelease() {
		return release;
	}

	public void setRelease(Date release) {
		this.release = release;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pagecount) {
		this.pageCount = pagecount;
	}
	
	public BookAndroid(){

	}

}