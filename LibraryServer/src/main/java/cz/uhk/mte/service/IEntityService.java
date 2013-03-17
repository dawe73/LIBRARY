package cz.uhk.mte.service;

import java.util.ArrayList;

import cz.uhk.mte.model.IEntity;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 21:07:18
 */
public interface IEntityService {

	/**
	 * nejaky settings z configu treba? treba to nebude potreba
	 */
//	public static int Settings;

	/**
	 * 
	 * @param entity
	 */
	public boolean Delete(IEntity entity);

	/**
	 * taky generika
	 */
	public ArrayList<IEntity> getAllEntities();

	/**
	 * tady pouzijem generiku
	 * 
	 * @param ID
	 */
	public IEntity GetEntityByID(int ID);

	/**
	 * 
	 * @param entity
	 */
	public int InsertEntity(IEntity entity);

	/**
	 * 
	 * @param entity
	 */
	public void Update(IEntity entity);

}