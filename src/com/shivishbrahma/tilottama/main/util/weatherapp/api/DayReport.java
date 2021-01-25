/**
 * 
 */
package com.shivishbrahma.tilottama.main.util.weatherapp.api;

import java.util.ArrayList;

/**
 * @author Purbayan Chowdhury
 *         (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class DayReport {
	public Main main;
	public Sys sys;
	public ArrayList<Weather> weather;
	public Wind wind;
	public Cloud clouds;
	public Snow snow;
	public Rain rain;
	public String dtText;

	/**
	 * @param main
	 * @param sys
	 * @param weather
	 * @param wind
	 * @param clouds
	 * @param snow
	 * @param rain
	 * @param dtText
	 */
	public DayReport(Main main, Sys sys, ArrayList<Weather> weather, Wind wind, Cloud clouds, Snow snow, Rain rain,
			String dtText) {
		this.main = main;
		this.sys = sys;
		this.weather = weather;
		this.wind = wind;
		this.clouds = clouds;
		this.snow = snow;
		this.rain = rain;
		this.dtText = dtText;
	}

	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	}

	/**
	 * @return the sys
	 */
	public Sys getSys() {
		return sys;
	}

	/**
	 * @param sys the sys to set
	 */
	public void setSys(Sys sys) {
		this.sys = sys;
	}

	/**
	 * @return the weather
	 */
	public ArrayList<Weather> getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(ArrayList<Weather> weather) {
		this.weather = weather;
	}

	/**
	 * @return the wind
	 */
	public Wind getWind() {
		return wind;
	}

	/**
	 * @param wind the wind to set
	 */
	public void setWind(Wind wind) {
		this.wind = wind;
	}

	/**
	 * @return the clouds
	 */
	public Cloud getClouds() {
		return clouds;
	}

	/**
	 * @param clouds the clouds to set
	 */
	public void setClouds(Cloud clouds) {
		this.clouds = clouds;
	}

	/**
	 * @return the snow
	 */
	public Snow getSnow() {
		return snow;
	}

	/**
	 * @param snow the snow to set
	 */
	public void setSnow(Snow snow) {
		this.snow = snow;
	}

	/**
	 * @return the rain
	 */
	public Rain getRain() {
		return rain;
	}

	/**
	 * @param rain the rain to set
	 */
	public void setRain(Rain rain) {
		this.rain = rain;
	}

	/**
	 * @return the dtText
	 */
	public String getDtText() {
		return dtText;
	}

	/**
	 * @param dtText the dtText to set
	 */
	public void setDtText(String dtText) {
		this.dtText = dtText;
	}

	public void details() {
		System.out.println("\nDay Report: ");
		System.out.println("Date: " + dtText);
		if (sys != null)
			sys.details();
		if (main != null)
			main.details();
		for (Weather i : weather)
			i.details();
		if (wind != null)
			wind.details();
		if (clouds != null)
			clouds.details();
		if (rain != null)
			rain.details();
		if (snow != null)
			snow.details();
	}

}
