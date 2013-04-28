package cz.uhk.mte.android;

import java.util.ArrayList;

import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.service.CategoryService;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class CategoriesLoader extends AsyncTaskLoader<ArrayList<CategoryAndroid>> {

	private int parentCategoryID = 0;
	private String searchExpression = "";
	
	public CategoriesLoader(Context context) {
		super(context);
		parentCategoryID = ((CategoriesActivity)context).getParentCategoryID();
	}
	
	public CategoriesLoader(Context context, String searchExpression) {
		super(context);

		this.searchExpression = searchExpression;
	}
	
	public CategoriesLoader(Context context, int parentCategoryID) {
		super(context);
		this.parentCategoryID = parentCategoryID;
	}

	@Override
	public ArrayList<CategoryAndroid> loadInBackground() {
		
		ArrayList<CategoryAndroid> categories;
		
		CategoryService service = new CategoryService(); 
		
		if (searchExpression.equals("")) {
			categories = service.GetCategoriesByParentCategoryID(parentCategoryID);
		}
		else {
			categories = service.GetCategoriesBySearchExpression(searchExpression);
		}
		
		return categories;
	}
}