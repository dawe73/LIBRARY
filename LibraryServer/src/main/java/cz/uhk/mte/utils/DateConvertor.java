package cz.uhk.mte.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {
	DateFormat df;
	Date date;

	public Date datumZapasu(String datum){
		df = new SimpleDateFormat("dd.MM.yy");
		try {
			date = (Date) df.parse(datum);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
