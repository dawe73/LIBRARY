package cz.uhk.mte.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertorImpl implements DateConvertor {
	DateFormat df;
	Date date;

	public Date stringToDate(String datum) throws ParseException {
		df = new SimpleDateFormat("dd.MM.yy");
		date = (Date) df.parse(datum);
		return date;
	}

	@Override
	public String dateTOString(Date date) {
		df = new SimpleDateFormat("dd.MM.yy");
		return df.format(date);
	}
}
