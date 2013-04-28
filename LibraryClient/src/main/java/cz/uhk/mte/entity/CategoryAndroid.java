package cz.uhk.mte.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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
		this.parentCategoryID = parentCategoryID;
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
	
	public int getParentCategoryID() {
		return parentCategoryID;
	}

	public void setParentCategoryID(int parentCategoryID) {
		this.parentCategoryID = parentCategoryID;
	}

	public int getID() {
		return ID;
	}

	@Override
	public void setID(int id) {
		this.ID = id;
	}
	
}