package com.shivishbrahma.tilottama.test.par;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import com.shivishbrahma.tilottama.main.util.currencyconv.api.Currency;

public class CurrencyHandler {

//	static JsonObject currencyMap;
	static Map<String, Currency> currencyMap = new TreeMap<>();
	static List<Currency> currencyList;

	public static String getCurrencyString(String from, double amount) {
//		if (from.equalsIgnoreCase("AED") || from.equalsIgnoreCase("United Arab Emirates Dirham")
//				|| from.equalsIgnoreCase("د.إ")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "ae")).format(amount);
//		}
//		if (from.equalsIgnoreCase("ARS") || from.equalsIgnoreCase("Argentine Peso")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "ar")).format(amount);
//		}
//		if (from.equalsIgnoreCase("AUD") || from.equalsIgnoreCase("Australian Dollar") || from.equalsIgnoreCase("A$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "au")).format(amount);
//		}
//		if (from.equalsIgnoreCase("BGN") || from.equalsIgnoreCase("Bulgarian lev") || from.equalsIgnoreCase("лв")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "bg")).format(amount);
//		}
//		if (from.equalsIgnoreCase("BRL") || from.equalsIgnoreCase("Brazilian real") || from.equalsIgnoreCase("R$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "br")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("BSD") || from.equalsIgnoreCase("Bahamian dollar") || from.equalsIgnoreCase("B$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "bs")).format(amount);
//		}
//		if (from.equalsIgnoreCase("CAD") || from.equalsIgnoreCase("Canadian Dollar") || from.equalsIgnoreCase("CA$")) {
//			return NumberFormat.getCurrencyInstance(Locale.CANADA).format(amount);
//		}
//		if (from.equalsIgnoreCase("CHF") || from.equalsIgnoreCase("Swiss franc")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "ch")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("CLP") || from.equalsIgnoreCase("Chilean peso")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "cl")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("CNY") || from.equalsIgnoreCase("Renminbi") || from.equalsIgnoreCase("CN¥")) {
//			return NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("COP") || from.equalsIgnoreCase("Colombian peso") || from.equalsIgnoreCase("COP$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "co")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("CZK") || from.equalsIgnoreCase("Czech koruna") || from.equalsIgnoreCase("Kč")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "cz")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("DKK") || from.equalsIgnoreCase("Danish krone") || from.equalsIgnoreCase("kr.")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "dk")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("DOP") || from.equalsIgnoreCase("Dominican peso") || from.equalsIgnoreCase("RD$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "do")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("EGP") || from.equalsIgnoreCase("Egyptian Pound") || from.equalsIgnoreCase("E£")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "eg")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("EUR") || from.equalsIgnoreCase("Euro") || from.equalsIgnoreCase("€")) {
//			return NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("FJD") || from.equalsIgnoreCase("Fijian Dollar") || from.equalsIgnoreCase("FJ$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "fj")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("GBP") || from.equalsIgnoreCase("British Pound") || from.equalsIgnoreCase("£")) {
//			return NumberFormat.getCurrencyInstance(Locale.UK).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("GTQ") || from.equalsIgnoreCase("Guatemalan quetzal")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "gt")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("HKD") || from.equalsIgnoreCase("Hong Kong Dollar") || from.equalsIgnoreCase("HK$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "hk")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("HRK") || from.equalsIgnoreCase("Croatian kuna") || from.equalsIgnoreCase("kn.")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "hr")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("HUF") || from.equalsIgnoreCase("Hungarian forint") || from.equalsIgnoreCase("Ft")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "hu")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("IDR") || from.equalsIgnoreCase("Indonesian rupiah") || from.equalsIgnoreCase("Rp")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "id")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("ILS") || from.equalsIgnoreCase("Israeli shekel") || from.equalsIgnoreCase("₪")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "il")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("INR") || from.equalsIgnoreCase("Indian Rupee") || from.equalsIgnoreCase("₹")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "in")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("ISK") || from.equalsIgnoreCase("Icelandic króna") || from.equalsIgnoreCase("kr.")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "is")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("JPY") || from.equalsIgnoreCase("Japanese Yen") || from.equalsIgnoreCase("￥")) {
//			return NumberFormat.getCurrencyInstance(Locale.JAPAN).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("KRW") || from.equalsIgnoreCase("South Korean won") || from.equalsIgnoreCase("₩")) {
//			return NumberFormat.getCurrencyInstance(Locale.KOREA).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("KZT") || from.equalsIgnoreCase("Kazakhstani tenge") || from.equalsIgnoreCase("₸")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "kz")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("MVR") || from.equalsIgnoreCase("Maldivian rufiyaa") || from.equalsIgnoreCase("Rf")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "mv")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("MXN") || from.equalsIgnoreCase("Mexican peso") || from.equalsIgnoreCase("MX$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "mx")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("MYR") || from.equalsIgnoreCase("Malaysian ringgit") || from.equalsIgnoreCase("RM")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "mx")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("NOK") || from.equalsIgnoreCase("Norwegian krone")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "no")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("NZD") || from.equalsIgnoreCase("New Zealand dollar")
//				|| from.equalsIgnoreCase("NZ$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "nz")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("PAB") || from.equalsIgnoreCase("Panamanian balboa")
//				|| from.equalsIgnoreCase("B/.")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "pa")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("PEN") || from.equalsIgnoreCase("Peruvian Sol") || from.equalsIgnoreCase("P/.")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "pe")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("PHP") || from.equalsIgnoreCase("Philippine peso") || from.equalsIgnoreCase("₱")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "ph")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("PKR") || from.equalsIgnoreCase("Pakistani rupee") || from.equalsIgnoreCase("Rs")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "pk")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("PLN") || from.equalsIgnoreCase("Polish złoty") || from.equalsIgnoreCase("zł")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "pl")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("PYG") || from.equalsIgnoreCase("Paraguayan guaraní") || from.equalsIgnoreCase("₲")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "py")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("RON") || from.equalsIgnoreCase("Romanian leu") || from.equalsIgnoreCase("L")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "ro")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("RUB") || from.equalsIgnoreCase("Russian rubble") || from.equalsIgnoreCase("₽")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "ru")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("SAR") || from.equalsIgnoreCase("Saudi riyal") || from.equalsIgnoreCase("ر.س")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "sa")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("SEK") || from.equalsIgnoreCase("Swedish krona") || from.equalsIgnoreCase("kr")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "se")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("SGD") || from.equalsIgnoreCase("Singapore dollar") || from.equalsIgnoreCase("S$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "sg")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("THB") || from.equalsIgnoreCase("Thai baht") || from.equalsIgnoreCase("฿")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "th")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("TRY") || from.equalsIgnoreCase("Turkish lira") || from.equalsIgnoreCase("₺")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "tr")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("TWD") || from.equalsIgnoreCase("New Taiwan dollar")
//				|| from.equalsIgnoreCase("NT$")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "tw")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("UAH") || from.equalsIgnoreCase("Ukrainian hryvnia") || from.equalsIgnoreCase("₴")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "ua")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("UYU") || from.equalsIgnoreCase("Uruguayan peso") || from.equalsIgnoreCase("$U")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "uy")).format(amount);
//		}
//
//		if (from.equalsIgnoreCase("ZAR") || from.equalsIgnoreCase("South African rand") || from.equalsIgnoreCase("R")) {
//			return NumberFormat.getCurrencyInstance(new Locale("en", "za")).format(amount);
//		}
//		if (from.equalsIgnoreCase("USD") || from.equalsIgnoreCase("US Dollar") || from.equalsIgnoreCase("$")) {
//			return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
//		}
		Currency c = findCurrency(from);
		return NumberFormat.getCurrencyInstance(new Locale("en",c.getCountryCode())).format(amount);
	}

	@SuppressWarnings({ "deprecation" })
	private static void loadCurrencies() {
		JsonParser jp = new JsonParser();
		GsonBuilder builder = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		Gson gson = builder.create();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("currencies.json")));
			JsonElement je = jp.parse(br);
			Type currMapType = new TypeToken<Map<String, Currency>>() {
			}.getType();
			currencyMap = gson.fromJson(je, currMapType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Currency> getCurrencies(){
		loadCurrencies();
		currencyList=new ArrayList<Currency>();
		for(Entry<String,Currency> e:currencyMap.entrySet()) {
			currencyList.add(e.getValue());
		}
		return currencyList;
	}

	public static Currency findCurrency(String key) {
		loadCurrencies();
		Currency c = null;
		Iterator<Currency> it = currencyMap.values().iterator();
		while (it.hasNext()) {
			c = it.next();
			if (c.getCurrencyCode().equalsIgnoreCase(key) || c.getName().equalsIgnoreCase(key)) {
				return c;
			}
		}
		return null;
	}
}
