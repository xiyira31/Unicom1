package dmlab.unicom.data.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	public static String DATETYPE_1 = "dd-MM月-yy";
	public static String DATETYPE_2 = "dd-MM月 -yy";
	public static String RETURN_DATE_TYPE ="yyMM";
	
	public static String parse(String sDate) throws ParseException
	{
		SimpleDateFormat sdf1 = new SimpleDateFormat(DATETYPE_1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(DATETYPE_2);
		Date date = new Date();
		try{
			date = sdf1.parse(sDate);
		}
		catch(Exception e)
		{
			date = sdf2.parse(sDate);
		}
		SimpleDateFormat sdf = new SimpleDateFormat(RETURN_DATE_TYPE);
		return sdf.format(date);
	}
	
	public static Date parseDate(String sDate) throws ParseException
	{
		SimpleDateFormat sdf1 = new SimpleDateFormat(DATETYPE_1);
		SimpleDateFormat sdf2 = new SimpleDateFormat(DATETYPE_2);
		Date date = new Date();
		try{
			date = sdf1.parse(sDate);
		}
		catch(Exception e)
		{
			date = sdf2.parse(sDate);
		}
		//SimpleDateFormat sdf = new SimpleDateFormat(RETURN_DATE_TYPE);
		return date;
	}
}
