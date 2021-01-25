package com.shivishbrahma.tilottama.main.par;

import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import com.shivishbrahma.tilottama.main.App;

/**
 * A Web Scraper built using okhttp and gson.
 * 
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Scraper {

	/**
	 * @param app  - Instance of the main App object
	 * @param name - Name of the service to be searched
	 * @return service - Service searched
	 */
	public Service findService(App app, String name) {
		List<Service> sl = app.getServices().stream().filter(p -> p.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		if (sl.size() > 0) {
			return sl.get(0);
		}
		return null;
	}

	/**
	 * @param s
	 * @param name
	 * @return
	 */
	public Args findArg(Service s, String name) {
		List<Args> arglist = s.getConfig().args.stream().filter(p -> p.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		if (arglist.size() > 0) {
			return arglist.get(0);
		}
		return null;
	}

	/**
	 * @param s
	 * @param args
	 * @return
	 */
	@SuppressWarnings({ "unlikely-arg-type" })
	public JsonElement getJsonRequest(Service s, String args) {
		StringTokenizer tokenizer = new StringTokenizer(args);
		String token, val, url = "";
		Args arg;
		try {
			while (tokenizer.hasMoreTokens()) {
				token = tokenizer.nextToken();
				arg = findArg(s, token);
				if (arg == null) {
					url = url + "+" + token;
				} else {
					if (!tokenizer.hasMoreTokens()) {
						throw new Exception("Missing value or argument name");
					}

					val = tokenizer.nextToken();
					url = url + "&" + arg.getQuery() + "=";
					if (arg.equals("Integer")) {
						url = url + "%d";
						url = String.format(url, Integer.parseInt(val));
					}
					if (arg.equals("Float")) {
						url = url + "%f";
						url = String.format(url, Float.parseFloat(val));
					}
					if (arg.equals("String")) {
						url = url + "%s";
						url = String.format(url, val.toString());
					}
					url = url + val;
				}
			}

			url = String.format(s.getConfig().url, s.getConfig().key) + url;
			return getJsonRequest(url);
		} catch (NumberFormatException e) {
			System.err.println("Invalid Type of Value\n" + e.getMessage());
			System.exit(0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}

		return null;
	}

	/**
	 * @param url
	 * @return
	 */
	@SuppressWarnings({ "deprecation" })
	public JsonElement getJsonRequest(String url) {
		try {
			System.setProperty("http.agent", "Netscape 1.0");

			OkHttpClient client = new OkHttpClient();
			Request req = new Request.Builder().url(url).get().build();
			Response res = client.newCall(req).execute();
//			System.out.println(res.toString());

			JsonParser jp = new JsonParser();
			if (res.code() == 200) {
				return jp.parse(res.body().string());
			} else {
				String json = String.format("{\'code\':%d, \'message\': \'%s\'}", res.code(), res.message());
				return jp.parse(json);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
