package cz.uhk.mte.model.Android;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cz.uhk.mte.model.Category;


public class CategoryAndroid implements Serializable, ILibraryEntity {
	
	protected int ID;
		
	private String description;
	private boolean isTopLevelCategory;
	private int level;
	private int booksCount;
	
	private String parentCategoryTitle;
	private int parentCategoryID;
	private String title;

	public CategoryAndroid(){
		
	}
	
	

	public CategoryAndroid(Category c) {
		this.ID = c.getID();
		this.description = c.getDescription();
		this.level = c.getLevel();
		this.booksCount=c.getBooks().size();
		if (c.getParentCategory() != null) {
			this.parentCategoryTitle = c.getParentCategory().getTitle();
			this.parentCategoryID = c.getParentCategory().getID();
		}
		else {
			this.parentCategoryTitle = "";
			this.parentCategoryID = 0;
			this.isTopLevelCategory = true;
		}
		this.title = c.getTitle();
	}



	public CategoryAndroid(int ID, String description,	boolean isTopLevelCategory, 
			int level, int booksCount, String parentCategoryTitle, String title) {
		
		super();
		
		this.ID = ID;
		this.description = description;
		this.isTopLevelCategory = isTopLevelCategory;
		this.level = level;
		this.booksCount = booksCount;
		this.parentCategoryTitle = parentCategoryTitle;
		this.title = title;
	}

	public int getBooksCount() {
		return booksCount;
	}


	public void setBooksCount(int count) {
		this.booksCount = count;
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

	public String getParentCategoryTitle() {
		return parentCategoryTitle;
	}

	public void setParentCategoryTitle(String parentCategoryTitle) {
		this.parentCategoryTitle = parentCategoryTitle;
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

	@Override
	public void setID(int id) {
		this.ID = id;
	}



	public int getParentCategoryID() {
		return parentCategoryID;
	}



	public void setParentCategoryID(int parentCategoryID) {
		this.parentCategoryID = parentCategoryID;
	}
	
	
	
}