package cz.uhk.mte.service;

import java.util.ArrayList;

import cz.uhk.mte.model.IEntity;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 21:07:18
 */
public class ReservationService extends AbstractEntityService {

	public static ReservationService Instance;

	public ReservationService(){

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
	public ArrayList<IEntity> GetAllEntities(){
		return null;
	}

	/**
	 * tady pouzijem generiku
	 * 
	 * @param ID
	 */
	public IEntity GetEntityByID(int ID){
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