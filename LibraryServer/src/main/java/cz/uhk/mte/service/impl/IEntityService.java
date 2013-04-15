package cz.uhk.mte.service.impl;

import java.util.ArrayList;
import java.util.List;

import cz.uhk.mte.model.IEntity;


public interface IEntityService {


	public boolean delete(IEntity entity);


	public List<IEntity> getAllEntities();

	public Object getEntityByID(int ID);

	public void insertEntity(IEntity entity);

	public void update(IEntity entity);

}