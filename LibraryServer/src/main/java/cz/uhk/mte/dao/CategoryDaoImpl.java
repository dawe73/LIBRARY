package cz.uhk.mte.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Category;

public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	@Override
	public void addCategory(Category c) {
		getHibernateTemplate().saveOrUpdate(c);
		
	}

}
