/**
 * 
 */
package tilottama.util;

import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import tilottama.App;
import tilottama.par.CurrencyHandler;
import tilottama.par.DateTime;
import tilottama.par.Scraper;
import tilottama.par.Service;
import tilottama.par.StringHandler;

/**
 * @author Purbayan Chowdhury
 *         (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class CurrencyConvertor {
	App app;
	Scraper scraper;
	Service s;
	GsonBuilder builder;
	Gson gson;

	public CurrencyConvertor(App app, String cmd) {
		this.app = app;
		scraper = new Scraper();
		s = scraper.findService(app, cmd);
		builder = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		gson = builder.create();
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("resource")
	public void convertCurrency(String args) {
		Scanner sc = new Scanner(args);
		double fromVal = sc.nextDouble();
		String url = s.getConfig().getUrl();
		String fromCurr = sc.next().toUpperCase();
		String toCurr = sc.next().toUpperCase();
		url = url + fromCurr;
		JsonObject jo = scraper.getJsonRequest(url).getAsJsonObject();
		if (jo == null) {
			return;
		}
		double conv_rate = jo.get("rates").getAsJsonObject().get(toCurr).getAsDouble();
		System.out.println(StringHandler.centerAligned("CURRENCY CONVERTOR", 64, "="));
		System.out.println(StringHandler.centerAligned("Powered by ExchangeRate-API", 64, "-"));
		System.out.println("Current Time: " + DateTime.unixToZFormat(jo.get("time_last_updated").getAsLong()));
		System.out.println("Current Conversion Rate: " + conv_rate);
		System.out.println(
				"Amount in " + toCurr + " : " + CurrencyHandler.getCurrencyString(fromCurr, (conv_rate * fromVal)));
		sc.close();
	}


	/**
	 * @param fromCurr
	 * @param toCurr
	 * @param val
	 * @return
	 */
	public double convertCurrency(String fromCurr, String toCurr, double val) {
		fromCurr = fromCurr.toUpperCase();
		toCurr = toCurr.toUpperCase();
		String url = s.getConfig().getUrl();
		url = url + fromCurr;
		JsonObject jo = scraper.getJsonRequest(url).getAsJsonObject();
		if (jo == null) {
			return 0;
		}
		double conv_rate = jo.get("rates").getAsJsonObject().get(toCurr).getAsDouble();
		return conv_rate * val;
	}
}
