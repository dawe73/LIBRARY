package cz.uhk.mte.service;

import java.util.ArrayList;
import java.util.Date;

import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.entity.ReservationAndroid;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 21:05:16
 */
public interface ILibraryWebService {

	
	public ArrayList<CategoryAndroid> getCategoriesByParentCategoryID(int parentCategoryID);
	public ArrayList<CategoryAndroid> getCategoriesBySearchExpression(String searchExpression);
	public CategoryAndroid getCategoryByID(int categoryID);
	
	public BookAndroid getBookByID(int bookID);
	public ArrayList<BookAndroid> getBooksByCategoryID(int categoryID);
	public ArrayList<BookAndroid> getBooksBySearchExpression(String searchExpression);
	
	public int InsertReservation(ReservationAndroid reservation);
}