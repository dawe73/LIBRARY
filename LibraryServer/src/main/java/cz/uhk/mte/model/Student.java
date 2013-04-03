package cz.uhk.mte.model;

import java.util.ArrayList;
import java.util.Date;


/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:50
 */
public class Student {

	public ArrayList<Borrowing> Borrowings;
	public  Date DateBirth;
	/**
	 * Rodne cislo voe
	 */
	public  String IdentificationNumber;
	public  int IsicNumber;
	public  String Name;
	public  String Surname;

}