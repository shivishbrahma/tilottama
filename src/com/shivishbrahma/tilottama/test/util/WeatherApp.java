package com.shivishbrahma.tilottama.test.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import com.shivishbrahma.tilottama.main.App;
import com.shivishbrahma.tilottama.main.par.Scraper;
import com.shivishbrahma.tilottama.main.par.Service;
import com.shivishbrahma.tilottama.main.par.StringHandler;
import com.shivishbrahma.tilottama.main.util.weatherapp.OpenWeather;
import com.shivishbrahma.tilottama.main.util.weatherapp.OpenWeatherForecast;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class WeatherApp {
	App app;
	Scraper scraper;
	Service s;
	GsonBuilder builder;
	Gson gson;

	public WeatherApp(App app, String cmd) {
		this.app = app;
		scraper = new Scraper();
		s = scraper.findService(app, cmd);
		builder = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		gson = builder.create();
	}

	/**
	 * @param args
	 */
	public void findWeather(String args) {
		OpenWeather ow = new OpenWeather();
		JsonObject jo = scraper.getJsonRequest(s, args).getAsJsonObject();
		if (jo == null) {
			return;
		}
		ow = gson.fromJson(jo, OpenWeather.class);

//        FileWriter fw;
//        try {           
//            fw= new FileWriter(new File("weather.json"));
//            fw.write(gson.toJson(jo));            
//            fw.close();
//            System.out.println("Written successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        FileReader fr;
//        try {           
//            fr = new FileReader(new File("weather.json"));
//            BufferedReader br = new BufferedReader(fr);
//            
//            System.out.println("Read successfully!");
//            ow = gson.fromJson(br, OpenWeather.class);            
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		System.out.println(StringHandler.centerAligned("WEATHER REPORT", 64, "="));
		System.out.println(StringHandler.centerAligned("Powered by Open Weather Api", 64, "-"));
		ow.details();
	}

	/**
	 * @param args
	 */
	public void findForecast(String args) {
		OpenWeatherForecast owf = new OpenWeatherForecast();
		JsonObject jo = scraper.getJsonRequest(s, args).getAsJsonObject();
		if (jo == null) {
			return;
		}
		owf = gson.fromJson(jo, OpenWeatherForecast.class);
		System.out.println(StringHandler.centerAligned("WEATHER FORECAST REPORT", 64, "="));
		System.out.println(StringHandler.centerAligned("Powered by Open Weather Api", 64, "-"));
		owf.details();
	}

}
