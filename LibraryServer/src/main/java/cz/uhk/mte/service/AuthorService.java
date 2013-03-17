package cz.uhk.mte.service;

import java.util.ArrayList;

import cz.uhk.mte.model.IEntity;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 21:07:18
 */
public class AuthorService extends AbstractEntityService {

	public static AuthorService Instance;

	public AuthorService(){

	}

	public void finalize() throws Throwable {
		super.finalize();
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

}