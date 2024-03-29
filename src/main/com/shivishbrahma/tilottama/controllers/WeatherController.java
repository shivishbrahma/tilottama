package com.shivishbrahma.tilottama.controllers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import com.shivishbrahma.tilottama.App;
import com.shivishbrahma.tilottama.handlers.ScraperHandler;
import com.shivishbrahma.tilottama.handlers.StringHandler;
import com.shivishbrahma.tilottama.models.Service;
import com.shivishbrahma.tilottama.models.openweatherapi.OpenWeather;
import com.shivishbrahma.tilottama.models.openweatherapi.OpenWeatherForecast;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class WeatherController {
	App app;
	ScraperHandler scraper;
	Service s;
	GsonBuilder builder;
	Gson gson;

	public WeatherController(App app, String cmd) {
		this.app = app;
		scraper = new ScraperHandler();
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
