package radSaDatumima;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class RadSaDatumima {
	
	public static String datumUString(GregorianCalendar datum) {
		GregorianCalendar danas = datum;
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		String formatiranDatum = formatter.format(danas.getTime());
		return formatiranDatum;
	}
	
	public static GregorianCalendar stringUDatum(String procitanDatum) {
		GregorianCalendar datum = new GregorianCalendar();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try {
		datum.setTime(formatter.parse(procitanDatum));
		} catch (ParseException e) {
		e.printStackTrace();
		}
		return datum;
	}

}
