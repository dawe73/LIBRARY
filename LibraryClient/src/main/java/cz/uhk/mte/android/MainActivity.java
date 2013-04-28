package cz.uhk.mte.android;

import com.googlecode.androidannotations.annotations.EActivity;

import cz.uhk.mte.global.Globals;
import cz.uhk.mte.global.LibraryTabType;
import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	private DummyLibraryParcelable categoryParcel;
	private DummyLibraryParcelable bookParcel;
	
	TabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		categoryParcel = new DummyLibraryParcelable(Globals.TOP_LEVEL_CATEGORY);
		bookParcel = new DummyLibraryParcelable(Globals.TOP_LEVEL_CATEGORY); 
		
        tabHost = getTabHost();
        
        // Tab for Categories
        TabSpec categoriesSpec = tabHost.newTabSpec("Kategorie");
        // setting Title and Icon for the Tab
        categoriesSpec.setIndicator("Kategorie");
        Intent categoriesIntent = new Intent(this, CategoriesActivity_.class);
		Bundle categoriesBundle = new Bundle();
		categoriesBundle.putParcelable(Globals.PACKAGE_CATEGORY, categoryParcel);
		categoriesIntent.putExtras(categoriesBundle);
        categoriesSpec.setContent(categoriesIntent);
 
        // Tab for Books
        TabSpec booksSpec = tabHost.newTabSpec("Knihy");
        booksSpec.setIndicator("Knihy");
        Intent booksIntent = new Intent(this, BooksActivity_.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		Bundle booksBundle = new Bundle();
		booksBundle.putParcelable(Globals.PACKAGE_CATEGORY, bookParcel);
		booksIntent.putExtras(booksBundle);
        booksSpec.setContent(booksIntent);
        
        // Tab for Reservations
        TabSpec reservationsSpec = tabHost.newTabSpec("Rezervace");
        reservationsSpec.setIndicator("Rezervace");
        Intent reservationsIntent = new Intent(this, ReservationsActivity_.class);
        reservationsSpec.setContent(reservationsIntent);        
 
        // Adding all TabSpec to TabHost
        tabHost.addTab(reservationsSpec); // Adding reservations tab
        tabHost.addTab(categoriesSpec); // Adding categories tab
        tabHost.addTab(booksSpec); // Adding books tab
	}
	
	
	public void ChangeTab(LibraryTabType tabType, int dataObjectID){
		
		switch (tabType) {
		case BooksTab:
			bookParcel.setDataObjectID(dataObjectID);
			tabHost.setCurrentTab(2);
			break;
		case CategoriesTab:
			categoryParcel.setDataObjectID(dataObjectID);
			tabHost.setCurrentTab(1);
			break;
		case ReservationsTab:

			tabHost.setCurrentTab(0);
			break;
		case Unknown:

			break;
		}
		
	}
}
