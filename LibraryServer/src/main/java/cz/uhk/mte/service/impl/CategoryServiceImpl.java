package cz.uhk.mte.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.uhk.mte.dao.CategoryDaoImpl;
import cz.uhk.mte.dao.EntityDao;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.IEntity;
import cz.uhk.mte.service.CategoryService;


@Component
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryService categoryDao;

	@Override
	public boolean delete(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}
	
}