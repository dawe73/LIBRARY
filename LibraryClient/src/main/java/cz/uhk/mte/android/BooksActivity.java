package cz.uhk.mte.android;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.global.Globals;
import cz.uhk.mte.global.Helpers;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.CategoryService;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

@EActivity(R.layout.activity_books)
public class BooksActivity extends FragmentActivity  {

	public static final int LOADER_ID = 1;
	private int categoryID = 0;
	private ProgressDialog wait; 
	private BookService bookService;
	private CategoryService categoryService;
	private CategoryAndroid category;
	
	@ViewById(R.id.lvBooks)
	ListView lvBooks;
	
	@ViewById(R.id.btnBooksSearch)
	Button btnSearch;
	
	@ViewById(R.id.btnBooksParentCategory)
	Button btnParentCategoryBrowse;
	
	@ViewById(R.id.txtBooksSearch)
	EditText txtSearch;
	
	@ViewById(R.id.tvBooksCategoryTitle)
	TextView tvCategoryTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		bookService = new BookService();
		categoryService = new CategoryService();
	}
	
	@Override
	public void onBackPressed() {
		if (category == null) {
			category = new CategoryAndroid();
			category.setParentCategoryID(Globals.TOP_LEVEL_CATEGORY);
			loadCategorySetFields();
		}
		else {
			if (category.isTopLevelCategory()) {
				super.onBackPressed();
			}
			else {
				loadCategorySetFields();
			}
		}
	}
	
	@AfterViews
	void init(){
		getCategorySetFields();
	}

	@Click(R.id.btnBooksSearch)
	void btnSearchClick(){
		loadBindDataBySearchExpression(txtSearch.getText().toString());
	}

	@Click(R.id.btnBooksParentCategory)
	void btnParentCategoryBrowseClick(){
		loadCategorySetFields();
	}

	
	@Background
	void loadBindDataBySearchExpression(String searchExpression){
		showWait("Vyhledávání knih");
		bindData(bookService.GetBooksBySearchExpression(searchExpression));
		hideWait();
	}
	
	@UiThread
	void bindData(ArrayList<BookAndroid> data){
		
		BooksAdapter booksAdapter = new BooksAdapter(BooksActivity.this, data); 
		
		lvBooks.setAdapter(booksAdapter);
	}

	
	@UiThread
	void setFields(CategoryAndroid c){
		
		if (c != null) {
			btnParentCategoryBrowse.setEnabled(!c.isTopLevelCategory());
			tvCategoryTitle.setText(c.getTitle());
		}
		else {
			tvCategoryTitle.setText("Chyba v aplikaci");
			hideWait();
			showErrorAlert();
		}
	}
	
	@Background
	void getCategorySetFields() {
		showWait("Naèítání knih");
		category = Helpers.GetCategoryFromParcelable(getIntent());

		refreshViews();
	}
	
	@Background
	void loadCategorySetFields() {
		showWait("Naèítání knih");		

		if (category != null && !category.isTopLevelCategory()) {
			category = categoryService.GetCategoryByID(category.getParentCategoryID());
		}
		refreshViews();
	}
	
	private void refreshViews(){
		setFields(category);
		if (category != null){
			bindData(bookService.GetBooksByCategoryID(category.getID()));
			hideWait();
		}
		
	}
	
	@UiThread
	void showWait(String message){
		wait = ProgressDialog.show(this, message, "Èekejte prosím...");
	}
	
	@UiThread
	void hideWait() {
		if (wait != null) {
			wait.dismiss();
		}
	}
	
	@UiThread
	void showErrorAlert(){
		AlertDialog ad = new AlertDialog.Builder(this).create();  
		ad.setCancelable(false); // This blocks the 'BACK' button  
		ad.setMessage(Globals.ERROR_MSG);  
		ad.setButton("OK", new DialogInterface.OnClickListener() {  
		    @Override  
		    public void onClick(DialogInterface dialog, int which) {  
		        dialog.dismiss();                      
		    }  
		});  
		ad.show(); 
	}
}
