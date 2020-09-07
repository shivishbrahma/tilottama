/**
 * 
 */
package tilottama.util;

import java.util.Calendar;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class CalendarApp {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();

		System.out.println("Calendar's Year: " + cal.get(Calendar.YEAR));
		System.out.println("Calendar's Month: " + cal.get(Calendar.MONTH));
		System.out.println("Calendar's Day: " + cal.get(Calendar.DATE));
	}
}
