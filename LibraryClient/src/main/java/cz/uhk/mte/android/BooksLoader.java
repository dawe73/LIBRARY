package cz.uhk.mte.android;

import java.util.ArrayList;

import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.service.BookService;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class BooksLoader extends AsyncTaskLoader<ArrayList<BookAndroid>> {
	
	private int categoryID = 0;
	private String searchExpression = "";
	
	public BooksLoader(Context context) {
		super(context);
	}
	
	public BooksLoader(Context context, int categoryID){
		super(context);
		
		this.categoryID = categoryID;
	}
	
	public BooksLoader(Context context, String  searchExpression){
		super(context);
		
		this.searchExpression = searchExpression;
	}

	@Override
	public ArrayList<BookAndroid> loadInBackground() {
		
		ArrayList<BookAndroid> books;
		
		BookService service = new BookService(); 
		
		if (searchExpression.equals("")) {
			books = service.GetBooksByCategoryID(categoryID);
		}
		else {
			books = service.GetBooksBySearchExpression(searchExpression);
		}
		
		return books;
	}

}
