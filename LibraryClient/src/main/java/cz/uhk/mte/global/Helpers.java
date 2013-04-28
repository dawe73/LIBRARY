package cz.uhk.mte.global;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import cz.uhk.mte.android.DummyLibraryParcelable;
import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.CategoryService;

public class Helpers {

	public static BookAndroid GetBookFromParcelable(Intent intent) {
		//LibraryParcelable<BookAndroid> parcel = (LibraryParcelable<BookAndroid>)getIntent().getParcelableExtra(Globals.PACKAGE_BOOK);		
		DummyLibraryParcelable parcel = intent.getParcelableExtra(Globals.PACKAGE_BOOK);
		BookService service = new BookService();
		
		return service.GetBookByID(parcel.getDataObjectID());
	}
	
	public static CategoryAndroid GetCategoryFromParcelable(Intent intent) {
		//LibraryParcelable<BookAndroid> parcel = (LibraryParcelable<BookAndroid>)getIntent().getParcelableExtra(Globals.PACKAGE_BOOK);		
		DummyLibraryParcelable parcel = intent.getParcelableExtra(Globals.PACKAGE_CATEGORY);
		CategoryService service = new CategoryService();
		
		return service.GetCategoryByID(parcel.getDataObjectID());
	}
	
	public static void Wait(int seconds){
		try {
			Thread.sleep(1000 * 0);
		} 
		catch (InterruptedException e) {
			
		}
	}
	
	public static String GetHumanFriendlyDate(Date date, boolean includingTime){
		SimpleDateFormat sdf = null;
		if (includingTime) {
			sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		}
		else {
			sdf = new SimpleDateFormat("dd.MM.yyyy");
		}
		
		String dateString = sdf.format(date);
		return dateString;
	}
}
