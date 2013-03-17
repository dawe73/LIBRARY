package cz.uhk.mte.service;

import java.util.ArrayList;

import cz.uhk.mte.model.IEntity;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 21:07:18
 */
public class AbstractEntityService implements IEntityService {

	public AbstractEntityService(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param entity
	 */
	public boolean Delete(IEntity entity){
		return false;
	}

	/**
	 * taky generika
	 */
	public ArrayList<IEntity> getAllEntities(){
		return null;
	}

	/**
	 * tady pouzijem generiku
	 * 
	 * @param ID
	 */
	public IEntity getEntityByID(int ID){
		return null;
	}

	/**
	 * 
	 * @param entity
	 */
	public int InsertEntity(IEntity entity){
		return 0;
	}

	/**
	 * 
	 * @param entity
	 */
	public void Update(IEntity entity){

	}

	@Override
	public IEntity GetEntityByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

}