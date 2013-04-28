package cz.uhk.mte.service;

import java.util.ArrayList;

import cz.uhk.mte.entity.BookAndroid;


/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 21:05:16
 */
public class BookService {

	ILibraryWebService webService;
	
	public BookService(){
		webService = LibraryWebServiceFactory.GetInstance().GetWebService();
	}

	public BookAndroid GetBookByID(int ID){

		BookAndroid book;
		
		book = webService.getBookByID(ID);
		
		return book;
	}
	
	public ArrayList<BookAndroid> GetBooksBySearchExpression(String searchExpression) {
		
		ArrayList<BookAndroid> books;
		
		books = webService.getBooksBySearchExpression(searchExpression);
		
		return books;
	}
	
	public ArrayList<BookAndroid> GetBooksByCategoryID(int categoryID) {
		
		ArrayList<BookAndroid> books;
		
		books = webService.getBooksByCategoryID(categoryID);
		
		return books;
	}
}