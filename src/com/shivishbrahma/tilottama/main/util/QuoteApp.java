/**
 * 
 */
package com.shivishbrahma.tilottama.main.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class QuoteApp {
	private String BASE_URL = "";

	public QuoteApp() {

	}

	public static void main(String[] args) {
		QuoteApp qa = new QuoteApp();
		qa.topic();
	}

	public void topic() {
		this.BASE_URL = "https://www.brainyquote.com/quotes_of_the_day.html";
		Document doc;
		try {
			doc = Jsoup.connect(this.BASE_URL).get();
			Elements quotes = doc.select("img.p-qotd");
			System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.centerAligned("Powered by BrainlyQuote", 64, "-"));
			for (Element quote : quotes) {
				String s = quote.attr("alt");
				System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.wrapString(s, 64));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.BASE_URL = "https://en.wikiquote.org/wiki/Main_Page";
		try {
			doc = Jsoup.connect(this.BASE_URL).get();
			Elements quotes = doc.select("#mf-qotd table table");
			System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.centerAligned("Powered by WikiQuote", 64, "-"));
			for (Element quote : quotes) {
				String s = quote.text();
				System.out.println(com.shivishbrahma.tilottama.main.par.StringHandler.wrapString(s, 64));
				break;
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
