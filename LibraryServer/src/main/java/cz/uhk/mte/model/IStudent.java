package cz.uhk.mte.model;

import java.util.ArrayList;

import org.joda.time.DateTime;

/**
 * @author Lukas
 * @version 1.0
 * @created 17-3-2013 20:50:50
 */
public class IStudent {

	public ArrayList<Borrowing> Borrowings;
	public  DateTime DateBirth;
	/**
	 * Rodne cislo voe
	 */
	public  String IdentificationNumber;
	public  int IsicNumber;
	public  String Name;
	public  String Surname;

}