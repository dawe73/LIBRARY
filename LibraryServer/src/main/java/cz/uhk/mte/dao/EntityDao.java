package cz.uhk.mte.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.IEntity;
import cz.uhk.mte.service.impl.IEntityService;

public class EntityDao extends HibernateDaoSupport implements IEntityService{

	@Override
	public boolean delete(IEntity entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IEntity> getAllEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEntityByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEntity(IEntity entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		
	}

	@Override
	public void update(IEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
