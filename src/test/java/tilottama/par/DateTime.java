package tilottama.par;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Purbayan Chowdhury (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class DateTime {
	static Date date;
	static SimpleDateFormat sdf;

	/**
	 * @param unix
	 * @param s
	 * @return
	 */
	public static String unixToFormat(long unix, String s) {
		date = new Date(unix * 1000L);
		sdf = new SimpleDateFormat(s);
		sdf.setTimeZone(TimeZone.getDefault());
		try {
			String fdate = sdf.format(date);
			return fdate;
		} catch (Exception e) {
			System.out.println("Cannot parse date\n " + e.getMessage());
		}
		return null;
	}

	/**
	 * @param unix
	 * @return
	 */
	public static String unixToAFormat(long unix) {
		String s = "HH:mm:ss";
		return unixToFormat(unix, s);
	}

	/**
	 * @param unix
	 * @return
	 */
	public static String unixToAPFormat(long unix) {
		String s = "dd MMM yyyy hh:mm:ss a";
		return unixToFormat(unix, s);
	}

	/**
	 * @param unix
	 * @return
	 */
	public static String unixToZFormat(long unix) {
		String s = "dd MMM yyyy HH:mm:ss z";
		return unixToFormat(unix, s);
	}

	/**
	 * @param unix
	 * @return
	 */
	public static String unixToDFormat(long unix) {
		String s = "dd MMM yyyy";
		return unixToFormat(unix, s);
	}

	/**
	 * @param unix
	 * @param s
	 * @return
	 */
	public static String unixtoUTC(long unix, String s) {
		date = new Date(unix * 1000L);
		sdf = new SimpleDateFormat(s);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			String fdate = sdf.format(date);
			return fdate;
		} catch (Exception e) {
			System.out.println("Cannot parse date\n " + e.getMessage());
		}
		return null;
	}

}
