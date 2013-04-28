package cz.uhk.mte.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.uhk.mte.model.Category;
import cz.uhk.mte.service.CategoryService;


@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryService categoryDao;

	@Override
	public void delete(Category category) {
		categoryDao.delete(category);
	}

	@Override
	public List<Category> getAllCategories() {
		if (categoryDao.getAllCategories().size() == 0) {
			Category c = new Category();
			c.setTitle("UHK");
			c.setLevel(0);
			categoryDao.insertCategory(c);
		}
		return categoryDao.getAllCategories();
	}

	@Override
	public Category getCategoryByID(int ID) {
		return categoryDao.getCategoryByID(ID);
	}

	@Override
	public void insertCategory(Category category) {
		categoryDao.insertCategory(category);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

	public CategoryService getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryService categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<Category> getByParentCategory(Category parent) {
		return categoryDao.getByParentCategory(parent);
	}

	@Override
	public List<Category> getCategoriesBySearchExpression(String search) {
		return categoryDao.getCategoriesBySearchExpression(search);
	}
	
	
}