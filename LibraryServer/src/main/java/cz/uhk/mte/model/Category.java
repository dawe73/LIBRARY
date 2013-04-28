package cz.uhk.mte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Category implements Serializable, IEntity {
	
	@Id
	@GeneratedValue
	protected int ID;
	
	@OneToMany(mappedBy="category")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Book> books;
	
	private String description;
	private boolean isTopLevelCategory;
	private int level;
	
	@OneToOne()
	private Category parentCategory;
	@NotEmpty
	private String title;

	public Category(){
		this.books = new ArrayList<Book>();
	}
	
	
	

	public Category(String title) {
		super();
		this.title = title;
		this.books = new ArrayList<Book>();
		this.isTopLevelCategory = false;
		this.level = 0;
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