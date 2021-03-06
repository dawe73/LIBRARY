package cz.uhk.mte.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Category;
import cz.uhk.mte.service.CategoryService;

public class CategoryDao extends HibernateDaoSupport implements CategoryService {

	@Override
	public void delete(Category category) {
		getHibernateTemplate().delete(category);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		return getHibernateTemplate().find("from Category");
	}

	@Override
	public Category getCategoryByID(int ID) {
		return (Category) getHibernateTemplate().get(Category.class, ID);
	}

	@Override
	public void insertCategory(Category category) {
		getHibernateTemplate().saveOrUpdate(category);
		
	}

	@Override
	public void update(Category category) {
		insertCategory(category);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getByParentCategory(Category parent) {
		return getHibernateTemplate().find("from Category c where c.parentCategory=?",parent);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoriesBySearchExpression(String search) {
		search = "%"+search+"%";
		return getHibernateTemplate().find("from Category c where c.title like ? or c.description like ?",search,search);
	}



}
