package cz.uhk.mte.android;

import java.util.ArrayList;

import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;

import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.entity.ReservationAndroid;
import cz.uhk.mte.global.Helpers;
import cz.uhk.mte.service.CategoryService;
import cz.uhk.mte.service.ReservationService;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

@EActivity(R.layout.activity_categories)
public class CategoriesActivity extends ActivityGroup {

	public static final int LOADER_ID = 1;
	private ProgressDialog wait; 
	private CategoryService categoryService;
	private CategoryAndroid category;
	
	@ViewById(R.id.lvCategories)
	ListView lvCategories;
	
	@ViewById(R.id.btnCategoriesParentCategory)
	Button btnParentCategory;
	
	@ViewById(R.id.btnSearchCategories)
	Button btnSearchCategories;
	
	@ViewById(R.id.txtSearchCategories)
	EditText txtSearchCategories;
	
	@ViewById(R.id.tvCategoriesCategoryTitle)
	TextView tvCategoryTitle;
	
	private int parentCategoryID;
	
	public int getParentCategoryID() {
		return parentCategoryID;
	}
	
	public void setParentCategoryID(int value) {
		parentCategoryID = value;
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		categoryService = new CategoryService();
	}

	
	@AfterViews
	void init(){
		getCategorySetFields();
	}
	
	@Click(R.id.btnCategoriesParentCategory)
	void btnParentCategoryClick(){
		loadCategorySetFields();
	}
	
	@Click(R.id.btnSearchCategories)
	void btnSearchClick(){
		loadBindDataBySearchExpression(txtSearchCategories.getText().toString());
	}
	
	@Background
	void loadBindDataBySearchExpression(String searchExpression){
		showWait("Vyhledávání knih");
		bindData(categoryService.GetCategoriesBySearchExpression(searchExpression));
		hideWait();
	}
	
	@Background
	void getCategorySetFields() {
		showWait("Naèítání kategorií");
		category = Helpers.GetCategoryFromParcelable(getIntent());

		refreshViews();
	}
	
	@Background
	void loadCategorySetFields() {
		showWait("Naèítání kategorií");		
		
		if (!category.isTopLevelCategory()) {
			category = categoryService.GetCategoryByID(category.getParentCategoryID());
		}
		refreshViews();
	}
	
	@Background
	void loadCategorySetFields(int categoryID){
		showWait("Naèítání kategorií");		
		
		category = categoryService.GetCategoryByID(categoryID);
		
		refreshViews();
	}
	
	@UiThread
	void setFields(CategoryAndroid c){
		
		if (c != null) {
			btnParentCategory.setEnabled(!c.isTopLevelCategory());
			tvCategoryTitle.setText(c.getTitle());
		}
	}
	
	private void refreshViews(){
		setFields(category);
		bindData(categoryService.GetCategoriesByParentCategoryID(category.getID()));
		hideWait();
	}
	
	
	@UiThread
	void bindData(ArrayList<CategoryAndroid> data){
		
		CategoriesAdapter categoriesAdapter = new CategoriesAdapter(CategoriesActivity.this, data); 
		lvCategories.setAdapter(categoriesAdapter);
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

}
