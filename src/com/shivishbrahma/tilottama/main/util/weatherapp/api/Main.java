/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shivishbrahma.tilottama.main.util.weatherapp.api;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Main {
	private float temp, feels_like, temp_min, temp_max, temp_kf, pressure, humidity, sea_level, grnd_level;
	public static String tUnit[] = { "K(Kelvin)", "°C(Celsius)", "°F(Fahrenheit)" };
	public int unit;

	/**
	 * @param temp
	 * @param feels_like
	 * @param temp_min
	 * @param temp_max
	 * @param pressure
	 * @param humidity
	 * @param sea_level
	 * @param grnd_level
	 */
	public Main(float temp, float feels_like, float temp_min, float temp_max, float pressure, float humidity,
			float sea_level, float grnd_level) {
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.pressure = pressure;
		this.humidity = humidity;
		this.sea_level = sea_level;
		this.grnd_level = grnd_level;
		this.unit = 0;
	}

	/**
	 * @return the temp
	 */
	public float getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(float temp) {
		this.temp = temp;
	}

	/**
	 * @return the feels_like
	 */
	public float getFeels_like() {
		return feels_like;
	}

	/**
	 * @param feels_like the feels_like to set
	 */
	public void setFeels_like(float feels_like) {
		this.feels_like = feels_like;
	}

	/**
	 * @return the temp_min
	 */
	public float getTemp_min() {
		return temp_min;
	}

	/**
	 * @param temp_min the temp_min to set
	 */
	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}

	/**
	 * @return the temp_max
	 */
	public float getTemp_max() {
		return temp_max;
	}

	/**
	 * @param temp_max the temp_max to set
	 */
	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}

	/**
	 * @return the temp_kf
	 */
	public float getTemp_kf() {
		return temp_kf;
	}

	/**
	 * @param temp_kf the temp_kf to set
	 */
	public void setTemp_kf(float temp_kf) {
		this.temp_kf = temp_kf;
	}

	/**
	 * @return the pressure
	 */
	public float getPressure() {
		return pressure;
	}

	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	/**
	 * @return the humidity
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the sea_level
	 */
	public float getSea_level() {
		return sea_level;
	}

	/**
	 * @param sea_level the sea_level to set
	 */
	public void setSea_level(float sea_level) {
		this.sea_level = sea_level;
	}

	/**
	 * @return the grnd_level
	 */
	public float getGrnd_level() {
		return grnd_level;
	}

	/**
	 * @param grnd_level the grnd_level to set
	 */
	public void setGrnd_level(float grnd_level) {
		this.grnd_level = grnd_level;
	}

	/**
	 * @return the unit
	 */
	public int getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(int unit) {
		this.unit = unit;
	}

	/**
	 * 
	 */
	public void details() {
		System.out.println("Main: ");
		System.out.println("Temperature: " + this.getTemp() + " " + tUnit[this.unit]);
		System.out.println("Feels like: " + this.getFeels_like() + " " + tUnit[this.unit]);
		System.out.println("Max. Temperature: " + this.getTemp_max() + " " + tUnit[this.unit]);
		System.out.println("Min. Temperature: " + this.getTemp_min() + " " + tUnit[this.unit]);
		System.out.println("Pressure: " + this.getPressure() + " hPa");
		System.out.println("Humidity: " + this.getHumidity() + "%");
		if (this.getSea_level() != 0)
			System.out.println("Sea Level: " + this.getSea_level() + " hPa");
		if (this.getGrnd_level() != 0)
			System.out.println("Ground Level: " + this.getGrnd_level() + " hPa");
	}
}
