package cz.uhk.mte.model;

/**
 * abstraktni trida hlavne kvuli atributu ID, ale treba ji vyuzijem i na vic
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:49
 */
public class AbstractDbEntity extends IEntity {

	private int ID;

	public AbstractDbEntity(){

	}

	public void finalize() throws Throwable {

	}

	public boolean Delete(){
		return false;
	}

	public boolean Update(){
		return false;
	}

}