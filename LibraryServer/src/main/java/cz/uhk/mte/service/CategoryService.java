package cz.uhk.mte.service;

import java.util.List;

import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.IEntity;

public interface CategoryService {

	public boolean delete(Category category);

	public List<Category> getAllCategories();

	public Category getCategoryByID(int ID);

	public void insertCategory(Category category);

	public void update(Category category);
}
