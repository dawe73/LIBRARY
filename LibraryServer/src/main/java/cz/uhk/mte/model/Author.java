package cz.uhk.mte.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private int id;

	public int getId() {
		return id;
	}
	
	
}
