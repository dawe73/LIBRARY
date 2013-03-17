package cz.uhk.mte.model;

import java.util.ArrayList;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:50
 */
public class Category extends AbstractDbEntity {

	private ArrayList<Book> Books;
	private String Description;
	private boolean IsTopLevelCategory;
	private int Level;
	private Category ParentCategory;
	private String Title;

	public Category(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

}