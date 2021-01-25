package com.shivishbrahma.tilottama.main.util;

import java.io.IOException;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class OSCommand {
	public static void today() throws IOException {
//		Process process = Runtime.getRuntime().exec("calendar");
//		// deal with OutputStream to send inputs
////		process.getOutputStream();
//
//		// deal with InputStream to get ordinary outputs
//		Scanner scanner = new Scanner(process.getInputStream());
//		scanner.useDelimiter("\r\n");
//
//		while (scanner.hasNext()) {
//			System.out.println(scanner.next());
//		}
//
//		scanner.close();
//
//		// deal with ErrorStream to get error outputs
//		process.getErrorStream();

		CalendarApp c = new CalendarApp();
		System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.centerAligned("Date in History", 64, "="));
		System.out.println("Today's Date: " + c.getToday("MMMM dd, yyyy"));
		System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.centerAligned("Powered by Wikipedia", 64, "-"));
		c.getEvents(c.getToday("MMMM_d"));
		c.getBirths(c.getToday("MMMM_d"));
		c.getDeaths(c.getToday("MMMM_d"));
	}

	public static void main(String[] args) {
//		String music = "/home/anitesh/Music/music/Aero Chord feat. DDARK - Shootin Stars [NCS Release]-PTF5xgT-pm8.mp3";
	}
}
