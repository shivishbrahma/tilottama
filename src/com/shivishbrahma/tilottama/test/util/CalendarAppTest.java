/**
 * 
 */
package com.shivishbrahma.tilottama.test.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class CalendarAppTest {
	protected String BASE_URL = "https://en.wikipedia.org/wiki/";
	
	public String getToday(String format) {
		return getToday(format, new Date());		
	}
	
	public String getToday(String format, Date date) {
		return new SimpleDateFormat(format).format(date);		
	}
	
	public void getEvents(String day) {
		Document doc;
		try {
			doc = Jsoup.connect(this.BASE_URL+day).get();
			Elements events = doc.select("span#Events").parents().next().get(0).select("li");
			System.out.println(tilottama.par.StringHandler.centerAligned("Events", 64, "#"));
			for (Element event : events) {
				String s = event.text();
				System.out.println(tilottama.par.StringHandler.wrapString(s, 80));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getBirths(String day) {
		Document doc;
		try {
			doc = Jsoup.connect(this.BASE_URL+day).get();
			Elements events = doc.select("span#Births").parents().next().get(0).select("li");
			System.out.println(tilottama.par.StringHandler.centerAligned("Births", 64, "#"));
			for (Element event : events) {
				String s = event.text();
				System.out.println(tilottama.par.StringHandler.wrapString(s, 80));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getDeaths(String day) {
		Document doc;
		try {
			doc = Jsoup.connect(this.BASE_URL+day).get();
			Elements events = doc.select("span#Deaths").parents().next().get(0).select("li");
			System.out.println(tilottama.par.StringHandler.centerAligned("Deaths", 64, "#"));
			for (Element event : events) {
				String s = event.text();
				System.out.println(tilottama.par.StringHandler.wrapString(s, 80));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getBASE_URL() {
		return BASE_URL;
	}

	public void setBASE_URL(String BASE_URL) {
		this.BASE_URL = BASE_URL;
	}
}
