package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


public class Category extends AbstractDbEntity implements Serializable {

	private ArrayList<Book> books;
	private String description;
	private boolean isTopLevelCategory;
	private int level;
	private Category parentCategory;
	@NotEmpty
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



	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
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

	

}