package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Category implements Serializable, IEntity {
	
	protected int ID;
	
	private List<Book> books;
	
	private String description;
	private boolean isTopLevelCategory;
	private int level;
	
	private Category parentCategory;
	private String title;

	public Category(){
		
	}
	
	

	public Category(ArrayList<Book> books, String description,
			boolean isTopLevelCategory, int level, Category parentCategory,
			String title) {
		super();
		this.books = books;
		this.description = description;
		this.isTopLevelCategory = isTopLevelCategory;
		this.level = level;
		this.parentCategory = parentCategory;
		this.title = title;
	}




	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isTopLevelCategory() {
		return isTopLevelCategory;
	}

	public void setTopLevelCategory(boolean isTopLevelCategory) {
		this.isTopLevelCategory = isTopLevelCategory;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	
	

}