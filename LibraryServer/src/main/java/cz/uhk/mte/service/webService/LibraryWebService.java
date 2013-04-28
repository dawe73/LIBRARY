package cz.uhk.mte.service.webService;

import java.util.List;

import cz.uhk.mte.model.Android.BookAndroid;
import cz.uhk.mte.model.Android.CategoryAndroid;
import cz.uhk.mte.model.Android.ReservationAndroid;


public interface LibraryWebService {

	
	public List<CategoryAndroid> getCategoriesByParentCategoryID(int parentCategoryID);
	public List<CategoryAndroid> getCategoriesBySearchExpression(String searchExpression);
	
	public BookAndroid getBookByID(int bookID);
	public List<BookAndroid> getBooksByCategoryID(int categoryID);
	public List<BookAndroid> getBooksBySearchExpression(String searchExpression);
	
	public List<BookAndroid> getAllBook();
	public int InsertReservation(ReservationAndroid reservation);
	
	public CategoryAndroid getCategoryByID(int categoryID);
}