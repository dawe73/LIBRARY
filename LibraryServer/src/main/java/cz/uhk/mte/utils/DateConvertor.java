package cz.uhk.mte.utils;

import java.text.ParseException;
import java.util.Date;

public interface DateConvertor  {

	public Date stringToDate(String datum) throws ParseException;
	
	public String dateTOString(Date date) ;
}
