package cz.uhk.mte.service;

import java.util.ArrayList;

import cz.uhk.mte.entity.CategoryAndroid;

public class CategoryService {

	
	ILibraryWebService webService;
	
	public CategoryService() {

		webService = LibraryWebServiceFactory.GetInstance().GetWebService();
	}
	
	public ArrayList<CategoryAndroid> GetAllCategories() {
		
		return webService.getCategoriesByParentCategoryID(0);
	}
	
	public ArrayList<CategoryAndroid> GetCategoriesByParentCategoryID(int parentCategoryID) {
		
		return webService.getCategoriesByParentCategoryID(parentCategoryID);
	}
	
	public ArrayList<CategoryAndroid> GetCategoriesBySearchExpression(String searchExpression){
		
		return webService.getCategoriesBySearchExpression(searchExpression);
	}
	
	public CategoryAndroid GetCategoryByID(int categoryID){
		
		return webService.getCategoryByID(categoryID);
	}
}
